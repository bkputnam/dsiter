package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

public class RangeIterator implements IDatasetIterator {

	private int curVal = -1;
	private int numVals;

	private static ColumnDescriptor[] columns = {
		new ColumnDescriptor("value", ColumnType.INT, 0)
	};

	private Row row;

	public RangeIterator(int numVals) {
		this.numVals = numVals;

		row = new Row();
		row.ints = new int[] { -1 };
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return columns.clone();
	}

	public boolean tryMoveNext() {
		if( curVal < numVals - 1 ) {
			curVal++;
			return true;
		}
		else {
			return false;
		}
	}

	public Row getCurrentRow() {
		row.ints[0] = this.curVal;
		return row;
	}
}