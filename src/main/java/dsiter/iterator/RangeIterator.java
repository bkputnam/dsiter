package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

public class RangeIterator implements IDatasetIterator {

	private int curVal;
	private int maxVal;
	private int length;
	private boolean isFirst = true;

	private Row row;

	public RangeIterator(int minVal, int maxVal) {

		// Note: don't have to worry about underflow here because
		// vm will do it silently, and then will overflow right
		// back to where we want to be when we do curVal++ in
		// tryMoveNext()
		this.curVal = minVal-1;
		this.maxVal = maxVal;
		length = (maxVal - minVal);

		row = new Row();
		row.ints = new int[1];
	}

	public RangeIterator(int maxVal) {
		this(0, maxVal);
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return new ColumnDescriptor[]{
			new ColumnDescriptor("value", ColumnType.INT, 0)
		};
	}

	public boolean tryMoveNext() {
		curVal++;
		return curVal < maxVal;
	}

	@Override
	public long tryGetLength() {
		return length;
	}

	public Row getCurrentRow() {
		row.ints[0] = this.curVal;
		return row;
	}
}