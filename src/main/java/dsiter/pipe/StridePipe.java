package dsiter.pipe;

import dsiter.iterator.StrideIterator;
import dsiter.iterator.IDatasetIterator;

public class StridePipe implements IPipe {

	private int stride;

	public StridePipe(int stride) {
		this.stride = stride;
	}

	public IDatasetIterator applyTo(IDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

}