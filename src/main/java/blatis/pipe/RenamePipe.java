package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.RenameIterator;

public class RenamePipe implements IPipe {

    private String from;
    private String to;

    public RenamePipe(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
        return new RenameIterator(src, from, to);
    }
}
