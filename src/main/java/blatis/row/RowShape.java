package blatis.row;

public class RowShape {

	private int numInts;
	private int numLongs;
	private int numFloats;
	private int numDoubles;
	private int numStrings;
	private int numBools;

	public RowShape() {
		this(0, 0, 0, 0, 0, 0);
	}

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
			throw new Error("This should be impossible");
		}
	}

	public void setNum(ColumnType type, int num) {

		if(type == ColumnType.INT) {
			numInts = num;
		}
		else if(type == ColumnType.LONG) {
			numLongs = num;
		}
		else if(type == ColumnType.FLOAT) {
			numFloats = num;
		}
		else if(type == ColumnType.DOUBLE) {
			numDoubles = num;
		}
		else if(type == ColumnType.STRING) {
			numStrings = num;
		}
		else if(type == ColumnType.BOOLEAN) {
			numBools = num;
		}
		else {
			throw new Error("This should be impossible");
		}
	}

	public void incrNum(ColumnType type) {

		if(type == ColumnType.INT) {
			numInts++;
		}
		else if(type == ColumnType.LONG) {
			numLongs++;
		}
		else if(type == ColumnType.FLOAT) {
			numFloats++;
		}
		else if(type == ColumnType.DOUBLE) {
			numDoubles++;
		}
		else if(type == ColumnType.STRING) {
			numStrings++;
		}
		else if(type == ColumnType.BOOLEAN) {
			numBools++;
		}
		else {
			throw new Error("This should be impossible");
		}
	}

	public static RowShape add(RowShape shape1, RowShape shape2) {
		return new RowShape(

			shape1.numInts + shape2.numInts,
			shape1.numLongs + shape2.numLongs,
			shape1.numFloats + shape2.numFloats,
			shape1.numDoubles + shape2.numDoubles,
			shape1.numStrings + shape2.numStrings,
			shape1.numBools + shape2.numBools
		);
	}

	public RowShape add(RowShape other) {
		return RowShape.add(this, other);
	}
}