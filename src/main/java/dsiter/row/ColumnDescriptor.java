package dsiter.row;

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