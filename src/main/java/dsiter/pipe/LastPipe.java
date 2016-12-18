package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.LastIterator;

public class LastPipe implements IPipe {

	public LastPipe() { }

	public IDatasetIterator applyTo(IDatasetIterator src) {
		return new LastIterator( src );
	}

}