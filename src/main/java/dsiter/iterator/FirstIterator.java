package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FirstIterator implements IDatasetIterator {

    boolean hasMovedNext = false;
    IDatasetIterator src;

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
    public Row getCurrentRow() {
        return src.getCurrentRow();
    }

    @Override
    public ColumnDescriptor[] getColumnDescriptors() {
        return src.getColumnDescriptors();
    }
}
