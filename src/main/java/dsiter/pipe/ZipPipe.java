package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.ZipIterator;

public class ZipPipe implements IPipe {

    IDatasetIterator[] iters;

    public ZipPipe(IDatasetIterator... iters) {
        this.iters = iters;
    }

    @Override
    public IDatasetIterator applyTo(IDatasetIterator src) {

        // add space for src, shift everything else up one index
        IDatasetIterator[] args = new IDatasetIterator[iters.length+1];
        args[0] = src;
        for(int i=0; i<iters.length; i++) {
            args[i+1] = iters[i];
        }

        return new ZipIterator(args);
    }
}
