package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

/**
 * An iterator over a range of integers.
 * Returned rows will have a single column of
 * type {@code ColumnType.INT}, named
 * {@code "value"}.
 *
 * @see dsiter.dataset.RangeDataset
 */
public class RangeIterator implements IDatasetIterator {

	private int curVal;
	private int maxVal;
	private int length;
	private boolean isFirst = true;

	private Row row;

	/**
	 * Construct an iterator from {@code minVal} (inclusive)
	 * to {@code maxVal} (exclusive)
	 *
	 * @param minVal The min boundary of the range.
	 *               Will be the first returned value.
	 * @param maxVal The max boundary of the range.
	 *               The last value returned will be
	 *               {@code maxVal-1}
	 */
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

	/**
	 * Construct an iterator from {@code 0} (inclusive)
	 * to {@code maxVal} (exclusive).
	 *
	 * @param maxVal The max boundary of the range.
	 *               The last value returned will be
	 *               {@code maxVal-1}
	 */
	public RangeIterator(int maxVal) {
		this(0, maxVal);
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return new ColumnDescriptor[]{
			new ColumnDescriptor("value", ColumnType.INT, 0)
		};
	}

	@Override
	public boolean tryMoveNext() {
		curVal++;
		return curVal < maxVal;
	}

	@Override
	public long tryGetLength() {
		return length;
	}

	@Override
	public Row getCurrentRow() {
		row.ints[0] = this.curVal;
		return row;
	}

	@Override
	public void close() {
		// do nothing
	}
}