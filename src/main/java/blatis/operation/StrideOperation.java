package blatis.operation;

import blatis.iterator.AbstractDatasetIterator;
import blatis.dataset.Row;
import blatis.dataset.ColumnDescriptor;

public class StrideOperation extends AbstractOperation {

	private int stride;

	public StrideOperation(int stride) {
		this.stride = stride;
	}

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

	private static class StrideIterator extends AbstractDatasetIterator {

		private AbstractDatasetIterator src;
		private int stride;
		private boolean isFirstTime = true;
		private Row currentRow;

		public StrideIterator(AbstractDatasetIterator src, int stride) {
			this.src = src;
			this.stride = stride;
			this.currentRow = null;
		}

		public boolean tryMoveNext() {
			if( isFirstTime ) {
				isFirstTime = false;
				boolean success = this.src.tryMoveNext();
				if( success ) {
					currentRow = null;
				}
				return success;
			}
			else {
				for( int i=0; i<stride; i++) {
					if( !this.src.tryMoveNext() ) {
						return false;
					}
				}
				currentRow = null;
				return true;
			}
		}

		public Row getCurrentRow() {
			if( currentRow == null ) {
				currentRow = this.src.getCurrentRow().clone();
			}
			return currentRow;
		}

		public ColumnDescriptor[] getColumnDescriptors() {
			return this.src.getColumnDescriptors();
		}

	}

}