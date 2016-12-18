package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import dsiter.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FilterIterator extends AbstractDatasetIterator {

    private AbstractDatasetIterator src;
    private TypedRowAccessor.BOOLEAN predicate;

    public FilterIterator(AbstractDatasetIterator src, TypedRowAccessor.BOOLEAN predicate) {
        this.src = src;
        this.predicate = predicate;
    }

    @Override
    public boolean tryMoveNext() {
        boolean foundPassingRow = false;
        while(src.tryMoveNext()) {
            if(predicate.getBoolFromRow(src.getCurrentRow())) {
                return true;
            }
        }
        return false;
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
