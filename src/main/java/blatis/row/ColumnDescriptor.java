package blatis.row;

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
		if( type == Type.INT ) {
			return new ColumnAccessor.IntAccessor( this.rowArrayIndex );
		}
		else if( type == Type.LONG ) {
			return new ColumnAccessor.LongAccessor( this.rowArrayIndex );
		}
		else if( type == Type.FLOAT ) {
			return new ColumnAccessor.FloatAccessor( this.rowArrayIndex );
		}
		else if( type == Type.DOUBLE ) {
			return new ColumnAccessor.DoubleAccessor( this.rowArrayIndex );
		}
		else if( type == Type.STRING ) {
			return new ColumnAccessor.StringAccessor( this.rowArrayIndex );
		}
		else if( type == Type.BOOLEAN ) {
			return new ColumnAccessor.BoolAccessor( this.rowArrayIndex );
		}
		else {
			throw new Error("Programmer Error: unrecognized Type: " + type);
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