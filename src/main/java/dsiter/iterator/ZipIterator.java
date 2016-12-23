/* GENERATED CODE */package dsiter.iterator;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnDescriptor;
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import dsiter.row.RowShape;
/* GENERATED CODE */
/* GENERATED CODE */public class ZipIterator implements IDatasetIterator {
/* GENERATED CODE */
/* GENERATED CODE */	private IDatasetIterator[] srcIters;
/* GENERATED CODE */	private Row[] srcRows;
/* GENERATED CODE */
/* GENERATED CODE */	private RowShape combinedShape;
/* GENERATED CODE */	private Row row;
/* GENERATED CODE */	private ColumnDescriptor[] combinedColumnDescriptors;
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	private IndexPair[][] indexMapInt;
/* GENERATED CODE */	private IndexPair[][] indexMapLong;
/* GENERATED CODE */	private IndexPair[][] indexMapFloat;
/* GENERATED CODE */	private IndexPair[][] indexMapDouble;
/* GENERATED CODE */	private IndexPair[][] indexMapString;
/* GENERATED CODE */	private IndexPair[][] indexMapBool;
/* GENERATED CODE */
/* GENERATED CODE */	public ZipIterator(IDatasetIterator... srcIters) {
/* GENERATED CODE */		this.srcIters = srcIters;
/* GENERATED CODE */		srcRows = new Row[srcIters.length];
/* GENERATED CODE */
/* GENERATED CODE */		
/* GENERATED CODE */		indexMapInt = new IndexPair[srcIters.length][];
/* GENERATED CODE */		indexMapLong = new IndexPair[srcIters.length][];
/* GENERATED CODE */		indexMapFloat = new IndexPair[srcIters.length][];
/* GENERATED CODE */		indexMapDouble = new IndexPair[srcIters.length][];
/* GENERATED CODE */		indexMapString = new IndexPair[srcIters.length][];
/* GENERATED CODE */		indexMapBool = new IndexPair[srcIters.length][];
/* GENERATED CODE */
/* GENERATED CODE */		int numColumns = 0;
/* GENERATED CODE */		for(int i=0; i<srcIters.length; i++) {
/* GENERATED CODE */			numColumns += srcIters[i].getColumnDescriptors().length;
/* GENERATED CODE */		}
/* GENERATED CODE */		combinedColumnDescriptors = new ColumnDescriptor[numColumns];
/* GENERATED CODE */
/* GENERATED CODE */		combinedShape = new RowShape();
/* GENERATED CODE */		int combinedColumnIndex = 0;
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IDatasetIterator srcIt = srcIters[iterIndex];
/* GENERATED CODE */			ColumnDescriptor[] cds = srcIt.getColumnDescriptors();
/* GENERATED CODE */			RowShape iterShape = srcIt.computeShape();
/* GENERATED CODE */
/* GENERATED CODE */			
/* GENERATED CODE */			indexMapInt[iterIndex] = new IndexPair[iterShape.getNumInts()];
/* GENERATED CODE */			indexMapLong[iterIndex] = new IndexPair[iterShape.getNumLongs()];
/* GENERATED CODE */			indexMapFloat[iterIndex] = new IndexPair[iterShape.getNumFloats()];
/* GENERATED CODE */			indexMapDouble[iterIndex] = new IndexPair[iterShape.getNumDoubles()];
/* GENERATED CODE */			indexMapString[iterIndex] = new IndexPair[iterShape.getNumStrings()];
/* GENERATED CODE */			indexMapBool[iterIndex] = new IndexPair[iterShape.getNumBools()];
/* GENERATED CODE */
/* GENERATED CODE */			iterShape = new RowShape(); // reset to 0's
/* GENERATED CODE */
/* GENERATED CODE */			for(int columnIndex=0; columnIndex<cds.length; columnIndex++) {
/* GENERATED CODE */				ColumnDescriptor cd = cds[columnIndex];
/* GENERATED CODE */				ColumnType type = cd.getType();
/* GENERATED CODE */				iterShape.incrNum(type);
/* GENERATED CODE */				combinedShape.incrNum(type);
/* GENERATED CODE */
/* GENERATED CODE */				int srcIndex = iterShape.getNum(type) - 1;
/* GENERATED CODE */				int destIndex = combinedShape.getNum(type) - 1;
/* GENERATED CODE */
/* GENERATED CODE */				combinedColumnDescriptors[combinedColumnIndex] = new ColumnDescriptor(
/* GENERATED CODE */					cd.getName(),
/* GENERATED CODE */					type,
/* GENERATED CODE */					destIndex
/* GENERATED CODE */				);
/* GENERATED CODE */
/* GENERATED CODE */				switch (type) {
/* GENERATED CODE */					
/* GENERATED CODE */					case INT:
/* GENERATED CODE */						indexMapInt[iterIndex][columnIndex] = new IndexPair(srcIndex, destIndex);
/* GENERATED CODE */						break;
/* GENERATED CODE */					
/* GENERATED CODE */					case LONG:
/* GENERATED CODE */						indexMapLong[iterIndex][columnIndex] = new IndexPair(srcIndex, destIndex);
/* GENERATED CODE */						break;
/* GENERATED CODE */					
/* GENERATED CODE */					case FLOAT:
/* GENERATED CODE */						indexMapFloat[iterIndex][columnIndex] = new IndexPair(srcIndex, destIndex);
/* GENERATED CODE */						break;
/* GENERATED CODE */					
/* GENERATED CODE */					case DOUBLE:
/* GENERATED CODE */						indexMapDouble[iterIndex][columnIndex] = new IndexPair(srcIndex, destIndex);
/* GENERATED CODE */						break;
/* GENERATED CODE */					
/* GENERATED CODE */					case STRING:
/* GENERATED CODE */						indexMapString[iterIndex][columnIndex] = new IndexPair(srcIndex, destIndex);
/* GENERATED CODE */						break;
/* GENERATED CODE */					
/* GENERATED CODE */					case BOOLEAN:
/* GENERATED CODE */						indexMapBool[iterIndex][columnIndex] = new IndexPair(srcIndex, destIndex);
/* GENERATED CODE */						break;
/* GENERATED CODE */					
/* GENERATED CODE */					default:
/* GENERATED CODE */						throw new Error("Programmer Error: this should be impossible");
/* GENERATED CODE */				}
/* GENERATED CODE */
/* GENERATED CODE */				combinedColumnIndex++;
/* GENERATED CODE */			}
/* GENERATED CODE */
/* GENERATED CODE */			row = new Row(combinedShape);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public boolean tryMoveNext() {
/* GENERATED CODE */		for(int i=0; i<srcIters.length; i++) {
/* GENERATED CODE */			if (!srcIters[i].tryMoveNext()) {
/* GENERATED CODE */				return false;
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		return true;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public Row getCurrentRow() throws Exception {
/* GENERATED CODE */
/* GENERATED CODE */		for(int i=0; i<srcIters.length; i++) {
/* GENERATED CODE */			srcRows[i] = srcIters[i].getCurrentRow();
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IndexPair[] columnMap = indexMapInt[iterIndex];
/* GENERATED CODE */
/* GENERATED CODE */			for(int colIndex=0; colIndex<columnMap.length; colIndex++) {
/* GENERATED CODE */				IndexPair map = columnMap[colIndex];
/* GENERATED CODE */				row.ints[map.destIndex] = srcRows[iterIndex].ints[map.srcIndex];
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IndexPair[] columnMap = indexMapLong[iterIndex];
/* GENERATED CODE */
/* GENERATED CODE */			for(int colIndex=0; colIndex<columnMap.length; colIndex++) {
/* GENERATED CODE */				IndexPair map = columnMap[colIndex];
/* GENERATED CODE */				row.longs[map.destIndex] = srcRows[iterIndex].longs[map.srcIndex];
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IndexPair[] columnMap = indexMapFloat[iterIndex];
/* GENERATED CODE */
/* GENERATED CODE */			for(int colIndex=0; colIndex<columnMap.length; colIndex++) {
/* GENERATED CODE */				IndexPair map = columnMap[colIndex];
/* GENERATED CODE */				row.floats[map.destIndex] = srcRows[iterIndex].floats[map.srcIndex];
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IndexPair[] columnMap = indexMapDouble[iterIndex];
/* GENERATED CODE */
/* GENERATED CODE */			for(int colIndex=0; colIndex<columnMap.length; colIndex++) {
/* GENERATED CODE */				IndexPair map = columnMap[colIndex];
/* GENERATED CODE */				row.doubles[map.destIndex] = srcRows[iterIndex].doubles[map.srcIndex];
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IndexPair[] columnMap = indexMapString[iterIndex];
/* GENERATED CODE */
/* GENERATED CODE */			for(int colIndex=0; colIndex<columnMap.length; colIndex++) {
/* GENERATED CODE */				IndexPair map = columnMap[colIndex];
/* GENERATED CODE */				row.strings[map.destIndex] = srcRows[iterIndex].strings[map.srcIndex];
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
/* GENERATED CODE */			IndexPair[] columnMap = indexMapBool[iterIndex];
/* GENERATED CODE */
/* GENERATED CODE */			for(int colIndex=0; colIndex<columnMap.length; colIndex++) {
/* GENERATED CODE */				IndexPair map = columnMap[colIndex];
/* GENERATED CODE */				row.bools[map.destIndex] = srcRows[iterIndex].bools[map.srcIndex];
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		
/* GENERATED CODE */
/* GENERATED CODE */		// Null out srcRows. May allow them to be garbage collected,
/* GENERATED CODE */		// depending on the implementation of the srcIter
/* GENERATED CODE */		for(int i=0; i<srcIters.length; i++) {
/* GENERATED CODE */			srcRows[i] = null;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		return row;
/* GENERATED CODE */
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public long tryGetLength() {
/* GENERATED CODE */		long minLen = Long.MAX_VALUE;
/* GENERATED CODE */		for(int i=0; i<srcIters.length; i++) {
/* GENERATED CODE */			long len = srcIters[i].tryGetLength();
/* GENERATED CODE */			if (len==-1) {
/* GENERATED CODE */				return -1;
/* GENERATED CODE */			}
/* GENERATED CODE */			else if (len<minLen) {
/* GENERATED CODE */				minLen = len;
/* GENERATED CODE */			}
/* GENERATED CODE */		}
/* GENERATED CODE */		return minLen;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public ColumnDescriptor[] getColumnDescriptors() {
/* GENERATED CODE */		return combinedColumnDescriptors;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private static class IndexPair {
/* GENERATED CODE */		int srcIndex;
/* GENERATED CODE */		int destIndex;
/* GENERATED CODE */
/* GENERATED CODE */		public IndexPair(int srcIndex, int destIndex) {
/* GENERATED CODE */			this.srcIndex = srcIndex;
/* GENERATED CODE */			this.destIndex = destIndex;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */}
