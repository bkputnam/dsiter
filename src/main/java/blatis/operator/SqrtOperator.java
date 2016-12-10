package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.TypedRowAccessor;

public class SqrtOperator extends TypedUnaryOperator {

	public SqrtOperator(TypedRowAccessor src) {
		super(src);
	}

	@Override
	protected ColumnType getReturnType(ColumnType srcType) {
		return ColumnType.DOUBLE;
	}

	@Override
	protected boolean testTypeCompatibility(ColumnType srcType) {
		return srcType.isNumeric();
	}

	
	
	protected double handle_int_double(int src) { return Math.sqrt(src); }
	
	protected double handle_long_double(long src) { return Math.sqrt(src); }
	
	protected double handle_float_double(float src) { return Math.sqrt(src); }
	
	protected double handle_double_double(double src) { return Math.sqrt(src); }
	
}