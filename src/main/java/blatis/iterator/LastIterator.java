package blatis.iterator;

import blatis.row.Row;
import blatis.row.ColumnDescriptor;

public class LastIterator extends AbstractDatasetIterator {

	private AbstractDatasetIterator src;
	private Row row;

	public LastIterator(AbstractDatasetIterator src) {
		this.src = src;
		this.row = new Row();
	}

	public boolean tryMoveNext() {
		boolean foundAny = false;
		while( src.tryMoveNext() ) {
			foundAny = true;
			Row.copyTo(src.getCurrentRow(), row);
		}
		return foundAny;
	}

	public Row getCurrentRow() {
		return row;
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return this.src.getColumnDescriptors();
	}

}