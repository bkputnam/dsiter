package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;

public abstract class AbstractPipe {
	
	public abstract AbstractDatasetIterator applyTo(AbstractDatasetIterator src);

}