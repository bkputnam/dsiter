package dsiter.pipe;

import dsiter.iterator.AbstractDatasetIterator;

public interface IPipe {
	
	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src);

}