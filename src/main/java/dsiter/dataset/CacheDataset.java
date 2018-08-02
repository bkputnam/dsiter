package dsiter.dataset;

import dsiter.iterator.CacheIterator;
import dsiter.iterator.IDatasetIterator;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import dsiter.row.RowCopier;
import dsiter.row.RowShape;

import java.util.ArrayList;
import java.util.List;

/**
 * An IDataset that immediately reads and then caches another dataset. The cache expires after a configurable amount of
 * time. The CacheDataset will have the same Row structure as the source dataset.
 */
public class CacheDataset implements IDataset {

	private long timeoutMillis;
	private long lastRefresh;

	private IDataset src;
	private Row[] cache;
	private ColumnDescriptor[] cds;

	/**
	 * Create a CacheDataset that immediately reads the entirety of the passed @{code src} dataset and caches it
	 * forever.
	 * @param src The source dataset to read from and cache
	 * @throws Exception If the source dataset throws any Exceptions.
	 */
	public CacheDataset(IDataset src) throws Exception {
		this(src, -1);
	}

	/**
	 * Create a CacheDataset that reads the entirety of the passed @{code src} dataset and caches it for
	 * {@code timeoutSeconds}.
	 * @param src The source dataset to read from and cache
	 * @param timeoutSeconds How long a cache can persist for before it is considered stale. If value is -1, cache will
	 *		never timeout.
	 * @throws Exception If the source dataset throws any Exceptions.
	 */
	public CacheDataset(IDataset src, double timeoutSeconds) throws Exception {
		this.src = src;
		if (timeoutSeconds == -1) {
			this.timeoutMillis = -1;
		}
		else {
			this.timeoutMillis = (long) (timeoutSeconds * 1000);
		}
		refreshCache();
	}

	private void refreshCache() throws Exception {
		List<Row> rowList = new ArrayList<>();
		IDatasetIterator srcIter = src.getIterator();

		cds = srcIter.getColumnDescriptors();
		RowCopier rowCopier = new RowCopier(cds);
		RowShape destShape = rowCopier.getDestShape();

		while(srcIter.tryMoveNext()) {
			Row srcRow = srcIter.getCurrentRow();

			Row destRow = new Row(destShape);
			rowCopier.copyTo(srcRow, destRow);
			rowList.add(destRow);
		}

		cache = rowList.toArray(new Row[0]);
		if (timeoutMillis != -1) {
			// Minor optimization - avoid a system call if we're caching indefinitely anyway.
			lastRefresh = System.currentTimeMillis();
		}
	}

	private void maybeRefreshCache() throws Exception {
		if (cache == null) {
			refreshCache();
		}
		else if (timeoutMillis == -1) {
			return;
		}
		else {
			long now = System.currentTimeMillis();
			if (now > lastRefresh + timeoutMillis) {
				refreshCache();
			}
		}
	}


	@Override
	public IDatasetIterator getIterator() throws Exception {
		maybeRefreshCache();
		return new CacheIterator(cache, cds);
	}
}
