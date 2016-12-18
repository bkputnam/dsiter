package dsiter.dataset;

import dsiter.iterator.RangeIterator;
import dsiter.iterator.IDatasetIterator;

public class RangeDataset implements IDataset {

	private int numVals;

	public RangeDataset(int numVals) {
		this.numVals = numVals;
	}

	public IDatasetIterator getIterator() {
		return new RangeIterator(this.numVals);
	}

}