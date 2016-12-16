package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.FilterIterator;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FilterPipe implements IPipe {

	TypedRowAccessor.BOOLEAN predicate;

	public FilterPipe(TypedRowAccessor.BOOLEAN predicate) {
		this.predicate = predicate;
	}

    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		return new FilterIterator(src, predicate);
    }
}
