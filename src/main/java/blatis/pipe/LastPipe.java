package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.LastIterator;

public class LastPipe extends AbstractPipe {

	public LastPipe() { }

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new LastIterator( src );
	}

}