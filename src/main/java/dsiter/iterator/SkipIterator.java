package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

/**
 * An iterator that skips the first {@code howMany} elements
 * of its source iterator, and then returns the rest.
 */
public class SkipIterator implements IDatasetIterator {

    private IDatasetIterator src;
    private long numSkips;
    private long remainingSkips;

	/**
	 * Construct a SkipIterator that skips the first {@code howMany}
	 * elements of {@code src}
	 *
	 * @param src     The source iterator
	 * @param howMany The number of elements of {@code src} to be skipped
	 */
	public SkipIterator(IDatasetIterator src, long howMany) {
        this.src = src;
        numSkips = remainingSkips = howMany;
    }

    @Override
    public boolean tryMoveNext() throws Exception {
        while(remainingSkips > 0) {
            remainingSkips--;
            if(!src.tryMoveNext()) {
                return false;
            }
        }
        return src.tryMoveNext();
    }

    @Override
    public Row getCurrentRow() throws Exception {
        return src.getCurrentRow();
    }

	@Override
	public long tryGetLength() {
		long srcLen = src.tryGetLength();
		if (srcLen == -1) {
			return -1;
		}
		else {
			if (srcLen < numSkips) {
				return 0;
			}
			else {
				return srcLen - numSkips;
			}
		}
	}

	@Override
    public ColumnDescriptor[] getColumnDescriptors() {
        return src.getColumnDescriptors();
    }

	@Override
	public void close() throws Exception {
		src.close();
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) {
		return false;
	}
}
