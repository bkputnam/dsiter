package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

/**
 * An iterator that returns only the first element of
 * another source iterator.
 */
public class FirstIterator implements IDatasetIterator {

    private boolean hasMovedNext = false;
    private IDatasetIterator src;

	public FirstIterator(IDatasetIterator src) {
        this.src = src;
    }

    @Override
    public boolean tryMoveNext() {
        if(!hasMovedNext) {
            hasMovedNext = true;
            return src.tryMoveNext();
        }
        else {
            return false;
        }
    }

	@Override
	public long tryGetLength() {
		// length is either 0 or 1, but we don't know
		// which ahead of time.
		return -1;
	}

	@Override
    public Row getCurrentRow() {
        return src.getCurrentRow();
    }

    @Override
    public ColumnDescriptor[] getColumnDescriptors() {
        return src.getColumnDescriptors();
    }
}
