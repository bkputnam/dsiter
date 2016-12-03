package blatis.row;

public class RowShape {
	private int numInts;
	private int numLongs;
	private int numFloats;
	private int numDoubles;
	private int numStrings;
	private int numBools;

	public RowShape(int numInts, int numLongs, int numFloats, int numDoubles, int numStrings, int numBools) {
		this.numInts = numInts;
		this.numLongs = numLongs;
		this.numFloats = numFloats;
		this.numDoubles = numDoubles;
		this.numStrings = numStrings;
		this.numBools = numBools;
	}

	public int getNumInts() { return numInts; }
	public int getNumLongs() { return numLongs; }
	public int getNumFloats() { return numFloats; }
	public int getNumDoubles() { return numDoubles; }
	public int getNumStrings() { return numStrings; }
	public int getNumBools() { return numBools; }

	public int getNum(ColumnDescriptor.Type type) {
		if(type == ColumnDescriptor.Type.INT) {
			return getNumInts();
		}
		else if(type == ColumnDescriptor.Type.LONG) {
			return getNumLongs();
		}
		else if(type == ColumnDescriptor.Type.FLOAT) {
			return getNumFloats();
		}
		else if(type == ColumnDescriptor.Type.DOUBLE) {
			return getNumDoubles();
		}
		else if(type == ColumnDescriptor.Type.STRING) {
			return getNumStrings();
		}
		else if(type == ColumnDescriptor.Type.BOOLEAN) {
			return getNumBools();
		}
		else {
			throw new RuntimeException("This should be impossible");
		}
	}
}