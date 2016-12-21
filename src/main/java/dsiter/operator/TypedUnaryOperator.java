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
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */
                    /**
                     * Abstract class for use in creating unary operators. Not all unary operators
                     * need to use this class, but it's almost certainly easier to implement if you
                     * do.
                     * 
                     * <p>
                     * 		Subclasses must override the {@link #getReturnType} and {@link #testTypeCompatibility}
                     *		methods. This class can then use that information to determine how best to process
                     *		the source operator.
                     * </p>
                     *
                     * <p>
                     * 		This class provides overrideable methods for every possible type combination
                     *		of {@code source} and {@code returnValue} (which means there are
                     *		{@code (# of types)^2} overridable methods available). Subclasses only
                     *		need to override the methods which they will actually support. So, for example,
                     *		a logical boolean operator only needs to override {@link #handle_boolean_boolean}
                     *		and a numeric operator will only need to override the appropriate numeric
                     *		{@code handle_x_y} method(s). This superclass will use the information from
                     *		{@link #getReturnType} and {@link #testTypeCompatibility} to efficiently determine
                     *		which method to call.
                     * </p>
                     */
/* GENERATED CODE */public abstract class TypedUnaryOperator implements IRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	private IRowAccessor src;
/* GENERATED CODE */	private IRowAccessor innerAccessor;
/* GENERATED CODE */
/* GENERATED CODE */	public TypedUnaryOperator(IRowAccessor src) {
/* GENERATED CODE */		this.src = src;
/* GENERATED CODE */
/* GENERATED CODE */		if(src == null) { throw new IllegalArgumentException("src cannot be null"); }
/* GENERATED CODE */
/* GENERATED CODE */		ColumnType srcType = src.getType();
/* GENERATED CODE */
/* GENERATED CODE */		if(!testTypeCompatibility(srcType)) {
/* GENERATED CODE */			throw new IllegalArgumentException("Incompatible type: " + srcType);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		ColumnType returnType = this.getReturnType(srcType);
/* GENERATED CODE */		innerAccessor = getInnerAccessor(src, returnType);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	protected abstract ColumnType getReturnType(ColumnType srcType);
/* GENERATED CODE */	protected abstract boolean testTypeCompatibility(ColumnType srcType);
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
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */	private IRowAccessor getInnerAccessor(IRowAccessor src, ColumnType returnType) {
/* GENERATED CODE */		ColumnType srcType = src.getType();
/* GENERATED CODE */
/* GENERATED CODE */		if(srcType == ColumnType.INT) {
/* GENERATED CODE */			if(returnType == ColumnType.INT) {
/* GENERATED CODE */				return new INT_INT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */				return new INT_LONG(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */				return new INT_FLOAT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */				return new INT_DOUBLE(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */				return new INT_STRING(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				return new INT_BOOLEAN(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(srcType == ColumnType.LONG) {
/* GENERATED CODE */			if(returnType == ColumnType.INT) {
/* GENERATED CODE */				return new LONG_INT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */				return new LONG_LONG(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */				return new LONG_FLOAT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */				return new LONG_DOUBLE(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */				return new LONG_STRING(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				return new LONG_BOOLEAN(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(srcType == ColumnType.FLOAT) {
/* GENERATED CODE */			if(returnType == ColumnType.INT) {
/* GENERATED CODE */				return new FLOAT_INT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */				return new FLOAT_LONG(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */				return new FLOAT_FLOAT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */				return new FLOAT_DOUBLE(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */				return new FLOAT_STRING(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				return new FLOAT_BOOLEAN(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(srcType == ColumnType.DOUBLE) {
/* GENERATED CODE */			if(returnType == ColumnType.INT) {
/* GENERATED CODE */				return new DOUBLE_INT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */				return new DOUBLE_LONG(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */				return new DOUBLE_FLOAT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */				return new DOUBLE_DOUBLE(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */				return new DOUBLE_STRING(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				return new DOUBLE_BOOLEAN(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(srcType == ColumnType.STRING) {
/* GENERATED CODE */			if(returnType == ColumnType.INT) {
/* GENERATED CODE */				return new STRING_INT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */				return new STRING_LONG(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */				return new STRING_FLOAT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */				return new STRING_DOUBLE(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */				return new STRING_STRING(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				return new STRING_BOOLEAN(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else {
/* GENERATED CODE */				throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(srcType == ColumnType.BOOLEAN) {
/* GENERATED CODE */			if(returnType == ColumnType.INT) {
/* GENERATED CODE */				return new BOOLEAN_INT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.LONG) {
/* GENERATED CODE */				return new BOOLEAN_LONG(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.FLOAT) {
/* GENERATED CODE */				return new BOOLEAN_FLOAT(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.DOUBLE) {
/* GENERATED CODE */				return new BOOLEAN_DOUBLE(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.STRING) {
/* GENERATED CODE */				return new BOOLEAN_STRING(src);
/* GENERATED CODE */			}
/* GENERATED CODE */			else if(returnType == ColumnType.BOOLEAN) {
/* GENERATED CODE */				return new BOOLEAN_BOOLEAN(src);
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
/* GENERATED CODE */	protected int handle_int_int( int src )  { throw new Error("Programmer error: handle_int_int must be overridden by subclass"); }
/* GENERATED CODE */	protected long handle_int_long( int src )  { throw new Error("Programmer error: handle_int_long must be overridden by subclass"); }
/* GENERATED CODE */	protected float handle_int_float( int src )  { throw new Error("Programmer error: handle_int_float must be overridden by subclass"); }
/* GENERATED CODE */	protected double handle_int_double( int src )  { throw new Error("Programmer error: handle_int_double must be overridden by subclass"); }
/* GENERATED CODE */	protected String handle_int_String( int src )  { throw new Error("Programmer error: handle_int_String must be overridden by subclass"); }
/* GENERATED CODE */	protected boolean handle_int_boolean( int src )  { throw new Error("Programmer error: handle_int_boolean must be overridden by subclass"); }
/* GENERATED CODE */	protected int handle_long_int( long src )  { throw new Error("Programmer error: handle_long_int must be overridden by subclass"); }
/* GENERATED CODE */	protected long handle_long_long( long src )  { throw new Error("Programmer error: handle_long_long must be overridden by subclass"); }
/* GENERATED CODE */	protected float handle_long_float( long src )  { throw new Error("Programmer error: handle_long_float must be overridden by subclass"); }
/* GENERATED CODE */	protected double handle_long_double( long src )  { throw new Error("Programmer error: handle_long_double must be overridden by subclass"); }
/* GENERATED CODE */	protected String handle_long_String( long src )  { throw new Error("Programmer error: handle_long_String must be overridden by subclass"); }
/* GENERATED CODE */	protected boolean handle_long_boolean( long src )  { throw new Error("Programmer error: handle_long_boolean must be overridden by subclass"); }
/* GENERATED CODE */	protected int handle_float_int( float src )  { throw new Error("Programmer error: handle_float_int must be overridden by subclass"); }
/* GENERATED CODE */	protected long handle_float_long( float src )  { throw new Error("Programmer error: handle_float_long must be overridden by subclass"); }
/* GENERATED CODE */	protected float handle_float_float( float src )  { throw new Error("Programmer error: handle_float_float must be overridden by subclass"); }
/* GENERATED CODE */	protected double handle_float_double( float src )  { throw new Error("Programmer error: handle_float_double must be overridden by subclass"); }
/* GENERATED CODE */	protected String handle_float_String( float src )  { throw new Error("Programmer error: handle_float_String must be overridden by subclass"); }
/* GENERATED CODE */	protected boolean handle_float_boolean( float src )  { throw new Error("Programmer error: handle_float_boolean must be overridden by subclass"); }
/* GENERATED CODE */	protected int handle_double_int( double src )  { throw new Error("Programmer error: handle_double_int must be overridden by subclass"); }
/* GENERATED CODE */	protected long handle_double_long( double src )  { throw new Error("Programmer error: handle_double_long must be overridden by subclass"); }
/* GENERATED CODE */	protected float handle_double_float( double src )  { throw new Error("Programmer error: handle_double_float must be overridden by subclass"); }
/* GENERATED CODE */	protected double handle_double_double( double src )  { throw new Error("Programmer error: handle_double_double must be overridden by subclass"); }
/* GENERATED CODE */	protected String handle_double_String( double src )  { throw new Error("Programmer error: handle_double_String must be overridden by subclass"); }
/* GENERATED CODE */	protected boolean handle_double_boolean( double src )  { throw new Error("Programmer error: handle_double_boolean must be overridden by subclass"); }
/* GENERATED CODE */	protected int handle_String_int( String src )  { throw new Error("Programmer error: handle_String_int must be overridden by subclass"); }
/* GENERATED CODE */	protected long handle_String_long( String src )  { throw new Error("Programmer error: handle_String_long must be overridden by subclass"); }
/* GENERATED CODE */	protected float handle_String_float( String src )  { throw new Error("Programmer error: handle_String_float must be overridden by subclass"); }
/* GENERATED CODE */	protected double handle_String_double( String src )  { throw new Error("Programmer error: handle_String_double must be overridden by subclass"); }
/* GENERATED CODE */	protected String handle_String_String( String src )  { throw new Error("Programmer error: handle_String_String must be overridden by subclass"); }
/* GENERATED CODE */	protected boolean handle_String_boolean( String src )  { throw new Error("Programmer error: handle_String_boolean must be overridden by subclass"); }
/* GENERATED CODE */	protected int handle_boolean_int( boolean src )  { throw new Error("Programmer error: handle_boolean_int must be overridden by subclass"); }
/* GENERATED CODE */	protected long handle_boolean_long( boolean src )  { throw new Error("Programmer error: handle_boolean_long must be overridden by subclass"); }
/* GENERATED CODE */	protected float handle_boolean_float( boolean src )  { throw new Error("Programmer error: handle_boolean_float must be overridden by subclass"); }
/* GENERATED CODE */	protected double handle_boolean_double( boolean src )  { throw new Error("Programmer error: handle_boolean_double must be overridden by subclass"); }
/* GENERATED CODE */	protected String handle_boolean_String( boolean src )  { throw new Error("Programmer error: handle_boolean_String must be overridden by subclass"); }
/* GENERATED CODE */	protected boolean handle_boolean_boolean( boolean src )  { throw new Error("Programmer error: handle_boolean_boolean must be overridden by subclass"); }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_INT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_int_int(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_LONG(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_int_long(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_FLOAT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_int_float(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_DOUBLE(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_int_double(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_STRING(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_int_String(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class INT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		private INT_BOOLEAN(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asIntAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_int_boolean(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_INT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_long_int(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_LONG(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_long_long(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_FLOAT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_long_float(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_DOUBLE(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_long_double(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_STRING(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_long_String(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		private LONG_BOOLEAN(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asLongAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_long_boolean(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_INT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_float_int(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_LONG(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_float_long(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_FLOAT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_float_float(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_DOUBLE(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_float_double(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_STRING(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_float_String(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		private FLOAT_BOOLEAN(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asFloatAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_float_boolean(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_INT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_double_int(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_LONG(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_double_long(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_FLOAT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_double_float(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_DOUBLE(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_double_double(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_STRING(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_double_String(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		private DOUBLE_BOOLEAN(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asDoubleAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_double_boolean(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING src;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_INT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_String_int(src.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING src;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_LONG(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_String_long(src.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING src;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_FLOAT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_String_float(src.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING src;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_DOUBLE(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_String_double(src.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING src;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_STRING(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_String_String(src.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING src;
/* GENERATED CODE */
/* GENERATED CODE */		private STRING_BOOLEAN(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asStringAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_String_boolean(src.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_INT implements IRowAccessor.INT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN src;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_INT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return handle_boolean_int(src.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_LONG implements IRowAccessor.LONG {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN src;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_LONG(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return handle_boolean_long(src.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_FLOAT implements IRowAccessor.FLOAT {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN src;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_FLOAT(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return handle_boolean_float(src.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_DOUBLE implements IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN src;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_DOUBLE(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return handle_boolean_double(src.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_STRING implements IRowAccessor.STRING {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN src;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_STRING(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return handle_boolean_String(src.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN_BOOLEAN implements IRowAccessor.BOOLEAN {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN src;
/* GENERATED CODE */
/* GENERATED CODE */		private BOOLEAN_BOOLEAN(IRowAccessor src) {
/* GENERATED CODE */			this.src = src.asBoolAccessor();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return handle_boolean_boolean(src.getBoolFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */}