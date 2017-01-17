/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
/* GENERATED CODE */
                    /**
                     * Abstract class for use in creating binary operators. Not all binary operators
                     * need to use this class, but it's almost certainly easier to implement if you
                     * do.
                     * 
                     * <p>
                     * 		Subclasses must override the {@link #getReturnType} and {@link #testTypeCompatibility}
                     *		methods. This class can then use that information to determine how best to process
                     *		the child operators.
                     * </p>
                     *
                     * <p>
                     * 		This class provides overrideable methods for every possible type combination
                     *		of {@code lhs}, {@code rhs}, and {@code returnValue} (which means there are
                     *		{@code (# of types)^3} overridable methods available). Subclasses only
                     *		need to override the methods which they will actually support. So, for example,
                     *		a logical boolean operator only needs to override {@link #handle_bool_bool_bool}
                     *		and a numeric operator will only need to override the appropriate numeric
                     *		{@code handle_x_y_z} methods. This superclass will use the information from
                     *		{@link #getReturnType} and {@link #testTypeCompatibility} to efficiently determine
                     *		which method to call.
                     * </p>
                     * 
                     * @see TypedUnaryAccessor
                     */
/* GENERATED CODE */public abstract class TypedBinaryAccessor implements IRowAccessor {
/* GENERATED CODE */
                    	/**
                    	 * Left Hand Side
                    	 */
/* GENERATED CODE */	private IRowAccessor lhs;
/* GENERATED CODE */
                    	/**
                    	 * Right Hand Side
                    	 */
/* GENERATED CODE */	private IRowAccessor rhs;
/* GENERATED CODE */
/* GENERATED CODE */	private IRowAccessor innerAccessor;
/* GENERATED CODE */
                    	/**
                    	 * Construct a TypedBinaryOperator with {@code lhs} and {@code rhs} as
                    	 * its left- and right-hand sides, respectively.
                    	 * 
                    	 * @param lhs	The {@code IRowAccessor} that will provide the left
                    	 *				hand side of the operation
                    	 * @param rhs	The {@code IRowAccessor} that will provide the right
                    	 *				hand side of the operation
                    	 */
/* GENERATED CODE */	public TypedBinaryAccessor(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */		this.lhs = lhs;
/* GENERATED CODE */		this.rhs = rhs;
/* GENERATED CODE */
/* GENERATED CODE */		if(lhs == null) { throw new IllegalArgumentException("lhs cannot be null"); }
/* GENERATED CODE */		if(rhs == null) { throw new IllegalArgumentException("rhs cannot be null"); }
/* GENERATED CODE */
/* GENERATED CODE */		ColumnType lhsType = lhs.getType();
/* GENERATED CODE */		ColumnType rhsType = rhs.getType();
/* GENERATED CODE */
/* GENERATED CODE */        if(!testTypeCompatibility(lhsType, rhsType)) {
/* GENERATED CODE */            throw new IllegalArgumentException("Incompatible types: " + lhsType + ", " + rhsType);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */		ColumnType returnType = this.getReturnType(lhsType, rhsType);
/* GENERATED CODE */		innerAccessor = getInnerAccessor(lhs, rhs, returnType);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public ColumnType getType() {
/* GENERATED CODE */		return innerAccessor.getType();
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public Object getValueFromRow(Row row) {
/* GENERATED CODE */		return innerAccessor.getValueFromRow(row);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.INT}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.INT} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.INT asIntAccessor() { return (IRowAccessor.INT)innerAccessor; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.LONG}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.LONG} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.LONG asLongAccessor() { return (IRowAccessor.LONG)innerAccessor; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.FLOAT}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.FLOAT} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.FLOAT asFloatAccessor() { return (IRowAccessor.FLOAT)innerAccessor; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.DOUBLE}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.DOUBLE} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.DOUBLE asDoubleAccessor() { return (IRowAccessor.DOUBLE)innerAccessor; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.STRING}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.STRING} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.STRING asStringAccessor() { return (IRowAccessor.STRING)innerAccessor; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.BOOLEAN}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.BOOLEAN} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.BOOLEAN asBoolAccessor() { return (IRowAccessor.BOOLEAN)innerAccessor; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.JSDATE}
                    	 * by casting and returning the hidden {@code innerAccessor}
                    	 *
                    	 * @return An {@code IRowAccessor.JSDATE} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor.JSDATE asJsDateAccessor() { return (IRowAccessor.JSDATE)innerAccessor; }
