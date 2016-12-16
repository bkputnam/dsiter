package blatis.iterator;

import blatis.row.ColumnDescriptor;
import blatis.row.Row;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FilterIterator extends AbstractDatasetIterator {

    private AbstractDatasetIterator src;
    private TypedRowAccessor.BOOLEAN predicate;
    private Row currentRow;

    public FilterIterator(AbstractDatasetIterator src, TypedRowAccessor.BOOLEAN predicate) {
        this.src = src;
        this.predicate = predicate;
    }

    @Override
    public boolean tryMoveNext() {
        Row row;
        boolean foundPassingRow = false;
        while(src.tryMoveNext()) {
            row = src.getCurrentRow();
            if(predicate.getBoolFromRow(row)) {
                currentRow = row;
                return true;
            }
        }
        return false;
    }

    @Override
    public Row getCurrentRow() {
        return currentRow;
    }

    @Override
    public ColumnDescriptor[] getColumnDescriptors() {
        return src.getColumnDescriptors();
    }
}
