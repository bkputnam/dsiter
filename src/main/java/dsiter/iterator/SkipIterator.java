package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

public class SkipIterator implements IDatasetIterator {

    private IDatasetIterator src;
    private int remainingSkips;

    public SkipIterator(IDatasetIterator src, int howMany) {
        this.src = src;
        this.remainingSkips = howMany;
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
    public ColumnDescriptor[] getColumnDescriptors() {
        return src.getColumnDescriptors();
    }
}
