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
		long srcLen = src.tryGetLength();
		if (srcLen == -1 || srcLen == 0) {
			return srcLen;
		}
		else {
			return 1;
		}
	}

	@Override
    public Row getCurrentRow() throws Exception {
        return src.getCurrentRow();
    }

    @Override
    public ColumnDescriptor[] getColumnDescriptors() {
        return src.getColumnDescriptors();
    }
}
