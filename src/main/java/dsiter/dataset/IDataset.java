package dsiter.dataset;

import dsiter.iterator.AbstractDatasetIterator;

public interface IDataset {

	public AbstractDatasetIterator getIterator() throws Exception;

}
