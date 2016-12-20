package dsiter.pipe;

import dsiter.iterator.StrideIterator;
import dsiter.iterator.IDatasetIterator;

/**
 * Pipe class for {@link StrideIterator}
 */
public class StridePipe implements IPipe {

	private int stride;

	public StridePipe(int stride) {
		this.stride = stride;
	}

	public IDatasetIterator attachTo(IDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

}