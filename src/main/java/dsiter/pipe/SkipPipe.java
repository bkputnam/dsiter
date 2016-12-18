package dsiter.pipe;

import dsiter.iterator.AbstractDatasetIterator;
import dsiter.iterator.SkipIterator;

public class SkipPipe implements IPipe {

    private int howMany;

    public SkipPipe(int howMany) {
        this.howMany = howMany;
    }

    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
        return new SkipIterator(src, howMany);
    }
}
