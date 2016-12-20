package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.RenameIterator;

/**
 * Pipe class for {@link RenameIterator}
 */
public class RenamePipe implements IPipe {

    private String from;
    private String to;

    public RenamePipe(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public IDatasetIterator attachTo(IDatasetIterator src) {
        return new RenameIterator(src, from, to);
    }
}
