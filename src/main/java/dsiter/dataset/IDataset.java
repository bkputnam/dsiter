package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;

public interface IDataset {

	public IDatasetIterator getIterator() throws Exception;

}
