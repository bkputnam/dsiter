/* GENERATED CODE */package dsiter.operator;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */
                    /**
                     * Binary operator that tests whether {@code lhs} is greater than {@code rhs}
                     *
                     * <p>
                     *     You probably won't ever want to use this class directly;
                     *     it's much simpler to use {@link dsiter.operator.parser.OperatorParser}
                     *     directly. However, I certainly won't tell you you can't!
                     * </p>
                     */
/* GENERATED CODE */public class GreaterThanOperator extends TypedBinaryOperator {
/* GENERATED CODE */
/* GENERATED CODE */	public GreaterThanOperator(IRowAccessor lhs, IRowAccessor rhs) {
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
/* GENERATED CODE */		return (lhsType.isNumeric() && rhsType.isNumeric());
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_int_boolean(int lhs, int rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_long_boolean(int lhs, long rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_float_boolean(int lhs, float rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_int_double_boolean(int lhs, double rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_int_boolean(long lhs, int rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_long_boolean(long lhs, long rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_float_boolean(long lhs, float rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_long_double_boolean(long lhs, double rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_int_boolean(float lhs, int rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_long_boolean(float lhs, long rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_float_boolean(float lhs, float rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_float_double_boolean(float lhs, double rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_int_boolean(double lhs, int rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_long_boolean(double lhs, long rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_float_boolean(double lhs, float rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */	@Override
/* GENERATED CODE */	protected boolean handle_double_double_boolean(double lhs, double rhs) { return lhs > rhs; }
/* GENERATED CODE */	
/* GENERATED CODE */}
