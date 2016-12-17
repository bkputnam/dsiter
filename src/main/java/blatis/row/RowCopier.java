package blatis.row;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

public class RowCopier {

	
	private int[] srcIntIndexes;
	private int[] srcLongIndexes;
	private int[] srcFloatIndexes;
	private int[] srcDoubleIndexes;
	private int[] srcStringIndexes;
	private int[] srcBoolIndexes;

	private RowShape shape;
	private ColumnDescriptor[] destCds;

	public RowCopier(ColumnDescriptor[] srcCds) {

		shape = new RowShape();

		for(int i=0; i<srcCds.length; i++) {
			shape.incrNum(srcCds[i].getType());
		}

		
		srcIntIndexes = new int[shape.getNumInts()];
		srcLongIndexes = new int[shape.getNumLongs()];
		srcFloatIndexes = new int[shape.getNumFloats()];
		srcDoubleIndexes = new int[shape.getNumDoubles()];
		srcStringIndexes = new int[shape.getNumStrings()];
		srcBoolIndexes = new int[shape.getNumBools()];

		destCds = new ColumnDescriptor[srcCds.length];

		shape = new RowShape(); // reset to all 0's
		for(int i=0; i<srcCds.length; i++) {
			ColumnDescriptor cd = srcCds[i];
			ColumnAccessor ca = cd.getAccessor();
			ColumnType type = ca.getType();
			shape.incrNum(type);
			int index = shape.getNum(type) - 1;

			destCds[i] = new ColumnDescriptor(
				cd.getName(),
				cd.getType(),
				index
			);

			switch(type) {
				
				case INT: srcIntIndexes[index] = ca.getIndex(); break;
				case LONG: srcLongIndexes[index] = ca.getIndex(); break;
				case FLOAT: srcFloatIndexes[index] = ca.getIndex(); break;
				case DOUBLE: srcDoubleIndexes[index] = ca.getIndex(); break;
				case STRING: srcStringIndexes[index] = ca.getIndex(); break;
				case BOOLEAN: srcBoolIndexes[index] = ca.getIndex(); break;
				default:
					throw new Error("This should be impossible");
			}
		}
	}

	public RowShape getDestShape() {
		return new RowShape().add(shape);
	}

	public ColumnDescriptor[] getDestColumnDescriptors() {
		return destCds;
	}

	public void copyTo(Row src, Row dest) {
		
		for(int i=0; i<srcIntIndexes.length; i++) {
			dest.ints[i] = src.ints[srcIntIndexes[i]];
		}
		
		for(int i=0; i<srcLongIndexes.length; i++) {
			dest.longs[i] = src.longs[srcLongIndexes[i]];
		}
		
		for(int i=0; i<srcFloatIndexes.length; i++) {
			dest.floats[i] = src.floats[srcFloatIndexes[i]];
		}
		
		for(int i=0; i<srcDoubleIndexes.length; i++) {
			dest.doubles[i] = src.doubles[srcDoubleIndexes[i]];
		}
		
		for(int i=0; i<srcStringIndexes.length; i++) {
			dest.strings[i] = src.strings[srcStringIndexes[i]];
		}
		
		for(int i=0; i<srcBoolIndexes.length; i++) {
			dest.bools[i] = src.bools[srcBoolIndexes[i]];
		}
		
	}
}
