/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * An extension of {@link IRowAccessor} for implementations that simply
                     * access a Column within a {@link Row} and return that value. The only
                     * addition to the base interface is the {@link #getIndex()} method which
                     * returns the type-specific index at which the column's value can be
                     * found (similar to {@link ColumnDescriptor#getRowArrayIndex()}). When
                     * possible, it is usually cleaner to use the super-type {@code IRowAccessor}
                     * unless you really need to use the {@code getIndex()} method (occasionally
                     * useful for copying IColumnAccessor instances, etc).
                     *
                     * <p>
                     *     Like {@link IRowAccessor}, this interface defines inner interfaces
                     *     that are type-specific versions of itself, and extend the
                     *     type-specific version of {@code IRowAccessor}. For example,
                     *     {@link IColumnAccessor.INT} extends {@link IRowAccessor.INT} and
                     *     therefore requires both {@link #getIndex()} and
                     *     {@link dsiter.row.IRowAccessor.INT#getIntFromRow(Row)} to be
                     *     defined.
                     * </p>
                     *
                     * <p>
                     *     Although this is an interface, concrete type-specific instances can
                     *     be obtained via {@link #getInstance(ColumnType, int)}. It is unlikely
                     *     that implementors will want to extend this interface themselves,
                     *     instead simply using the types returned by {@code getInstance(...)}
                     * </p>
                     */
/* GENERATED CODE */public interface IColumnAccessor extends IRowAccessor {
/* GENERATED CODE */
                    	/**
                    	 * Get the type-specific index at which this column's
                    	 * value can be accessed.
                    	 *
                    	 * @see ColumnDescriptor#getRowArrayIndex()
                    	 * @return	The index at which this column can be accessed,
                    	 * 		within the {@link Row}'s type-appropriate array.
                    	 */
/* GENERATED CODE */	int getIndex();
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.INT}
                    	 */
/* GENERATED CODE */	interface INT extends IColumnAccessor, IRowAccessor.INT {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default int getIntFromRow(Row row) {
/* GENERATED CODE */			return row.ints[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.LONG}
                    	 */
/* GENERATED CODE */	interface LONG extends IColumnAccessor, IRowAccessor.LONG {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default long getLongFromRow(Row row) {
/* GENERATED CODE */			return row.longs[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.FLOAT}
                    	 */
/* GENERATED CODE */	interface FLOAT extends IColumnAccessor, IRowAccessor.FLOAT {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default float getFloatFromRow(Row row) {
/* GENERATED CODE */			return row.floats[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.DOUBLE}
                    	 */
/* GENERATED CODE */	interface DOUBLE extends IColumnAccessor, IRowAccessor.DOUBLE {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return row.doubles[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.STRING}
                    	 */
/* GENERATED CODE */	interface STRING extends IColumnAccessor, IRowAccessor.STRING {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default String getStringFromRow(Row row) {
/* GENERATED CODE */			return row.strings[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.BOOLEAN}
                    	 */
/* GENERATED CODE */	interface BOOLEAN extends IColumnAccessor, IRowAccessor.BOOLEAN {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return row.bools[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * An {@link IColumnAccessor} that is also an {@link IRowAccessor.JSDATE}
                    	 */
/* GENERATED CODE */	interface JSDATE extends IColumnAccessor, IRowAccessor.JSDATE {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return row.jsdates[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */
                    	/**
                    	 * Get a type-specific instance of {@link IColumnAccessor}. The column's
                    	 * value will be read from the {@code index}-th position of the
                    	 * type-appropriate array in the {@link Row}
                    	 *
                    	 * @param type  The type of the column
                    	 * @param index The index at which to read the column's value
                    	 * @return		An appropriately-typed instance of {@link IColumnAccessor}
                    	 */
/* GENERATED CODE */	static IColumnAccessor getInstance(ColumnType type, int index) {
/* GENERATED CODE */		switch (type) {
/* GENERATED CODE */			
/* GENERATED CODE */			case INT: return new INT() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			case LONG: return new LONG() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			case FLOAT: return new FLOAT() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			case DOUBLE: return new DOUBLE() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			case STRING: return new STRING() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			case BOOLEAN: return new BOOLEAN() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			case JSDATE: return new JSDATE() {
/* GENERATED CODE */				@Override
/* GENERATED CODE */				public int getIndex() { return index; }
/* GENERATED CODE */			};
/* GENERATED CODE */			
/* GENERATED CODE */			default:
/* GENERATED CODE */				throw new Error("Programmer Error: this should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */}
/* GENERATED CODE */