/* GENERATED CODE */	
/* GENERATED CODE */
                    	/**
                    	 * Subclasses must implement this method to let the superclass know the return type
                    	 * of this operation. This method will only be called if {@link #testTypeCompatibility}
                    	 * returned {@code true}.
                    	 * 
                    	 * @param lhsType	The type of the left hand side of the operator
                    	 * @param rhsType	The type of the right hand side of the operator
                    	 * @return	The return type of the operation
                    	 */
/* GENERATED CODE */	protected abstract ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType);
/* GENERATED CODE */
                    	/**
                    	 * Subclasses must implement this method to let the superclass know whether or not they
                    	 * will accept {@code lhsType} and {@code rhsType} as valid argument types or not.
                    	 * 
                    	 * @param lhsType	The type of the left hand side of the operator
                    	 * @param rhsType	The type of the right hand side of the operator
                    	 * @return	{@code true} if the subclass will accept the passed types, else {@code false}
                    	 */
/* GENERATED CODE */	protected abstract boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType);
/* GENERATED CODE */
                    	/**
                    	 * Utility method for subclasses, shorthand for {@code lhs.getType() == type || rhs.getType() == type}
                    	 * 
                    	 * @param type The type to be tested
                    	 * @return {@code true} if either {@code lhs} or {@code rhs} has type {@code type}, else {@code false}
                    	 */
/* GENERATED CODE */    protected boolean eitherTypeIs(ColumnType type) { return lhs.getType() == type || rhs.getType() == type; }
/* GENERATED CODE */
                    	/**
                    	 * Utility method for subclasses, shorthand for {@code lhs.getType() == type && rhs.getType() == type}
                    	 * 
                    	 * @param type The type to be tested
                    	 * @return {@code true} if both {@code lhs} and {@code rhs} have type {@code type}, else {@code false}
                    	 */
