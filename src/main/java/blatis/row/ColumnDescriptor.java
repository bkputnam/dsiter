package blatis.row;

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

	public ColumnAccessor getAccessor() {
		return new ColumnAccessor(type, rowArrayIndex);
	}

}