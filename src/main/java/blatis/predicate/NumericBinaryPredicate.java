package blatis.predicate;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public abstract class NumericBinaryPredicate extends BinaryPredicate {

    protected IPredicate innerPredicate;

    public NumericBinaryPredicate(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);

        if( lhs.getType() != rhs.getType() ) {
            throw new IllegalArgumentException(
                "lhs and rhs must have same type (found " +
                lhs.getType() + ", " + rhs.getType() +
                ", respectively)"
            );
        }

        ColumnType type = lhs.getType();
        innerPredicate =
            type == ColumnType.INT ? new IntPredicate(lhs, rhs) :
            type == ColumnType.LONG ? new LongPredicate(lhs, rhs) :
            type == ColumnType.FLOAT ? new FloatPredicate(lhs, rhs) :
            type == ColumnType.DOUBLE ? new DoublePredicate(lhs, rhs) :
            null;
        if( innerPredicate == null ) {
            throw new IllegalArgumentException("Unsupported column type: " + type);
        }
    }

    @Override
    public boolean testRow(Row row) {
        return innerPredicate.testRow(row);
    }

    protected abstract boolean compareInts(int lhs, int rhs);
    protected abstract boolean compareLongs(long lhs, long rhs);
    protected abstract boolean compareFloats(float lhs, float rhs);
    protected abstract boolean compareDoubles(double lhs, double rhs);

    private class IntPredicate extends BinaryPredicate {
        public IntPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareInts((int)lhs.getValueFromRow(row), (int)rhs.getValueFromRow(row));
        }
    }

    private class LongPredicate extends BinaryPredicate {
        public LongPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareLongs((long)lhs.getValueFromRow(row), (long)rhs.getValueFromRow(row));
        }
    }

    private class FloatPredicate extends BinaryPredicate {
        public FloatPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareFloats((float)lhs.getValueFromRow(row), (float)rhs.getValueFromRow(row));
        }
    }

    private class DoublePredicate extends BinaryPredicate {
        public DoublePredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareDoubles((double)lhs.getValueFromRow(row), (double)rhs.getValueFromRow(row));
        }
    }
}
