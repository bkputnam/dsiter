package blatis.predicate;

import blatis.row.IRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class EqualsPredicate extends AnyTypeBinaryPredicate {

    public EqualsPredicate(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);
    }

    @Override
    protected boolean compareInts(int lhs, int rhs) {
        return lhs == rhs;
    }

    @Override
    protected boolean compareLongs(long lhs, long rhs) {
        return lhs == rhs;
    }

    @Override
    protected boolean compareFloats(float lhs, float rhs) {
        return lhs == rhs;
    }

    @Override
    protected boolean compareDoubles(double lhs, double rhs) {
        return lhs == rhs;
    }

    @Override
    protected boolean compareStrings(String lhs, String rhs) {
        return lhs.equals(rhs);
    }

    @Override
    protected boolean compareBools(boolean lhs, boolean rhs) {
        return lhs == rhs;
    }
}
