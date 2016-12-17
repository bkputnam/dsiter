package blatis.dataset;

import blatis.iterator.AbstractDatasetIterator;

public abstract class AbstractDataset {

	public abstract AbstractDatasetIterator getIterator() throws Exception;

}
