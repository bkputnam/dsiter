package blatis.iterator;

import blatis.row.*;

/**
 * Created by bkputnam on 12/3/16.
 */
public class ArrayIterator<T> extends AbstractDatasetIterator {

    private T[] values;
    private int index;
    private Row row;
    private ColumnMutator mutator;
    private ColumnType type;

    @SafeVarargs
    public ArrayIterator(T... values) {
        this.values = values;
        this.index = -1;

        if(values.length > 0) {
            T sample = values[0];
            type =
                sample instanceof Integer ? ColumnType.INT :
                sample instanceof Long ? ColumnType.LONG :
                sample instanceof Float ? ColumnType.FLOAT :
                sample instanceof Double ? ColumnType.DOUBLE :
                sample instanceof String ? ColumnType.STRING :
                sample instanceof Boolean ? ColumnType.BOOLEAN :
                null;
            if(type == null) {
                throw new Error(
                    "Programmer error: Unable to cast array to standard type(" +
                    sample.getClass().getSimpleName() + ")"
                );
            }
            mutator = ColumnMutator.create(type, 0);
            RowShape shape = new RowShape();
            shape.setNum(type, 1);
            row = new Row(shape);
        }
    }

    @Override
    public boolean tryMoveNext() {
        if(index < values.length-1) {
            index++;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Row getCurrentRow() {
        mutator.setValueInRow(row, values[index]);
        return row;
    }

    @Override
    public ColumnDescriptor[] getColumnDescriptors() {
        return new ColumnDescriptor[] {
            new ColumnDescriptor("value", type, 0)
        };
    }
}
