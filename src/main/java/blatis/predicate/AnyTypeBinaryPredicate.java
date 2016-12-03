package blatis.predicate;

import blatis.row.ColumnDescriptor;
import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public abstract class AnyTypeBinaryPredicate extends AbstractBinaryPredicate {

    protected IPredicate innerPredicate;

    public AnyTypeBinaryPredicate(IRowAccessor lhs, IRowAccessor rhs) {
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
            type == ColumnType.STRING ? new StringPredicate(lhs, rhs) :
            type == ColumnType.BOOLEAN ? new BoolPredicate(lhs, rhs) :
            null;
        if( innerPredicate == null ) {
            throw new Error("Programmer error: unrecognized type: " + type);
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
    protected abstract boolean compareStrings(String lhs, String rhs);
    protected abstract boolean compareBools(boolean lhs, boolean rhs);

    private class IntPredicate extends AbstractBinaryPredicate {
        public IntPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareInts((int)lhs.getValueFromRow(row), (int)rhs.getValueFromRow(row));
        }
    }

    private class LongPredicate extends AbstractBinaryPredicate {
        public LongPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareLongs((long)lhs.getValueFromRow(row), (long)rhs.getValueFromRow(row));
        }
    }

    private class FloatPredicate extends AbstractBinaryPredicate {
        public FloatPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareFloats((float)lhs.getValueFromRow(row), (float)rhs.getValueFromRow(row));
        }
    }

    private class DoublePredicate extends AbstractBinaryPredicate {
        public DoublePredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareDoubles((double)lhs.getValueFromRow(row), (double)rhs.getValueFromRow(row));
        }
    }

    private class StringPredicate extends AbstractBinaryPredicate {
        public StringPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareStrings((String)lhs.getValueFromRow(row), (String)rhs.getValueFromRow(row));
        }
    }

    private class BoolPredicate extends AbstractBinaryPredicate {
        public BoolPredicate(IRowAccessor lhs, IRowAccessor rhs) { super(lhs, rhs); }

        @Override
        public boolean testRow(Row row) {
            return compareBools((boolean)lhs.getValueFromRow(row), (boolean)rhs.getValueFromRow(row));
        }
    }
}
