package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.FirstIterator;

public class FirstPipe implements IPipe {
    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
        return new FirstIterator(src);
    }
}
