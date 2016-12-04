package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TimesOperator extends BinaryOperator {

    public TimesOperator(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);
    }

    @Override
    public ColumnType getType() {
        return
            eitherTypeIs(ColumnType.DOUBLE) ? ColumnType.DOUBLE :
            eitherTypeIs(ColumnType.FLOAT) ? ColumnType.FLOAT :
            eitherTypeIs(ColumnType.LONG) ? ColumnType.LONG :
            ColumnType.INT;
    }

    @Override
    protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
        return lhsType.isNumeric() && rhsType.isNumeric();
    }

    protected Object getValue(int lhs, int rhs) { return lhs * rhs; }
    protected Object getValue(int lhs, long rhs) { return lhs * rhs; }
    protected Object getValue(int lhs, float rhs) { return lhs * rhs; }
    protected Object getValue(int lhs, double rhs) { return lhs * rhs; }

    protected Object getValue(long lhs, int rhs) { return lhs * rhs; }
    protected Object getValue(long lhs, long rhs) { return lhs * rhs; }
    protected Object getValue(long lhs, float rhs) { return lhs * rhs; }
    protected Object getValue(long lhs, double rhs) { return lhs * rhs; }

    protected Object getValue(float lhs, int rhs) { return lhs * rhs; }
    protected Object getValue(float lhs, long rhs) { return lhs * rhs; }
    protected Object getValue(float lhs, float rhs) { return lhs * rhs; }
    protected Object getValue(float lhs, double rhs) { return lhs * rhs; }

    protected Object getValue(double lhs, int rhs) { return lhs * rhs; }
    protected Object getValue(double lhs, long rhs) { return lhs * rhs; }
    protected Object getValue(double lhs, float rhs) { return lhs * rhs; }
    protected Object getValue(double lhs, double rhs) { return lhs * rhs; }
}
