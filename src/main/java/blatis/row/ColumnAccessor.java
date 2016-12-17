/* GENERATED CODE */package blatis.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public class ColumnAccessor extends TypedRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */    private int index;
/* GENERATED CODE */
/* GENERATED CODE */	public ColumnAccessor(ColumnType type, int index) {
/* GENERATED CODE */	    this.index = index;
/* GENERATED CODE */	    super.type = type;
/* GENERATED CODE */		super.innerAccessor = getInnerAccessor();
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public int getIndex() { return index; }
/* GENERATED CODE */
/* GENERATED CODE */	private IRowAccessor getInnerAccessor() {
/* GENERATED CODE */		IRowAccessor result =
/* GENERATED CODE */			type == ColumnType.INT ? new INT() :
/* GENERATED CODE */			type == ColumnType.LONG ? new LONG() :
/* GENERATED CODE */			type == ColumnType.FLOAT ? new FLOAT() :
/* GENERATED CODE */			type == ColumnType.DOUBLE ? new DOUBLE() :
/* GENERATED CODE */			type == ColumnType.STRING ? new STRING() :
/* GENERATED CODE */			type == ColumnType.BOOLEAN ? new BOOLEAN() :
/* GENERATED CODE */			null;
/* GENERATED CODE */
/* GENERATED CODE */		if(result == null) {
/* GENERATED CODE */			throw new IllegalArgumentException("Programmer error: unrecognized ColumnType: " + type);
/* GENERATED CODE */		}
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */	private class INT extends TypedRowAccessor.INT {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return row.ints[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class LONG extends TypedRowAccessor.LONG {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return row.longs[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class FLOAT extends TypedRowAccessor.FLOAT {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return row.floats[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class DOUBLE extends TypedRowAccessor.DOUBLE {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return row.doubles[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class STRING extends TypedRowAccessor.STRING {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return row.strings[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private class BOOLEAN extends TypedRowAccessor.BOOLEAN {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return row.bools[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */}
/* GENERATED CODE */
