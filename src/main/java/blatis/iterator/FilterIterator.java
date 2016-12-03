package blatis.iterator;

import blatis.predicate.IPredicate;
import blatis.row.ColumnDescriptor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FilterIterator extends AbstractDatasetIterator {

    private AbstractDatasetIterator src;
    private IPredicate predicate;
    private Row currentRow;

    public FilterIterator(AbstractDatasetIterator src, IPredicate predicate) {
        this.src = src;
        this.predicate = predicate;
    }

    @Override
    public boolean tryMoveNext() {
        Row row;
        boolean foundPassingRow = false;
        while(src.tryMoveNext()) {
            row = src.getCurrentRow();
            if(predicate.testRow(row)) {
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
