package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;

public class TakeWhileIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private IRowAccessor.BOOLEAN predicate;
	private Row row;
	private boolean exhausted = false;

	public TakeWhileIterator(IDatasetIterator src, IRowAccessor.BOOLEAN predicate) {
		this.src = src;
		this.predicate = predicate;
	}

	@Override
	public boolean tryMoveNext() throws Exception {
		if (exhausted) {
			return false;
		}
		else if (!src.tryMoveNext()) {
			return false;
		}
		else {
			row = src.getCurrentRow();
			if (predicate.getBoolFromRow(row)) {
				return true;
			}
			else {
				exhausted = true;
				return false;
			}
		}
	}

	@Override
	public Row getCurrentRow() throws Exception {
		return row;
	}

	@Override
	public long tryGetLength() {
		return -1;
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return src.getColumnDescriptors();
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) {
		return false;
	}

	@Override
	public void close() throws Exception {
		src.close();
	}
}
