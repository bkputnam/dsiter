package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.FilterIterator;
import blatis.predicate.IPredicate;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FilterPipe implements IPipe {

    IPredicate predicate;

    public FilterPipe(IPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
        return new FilterIterator(src, predicate);
    }
}
