package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;

public interface IPipe {
	
	public IDatasetIterator applyTo(IDatasetIterator src);

}