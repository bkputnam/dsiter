package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.FirstIterator;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FirstPipe implements IPipe {
    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
        return new FirstIterator(src);
    }
}
