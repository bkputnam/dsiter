package blatis.pipe;

import blatis.dataset.AbstractDataset;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.ZipIterator;

public class ZipPipe implements IPipe {

    AbstractDatasetIterator[] iters;

    public ZipPipe(AbstractDatasetIterator... iters) {
        this.iters = iters;
    }

    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {

        // add space for src, shift everything else up one index
        AbstractDatasetIterator[] args = new AbstractDatasetIterator[iters.length+1];
        args[0] = src;
        for(int i=0; i<iters.length; i++) {
            args[i+1] = iters[i];
        }

        return new ZipIterator(args);
    }
}
