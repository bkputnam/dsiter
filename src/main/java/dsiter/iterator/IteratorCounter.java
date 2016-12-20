package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

public class IteratorCounter {

	private long tryMoveNextCount = 0;
	private long getCurrentRowCount = 0;
	private long tryGetLengthCount = 0;
	private long getColumnDescriptorsCount = 0;

	public long getTryMoveNextCount() { return tryMoveNextCount; }
	public long getGetCurrentRowCount() { return getCurrentRowCount; }
	public long getTryGetLengthCount() { return tryGetLengthCount; }
	public long getGetColumnDescriptorsCount() { return getColumnDescriptorsCount; }

	public IPipe getPipe() {
		return new CountPipe();
	}

	private class CountPipe implements IPipe {
		@Override
		public IDatasetIterator applyTo(IDatasetIterator src) {
			return new CountIterator(src);
		}
	}

	private class CountIterator implements IDatasetIterator {

		private IDatasetIterator src;

		public CountIterator(IDatasetIterator src) {
			this.src = src;
		}

		@Override
		public boolean tryMoveNext() {
			boolean success = src.tryMoveNext();
			if (success) { tryMoveNextCount++; }
			return success;
		}

		@Override
		public Row getCurrentRow() {
			getCurrentRowCount++;
			return src.getCurrentRow();
		}

		@Override
		public long tryGetLength() {
			tryGetLengthCount++;
			return src.tryGetLength();
		}

		@Override
		public ColumnDescriptor[] getColumnDescriptors() {
			getColumnDescriptorsCount++;
			return src.getColumnDescriptors();
		}
	}
}
