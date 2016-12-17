package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.SkipIterator;

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
