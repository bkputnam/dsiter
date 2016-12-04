package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;

public interface IPipe {
	
	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src);

}