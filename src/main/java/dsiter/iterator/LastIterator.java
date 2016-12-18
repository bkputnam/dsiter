package dsiter.iterator;

import dsiter.row.Row;
import dsiter.row.ColumnDescriptor;
import dsiter.row.RowCopier;

public class LastIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private Row row;
	private RowCopier copier;

	public LastIterator(IDatasetIterator src) {
		this.src = src;

		copier = new RowCopier(src.getColumnDescriptors());
		row = new Row(copier.getDestShape());
	}

	public boolean tryMoveNext() {
		boolean foundAny = false;

		// Unfortunately, lastIterator needs to call getCurrentRow() on
		// each and every row, and also must save off a copy when it does
		// that. This is because we need to call tryMoveNext() until
		// it returns false, and any call to src.tryMoveNext() can
		// change or invalidate the value of src.getCurrentRow(), even
		// one that returns false.
		while( src.tryMoveNext() ) {
			foundAny = true;
			copier.copyTo(src.getCurrentRow(), row);
		}
		return foundAny;
	}

	public Row getCurrentRow() {
		return row;
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return copier.getDestColumnDescriptors();
	}

}