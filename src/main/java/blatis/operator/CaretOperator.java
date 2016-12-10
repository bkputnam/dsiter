package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class CaretOperator extends TypedBinaryOperator {

	public CaretOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
		super(lhs, rhs);
	}

	@Override
	public ColumnType getReturnType(ColumnType lhs, ColumnType rhs) {
		return
			super.eitherTypeIs(ColumnType.DOUBLE) ? ColumnType.DOUBLE :
			eitherTypeIs(ColumnType.FLOAT) ? ColumnType.FLOAT :
			eitherTypeIs(ColumnType.LONG) ? ColumnType.LONG :
			ColumnType.INT;
	}

	@Override
	protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
		return lhsType.isNumeric() && rhsType.isNumeric();
	}

	
	
	@Override
	protected int handle_int_int_int(int lhs, int rhs) { return (int)Math.pow(lhs, rhs); }
	
	@Override
	protected long handle_int_long_long(int lhs, long rhs) { return (long)Math.pow(lhs, rhs); }
	
	@Override
	protected float handle_int_float_float(int lhs, float rhs) { return (float)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_int_double_double(int lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
	
	@Override
	protected long handle_long_int_long(long lhs, int rhs) { return (long)Math.pow(lhs, rhs); }
	
	@Override
	protected long handle_long_long_long(long lhs, long rhs) { return (long)Math.pow(lhs, rhs); }
	
	@Override
	protected float handle_long_float_float(long lhs, float rhs) { return (float)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_long_double_double(long lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
	
	@Override
	protected float handle_float_int_float(float lhs, int rhs) { return (float)Math.pow(lhs, rhs); }
	
	@Override
	protected float handle_float_long_float(float lhs, long rhs) { return (float)Math.pow(lhs, rhs); }
	
	@Override
	protected float handle_float_float_float(float lhs, float rhs) { return (float)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_float_double_double(float lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_double_int_double(double lhs, int rhs) { return (double)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_double_long_double(double lhs, long rhs) { return (double)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_double_float_double(double lhs, float rhs) { return (double)Math.pow(lhs, rhs); }
	
	@Override
	protected double handle_double_double_double(double lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
	

}