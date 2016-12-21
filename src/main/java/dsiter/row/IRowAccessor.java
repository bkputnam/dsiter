/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * An interface representing objects that return values from {@link Row}s. The returned
                     * values may be simple column reads (see: {@link IColumnAccessor}), computed
                     * values (see: everything in <a href="../operator/package-summary.html">dsiter.operator</a>),
                     * or static values that
                     * have nothing at all to do with the passed {@code Row} (see: {@link ConstantAccessor}).
                     *
                     * <p>
                     *     A plain {@code IRowAccessor} will return its value as an {@link Object}, but there
                     *     are also type-specific inner interfaces, like {@link IRowAccessor.INT}, that can
                     *     return the same value as a strongly-typed {@code int}. Plain {@code IRowAccessors}
                     *     can be converted to their typed counterparts via methods like {@link #asIntAccessor()}.
                     *     The default implementations of these methods perform a simple cast operation on
                     *     {@code this}, but some implementations override this with more sophisticated
                     *     behavior. For example some implementations override these
                     *     methods to return an inner accessor of the correct type (see:
                     *     {@link dsiter.operator.TypedBinaryOperator}, {@link dsiter.operator.TypedUnaryOperator}).
                     * </p>
                     *
                     * <p>
                     *     All {@code as[Type]Accessor()} methods will throw an Exception (usually a
                     *     {@link ClassCastException}) if the accessor is not actually of that type.
                     *     In general though, if {@link #getType()} returns {@link ColumnType#INT}, then
                     *     {@link #asIntAccessor()} should not throw.
                     * </p>
                     */
/* GENERATED CODE */public interface IRowAccessor {
                    	/**
                    	 * Compute and return this Accessor's value, using the
                    	 * passed {@link Row} if/as appropriate.
                    	 *
                    	 * @param row The Row from which to compute the value (if needed)
                    	 * @return		This Accessor's value with respect to the passed row
                    	 */
/* GENERATED CODE */	Object getValueFromRow(Row row);
/* GENERATED CODE */
                    	/**
                    	 * Return this Accessor's type.
                    	 *
                    	 * <p>
                    	 * 	Note: If this method returns, e.g., {@link ColumnType#INT}, then
                    	 * 	{@link #asIntAccessor()} should return a valid
                    	 * {@link IRowAccessor.INT} and not throw.
                    	 * </p>
                    	 *
                    	 * @return		This Accessor's value with respect to the passed row
                    	 */
/* GENERATED CODE */	ColumnType getType();
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.INT}.
                    	 * The default implementation of this method simply casts
                    	 * {@code this} to {@code IRowAccessor.INT}, but some
                    	 * subclasses may wish to provide more sophisticated
                    	 * implementations, e.g. by casting and returning an inner
                    	 * accessor to the approriate type.
                    	 *
                    	 * <p>
                    	 * 	Note: this method will throw if {@link #getType} does not
                    	 * 	return {@link ColumnType#INT}.
                    	 * </p>
                    	 * @return An {@code IRowAccessor.INT} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default INT asIntAccessor() { return (INT)this; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.LONG}.
                    	 * The default implementation of this method simply casts
                    	 * {@code this} to {@code IRowAccessor.LONG}, but some
                    	 * subclasses may wish to provide more sophisticated
                    	 * implementations, e.g. by casting and returning an inner
                    	 * accessor to the approriate type.
                    	 *
                    	 * <p>
                    	 * 	Note: this method will throw if {@link #getType} does not
                    	 * 	return {@link ColumnType#LONG}.
                    	 * </p>
                    	 * @return An {@code IRowAccessor.LONG} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default LONG asLongAccessor() { return (LONG)this; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.FLOAT}.
                    	 * The default implementation of this method simply casts
                    	 * {@code this} to {@code IRowAccessor.FLOAT}, but some
                    	 * subclasses may wish to provide more sophisticated
                    	 * implementations, e.g. by casting and returning an inner
                    	 * accessor to the approriate type.
                    	 *
                    	 * <p>
                    	 * 	Note: this method will throw if {@link #getType} does not
                    	 * 	return {@link ColumnType#FLOAT}.
                    	 * </p>
                    	 * @return An {@code IRowAccessor.FLOAT} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default FLOAT asFloatAccessor() { return (FLOAT)this; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.DOUBLE}.
                    	 * The default implementation of this method simply casts
                    	 * {@code this} to {@code IRowAccessor.DOUBLE}, but some
                    	 * subclasses may wish to provide more sophisticated
                    	 * implementations, e.g. by casting and returning an inner
                    	 * accessor to the approriate type.
                    	 *
                    	 * <p>
                    	 * 	Note: this method will throw if {@link #getType} does not
                    	 * 	return {@link ColumnType#DOUBLE}.
                    	 * </p>
                    	 * @return An {@code IRowAccessor.DOUBLE} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default DOUBLE asDoubleAccessor() { return (DOUBLE)this; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.STRING}.
                    	 * The default implementation of this method simply casts
                    	 * {@code this} to {@code IRowAccessor.STRING}, but some
                    	 * subclasses may wish to provide more sophisticated
                    	 * implementations, e.g. by casting and returning an inner
                    	 * accessor to the approriate type.
                    	 *
                    	 * <p>
                    	 * 	Note: this method will throw if {@link #getType} does not
                    	 * 	return {@link ColumnType#STRING}.
                    	 * </p>
                    	 * @return An {@code IRowAccessor.STRING} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default STRING asStringAccessor() { return (STRING)this; }
/* GENERATED CODE */	
                    	/**
                    	 * Convert this IRowAccessor to an {@code IRowAccessor.BOOLEAN}.
                    	 * The default implementation of this method simply casts
                    	 * {@code this} to {@code IRowAccessor.BOOLEAN}, but some
                    	 * subclasses may wish to provide more sophisticated
                    	 * implementations, e.g. by casting and returning an inner
                    	 * accessor to the approriate type.
                    	 *
                    	 * <p>
                    	 * 	Note: this method will throw if {@link #getType} does not
                    	 * 	return {@link ColumnType#BOOLEAN}.
                    	 * </p>
                    	 * @return An {@code IRowAccessor.BOOLEAN} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default BOOLEAN asBoolAccessor() { return (BOOLEAN)this; }
/* GENERATED CODE */	
/* GENERATED CODE */	
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IRowAccessor} that returns a value of type int
                    	 * (i.e.&nbsp;{@code getType() == ColumnType.INT}).
                    	 */
/* GENERATED CODE */	public interface INT extends IRowAccessor {
/* GENERATED CODE */		public int getIntFromRow(Row row);
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default Object getValueFromRow(Row row) {
/* GENERATED CODE */			return getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default ColumnType getType() {
/* GENERATED CODE */			return ColumnType.INT;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IRowAccessor} that returns a value of type long
                    	 * (i.e.&nbsp;{@code getType() == ColumnType.LONG}).
                    	 */
/* GENERATED CODE */	public interface LONG extends IRowAccessor {
/* GENERATED CODE */		public long getLongFromRow(Row row);
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default Object getValueFromRow(Row row) {
/* GENERATED CODE */			return getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default ColumnType getType() {
/* GENERATED CODE */			return ColumnType.LONG;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IRowAccessor} that returns a value of type float
                    	 * (i.e.&nbsp;{@code getType() == ColumnType.FLOAT}).
                    	 */
/* GENERATED CODE */	public interface FLOAT extends IRowAccessor {
/* GENERATED CODE */		public float getFloatFromRow(Row row);
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default Object getValueFromRow(Row row) {
/* GENERATED CODE */			return getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default ColumnType getType() {
/* GENERATED CODE */			return ColumnType.FLOAT;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IRowAccessor} that returns a value of type double
                    	 * (i.e.&nbsp;{@code getType() == ColumnType.DOUBLE}).
                    	 */
/* GENERATED CODE */	public interface DOUBLE extends IRowAccessor {
/* GENERATED CODE */		public double getDoubleFromRow(Row row);
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default Object getValueFromRow(Row row) {
/* GENERATED CODE */			return getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default ColumnType getType() {
/* GENERATED CODE */			return ColumnType.DOUBLE;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IRowAccessor} that returns a value of type String
                    	 * (i.e.&nbsp;{@code getType() == ColumnType.STRING}).
                    	 */
/* GENERATED CODE */	public interface STRING extends IRowAccessor {
/* GENERATED CODE */		public String getStringFromRow(Row row);
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default Object getValueFromRow(Row row) {
/* GENERATED CODE */			return getStringFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default ColumnType getType() {
/* GENERATED CODE */			return ColumnType.STRING;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IRowAccessor} that returns a value of type boolean
                    	 * (i.e.&nbsp;{@code getType() == ColumnType.BOOLEAN}).
                    	 */
/* GENERATED CODE */	public interface BOOLEAN extends IRowAccessor {
/* GENERATED CODE */		public boolean getBoolFromRow(Row row);
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default Object getValueFromRow(Row row) {
/* GENERATED CODE */			return getBoolFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default ColumnType getType() {
/* GENERATED CODE */			return ColumnType.BOOLEAN;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
