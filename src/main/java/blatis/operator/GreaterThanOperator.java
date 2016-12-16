package blatis.operator;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.TypedRowAccessor;

public class GreaterThanOperator extends TypedBinaryOperator {

	public GreaterThanOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
		super(lhs, rhs);
	}

	@Override
	public ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType) {
		return ColumnType.BOOLEAN;
	}

	@Override
	protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
		return (lhsType.isNumeric() && rhsType.isNumeric());
	}

	
	@Override
	protected boolean handle_int_int_boolean(int lhs, int rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_int_long_boolean(int lhs, long rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_int_float_boolean(int lhs, float rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_int_double_boolean(int lhs, double rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_long_int_boolean(long lhs, int rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_long_long_boolean(long lhs, long rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_long_float_boolean(long lhs, float rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_long_double_boolean(long lhs, double rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_float_int_boolean(float lhs, int rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_float_long_boolean(float lhs, long rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_float_float_boolean(float lhs, float rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_float_double_boolean(float lhs, double rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_double_int_boolean(double lhs, int rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_double_long_boolean(double lhs, long rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_double_float_boolean(double lhs, float rhs) { return lhs > rhs; }
	
	@Override
	protected boolean handle_double_double_boolean(double lhs, double rhs) { return lhs > rhs; }
	
}
