package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.FirstIterator;

/**
 * Pipe class for {@link FirstIterator}
 */
public class FirstPipe implements IPipe {
    @Override
    public IDatasetIterator attachTo(IDatasetIterator src) {
        return new FirstIterator(src);
    }
}
