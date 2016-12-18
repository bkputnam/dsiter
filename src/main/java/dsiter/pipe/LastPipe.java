package dsiter.pipe;

import dsiter.iterator.AbstractDatasetIterator;
import dsiter.iterator.LastIterator;

public class LastPipe implements IPipe {

	public LastPipe() { }

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new LastIterator( src );
	}

}