/* GENERATED CODE */package blatis.operator;
/* GENERATED CODE */
/* GENERATED CODE */import blatis.row.ColumnType;
/* GENERATED CODE */import blatis.row.IRowAccessor;
/* GENERATED CODE */import blatis.row.TypedRowAccessor;
/* GENERATED CODE */
/* GENERATED CODE */public class SqrtOperator extends TypedUnaryOperator {
/* GENERATED CODE */
/* GENERATED CODE */	public SqrtOperator(TypedRowAccessor src) {
/* GENERATED CODE */		super(src);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected ColumnType getReturnType(ColumnType srcType) {
/* GENERATED CODE */		return ColumnType.DOUBLE;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean testTypeCompatibility(ColumnType srcType) {
/* GENERATED CODE */		return srcType.isNumeric();
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	
/* GENERATED CODE */	protected double handle_int_double(int src) { return Math.sqrt(src); }
/* GENERATED CODE */	
/* GENERATED CODE */	protected double handle_long_double(long src) { return Math.sqrt(src); }
/* GENERATED CODE */	
/* GENERATED CODE */	protected double handle_float_double(float src) { return Math.sqrt(src); }
/* GENERATED CODE */	
/* GENERATED CODE */	protected double handle_double_double(double src) { return Math.sqrt(src); }
/* GENERATED CODE */	
/* GENERATED CODE */}