package dsiter.pipe;

import dsiter.iterator.StrideIterator;
import dsiter.iterator.AbstractDatasetIterator;

public class StridePipe implements IPipe {

	private int stride;

	public StridePipe(int stride) {
		this.stride = stride;
	}

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

}