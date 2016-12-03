package blatis.operation;

import blatis.iterator.AbstractDatasetIterator;

public abstract class AbstractOperation {
	
	public abstract AbstractDatasetIterator applyTo(AbstractDatasetIterator src);

}