package dsiter.pipe;

import dsiter.iterator.AbstractDatasetIterator;
import dsiter.iterator.FirstIterator;

public class FirstPipe implements IPipe {
    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
        return new FirstIterator(src);
    }
}
