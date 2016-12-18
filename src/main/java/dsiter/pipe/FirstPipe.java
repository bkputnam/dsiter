package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.FirstIterator;

public class FirstPipe implements IPipe {
    @Override
    public IDatasetIterator applyTo(IDatasetIterator src) {
        return new FirstIterator(src);
    }
}
