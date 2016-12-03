package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class PlusOperator extends BinaryOperator {

    private ColumnType type;

    public PlusOperator(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);
    }

    @Override
    public ColumnType getType() {
        return type;
    }

    @Override
    protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
        if(eitherTypeIs(ColumnType.STRING)) {
            type = ColumnType.STRING;
            return true;
        }
        if(eitherTypeIs(ColumnType.BOOLEAN)) {
            // booleans can only be +'ed with strings
            return false;
        }

        if(eitherTypeIs(ColumnType.DOUBLE)) {
            type = ColumnType.DOUBLE;
        }
        else if(eitherTypeIs(ColumnType.FLOAT)) {
            type = ColumnType.FLOAT;
        }
        else if(eitherTypeIs(ColumnType.LONG)) {
            type = ColumnType.LONG;
        }
        else if(eitherTypeIs(ColumnType.INT)) {
            type = ColumnType.INT;
        }
        else {
            throw new Error("Programmer error: unrecognized types " + lhsType + ", " + rhsType);
        }

        return true;
    }

    protected Object getValue(int lhs, int rhs) { return lhs + rhs; }
    protected Object getValue(int lhs, long rhs) { return lhs + rhs; }
    protected Object getValue(int lhs, float rhs) { return lhs + rhs; }
    protected Object getValue(int lhs, double rhs) { return lhs + rhs; }
    protected Object getValue(int lhs, String rhs) { return lhs + rhs; }
//    protected Object getValue(int lhs, boolean rhs) { return lhs + rhs; }

    protected Object getValue(long lhs, int rhs) { return lhs + rhs; }
    protected Object getValue(long lhs, long rhs) { return lhs + rhs; }
    protected Object getValue(long lhs, float rhs) { return lhs + rhs; }
    protected Object getValue(long lhs, double rhs) { return lhs + rhs; }
    protected Object getValue(long lhs, String rhs) { return lhs + rhs; }
//    protected Object getValue(long lhs, boolean rhs) { return lhs + rhs; }

    protected Object getValue(float lhs, int rhs) { return lhs + rhs; }
    protected Object getValue(float lhs, long rhs) { return lhs + rhs; }
    protected Object getValue(float lhs, float rhs) { return lhs + rhs; }
    protected Object getValue(float lhs, double rhs) { return lhs + rhs; }
    protected Object getValue(float lhs, String rhs) { return lhs + rhs; }
//    protected Object getValue(float lhs, boolean rhs) { return lhs + rhs; }

    protected Object getValue(double lhs, int rhs) { return lhs + rhs; }
    protected Object getValue(double lhs, long rhs) { return lhs + rhs; }
    protected Object getValue(double lhs, float rhs) { return lhs + rhs; }
    protected Object getValue(double lhs, double rhs) { return lhs + rhs; }
    protected Object getValue(double lhs, String rhs) { return lhs + rhs; }
//    protected Object getValue(double lhs, boolean rhs) { return lhs + rhs; }

    protected Object getValue(String lhs, int rhs) { return lhs + rhs; }
    protected Object getValue(String lhs, long rhs) { return lhs + rhs; }
    protected Object getValue(String lhs, float rhs) { return lhs + rhs; }
    protected Object getValue(String lhs, double rhs) { return lhs + rhs; }
    protected Object getValue(String lhs, String rhs) { return lhs + rhs; }
    protected Object getValue(String lhs, boolean rhs) { return lhs + rhs; }

//    protected Object getValue(boolean lhs, int rhs) { return lhs + rhs; }
//    protected Object getValue(boolean lhs, long rhs) { return lhs + rhs; }
//    protected Object getValue(boolean lhs, float rhs) { return lhs + rhs; }
//    protected Object getValue(boolean lhs, double rhs) { return lhs + rhs; }
    protected Object getValue(boolean lhs, String rhs) { return lhs + rhs; }
//    protected Object getValue(boolean lhs, boolean rhs) { return lhs + rhs; }
}
