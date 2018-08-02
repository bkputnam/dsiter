package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

/**
 * Utility class that helps count how many times each method in IDatasetIterator was called.
 *
 * <h1>Example usage:</h1>
 * <code>
 *     IteratorCounter counter = new IteratorCounter();
 *     IDatasetIterator iterator = theIteratorUnderTest()
 *         .pipe(counter.getPipe());
 *
 *     while (it.tryMoveNext()) {
 *         // do stuff
 *     }
 *     assertEquals(numItems, counter.getTryMoveNextCount());
 * </code>
 */
public class IteratorCounter {

	private long tryMoveNextCount = 0;
	private long getCurrentRowCount = 0;
	private long tryGetLengthCount = 0;
	private long getColumnDescriptorsCount = 0;
	private long closeCount = 0;
	private long tryAbsorbCount = 0;
	private long tryAbsorbSuccessesCount = 0;

	public long getTryMoveNextCount() { return tryMoveNextCount; }
	public long getGetCurrentRowCount() { return getCurrentRowCount; }
	public long getTryGetLengthCount() { return tryGetLengthCount; }
	public long getGetColumnDescriptorsCount() { return getColumnDescriptorsCount; }
	public long getCloseCount() { return closeCount; }
	public long getTryAbsorbCount() { return tryAbsorbCount; }
	public long getTryAbsorbSuccessesCount() { return tryAbsorbSuccessesCount; }

	public IPipe getPipe() {
		return new CountPipe();
	}

	private class CountPipe implements IPipe {
		@Override
		public IDatasetIterator attachTo(IDatasetIterator src) {
			return new CountIterator(src);
		}
	}

	private class CountIterator implements IDatasetIterator {

		private IDatasetIterator src;

		public CountIterator(IDatasetIterator src) {
			this.src = src;
		}

		@Override
		public boolean tryMoveNext() throws Exception {
			boolean success = src.tryMoveNext();
			if (success) { tryMoveNextCount++; }
			return success;
		}

		@Override
		public Row getCurrentRow() throws Exception {
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

		@Override
		public void close() throws Exception {
			closeCount++;
			src.close();
		}

		@Override
		public boolean tryAbsorb(IPipe pipe) throws Exception {
			tryAbsorbCount++;
			if (src.tryAbsorb(pipe)) {
				tryAbsorbSuccessesCount++;
				return true;
			}
			else {
				return false;
			}
		}
	}
}
