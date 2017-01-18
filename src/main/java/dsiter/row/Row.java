/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * A {@code Row} represents a piece of data returned from an
                     * {@link dsiter.dataset.IDataset}. All {@link dsiter.iterator.IDatasetIterator}s
                     * iterate over {@code Row} objects of some description. Rows are intended to
                     * model a fairly generic row that you might see in a CSV file or a database
                     * table: any number of named, strongly typed 'primitive' values, but no
                     * variable-length arrays.
                     *
                     * <p>
                     *     Note that Rows are not self-describing: a Row does not know the names
                     *     or order of its columns, or even if every value within the Row is used
                     *     (sometimes a column will be "deleted" by simply failing to provide a
                     *     {@link ColumnDescriptor} for it - this will cause Rows to contain
                     *     extraneous values that do not represent a true column).
                     *     This is mostly a memory
                     *     optimization, and not a philosophical design feature. Since every Row
                     *     returned by an {@link dsiter.iterator.IDatasetIterator} will have the
                     *     same structure, the {@code IDatasetIterator} itself is responsible for
                     *     describing that structure, not the (potentially numerous) individual Row
                     *     instances.
                     * </p>
                     * <p>
                     *     Values are usually not read directly from Rows, and are instead accessed
                     *     via {@link IRowAccessor} instances (see also: {@link IColumnAccessor}). This
                     *     is not a hard requirement, however, and direct access is occasionally used
                     *     for speed or convenience reasons.
                     * </p>
                     */
/* GENERATED CODE */public class Row {
/* GENERATED CODE */	
                    	/**
                    	 * The Row's int values
                    	 */
/* GENERATED CODE */	public int[] ints;
/* GENERATED CODE */	
                    	/**
                    	 * The Row's long values
                    	 */
/* GENERATED CODE */	public long[] longs;
/* GENERATED CODE */	
                    	/**
                    	 * The Row's float values
                    	 */
/* GENERATED CODE */	public float[] floats;
/* GENERATED CODE */	
                    	/**
                    	 * The Row's double values
                    	 */
/* GENERATED CODE */	public double[] doubles;
/* GENERATED CODE */	
                    	/**
                    	 * The Row's String values
                    	 */
/* GENERATED CODE */	public String[] strings;
/* GENERATED CODE */	
                    	/**
                    	 * The Row's boolean values
                    	 */
/* GENERATED CODE */	public boolean[] bools;
/* GENERATED CODE */	
                    	/**
                    	 * The Row's long values
                    	 */
/* GENERATED CODE */	public long[] jsdates;
/* GENERATED CODE */	
/* GENERATED CODE */
                    	/**
                    	 * Construct a new Row with 0 of every type.
                    	 */
/* GENERATED CODE */	public Row() { }
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type int)
                    	 *
                    	 * @param vals	The {@code int} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromInts(int... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.ints = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type long)
                    	 *
                    	 * @param vals	The {@code long} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromLongs(long... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.longs = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type float)
                    	 *
                    	 * @param vals	The {@code float} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromFloats(float... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.floats = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type double)
                    	 *
                    	 * @param vals	The {@code double} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromDoubles(double... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.doubles = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type String)
                    	 *
                    	 * @param vals	The {@code String} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromStrings(String... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.strings = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type boolean)
                    	 *
                    	 * @param vals	The {@code boolean} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromBools(boolean... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.bools = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a Row with {@code vals} as values. (Row
                    	 * will only contain values of type long)
                    	 *
                    	 * @param vals	The {@code long} values to populate
                    	 * 				the Row with.
                    	 */
/* GENERATED CODE */	public static Row fromJsDates(long... vals) {
/* GENERATED CODE */	    Row result = new Row();
/* GENERATED CODE */	    result.jsdates = vals.clone();
/* GENERATED CODE */	    return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */
                    	/**
                    	 * Construct a Row with the specified shape. Initial
                    	 * values will be whatever the default value for that
                    	 * type is (usually {@code 0} or {@code null}).
                    	 *
                    	 * @param shape	The shape of the row to be built.
                    	 */
/* GENERATED CODE */	public Row(RowShape shape) {
/* GENERATED CODE */	
/* GENERATED CODE */		if(shape.getNumInts() > 0) {
/* GENERATED CODE */			ints = new int[shape.getNumInts()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumLongs() > 0) {
/* GENERATED CODE */			longs = new long[shape.getNumLongs()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumFloats() > 0) {
/* GENERATED CODE */			floats = new float[shape.getNumFloats()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumDoubles() > 0) {
/* GENERATED CODE */			doubles = new double[shape.getNumDoubles()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumStrings() > 0) {
/* GENERATED CODE */			strings = new String[shape.getNumStrings()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumBools() > 0) {
/* GENERATED CODE */			bools = new boolean[shape.getNumBools()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumJsDates() > 0) {
/* GENERATED CODE */			jsdates = new long[shape.getNumJsDates()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */}