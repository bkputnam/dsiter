package dsiter.iterator;

import dsiter.row.Row;
import dsiter.row.ColumnDescriptor;

public class StrideIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private int stride;
	private boolean isFirstTime = true;

	public StrideIterator(IDatasetIterator src, int stride) {
		this.src = src;
		this.stride = stride;
	}

	public boolean tryMoveNext() {
		if( isFirstTime ) {
			isFirstTime = false;
			return src.tryMoveNext();
		}
		else {
			for( int i=0; i<stride; i++) {
				if( !this.src.tryMoveNext() ) {
					return false;
				}
			}
			return true;
		}
	}

	public Row getCurrentRow() {
		return src.getCurrentRow();
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return this.src.getColumnDescriptors();
	}

}