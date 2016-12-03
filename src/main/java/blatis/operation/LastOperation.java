package blatis.operation;

import blatis.iterator.AbstractDatasetIterator;
import blatis.dataset.Row;
import blatis.dataset.ColumnDescriptor;

public class LastOperation extends AbstractOperation {

	public LastOperation() { }

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new LastIterator( src );
	}

	private static class LastIterator extends AbstractDatasetIterator {

		private AbstractDatasetIterator src;

		public LastIterator(AbstractDatasetIterator src) {
			this.src = src;
		}

		public boolean tryMoveNext() {
			boolean foundAny = false;
			while( src.tryMoveNext() ) {
				foundAny = true;
			}
			return foundAny;
		}

		public Row getCurrentRow() {
			return src.getCurrentRow();
		}

		public ColumnDescriptor[] getColumnDescriptors() {
			return this.src.getColumnDescriptors();
		}

	}

}