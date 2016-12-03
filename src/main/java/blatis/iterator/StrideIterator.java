package blatis.iterator;

import blatis.row.Row;
import blatis.row.ColumnDescriptor;

public class StrideIterator extends AbstractDatasetIterator {

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
			if( src.tryMoveNext() ) {
				currentRow = src.getCurrentRow();
				return true;
			}
			else {
				return false;
			}
		}
		else {
			for( int i=0; i<stride; i++) {
				if( !this.src.tryMoveNext() ) {
					return false;
				}
			}
			currentRow = this.src.getCurrentRow().clone();
			return true;
		}
	}

	public Row getCurrentRow() {
		return currentRow;
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return this.src.getColumnDescriptors();
	}

}