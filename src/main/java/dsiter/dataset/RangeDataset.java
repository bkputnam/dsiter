package dsiter.dataset;

import dsiter.iterator.RangeIterator;
import dsiter.iterator.IDatasetIterator;

public class RangeDataset implements IDataset {

	private int minVal;
	private int maxVal;

	public RangeDataset(int minVal, int maxVal) {
		this.minVal = minVal;
		this.maxVal = maxVal;
	}

	public RangeDataset(int maxVal) {
		this(0, maxVal);
	}

	public IDatasetIterator getIterator() {
		return new RangeIterator(minVal, maxVal);
	}

}