package blatis.operation;

import blatis.iterator.StrideIterator;
import blatis.iterator.AbstractDatasetIterator;

public class StrideOperation extends AbstractOperation {

	private int stride;

	public StrideOperation(int stride) {
		this.stride = stride;
	}

	public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new StrideIterator( src, stride );
	}

}