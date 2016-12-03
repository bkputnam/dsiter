package blatis.predicate;

import blatis.row.ColumnDescriptor;
import blatis.row.IRowAccessor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class GreaterThanEqualsPredicate extends NumericBinaryPredicate {

    public GreaterThanEqualsPredicate(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);
    }

    @Override
    protected boolean compareInts(int lhs, int rhs) {
        return lhs >= rhs;
    }

    @Override
    protected boolean compareLongs(long lhs, long rhs) {
        return lhs >= rhs;
    }

    @Override
    protected boolean compareFloats(float lhs, float rhs) {
        return lhs >= rhs;
    }

    @Override
    protected boolean compareDoubles(double lhs, double rhs) {
        return lhs >= rhs;
    }
}
