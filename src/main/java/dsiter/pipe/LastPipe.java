package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.LastIterator;

/**
 * Pipe class for {@link LastIterator}
 */
public class LastPipe implements IPipe {

	public LastPipe() { }

	public IDatasetIterator attachTo(IDatasetIterator src) {
		return new LastIterator( src );
	}

}