/* GENERATED CODE */    protected boolean bothTypesAre(ColumnType type) { return lhs.getType() == type && rhs.getType() == type; }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */	private IRowAccessor getInnerAccessor(IRowAccessor lhs, IRowAccessor rhs, ColumnType returnType) {
/* GENERATED CODE */		ColumnType lhsType = lhs.getType();
/* GENERATED CODE */		ColumnType rhsType = rhs.getType();
/* GENERATED CODE */
/* GENERATED CODE */		if(lhsType == ColumnType.INT) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new INT_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new INT_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new INT_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new INT_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new INT_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new INT_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new INT_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(lhsType == ColumnType.LONG) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new LONG_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new LONG_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new LONG_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new LONG_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new LONG_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new LONG_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new LONG_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(lhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new FLOAT_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new FLOAT_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new FLOAT_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new FLOAT_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new FLOAT_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new FLOAT_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new FLOAT_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(lhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new DOUBLE_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(lhsType == ColumnType.STRING) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new STRING_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new STRING_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new STRING_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new STRING_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new STRING_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new STRING_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new STRING_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(lhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new BOOLEAN_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(lhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			if(rhsType == ColumnType.INT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_INT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_INT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_INT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_INT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_INT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_INT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_INT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.LONG) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_LONG_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_LONG_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_LONG_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_LONG_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_LONG_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_LONG_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_LONG_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_FLOAT_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_FLOAT_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_FLOAT_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_FLOAT_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_FLOAT_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_FLOAT_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_FLOAT_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_DOUBLE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.STRING) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_STRING_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_STRING_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_STRING_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_STRING_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_STRING_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_STRING_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_STRING_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_BOOLEAN_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */				if(returnType == ColumnType.INT) {
/* GENERATED CODE */					return new JSDATE_JSDATE_INT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */					return new JSDATE_JSDATE_LONG(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */					return new JSDATE_JSDATE_FLOAT(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */					return new JSDATE_JSDATE_DOUBLE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */					return new JSDATE_JSDATE_STRING(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */					return new JSDATE_JSDATE_BOOLEAN(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else if(returnType == ColumnType.JSDATE) {
/* GENERATED CODE */					return new JSDATE_JSDATE_JSDATE(lhs, rhs);
/* GENERATED CODE */				}
/* GENERATED CODE */				else {
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_int_int( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_int_long( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_int_float( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_int_double( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_int_string( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_int_bool( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_int_jsdate( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_long_int( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_long_long( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_long_float( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_long_double( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_long_string( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_long_bool( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_long_jsdate( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_float_int( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_float_long( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_float_float( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_float_double( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_float_string( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_float_bool( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_float_jsdate( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_double_int( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_double_long( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_double_float( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_double_double( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_double_string( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_double_bool( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_double_jsdate( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_string_int( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_string_long( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_string_float( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_string_double( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_string_string( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_string_bool( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_string_jsdate( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_bool_int( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_bool_long( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_bool_float( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_bool_double( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_bool_string( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_bool_bool( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_bool_jsdate( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_int_jsdate_int( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_jsdate_long( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_int_jsdate_float( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_int_jsdate_double( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_int_jsdate_string( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_int_jsdate_bool( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_int_jsdate_jsdate( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_jsdate_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_int_int( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_int_long( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_int_float( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_int_double( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_int_string( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_int_bool( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_int_jsdate( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_long_int( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_long_long( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_long_float( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_long_double( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_long_string( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_long_bool( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_long_jsdate( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_float_int( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_float_long( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_float_float( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_float_double( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_float_string( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_float_bool( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_float_jsdate( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_double_int( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_double_long( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_double_float( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_double_double( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_double_string( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_double_bool( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_double_jsdate( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_string_int( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_string_long( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_string_float( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_string_double( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_string_string( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_string_bool( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_string_jsdate( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_bool_int( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_bool_long( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_bool_float( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_bool_double( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_bool_string( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_bool_bool( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_bool_jsdate( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_long_jsdate_int( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_jsdate_long( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_long_jsdate_float( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_long_jsdate_double( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_long_jsdate_string( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_long_jsdate_bool( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_long_jsdate_jsdate( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_jsdate_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_int_int( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_int_long( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_int_float( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_int_double( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_int_string( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_int_bool( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_int_jsdate( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_long_int( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_long_long( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_long_float( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_long_double( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_long_string( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_long_bool( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_long_jsdate( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_float_int( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_float_long( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_float_float( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_float_double( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_float_string( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_float_bool( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_float_jsdate( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_double_int( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_double_long( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_double_float( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_double_double( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_double_string( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_double_bool( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_double_jsdate( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_string_int( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_string_long( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_string_float( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_string_double( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_string_string( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_string_bool( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_string_jsdate( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_bool_int( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_bool_long( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_bool_float( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_bool_double( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_bool_string( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_bool_bool( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_bool_jsdate( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_float_jsdate_int( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_jsdate_long( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_float_jsdate_float( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_float_jsdate_double( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_float_jsdate_string( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_float_jsdate_bool( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_float_jsdate_jsdate( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_jsdate_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_int_int( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_int_long( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_int_float( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_int_double( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_int_string( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_int_bool( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_int_jsdate( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_long_int( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_long_long( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_long_float( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_long_double( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_long_string( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_long_bool( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_long_jsdate( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_float_int( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_float_long( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_float_float( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_float_double( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_float_string( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_float_bool( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_float_jsdate( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_double_int( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_double_long( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_double_float( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_double_double( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_double_string( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_double_bool( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_double_jsdate( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_string_int( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_string_long( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_string_float( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_string_double( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_string_string( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_string_bool( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_string_jsdate( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_bool_int( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_bool_long( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_bool_float( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_bool_double( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_bool_string( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_bool_bool( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_bool_jsdate( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_double_jsdate_int( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_jsdate_long( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_double_jsdate_float( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_double_jsdate_double( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_double_jsdate_string( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_double_jsdate_bool( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_double_jsdate_jsdate( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_jsdate_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_int_int( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_int_long( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_int_float( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_int_double( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_int_string( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_int_bool( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_int_jsdate( String lhs, int rhs )  { throw new Error("Programmer error: handle_string_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_long_int( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_long_long( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_long_float( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_long_double( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_long_string( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_long_bool( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_long_jsdate( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_float_int( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_float_long( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_float_float( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_float_double( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_float_string( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_float_bool( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_float_jsdate( String lhs, float rhs )  { throw new Error("Programmer error: handle_string_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_double_int( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_double_long( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_double_float( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_double_double( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_double_string( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_double_bool( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_double_jsdate( String lhs, double rhs )  { throw new Error("Programmer error: handle_string_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_string_int( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_string_long( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_string_float( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_string_double( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_string_string( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_string_bool( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_string_jsdate( String lhs, String rhs )  { throw new Error("Programmer error: handle_string_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_bool_int( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_bool_long( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_bool_float( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_bool_double( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_bool_string( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_bool_bool( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_bool_jsdate( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_string_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_string_jsdate_int( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_jsdate_long( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_string_jsdate_float( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_string_jsdate_double( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_string_jsdate_string( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_string_jsdate_bool( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_string_jsdate_jsdate( String lhs, long rhs )  { throw new Error("Programmer error: handle_string_jsdate_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_int_int( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_int_long( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_int_float( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_int_double( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_int_string( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_int_bool( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_int_jsdate( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_bool_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_long_int( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_long_long( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_long_float( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_long_double( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_long_string( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_long_bool( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_long_jsdate( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_float_int( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_float_long( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_float_float( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_float_double( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_float_string( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_float_bool( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_float_jsdate( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_bool_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_double_int( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_double_long( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_double_float( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_double_double( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_double_string( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_double_bool( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_double_jsdate( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_bool_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_string_int( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_string_long( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_string_float( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_string_double( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_string_string( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_string_bool( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_string_jsdate( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_bool_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_bool_int( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_bool_long( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_bool_float( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_bool_double( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_bool_string( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_bool_bool( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_bool_jsdate( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_bool_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_bool_jsdate_int( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_jsdate_long( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_bool_jsdate_float( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_bool_jsdate_double( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_bool_jsdate_string( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_bool_jsdate_bool( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_bool_jsdate_jsdate( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_bool_jsdate_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_int_int( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_int_long( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_int_float( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_int_double( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_int_string( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_int_bool( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_int_jsdate( long lhs, int rhs )  { throw new Error("Programmer error: handle_jsdate_int_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_long_int( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_long_long( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_long_float( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_long_double( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_long_string( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_long_bool( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_long_jsdate( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_long_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_float_int( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_float_long( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_float_float( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_float_double( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_float_string( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_float_bool( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_float_jsdate( long lhs, float rhs )  { throw new Error("Programmer error: handle_jsdate_float_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_double_int( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_double_long( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_double_float( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_double_double( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_double_string( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_double_bool( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_double_jsdate( long lhs, double rhs )  { throw new Error("Programmer error: handle_jsdate_double_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_string_int( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_string_long( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_string_float( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_string_double( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_string_string( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_string_bool( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_string_jsdate( long lhs, String rhs )  { throw new Error("Programmer error: handle_jsdate_string_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_bool_int( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_bool_long( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_bool_float( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_bool_double( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_bool_string( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_bool_bool( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_bool_jsdate( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_jsdate_bool_jsdate must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected int handle_jsdate_jsdate_int( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_int must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_jsdate_long( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_long must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected float handle_jsdate_jsdate_float( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_float must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected double handle_jsdate_jsdate_double( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_double must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected String handle_jsdate_jsdate_string( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_string must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected boolean handle_jsdate_jsdate_bool( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_bool must be overridden by subclass"); }
                    	/**
                    	 * Overrideable method. Computes value of operation from typed left- and right-hand side variables.
                    	 * 
                    	 * @param lhs The value of the left-hand side
                    	 * @param rhs The value of the right-hand side
                    	 * @return The computed value of the binary operator
                    	 */
/* GENERATED CODE */	protected long handle_jsdate_jsdate_jsdate( long lhs, long rhs )  { throw new Error("Programmer error: handle_jsdate_jsdate_jsdate must be overridden by subclass"); }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_int(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_long(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_float(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_double(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_string(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_bool(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int_jsdate(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_int(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_long(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_float(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_double(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_string(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_bool(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long_jsdate(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_int(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_long(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_float(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_double(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_string(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_bool(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float_jsdate(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_int(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_long(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_float(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_double(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_string(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_bool(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double_jsdate(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_int(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_long(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_float(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_double(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_string(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_bool(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_string_jsdate(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_int(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_long(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_float(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_double(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_string(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_bool(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_bool_jsdate(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_int(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_long(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_float(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_double(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_string(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_bool(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asIntAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_int_jsdate_jsdate(lhs.getIntFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_int(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_long(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_float(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_double(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_string(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_bool(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int_jsdate(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_int(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_long(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_float(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_double(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_string(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_bool(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long_jsdate(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_int(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_long(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_float(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_double(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_string(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_bool(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float_jsdate(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_int(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_long(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_float(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_double(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_string(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_bool(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double_jsdate(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_int(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_long(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_float(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_double(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_string(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_bool(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_string_jsdate(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_int(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_long(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_float(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_double(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_string(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_bool(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_bool_jsdate(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_int(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_long(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_float(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_double(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_string(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_bool(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asLongAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_long_jsdate_jsdate(lhs.getLongFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_int(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_long(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_float(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_double(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_string(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_bool(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int_jsdate(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_int(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_long(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_float(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_double(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_string(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_bool(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long_jsdate(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_int(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_long(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_float(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_double(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_string(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_bool(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float_jsdate(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_int(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_long(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_float(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_double(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_string(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_bool(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double_jsdate(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_int(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_long(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_float(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_double(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_string(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_bool(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_string_jsdate(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_int(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_long(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_float(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_double(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_string(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_bool(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_bool_jsdate(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_int(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_long(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_float(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_double(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_string(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_bool(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asFloatAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_float_jsdate_jsdate(lhs.getFloatFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_int(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_long(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_float(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_double(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_string(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_bool(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int_jsdate(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_int(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_long(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_float(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_double(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_string(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_bool(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long_jsdate(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_int(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_long(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_float(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_double(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_string(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_bool(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float_jsdate(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_int(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_long(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_float(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_double(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_string(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_bool(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double_jsdate(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_int(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_long(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_float(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_double(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_string(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_bool(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_string_jsdate(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_int(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_long(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_float(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_double(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_string(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_bool(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_bool_jsdate(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_int(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_long(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_float(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_double(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_string(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_bool(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asDoubleAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_double_jsdate_jsdate(lhs.getDoubleFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_int(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_long(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_float(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_double(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_string(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_bool(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_int_jsdate(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_int(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_long(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_float(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_double(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_string(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_bool(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_long_jsdate(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_int(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_long(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_float(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_double(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_string(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_bool(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_float_jsdate(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_int(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_long(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_float(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_double(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_string(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_bool(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_double_jsdate(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_int(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_long(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_float(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_double(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_string(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_bool(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_string_jsdate(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_int(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_long(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_float(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_double(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_string(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_bool(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_bool_jsdate(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_int(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_long(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_float(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_double(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_string(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_bool(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asStringAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_string_jsdate_jsdate(lhs.getStringFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_int(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_long(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_float(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_double(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_string(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_bool(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_int_jsdate(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_int(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_long(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_float(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_double(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_string(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_bool(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_long_jsdate(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_int(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_long(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_float(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_double(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_string(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_bool(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_float_jsdate(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_int(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_long(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_float(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_double(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_string(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_bool(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_double_jsdate(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_int(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_long(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_float(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_double(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_string(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_bool(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_string_jsdate(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_int(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_long(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_float(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_double(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_string(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_bool(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_bool_jsdate(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_int(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_long(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_float(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_double(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_string(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_bool(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asBoolAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_bool_jsdate_jsdate(lhs.getBoolFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_int(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_long(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_float(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_double(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_string(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_bool(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_INT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_INT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_int_jsdate(lhs.getJsDateFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_int(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_long(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_float(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_double(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_string(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_bool(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_LONG_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_LONG_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_long_jsdate(lhs.getJsDateFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_int(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_long(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_float(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_double(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_string(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_bool(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_FLOAT_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_FLOAT_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_float_jsdate(lhs.getJsDateFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_int(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_long(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_float(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_double(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_string(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_bool(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_DOUBLE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_DOUBLE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_double_jsdate(lhs.getJsDateFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_int(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_long(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_float(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_double(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_string(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_bool(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_STRING_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_STRING_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_string_jsdate(lhs.getJsDateFromRow(row), rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_int(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_long(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_float(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_double(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_string(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_bool(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_BOOLEAN_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_BOOLEAN_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_bool_jsdate(lhs.getJsDateFromRow(row), rhs.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_INT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_int(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_LONG(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_long(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_FLOAT(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_float(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_DOUBLE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_double(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_STRING(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_string(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_BOOLEAN(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_bool(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class JSDATE_JSDATE_JSDATE implements IRowAccessor.JSDATE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		private JSDATE_JSDATE_JSDATE(IRowAccessor lhs, IRowAccessor rhs) {
/* GENERATED CODE */			this.lhs = lhs.asJsDateAccessor();
/* GENERATED CODE */			this.rhs = rhs.asJsDateAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return handle_jsdate_jsdate_jsdate(lhs.getJsDateFromRow(row), rhs.getJsDateFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */}