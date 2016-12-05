package blatis.row;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

public class ColumnAccessor extends TypedRowAccessor {

    private int index;

	public ColumnAccessor(ColumnType type, int index) {
	    this.index = index;
	    super.type = type;
		super.innerAccessor = getInnerAccessor();
	}

	private IRowAccessor getInnerAccessor() {
		IRowAccessor result =
			type == ColumnType.INT ? new INT() :
			type == ColumnType.LONG ? new LONG() :
			type == ColumnType.FLOAT ? new FLOAT() :
			type == ColumnType.DOUBLE ? new DOUBLE() :
			type == ColumnType.STRING ? new STRING() :
			type == ColumnType.BOOLEAN ? new BOOLEAN() :
			null;

		if(result == null) {
			throw new IllegalArgumentException("Programmer error: unrecognized ColumnType: " + type);
		}
		return result;
	}


	private class INT extends TypedRowAccessor.INT {
		@Override
		public int getIntFromRow(Row row) {
			return row.ints[index];
		}
	}

	private class LONG extends TypedRowAccessor.LONG {
		@Override
		public long getLongFromRow(Row row) {
			return row.longs[index];
		}
	}

	private class FLOAT extends TypedRowAccessor.FLOAT {
		@Override
		public float getFloatFromRow(Row row) {
			return row.floats[index];
		}
	}

	private class DOUBLE extends TypedRowAccessor.DOUBLE {
		@Override
		public double getDoubleFromRow(Row row) {
			return row.doubles[index];
		}
	}

	private class STRING extends TypedRowAccessor.STRING {
		@Override
		public String getStringFromRow(Row row) {
			return row.strings[index];
		}
	}

	private class BOOLEAN extends TypedRowAccessor.BOOLEAN {
		@Override
		public boolean getBoolFromRow(Row row) {
			return row.bools[index];
		}
	}


}

