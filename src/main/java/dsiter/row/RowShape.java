/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * Class that describes the "shape" of a {@link Row}. The shape of a {@code Row}
                     * is simply the size of each array in the row (i.e. the number of ints, the
                     * number of longs, the number of floats, etc).
                     */
/* GENERATED CODE */public class RowShape {
/* GENERATED CODE */	
/* GENERATED CODE */	private int numInts;
/* GENERATED CODE */	private int numLongs;
/* GENERATED CODE */	private int numFloats;
/* GENERATED CODE */	private int numDoubles;
/* GENERATED CODE */	private int numStrings;
/* GENERATED CODE */	private int numBools;
/* GENERATED CODE */	private int numJsDates;
/* GENERATED CODE */
                    	/**
                    	 * Construct a new RowShape with all dimensions set to {@code 0}
                    	 */
/* GENERATED CODE */	public RowShape() {
/* GENERATED CODE */		this(0, 0, 0, 0, 0, 0, 0);
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Construct a new RowShape of the specified dimensions.
                    	 *
                    	 * 
                    	 * @param numInts		The number of ints
                    	 * @param numLongs		The number of longs
                    	 * @param numFloats		The number of floats
                    	 * @param numDoubles		The number of doubles
                    	 * @param numStrings		The number of Strings
                    	 * @param numBools		The number of booleans
                    	 * @param numJsDates		The number of longs
                    	 */
/* GENERATED CODE */	public RowShape(int numInts, int numLongs, int numFloats, int numDoubles, int numStrings, int numBools, int numJsDates) {
/* GENERATED CODE */		
/* GENERATED CODE */		this.numInts = numInts;
/* GENERATED CODE */		this.numLongs = numLongs;
/* GENERATED CODE */		this.numFloats = numFloats;
/* GENERATED CODE */		this.numDoubles = numDoubles;
/* GENERATED CODE */		this.numStrings = numStrings;
/* GENERATED CODE */		this.numBools = numBools;
/* GENERATED CODE */		this.numJsDates = numJsDates;
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Construct a new RowShape from a set of
                    	 * {@link ColumnDescriptor}s (counts the number
                    	 * of columns of each type)
                    	 *
                    	 * <p>
                    	 *     Note: this will fail to construct an accurate
                    	 *     RowShape if the Rows in question contain
                    	 *     "deleted" values that are not described by
                    	 *     any of the passed {@link ColumnDescriptor}s.
                    	 * </p>
                    	 *
                    	 * @param cds The columns that describe the Row
                    	 *            in question
                    	 */
/* GENERATED CODE */	public RowShape(ColumnDescriptor[] cds) {
/* GENERATED CODE */		for(int i=0; i<cds.length; i++) {
/* GENERATED CODE */			incrNum(cds[i].getType());
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of ints in the current shape
                    	 *
                    	 * @return The number of ints in the current shape
                    	 */
/* GENERATED CODE */	public int getNumInts() { return numInts; }
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of longs in the current shape
                    	 *
                    	 * @return The number of longs in the current shape
                    	 */
/* GENERATED CODE */	public int getNumLongs() { return numLongs; }
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of floats in the current shape
                    	 *
                    	 * @return The number of floats in the current shape
                    	 */
/* GENERATED CODE */	public int getNumFloats() { return numFloats; }
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of doubles in the current shape
                    	 *
                    	 * @return The number of doubles in the current shape
                    	 */
/* GENERATED CODE */	public int getNumDoubles() { return numDoubles; }
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of Strings in the current shape
                    	 *
                    	 * @return The number of Strings in the current shape
                    	 */
/* GENERATED CODE */	public int getNumStrings() { return numStrings; }
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of booleans in the current shape
                    	 *
                    	 * @return The number of booleans in the current shape
                    	 */
/* GENERATED CODE */	public int getNumBools() { return numBools; }
/* GENERATED CODE */	
                    	/**
                    	 * Return the number of longs in the current shape
                    	 *
                    	 * @return The number of longs in the current shape
                    	 */
/* GENERATED CODE */	public int getNumJsDates() { return numJsDates; }
/* GENERATED CODE */	
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */
                    	/**
                    	 * Get the number of values of the specified type in this shape.
                    	 *
                    	 * <p>
                    	 * 	For example, if {@code type == ColumnType.INT}, this is equivalent
                    	 * 	to calling {@link #getNumInts()}
                    	 * </p>
                    	 *
                    	 * @param type	The type whose count is to be returned
                    	 * @return The number of {@code type} values in the current shape
                    	 */
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
/* GENERATED CODE */		else if(type == ColumnType.JSDATE) {
/* GENERATED CODE */			return getNumJsDates();
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Set the number of values of the specified type in this shape.
                    	 *
                    	 * @param type	The type whose count is to be modified
                    	 * @param num	The new count of {@code type} values
                    	 */
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
/* GENERATED CODE */		else if(type == ColumnType.JSDATE) {
/* GENERATED CODE */			numJsDates = num;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Increment the number of values of the specified type in this shape.
                    	 *
                    	 * <p>
                    	 * 	This is equivalent to (but more efficient than) calling
                    	 * 	{@code setNum(type, getNum(type)+1)}
                    	 * </p>
                    	 *
                    	 * @param type	The type whose count is to be incremented
                    	 */
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
/* GENERATED CODE */		else if(type == ColumnType.JSDATE) {
/* GENERATED CODE */			numJsDates++;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Return a new RowShape instance whose counts are the sums of the
                    	 * counts of the passed RowShapes. Will not modify either
                    	 * {@code shape1} or {@code shape2}.
                    	 *
                    	 * @param shape1	One shape to be summed
                    	 * @param shape2	The other shape to be summed
                    	 * @return			A new RowShape instance representing the sum
                    	 *					of the two parameters
                    	 */
/* GENERATED CODE */	public static RowShape add(RowShape shape1, RowShape shape2) {
/* GENERATED CODE */		return new RowShape(
/* GENERATED CODE */			
/* GENERATED CODE */			shape1.numInts + shape2.numInts,
/* GENERATED CODE */			shape1.numLongs + shape2.numLongs,
/* GENERATED CODE */			shape1.numFloats + shape2.numFloats,
/* GENERATED CODE */			shape1.numDoubles + shape2.numDoubles,
/* GENERATED CODE */			shape1.numStrings + shape2.numStrings,
/* GENERATED CODE */			shape1.numBools + shape2.numBools,
/* GENERATED CODE */			shape1.numJsDates + shape2.numJsDates
/* GENERATED CODE */		);
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Return a new RowShape instance whose counts are the sums of the
                    	 * current RowShape and the passed RowShape. Will not modify either
                    	 * the current RowShape or the passed RowShape.
                    	 *
                    	 * <p>
                    	 * 	{@code shapeA.add(shapeB)} is equivalent to {@code RowShape.add(shapeA, shapeB)}
                    	 * </p>
                    	 *
                    	 * @param other	The RowShape to be summed with the current RowShape
                    	 * @return		A new RowShape instance representing the sum of the two RowShapes
                    	 */
/* GENERATED CODE */	public RowShape add(RowShape other) {
/* GENERATED CODE */		return RowShape.add(this, other);
/* GENERATED CODE */	}
/* GENERATED CODE */}