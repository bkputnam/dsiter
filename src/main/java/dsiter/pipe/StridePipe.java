package dsiter.pipe;

import dsiter.iterator.StrideIterator;
import dsiter.iterator.IDatasetIterator;

/**
 * Pipe class for {@link StrideIterator}
 */
public class StridePipe implements IPipe {

	private long stride;

	public StridePipe(long stride) {
		this.stride = stride;
	}

	public long getStride() { return stride; }

	public IDatasetIterator attachTo(IDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

}