package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.SkipIterator;

/**
 * Pipe class for {@link SkipIterator}
 */
public class SkipPipe implements IPipe {

    private long howMany;

    public SkipPipe(long howMany) {
        this.howMany = howMany;
    }

    @Override
    public IDatasetIterator attachTo(IDatasetIterator src) {
        return new SkipIterator(src, howMany);
    }
}
