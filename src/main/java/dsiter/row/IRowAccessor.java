/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE */public interface IRowAccessor {
/* GENERATED CODE */	Object getValueFromRow(Row row);
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
                    	 * @return An {@code IRowAccessor.BOOLEAN} representation
                    	 * of this instance
                    	 */
/* GENERATED CODE */	default BOOLEAN asBoolAccessor() { return (BOOLEAN)this; }
/* GENERATED CODE */	
/* GENERATED CODE */	
/* GENERATED CODE */	
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
