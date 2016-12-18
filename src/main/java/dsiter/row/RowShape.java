/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public class RowShape {
/* GENERATED CODE */	
/* GENERATED CODE */	private int numInts;
/* GENERATED CODE */	private int numLongs;
/* GENERATED CODE */	private int numFloats;
/* GENERATED CODE */	private int numDoubles;
/* GENERATED CODE */	private int numStrings;
/* GENERATED CODE */	private int numBools;
/* GENERATED CODE */
/* GENERATED CODE */	public RowShape() {
/* GENERATED CODE */		this(0, 0, 0, 0, 0, 0);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public RowShape(int numInts, int numLongs, int numFloats, int numDoubles, int numStrings, int numBools) {
/* GENERATED CODE */		
/* GENERATED CODE */		this.numInts = numInts;
/* GENERATED CODE */		this.numLongs = numLongs;
/* GENERATED CODE */		this.numFloats = numFloats;
/* GENERATED CODE */		this.numDoubles = numDoubles;
/* GENERATED CODE */		this.numStrings = numStrings;
/* GENERATED CODE */		this.numBools = numBools;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public RowShape(ColumnDescriptor[] cds) {
/* GENERATED CODE */		for(int i=0; i<cds.length; i++) {
/* GENERATED CODE */			incrNum(cds[i].getType());
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	public int getNumInts() { return numInts; }
/* GENERATED CODE */	public int getNumLongs() { return numLongs; }
/* GENERATED CODE */	public int getNumFloats() { return numFloats; }
/* GENERATED CODE */	public int getNumDoubles() { return numDoubles; }
/* GENERATED CODE */	public int getNumStrings() { return numStrings; }
/* GENERATED CODE */	public int getNumBools() { return numBools; }
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */
/* GENERATED CODE */	public int getNum(ColumnType type) {
/* GENERATED CODE */		
/* GENERATED CODE */		if(type == ColumnType.INT) {
/* GENERATED CODE */			return getNumInts();
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.LONG) {
/* GENERATED CODE */			return getNumLongs();
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.FLOAT) {
/* GENERATED CODE */			return getNumFloats();
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.DOUBLE) {
/* GENERATED CODE */			return getNumDoubles();
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.STRING) {
/* GENERATED CODE */			return getNumStrings();
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.BOOLEAN) {
/* GENERATED CODE */			return getNumBools();
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public void setNum(ColumnType type, int num) {
/* GENERATED CODE */		
/* GENERATED CODE */		if(type == ColumnType.INT) {
/* GENERATED CODE */			numInts = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.LONG) {
/* GENERATED CODE */			numLongs = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.FLOAT) {
/* GENERATED CODE */			numFloats = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.DOUBLE) {
/* GENERATED CODE */			numDoubles = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.STRING) {
/* GENERATED CODE */			numStrings = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.BOOLEAN) {
/* GENERATED CODE */			numBools = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public void incrNum(ColumnType type) {
/* GENERATED CODE */		
/* GENERATED CODE */		if(type == ColumnType.INT) {
/* GENERATED CODE */			numInts++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.LONG) {
/* GENERATED CODE */			numLongs++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.FLOAT) {
/* GENERATED CODE */			numFloats++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.DOUBLE) {
/* GENERATED CODE */			numDoubles++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.STRING) {
/* GENERATED CODE */			numStrings++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.BOOLEAN) {
/* GENERATED CODE */			numBools++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public static RowShape add(RowShape shape1, RowShape shape2) {
/* GENERATED CODE */		return new RowShape(
/* GENERATED CODE */			
/* GENERATED CODE */			shape1.numInts + shape2.numInts,
/* GENERATED CODE */			shape1.numLongs + shape2.numLongs,
/* GENERATED CODE */			shape1.numFloats + shape2.numFloats,
/* GENERATED CODE */			shape1.numDoubles + shape2.numDoubles,
/* GENERATED CODE */			shape1.numStrings + shape2.numStrings,
/* GENERATED CODE */			shape1.numBools + shape2.numBools
/* GENERATED CODE */		);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public RowShape add(RowShape other) {
/* GENERATED CODE */		return RowShape.add(this, other);
/* GENERATED CODE */	}
/* GENERATED CODE */}