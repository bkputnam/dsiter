/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE */public interface IColumnAccessor extends IRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	int getIndex();
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	interface INT extends IColumnAccessor, IRowAccessor.INT {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default int getIntFromRow(Row row) {
/* GENERATED CODE */			return row.ints[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	interface LONG extends IColumnAccessor, IRowAccessor.LONG {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default long getLongFromRow(Row row) {
/* GENERATED CODE */			return row.longs[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	interface FLOAT extends IColumnAccessor, IRowAccessor.FLOAT {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default float getFloatFromRow(Row row) {
/* GENERATED CODE */			return row.floats[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	interface DOUBLE extends IColumnAccessor, IRowAccessor.DOUBLE {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return row.doubles[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	interface STRING extends IColumnAccessor, IRowAccessor.STRING {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default String getStringFromRow(Row row) {
/* GENERATED CODE */			return row.strings[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	interface BOOLEAN extends IColumnAccessor, IRowAccessor.BOOLEAN {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		default boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return row.bools[getIndex()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */
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
/* GENERATED CODE */			default:
/* GENERATED CODE */				throw new Error("Programmer Error: this should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */}
/* GENERATED CODE */
