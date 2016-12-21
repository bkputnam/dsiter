/* GENERATED CODE */package dsiter.operator;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */
                    /**
                     * Unary operator that computes the square root of {@code src}
                     *
                     * <p>
                     *     You probably won't ever want to use this class directly;
                     *     it's much simpler to use {@link dsiter.operator.parser.OperatorParser}
                     *     directly. However, I certainly won't tell you you can't!
                     * </p>
                     */
/* GENERATED CODE */public class SqrtOperator extends TypedUnaryOperator {
/* GENERATED CODE */
/* GENERATED CODE */	public SqrtOperator(IRowAccessor src) {
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