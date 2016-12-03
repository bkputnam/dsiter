package blatis.row;

public abstract class ColumnAccessor {

	protected int index;

	protected ColumnAccessor(int index) {
		this.index = index;
	}

	public abstract Object getValueFromRow(Row row);

	public static class IntAccessor extends ColumnAccessor {
		public IntAccessor(int index) {
			super(index);
		}

		public Object getValueFromRow(Row row) {
			return row.ints[this.index];
		}
	}
}

