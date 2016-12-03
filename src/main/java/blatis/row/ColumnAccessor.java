package blatis.row;

public abstract class ColumnAccessor implements IRowAccessor {

	protected int index;

	protected ColumnAccessor(int index) {
		this.index = index;
	}

	public abstract Object getValueFromRow(Row row);
	public abstract ColumnType getType();

	public static ColumnAccessor create(ColumnType type, int rowArrayIndex) {
		if( type == ColumnType.INT ) {
			return new ColumnAccessor.IntAccessor( rowArrayIndex );
		}
		else if( type == ColumnType.LONG ) {
			return new ColumnAccessor.LongAccessor( rowArrayIndex );
		}
		else if( type == ColumnType.FLOAT ) {
			return new ColumnAccessor.FloatAccessor( rowArrayIndex );
		}
		else if( type == ColumnType.DOUBLE ) {
			return new ColumnAccessor.DoubleAccessor( rowArrayIndex );
		}
		else if( type == ColumnType.STRING ) {
			return new ColumnAccessor.StringAccessor( rowArrayIndex );
		}
		else if( type == ColumnType.BOOLEAN ) {
			return new ColumnAccessor.BoolAccessor( rowArrayIndex );
		}
		else {
			throw new Error("Programmer Error: unrecognized Type: " + type);
		}
	}

	public static class IntAccessor extends ColumnAccessor {
		public IntAccessor(int index) {
			super(index);
		}

		public ColumnType getType() { return ColumnType.INT; }

		public Object getValueFromRow(Row row) {
			return row.ints[this.index];
		}
	}

	public static class LongAccessor extends ColumnAccessor {
		public LongAccessor(int index) {
			super(index);
		}

		public ColumnType getType() { return ColumnType.LONG; }

		public Object getValueFromRow(Row row) {
			return row.longs[this.index];
		}
	}

	public static class FloatAccessor extends ColumnAccessor {
		public FloatAccessor(int index) {
			super(index);
		}

		public ColumnType getType() { return ColumnType.FLOAT; }

		public Object getValueFromRow(Row row) {
			return row.floats[this.index];
		}
	}

	public static class DoubleAccessor extends ColumnAccessor {
		public DoubleAccessor(int index) {
			super(index);
		}

		public ColumnType getType() { return ColumnType.DOUBLE; }

		public Object getValueFromRow(Row row) {
			return row.doubles[this.index];
		}
	}

	public static class StringAccessor extends ColumnAccessor {
		public StringAccessor(int index) {
			super(index);
		}

		public ColumnType getType() { return ColumnType.STRING; }

		public Object getValueFromRow(Row row) {
			return row.strings[this.index];
		}
	}

	public static class BoolAccessor extends ColumnAccessor {
		public BoolAccessor(int index) {
			super(index);
		}

		public ColumnType getType() { return ColumnType.BOOLEAN; }

		public Object getValueFromRow(Row row) {
			return row.bools[this.index];
		}
	}

}

