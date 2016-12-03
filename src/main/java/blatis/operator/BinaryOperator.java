package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public abstract class BinaryOperator implements IRowAccessor {

    IRowAccessor lhs;
    IRowAccessor rhs;

    InnerOperator innerOperator;

    public BinaryOperator(IRowAccessor lhs, IRowAccessor rhs) {
        if( lhs == null ) { throw new IllegalArgumentException("lhs cannot be null"); }
        if( rhs == null ) { throw new IllegalArgumentException("rhs cannot be null"); }

        this.lhs = lhs;
        this.rhs = rhs;

        ColumnType lhsType = lhs.getType();
        ColumnType rhsType = rhs.getType();

        if(!testTypeCompatibility(lhsType, rhsType)) {
            throw new IllegalArgumentException("Incompatible types: " + lhsType + ", " + rhsType);
        }

        innerOperator = getInnerOperator(lhsType, rhsType);
    }

    @Override
    public Object getValueFromRow(Row row) {
        return innerOperator.castValue(
            lhs.getValueFromRow(row),
            rhs.getValueFromRow(row)
        );
    }

    protected abstract boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType);

    protected boolean eitherTypeIs(ColumnType type) {
        return lhs.getType() == type || rhs.getType() == type;
    }
    protected boolean bothTypesAre(ColumnType type) {
        return lhs.getType() == type && rhs.getType() == type;
    }

    private InnerOperator getInnerOperator(ColumnType lhsType, ColumnType rhsType) {
        if(lhsType == ColumnType.INT) {
            if(rhsType == ColumnType.INT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((int)lhs, (int)rhs); }
                };
            }
            else if(rhsType == ColumnType.LONG) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((int)lhs, (long)rhs); }
                };
            }
            else if(rhsType == ColumnType.FLOAT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((int)lhs, (float)rhs); }
                };
            }
            else if(rhsType == ColumnType.DOUBLE) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((int)lhs, (double)rhs); }
                };
            }
            else if(rhsType == ColumnType.STRING) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((int)lhs, (String)rhs); }
                };
            }
            else if(rhsType == ColumnType.BOOLEAN) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((int)lhs, (boolean)rhs); }
                };
            }
            else {
                throw new Error("Programmer error: unrecognized ColumnType: " + rhsType);
            }
        }
        else if(lhsType == ColumnType.LONG) {
            if(rhsType == ColumnType.INT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((long)lhs, (int)rhs); }
                };
            }
            else if(rhsType == ColumnType.LONG) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((long)lhs, (long)rhs); }
                };
            }
            else if(rhsType == ColumnType.FLOAT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((long)lhs, (float)rhs); }
                };
            }
            else if(rhsType == ColumnType.DOUBLE) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((long)lhs, (double)rhs); }
                };
            }
            else if(rhsType == ColumnType.STRING) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((long)lhs, (String)rhs); }
                };
            }
            else if(rhsType == ColumnType.BOOLEAN) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((long)lhs, (boolean)rhs); }
                };
            }
            else {
                throw new Error("Programmer error: unrecognized ColumnType: " + rhsType);
            }
        }
        else if(lhsType == ColumnType.FLOAT) {
            if(rhsType == ColumnType.INT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((float)lhs, (int)rhs); }
                };
            }
            else if(rhsType == ColumnType.LONG) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((float)lhs, (long)rhs); }
                };
            }
            else if(rhsType == ColumnType.FLOAT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((float)lhs, (float)rhs); }
                };
            }
            else if(rhsType == ColumnType.DOUBLE) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((float)lhs, (double)rhs); }
                };
            }
            else if(rhsType == ColumnType.STRING) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((float)lhs, (String)rhs); }
                };
            }
            else if(rhsType == ColumnType.BOOLEAN) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((float)lhs, (boolean)rhs); }
                };
            }
            else {
                throw new Error("Programmer error: unrecognized ColumnType: " + rhsType);
            }
        }
        else if(lhsType == ColumnType.DOUBLE) {
            if(rhsType == ColumnType.INT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((double)lhs, (int)rhs); }
                };
            }
            else if(rhsType == ColumnType.LONG) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((double)lhs, (long)rhs); }
                };
            }
            else if(rhsType == ColumnType.FLOAT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((double)lhs, (float)rhs); }
                };
            }
            else if(rhsType == ColumnType.DOUBLE) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((double)lhs, (double)rhs); }
                };
            }
            else if(rhsType == ColumnType.STRING) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((double)lhs, (String)rhs); }
                };
            }
            else if(rhsType == ColumnType.BOOLEAN) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((double)lhs, (boolean)rhs); }
                };
            }
            else {
                throw new Error("Programmer error: unrecognized ColumnType: " + rhsType);
            }
        }
        else if(lhsType == ColumnType.STRING) {
            if(rhsType == ColumnType.INT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((String)lhs, (int)rhs); }
                };
            }
            else if(rhsType == ColumnType.LONG) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((String)lhs, (long)rhs); }
                };
            }
            else if(rhsType == ColumnType.FLOAT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((String)lhs, (float)rhs); }
                };
            }
            else if(rhsType == ColumnType.DOUBLE) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((String)lhs, (double)rhs); }
                };
            }
            else if(rhsType == ColumnType.STRING) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((String)lhs, (String)rhs); }
                };
            }
            else if(rhsType == ColumnType.BOOLEAN) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((String)lhs, (boolean)rhs); }
                };
            }
            else {
                throw new Error("Programmer error: unrecognized ColumnType: " + rhsType);
            }
        }
        else if(lhsType == ColumnType.BOOLEAN) {
            if(rhsType == ColumnType.INT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((boolean)lhs, (int)rhs); }
                };
            }
            else if(rhsType == ColumnType.LONG) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((boolean)lhs, (long)rhs); }
                };
            }
            else if(rhsType == ColumnType.FLOAT) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((boolean)lhs, (float)rhs); }
                };
            }
            else if(rhsType == ColumnType.DOUBLE) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((boolean)lhs, (double)rhs); }
                };
            }
            else if(rhsType == ColumnType.STRING) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((boolean)lhs, (String)rhs); }
                };
            }
            else if(rhsType == ColumnType.BOOLEAN) {
                return new InnerOperator() {
                    public Object castValue(Object lhs, Object rhs) { return getValue((boolean)lhs, (boolean)rhs); }
                };
            }
            else {
                throw new Error("Programmer error: unrecognized ColumnType: " + rhsType);
            }
        }
        else {
            throw new Error("Programmer error: unrecognized ColumnType: " + lhsType);
        }
    }

    protected Object getValue(int lhs, int rhs) { throw new Error("Programmer error: getValue(int, int) must be overridden by subclass"); }
    protected Object getValue(int lhs, long rhs) { throw new Error("Programmer error: getValue(int, long) must be overridden by subclass"); }
    protected Object getValue(int lhs, float rhs) { throw new Error("Programmer error: getValue(int, float) must be overridden by subclass"); }
    protected Object getValue(int lhs, double rhs) { throw new Error("Programmer error: getValue(int, double) must be overridden by subclass"); }
    protected Object getValue(int lhs, String rhs) { throw new Error("Programmer error: getValue(int, String) must be overridden by subclass"); }
    protected Object getValue(int lhs, boolean rhs) { throw new Error("Programmer error: getValue(int, boolean) must be overridden by subclass"); }

    protected Object getValue(long lhs, int rhs) { throw new Error("Programmer error: getValue(long, int) must be overridden by subclass"); }
    protected Object getValue(long lhs, long rhs) { throw new Error("Programmer error: getValue(long, long) must be overridden by subclass"); }
    protected Object getValue(long lhs, float rhs) { throw new Error("Programmer error: getValue(long, float) must be overridden by subclass"); }
    protected Object getValue(long lhs, double rhs) { throw new Error("Programmer error: getValue(long, double) must be overridden by subclass"); }
    protected Object getValue(long lhs, String rhs) { throw new Error("Programmer error: getValue(long, String) must be overridden by subclass"); }
    protected Object getValue(long lhs, boolean rhs) { throw new Error("Programmer error: getValue(long, boolean) must be overridden by subclass"); }

    protected Object getValue(float lhs, int rhs) { throw new Error("Programmer error: getValue(float, int) must be overridden by subclass"); }
    protected Object getValue(float lhs, long rhs) { throw new Error("Programmer error: getValue(float, long) must be overridden by subclass"); }
    protected Object getValue(float lhs, float rhs) { throw new Error("Programmer error: getValue(float, float) must be overridden by subclass"); }
    protected Object getValue(float lhs, double rhs) { throw new Error("Programmer error: getValue(float, double) must be overridden by subclass"); }
    protected Object getValue(float lhs, String rhs) { throw new Error("Programmer error: getValue(float, String) must be overridden by subclass"); }
    protected Object getValue(float lhs, boolean rhs) { throw new Error("Programmer error: getValue(float, boolean) must be overridden by subclass"); }

    protected Object getValue(double lhs, int rhs) { throw new Error("Programmer error: getValue(double, int) must be overridden by subclass"); }
    protected Object getValue(double lhs, long rhs) { throw new Error("Programmer error: getValue(double, long) must be overridden by subclass"); }
    protected Object getValue(double lhs, float rhs) { throw new Error("Programmer error: getValue(double, float) must be overridden by subclass"); }
    protected Object getValue(double lhs, double rhs) { throw new Error("Programmer error: getValue(double, double) must be overridden by subclass"); }
    protected Object getValue(double lhs, String rhs) { throw new Error("Programmer error: getValue(double, String) must be overridden by subclass"); }
    protected Object getValue(double lhs, boolean rhs) { throw new Error("Programmer error: getValue(double, boolean) must be overridden by subclass"); }

    protected Object getValue(String lhs, int rhs) { throw new Error("Programmer error: getValue(String, int) must be overridden by subclass"); }
    protected Object getValue(String lhs, long rhs) { throw new Error("Programmer error: getValue(String, long) must be overridden by subclass"); }
    protected Object getValue(String lhs, float rhs) { throw new Error("Programmer error: getValue(String, float) must be overridden by subclass"); }
    protected Object getValue(String lhs, double rhs) { throw new Error("Programmer error: getValue(String, double) must be overridden by subclass"); }
    protected Object getValue(String lhs, String rhs) { throw new Error("Programmer error: getValue(String, String) must be overridden by subclass"); }
    protected Object getValue(String lhs, boolean rhs) { throw new Error("Programmer error: getValue(String, boolean) must be overridden by subclass"); }

    protected Object getValue(boolean lhs, int rhs) { throw new Error("Programmer error: getValue(boolean, int) must be overridden by subclass"); }
    protected Object getValue(boolean lhs, long rhs) { throw new Error("Programmer error: getValue(boolean, long) must be overridden by subclass"); }
    protected Object getValue(boolean lhs, float rhs) { throw new Error("Programmer error: getValue(boolean, float) must be overridden by subclass"); }
    protected Object getValue(boolean lhs, double rhs) { throw new Error("Programmer error: getValue(boolean, double) must be overridden by subclass"); }
    protected Object getValue(boolean lhs, String rhs) { throw new Error("Programmer error: getValue(boolean, String) must be overridden by subclass"); }
    protected Object getValue(boolean lhs, boolean rhs) { throw new Error("Programmer error: getValue(boolean, boolean) must be overridden by subclass"); }

    private interface InnerOperator {
        public Object castValue(Object lhs, Object rhs);
    }
}
