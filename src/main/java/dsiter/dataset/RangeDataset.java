package dsiter.dataset;

import dsiter.iterator.RangeIterator;
import dsiter.iterator.IDatasetIterator;

/**
 * Dataset that represents a range of integers.
 * Returned rows will have a single column of
 * type {@code ColumnType.INT}, named
 * {@code "value"}.
 */
public class RangeDataset implements IDataset {

	private int minVal;
	private int maxVal;

	/**
	 * Construct a RangeDataset that returns the
	 * integers from {@code minVal} (inclusive)
	 * to {@code maxVal} (exclusive)
	 *
	 * @param minVal The min boundary of the range,
	 *               will be the first returned value.
	 * @param maxVal The max boundary of the range.
	 *               The last value returned will be
	 *               {@code maxVal-1}
	 */
	public RangeDataset(int minVal, int maxVal) {
		this.minVal = minVal;
		this.maxVal = maxVal;
	}

	/**
	 * Construct a RangeDataset from {@code 0}
	 * (inclusive) to {@code maxVal} (exclusive).
	 *
	 * <p>Equivalent to {@code new RangeDataset(0, maxVal)}</p>
	 * @param maxVal The max boundary of the range.
	 *               The last value returned will be
	 *               {@code maxVal-1}
	 */
	public RangeDataset(int maxVal) {
		this(0, maxVal);
	}

	public IDatasetIterator getIterator() {
		return new RangeIterator(minVal, maxVal);
	}

}