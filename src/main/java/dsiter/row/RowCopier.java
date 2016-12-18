/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
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
/* GENERATED CODE */			ColumnAccessor ca = cd.getAccessor();
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
/* GENERATED CODE */	public RowShape getDestShape() {
/* GENERATED CODE */		return new RowShape().add(shape);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	public ColumnDescriptor[] getDestColumnDescriptors() {
/* GENERATED CODE */		return destCds;
/* GENERATED CODE */	}
/* GENERATED CODE */
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
