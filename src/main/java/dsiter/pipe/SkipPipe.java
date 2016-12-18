package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.SkipIterator;

public class SkipPipe implements IPipe {

    private int howMany;

    public SkipPipe(int howMany) {
        this.howMany = howMany;
    }

    @Override
    public IDatasetIterator applyTo(IDatasetIterator src) {
        return new SkipIterator(src, howMany);
    }
}
