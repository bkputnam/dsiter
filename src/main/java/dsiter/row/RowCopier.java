/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * Class that manages copying data from one {@link Row} to another.
                     *
                     * <p>
                     *     Since it's moderately common for Rows to contain values not linked to
                     *     actual columns (not all values in the Row are described by a
                     *     {@link ColumnDescriptor} instance), this class requires a
                     *     {@code ColumnDescriptor[]} and will
                     *     only copy over the described columns. This means that the destination
                     *     Row may have a different shape than the source Row (always
                     *     less-than-or-equal to the source shape in every dimension). It also means
                     *     that the {@link ColumnDescriptor#getRowArrayIndex()} values for a
                     *     given column may change, and that the destination Row must therefore
                     *     be descibed by a different {@code ColumnDescriptor[]} than the source
                     *     Row. This class provides functionality to handle all of that.
                     * </p>
                     */
/* GENERATED CODE */public class RowCopier {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	private int[] srcIntIndexes;
/* GENERATED CODE */	private int[] srcLongIndexes;
/* GENERATED CODE */	private int[] srcFloatIndexes;
/* GENERATED CODE */	private int[] srcDoubleIndexes;
/* GENERATED CODE */	private int[] srcStringIndexes;
/* GENERATED CODE */	private int[] srcBoolIndexes;
/* GENERATED CODE */
/* GENERATED CODE */	private RowShape shape;
/* GENERATED CODE */	private ColumnDescriptor[] destCds;
/* GENERATED CODE */
                    	/**
                    	 * Construct a RowCopier that copies the specified columns
                    	 * to a new, potentially compacted Row
                    	 *
                    	 * @param srcCds Descriptors of the columns to be copied to
                    	 *               a new Row
                    	 */
/* GENERATED CODE */	public RowCopier(ColumnDescriptor[] srcCds) {
/* GENERATED CODE */
/* GENERATED CODE */		shape = new RowShape();
/* GENERATED CODE */
/* GENERATED CODE */		for(int i=0; i<srcCds.length; i++) {
/* GENERATED CODE */			shape.incrNum(srcCds[i].getType());
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		
/* GENERATED CODE */		srcIntIndexes = new int[shape.getNumInts()];
/* GENERATED CODE */		srcLongIndexes = new int[shape.getNumLongs()];
/* GENERATED CODE */		srcFloatIndexes = new int[shape.getNumFloats()];
/* GENERATED CODE */		srcDoubleIndexes = new int[shape.getNumDoubles()];
/* GENERATED CODE */		srcStringIndexes = new int[shape.getNumStrings()];
/* GENERATED CODE */		srcBoolIndexes = new int[shape.getNumBools()];
/* GENERATED CODE */
/* GENERATED CODE */		destCds = new ColumnDescriptor[srcCds.length];
/* GENERATED CODE */
/* GENERATED CODE */		shape = new RowShape(); // reset to all 0's
/* GENERATED CODE */		for(int i=0; i<srcCds.length; i++) {
/* GENERATED CODE */			ColumnDescriptor cd = srcCds[i];
/* GENERATED CODE */			IColumnAccessor ca = cd.getAccessor();
/* GENERATED CODE */			ColumnType type = ca.getType();
/* GENERATED CODE */			shape.incrNum(type);
/* GENERATED CODE */			int index = shape.getNum(type) - 1;
/* GENERATED CODE */
/* GENERATED CODE */			destCds[i] = new ColumnDescriptor(
/* GENERATED CODE */				cd.getName(),
/* GENERATED CODE */				cd.getType(),
/* GENERATED CODE */				index
/* GENERATED CODE */			);
/* GENERATED CODE */
/* GENERATED CODE */			switch(type) {
/* GENERATED CODE */				
/* GENERATED CODE */				case INT: srcIntIndexes[index] = ca.getIndex(); break;
/* GENERATED CODE */				case LONG: srcLongIndexes[index] = ca.getIndex(); break;
/* GENERATED CODE */				case FLOAT: srcFloatIndexes[index] = ca.getIndex(); break;
/* GENERATED CODE */				case DOUBLE: srcDoubleIndexes[index] = ca.getIndex(); break;
/* GENERATED CODE */				case STRING: srcStringIndexes[index] = ca.getIndex(); break;
/* GENERATED CODE */				case BOOLEAN: srcBoolIndexes[index] = ca.getIndex(); break;
/* GENERATED CODE */				default:
/* GENERATED CODE */					throw new Error("This should be impossible");
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Get the shape of the destination Row. This shape will
                    	 * be less-than-or-equal-to the source Row's shape in every
                    	 * dimension.
                    	 *
                    	 * @return	The shape of the destination row
                    	 */
/* GENERATED CODE */	public RowShape getDestShape() {
/* GENERATED CODE */		return new RowShape().add(shape);
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Get column descriptors that describe the destination Row
                    	 *
                    	 * @return Descriptions of every column in the destination Row
                    	 */
/* GENERATED CODE */	public ColumnDescriptor[] getDestColumnDescriptors() {
/* GENERATED CODE */		return destCds;
/* GENERATED CODE */	}
/* GENERATED CODE */
                    	/**
                    	 * Copy the source Row to the destination Row, using the previously
                    	 * configured {@link ColumnDescriptor}s as a guide.
                    	 *
                    	 * @param src  The Row to be copied from
                    	 * @param dest The Row to be copied to
                    	 */
/* GENERATED CODE */	public void copyTo(Row src, Row dest) {
/* GENERATED CODE */		
/* GENERATED CODE */		for(int i=0; i<srcIntIndexes.length; i++) {
/* GENERATED CODE */			dest.ints[i] = src.ints[srcIntIndexes[i]];
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int i=0; i<srcLongIndexes.length; i++) {
/* GENERATED CODE */			dest.longs[i] = src.longs[srcLongIndexes[i]];
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int i=0; i<srcFloatIndexes.length; i++) {
/* GENERATED CODE */			dest.floats[i] = src.floats[srcFloatIndexes[i]];
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int i=0; i<srcDoubleIndexes.length; i++) {
/* GENERATED CODE */			dest.doubles[i] = src.doubles[srcDoubleIndexes[i]];
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int i=0; i<srcStringIndexes.length; i++) {
/* GENERATED CODE */			dest.strings[i] = src.strings[srcStringIndexes[i]];
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int i=0; i<srcBoolIndexes.length; i++) {
/* GENERATED CODE */			dest.bools[i] = src.bools[srcBoolIndexes[i]];
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */	}
/* GENERATED CODE */}
