package blatis.row;

public abstract class ColumnAccessor implements IRowAccessor {

	protected int index;

	protected ColumnAccessor(int index) {
		this.index = index;
	}

	public abstract Object getValueFromRow(Row row);
	public abstract ColumnDescriptor.Type getType();

	public static class IntAccessor extends ColumnAccessor {
		public IntAccessor(int index) {
			super(index);
		}

		public ColumnDescriptor.Type getType() { return ColumnDescriptor.Type.INT; }

		public Object getValueFromRow(Row row) {
			return row.ints[this.index];
		}
	}

	public static class LongAccessor extends ColumnAccessor {
		public LongAccessor(int index) {
			super(index);
		}

		public ColumnDescriptor.Type getType() { return ColumnDescriptor.Type.LONG; }

		public Object getValueFromRow(Row row) {
			return row.longs[this.index];
		}
	}

	public static class FloatAccessor extends ColumnAccessor {
		public FloatAccessor(int index) {
			super(index);
		}

		public ColumnDescriptor.Type getType() { return ColumnDescriptor.Type.FLOAT; }

		public Object getValueFromRow(Row row) {
			return row.floats[this.index];
		}
	}

	public static class DoubleAccessor extends ColumnAccessor {
		public DoubleAccessor(int index) {
			super(index);
		}

		public ColumnDescriptor.Type getType() { return ColumnDescriptor.Type.DOUBLE; }

		public Object getValueFromRow(Row row) {
			return row.doubles[this.index];
		}
	}

	public static class StringAccessor extends ColumnAccessor {
		public StringAccessor(int index) {
			super(index);
		}

		public ColumnDescriptor.Type getType() { return ColumnDescriptor.Type.STRING; }

		public Object getValueFromRow(Row row) {
			return row.strings[this.index];
		}
	}

	public static class BoolAccessor extends ColumnAccessor {
		public BoolAccessor(int index) {
			super(index);
		}

		public ColumnDescriptor.Type getType() { return ColumnDescriptor.Type.BOOLEAN; }

		public Object getValueFromRow(Row row) {
			return row.bools[this.index];
		}
	}

}

