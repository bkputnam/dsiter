/* GENERATED CODE */package blatis.operator;
/* GENERATED CODE */
/* GENERATED CODE */import blatis.row.ColumnType;
/* GENERATED CODE */import blatis.row.IRowAccessor;
/* GENERATED CODE */import blatis.row.TypedRowAccessor;
/* GENERATED CODE */
/* GENERATED CODE */public class CaretOperator extends TypedBinaryOperator {
/* GENERATED CODE */
/* GENERATED CODE */	public CaretOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
/* GENERATED CODE */		super(lhs, rhs);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public ColumnType getReturnType(ColumnType lhs, ColumnType rhs) {
/* GENERATED CODE */		return
/* GENERATED CODE */			super.eitherTypeIs(ColumnType.DOUBLE) ? ColumnType.DOUBLE :
/* GENERATED CODE */			eitherTypeIs(ColumnType.FLOAT) ? ColumnType.FLOAT :
/* GENERATED CODE */			eitherTypeIs(ColumnType.LONG) ? ColumnType.LONG :
/* GENERATED CODE */			ColumnType.INT;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
/* GENERATED CODE */		return lhsType.isNumeric() && rhsType.isNumeric();
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected int handle_int_int_int(int lhs, int rhs) { return (int)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected long handle_int_long_long(int lhs, long rhs) { return (long)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected float handle_int_float_float(int lhs, float rhs) { return (float)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_int_double_double(int lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected long handle_long_int_long(long lhs, int rhs) { return (long)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected long handle_long_long_long(long lhs, long rhs) { return (long)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected float handle_long_float_float(long lhs, float rhs) { return (float)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_long_double_double(long lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected float handle_float_int_float(float lhs, int rhs) { return (float)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected float handle_float_long_float(float lhs, long rhs) { return (float)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected float handle_float_float_float(float lhs, float rhs) { return (float)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_float_double_double(float lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_double_int_double(double lhs, int rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_double_long_double(double lhs, long rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_double_float_double(double lhs, float rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected double handle_double_double_double(double lhs, double rhs) { return (double)Math.pow(lhs, rhs); }
/* GENERATED CODE */	
/* GENERATED CODE */
/* GENERATED CODE */}