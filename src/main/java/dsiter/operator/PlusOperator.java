package dsiter.operator;

import dsiter.row.ColumnType;
import dsiter.row.TypedRowAccessor;

/**
 * Binary operator that computes the sum of {@code lhs} and {@code rhs} for
 * numeric values, and the concatenation of {@code lhs} and {@code rhs} for
 * string values.
 *
 * <p>
 *     You probably won't ever want to use this class directly;
 *     it's much simpler to use {@link dsiter.operator.parser.OperatorParser}
 *     directly. However, I certainly won't tell you you can't!
 * </p>
 */
public class PlusOperator extends TypedBinaryOperator {

    private ColumnType type;

    public PlusOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
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
	protected String handle_int_String_String(int lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_int_boolean_boolean(int lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected long handle_long_int_long(long lhs, int rhs) { return lhs + rhs; }
	@Override
	protected long handle_long_long_long(long lhs, long rhs) { return lhs + rhs; }
	@Override
	protected float handle_long_float_float(long lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_long_double_double(long lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_long_String_String(long lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_long_boolean_boolean(long lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected float handle_float_int_float(float lhs, int rhs) { return lhs + rhs; }
	@Override
	protected float handle_float_long_float(float lhs, long rhs) { return lhs + rhs; }
	@Override
	protected float handle_float_float_float(float lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_float_double_double(float lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_float_String_String(float lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_float_boolean_boolean(float lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected double handle_double_int_double(double lhs, int rhs) { return lhs + rhs; }
	@Override
	protected double handle_double_long_double(double lhs, long rhs) { return lhs + rhs; }
	@Override
	protected double handle_double_float_double(double lhs, float rhs) { return lhs + rhs; }
	@Override
	protected double handle_double_double_double(double lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_double_String_String(double lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_double_boolean_boolean(double lhs, boolean rhs) { return lhs + rhs; }

	@Override
	protected String handle_String_int_String(String lhs, int rhs) { return lhs + rhs; }
	@Override
	protected String handle_String_long_String(String lhs, long rhs) { return lhs + rhs; }
	@Override
	protected String handle_String_float_String(String lhs, float rhs) { return lhs + rhs; }
	@Override
	protected String handle_String_double_String(String lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_String_String_String(String lhs, String rhs) { return lhs + rhs; }
	@Override
	protected String handle_String_boolean_String(String lhs, boolean rhs) { return lhs + rhs; }

//	@Override
//	protected double handle_boolean_int_double(boolean lhs, int rhs) { return lhs + rhs; }
//	@Override
//	protected double handle_boolean_long_double(boolean lhs, long rhs) { return lhs + rhs; }
//	@Override
//	protected double handle_boolean_float_double(boolean lhs, float rhs) { return lhs + rhs; }
//	@Override
//	protected double handle_boolean_double_double(boolean lhs, double rhs) { return lhs + rhs; }
	@Override
	protected String handle_boolean_String_String(boolean lhs, String rhs) { return lhs + rhs; }
//	@Override
//	protected boolean handle_boolean_boolean_boolean(boolean lhs, boolean rhs) { return lhs + rhs; }
}
