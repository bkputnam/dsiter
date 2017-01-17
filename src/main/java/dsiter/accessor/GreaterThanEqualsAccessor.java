/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */
                    /**
                     * Binary operator that tests whether {@code lhs} is greater than or equal
                     * to {@code rhs}
                     *
                     * <p>
                     *     You probably won't ever want to use this class directly;
                     *     it's much simpler to use {@link dsiter.parser.OperatorParser}
                     *     directly. However, I certainly won't tell you you can't!
                     * </p>
                     */
/* GENERATED CODE */public class GreaterThanEqualsAccessor extends TypedBinaryAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	public GreaterThanEqualsAccessor(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */		super(lhs, rhs);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType) {
/* GENERATED CODE */		return ColumnType.BOOLEAN;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
/* GENERATED CODE */		return (lhsType.isNumeric() && rhsType.isNumeric()) ||
/* GENERATED CODE */		    (lhsType == ColumnType.JSDATE && rhsType == ColumnType.JSDATE) ||
/* GENERATED CODE */		    (eitherTypeIs(ColumnType.JSDATE) && (eitherTypeIs(ColumnType.INT) || eitherTypeIs(ColumnType.LONG)));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_jsdate_bool(int lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_jsdate_bool(long lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_jsdate_int_bool(long lhs, int rhs) { return lhs >= rhs; }
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_jsdate_long_bool(long lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_jsdate_jsdate_bool(long lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_int_bool(int lhs, int rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_long_bool(int lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_float_bool(int lhs, float rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_double_bool(int lhs, double rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_int_bool(long lhs, int rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_long_bool(long lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_float_bool(long lhs, float rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_double_bool(long lhs, double rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_int_bool(float lhs, int rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_long_bool(float lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_float_bool(float lhs, float rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_double_bool(float lhs, double rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_int_bool(double lhs, int rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_long_bool(double lhs, long rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_float_bool(double lhs, float rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_double_bool(double lhs, double rhs) { return lhs >= rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */}
