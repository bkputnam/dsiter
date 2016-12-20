package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

public class SkipIterator implements IDatasetIterator {

    private IDatasetIterator src;
    private long numSkips;
    private long remainingSkips;

    public SkipIterator(IDatasetIterator src, long howMany) {
        this.src = src;
        numSkips = remainingSkips = howMany;
    }

    @Override
    public boolean tryMoveNext() {
        while(remainingSkips > 0) {
            remainingSkips--;
            if(!src.tryMoveNext()) {
                return false;
            }
        }
        return src.tryMoveNext();
    }

    @Override
    public Row getCurrentRow() {
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
}
