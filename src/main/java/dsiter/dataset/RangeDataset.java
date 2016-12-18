package dsiter.dataset;

import dsiter.iterator.RangeIterator;
import dsiter.iterator.AbstractDatasetIterator;

public class RangeDataset extends AbstractDataset {

	private int numVals;

	public RangeDataset(int numVals) {
		this.numVals = numVals;
	}

	public AbstractDatasetIterator getIterator() {
		return new RangeIterator(this.numVals);
	}

}