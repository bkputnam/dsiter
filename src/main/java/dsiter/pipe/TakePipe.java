package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.TakeIterator;

/**
 * Pipe class for {@link TakeIterator}
 */
public class TakePipe implements IPipe {

	private long howMany;

	public TakePipe(long howMany) {
		this.howMany = howMany;
	}

	@Override
	public IDatasetIterator attachTo(IDatasetIterator src) {
		return new TakeIterator(src, howMany);
	}
}
