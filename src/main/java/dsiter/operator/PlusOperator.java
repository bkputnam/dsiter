package dsiter.operator;

import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

/**
 * Binary operator that computes the sum of {@code lhs} and {@code rhs} for
 * numeric values, and the concatenation of {@code lhs} and {@code rhs} for
 * string values.
 *
 * <p>
 *     You probably won't ever want to use this class directly;
 *     it's much simpler to use {@link dsiter.parser.OperatorParser}
 *     directly. However, I certainly won't tell you you can't!
 * </p>
 */
public class PlusOperator extends TypedBinaryOperator {

    private ColumnType type;

    public PlusOperator(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);
    }

    @Override
    public ColumnType getReturnType(ColumnType lhs, ColumnType rhs) {
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

	@Override
	protected int handle_int_int_int(int lhs, int rhs) { return lhs + rhs; }
	@Override
	protected long handle_int_long_long(int lhs, long rhs) { return lhs + rhs; }
	@Override
	protected float handle_int_float_float(int lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_int_double_double(int lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_int_string_string(int lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_int_bool_bool(int lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected long handle_long_int_long(long lhs, int rhs) { return lhs + rhs; }
	@Override
	protected long handle_long_long_long(long lhs, long rhs) { return lhs + rhs; }
	@Override
	protected float handle_long_float_float(long lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_long_double_double(long lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_long_string_string(long lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_long_bool_bool(long lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected float handle_float_int_float(float lhs, int rhs) { return lhs + rhs; }
	@Override
	protected float handle_float_long_float(float lhs, long rhs) { return lhs + rhs; }
	@Override
	protected float handle_float_float_float(float lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_float_double_double(float lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_float_string_string(float lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_float_bool_bool(float lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected double handle_double_int_double(double lhs, int rhs) { return lhs + rhs; }
	@Override
	protected double handle_double_long_double(double lhs, long rhs) { return lhs + rhs; }
	@Override
	protected double handle_double_float_double(double lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_double_double_double(double lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_double_string_string(double lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_double_bool_bool(double lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected String handle_string_int_string(String lhs, int rhs) { return lhs + rhs; }
	@Override
	protected String handle_string_long_string(String lhs, long rhs) { return lhs + rhs; }
	@Override
	protected String handle_string_float_string(String lhs, float rhs) { return lhs + rhs; }
	@Override
	protected String handle_string_double_string(String lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_string_string_string(String lhs, String rhs) { return lhs + rhs; }
	@Override
	protected String handle_string_bool_string(String lhs, boolean rhs) { return lhs + rhs; }

//	@Override
//	protected double handle_bool_int_double(boolean lhs, int rhs) { return lhs + rhs; }
//	@Override
//	protected double handle_bool_long_double(boolean lhs, long rhs) { return lhs + rhs; }
//	@Override
//	protected double handle_bool_float_double(boolean lhs, float rhs) { return lhs + rhs; }
//	@Override
//	protected double handle_bool_double_double(boolean lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_bool_string_string(boolean lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_bool_bool_bool(boolean lhs, boolean rhs) { return lhs + rhs; }
}
