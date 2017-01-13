package dsiter.dataset;

import dsiter.iterator.CacheIterator;
import dsiter.iterator.IDatasetIterator;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import dsiter.row.RowCopier;
import dsiter.row.RowShape;

import java.util.ArrayList;
import java.util.List;

public class CacheDataset implements IDataset {

	private long timeoutMillis;
	private long lastRefresh;

	private IDataset src;
	private Row[] cache;
	private ColumnDescriptor[] cds;

	public CacheDataset(IDataset src, long timeoutMillis) throws Exception {
		this.src = src;
		this.timeoutMillis = timeoutMillis;
		refeshCache();
	}

	private void refeshCache() throws Exception {
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
		lastRefresh = System.currentTimeMillis();
	}

	private void maybeRefreshCache() throws Exception {
		long now = System.currentTimeMillis();
		if (cache == null || now > lastRefresh + timeoutMillis) {
			refeshCache();
		}
	}


	@Override
	public IDatasetIterator getIterator() throws Exception {
		maybeRefreshCache();
		return new CacheIterator(cache, cds);
	}
}
