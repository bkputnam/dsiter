package blatis.dataset;

public class ColumnDescriptor {

	private String name;
	private Type type;
	private int rowArrayIndex;

	public ColumnDescriptor(String name, Type type, int rowArrayIndex) {
		this.name = name;
		this.type = type;
		this.rowArrayIndex = rowArrayIndex;
	}

	public String getName() { return name; }
	public Type getType() { return type; }
	public int getRowArrayIndex() { return rowArrayIndex; }

	public ColumnAccessor getAccessor() {
		if( this.type == Type.INT ) {
			return new ColumnAccessor.IntAccessor( this.rowArrayIndex );
		}
		else {
			throw new RuntimeException("Not Implemented");
		}
	}

	public enum Type {
		INT,
		LONG,
		FLOAT,
		DOUBLE,
		STRING,
		BOOLEAN
	}
}