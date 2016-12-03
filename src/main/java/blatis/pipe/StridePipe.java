package blatis.pipe;

import blatis.iterator.StrideIterator;
import blatis.iterator.AbstractDatasetIterator;

public class StridePipe extends AbstractPipe {

	private int stride;

	public StridePipe(int stride) {
		this.stride = stride;
	}

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

}