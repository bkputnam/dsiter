package dsiter.iterator;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import dsiter.row.TypedRowAccessor;

/**
 * An iterator which uses a {@code TypedRowAccessor.BOOLEAN}
 * to filter values from a source iterator.
 *
 * <p>
 *     Note that {@link dsiter.operator.parser.OperatorParser}
 *     is frequently used to create the
 *     {@code TypedRowAccessor.BOOLEAN} instances
 * </p>
 */
public class FilterIterator implements IDatasetIterator {

    private IDatasetIterator src;
    private TypedRowAccessor.BOOLEAN predicate;

	/**
	 * Create a new FilterIterator
	 * @param src The source iterator to be filtered
	 * @param predicate The filter. If {@code predicate.getBoolFromRow(row)}
	 *                  returns {@code true}, that row will be returned
	 *                  from this FilterIterator, else it will be skipped
	 */
	public FilterIterator(IDatasetIterator src, TypedRowAccessor.BOOLEAN predicate) {
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
