package dsiter.dataset;

import dsiter.iterator.AbstractDatasetIterator;

public abstract class AbstractDataset {

	public abstract AbstractDatasetIterator getIterator() throws Exception;

}
