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

	public int getNum(ColumnType type) {
		if(type == ColumnType.INT) {
			return getNumInts();
		}
		else if(type == ColumnType.LONG) {
			return getNumLongs();
		}
		else if(type == ColumnType.FLOAT) {
			return getNumFloats();
		}
		else if(type == ColumnType.DOUBLE) {
			return getNumDoubles();
		}
		else if(type == ColumnType.STRING) {
			return getNumStrings();
		}
		else if(type == ColumnType.BOOLEAN) {
			return getNumBools();
		}
		else {
			throw new Error("Programmer error: unrecognized ColumnType: " + type);
		}
	}
}