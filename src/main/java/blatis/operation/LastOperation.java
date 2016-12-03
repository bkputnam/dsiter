package blatis.operation;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.LastIterator;

public class LastOperation extends AbstractOperation {

	public LastOperation() { }

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new LastIterator( src );
	}

}