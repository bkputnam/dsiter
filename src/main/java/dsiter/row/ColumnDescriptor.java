package dsiter.row;

/**
 * Class that describes a Column from a dataset. It contains
 * the name of the column, the type, and the index at which
 * it can be accessed.
 *
 * <p>
 *     To actually access a column's value within a row, however,
 *     it is usually best to use the {@link IColumnAccessor}
 *     returned from {@link #getAccessor()}
 * </p>
 */
public class ColumnDescriptor {

	private String name;
	private ColumnType type;
	private int rowArrayIndex;

	public ColumnDescriptor(String name, ColumnType type, int rowArrayIndex) {
		this.name = name;
		this.type = type;
		this.rowArrayIndex = rowArrayIndex;
	}

	public String getName() { return name; }
	public ColumnType getType() { return type; }
	public int getRowArrayIndex() { return rowArrayIndex; }

	public IColumnAccessor getAccessor() {
		return IColumnAccessor.getInstance(type, rowArrayIndex);
	}

}