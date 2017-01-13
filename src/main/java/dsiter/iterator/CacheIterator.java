package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.pipe.SkipPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import dsiter.row.RowCopier;
import dsiter.row.RowShape;

public class CacheIterator implements IDatasetIterator {

	private Row[] cache;
	private int index = -1;

	private ColumnDescriptor[] cds;

	private Row outputRow;
	private RowCopier rowCopier;


	public CacheIterator(Row[] cache, ColumnDescriptor[] cds) {
		this.cache = cache;
		this.cds = cds;

		rowCopier = new RowCopier(cds);
		outputRow = new Row(rowCopier.getDestShape());
	}

	@Override
	public boolean tryMoveNext() throws Exception {
		index++;
		return index < cache.length;
	}

	@Override
	public Row getCurrentRow() throws Exception {
		rowCopier.copyTo(cache[index], outputRow);
		return outputRow;
	}

	@Override
	public long tryGetLength() {
		return cache.length;
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return cds;
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) {
		if (pipe instanceof SkipPipe) {
			long howMany = ((SkipPipe)pipe).getHowMany();
			index += howMany;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void close() throws Exception { }
}
