/* GENERATED CODE */package dsiter.iterator;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.*;
/* GENERATED CODE */import dsiter.pipe.IPipe;
/* GENERATED CODE */import dsiter.pipe.SkipPipe;
/* GENERATED CODE */
                    /**
                     * An iterator over an array. The array may be
                     * of any type in {@code ColumnTypes}. The returned
                     * Rows will have one value of that type, named
                     * {@code value}.
                     */
/* GENERATED CODE */public class ArrayIterator implements IDatasetIterator {
/* GENERATED CODE */
/* GENERATED CODE */	private int index;
/* GENERATED CODE */	private int length;
/* GENERATED CODE */	private Row row;
/* GENERATED CODE */	private ColumnType type;
/* GENERATED CODE */	private RowWriter writer;
/* GENERATED CODE */
/* GENERATED CODE */	private ArrayIterator() {
/* GENERATED CODE */		row = new Row();
/* GENERATED CODE */		index = -1;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.INT}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromInts (int... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.ints = new int[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.INT;
/* GENERATED CODE */		result.writer = result.new INT(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.LONG}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromLongs (long... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.longs = new long[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.LONG;
/* GENERATED CODE */		result.writer = result.new LONG(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.FLOAT}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromFloats (float... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.floats = new float[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.FLOAT;
/* GENERATED CODE */		result.writer = result.new FLOAT(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.DOUBLE}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromDoubles (double... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.doubles = new double[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.DOUBLE;
/* GENERATED CODE */		result.writer = result.new DOUBLE(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.STRING}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromStrings (String... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.strings = new String[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.STRING;
/* GENERATED CODE */		result.writer = result.new STRING(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.BOOLEAN}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromBools (boolean... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.bools = new boolean[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.BOOLEAN;
/* GENERATED CODE */		result.writer = result.new BOOLEAN(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct a new ArrayIterator with type {@code ColumnType.JSDATE}
                    	 * @param values the values to iterator over
                    	 */
/* GENERATED CODE */	public static ArrayIterator fromJsDates (long... values) {
/* GENERATED CODE */		ArrayIterator result = new ArrayIterator();
/* GENERATED CODE */		result.row.jsdates = new long[1];
/* GENERATED CODE */		result.length = values.length;
/* GENERATED CODE */		result.type = ColumnType.JSDATE;
/* GENERATED CODE */		result.writer = result.new JSDATE(values);
/* GENERATED CODE */		return result;
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public boolean tryMoveNext() {
/* GENERATED CODE */		if(index < length-1) {
/* GENERATED CODE */			index++;
/* GENERATED CODE */			return true;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			return false;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public Row getCurrentRow() {
/* GENERATED CODE */		writer.writeToRow(row);
/* GENERATED CODE */		return row;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public long tryGetLength() {
/* GENERATED CODE */		return length;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public ColumnDescriptor[] getColumnDescriptors() {
/* GENERATED CODE */		return new ColumnDescriptor[] {
/* GENERATED CODE */			new ColumnDescriptor("value", type, 0)
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public void close() {
/* GENERATED CODE */		// do nothing
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public boolean tryAbsorb(IPipe pipe) {
/* GENERATED CODE */		if (pipe instanceof SkipPipe) {
/* GENERATED CODE */			long howMany = ((SkipPipe)pipe).getHowMany();
/* GENERATED CODE */			index += howMany;
/* GENERATED CODE */			return true;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			return false;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private interface RowWriter {
/* GENERATED CODE */		void writeToRow(Row row);
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	private class INT implements RowWriter{
/* GENERATED CODE */		private int[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public INT(int[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.ints[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	private class LONG implements RowWriter{
/* GENERATED CODE */		private long[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG(long[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.longs[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	private class FLOAT implements RowWriter{
/* GENERATED CODE */		private float[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT(float[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.floats[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	private class DOUBLE implements RowWriter{
/* GENERATED CODE */		private double[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE(double[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.doubles[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	private class STRING implements RowWriter{
/* GENERATED CODE */		private String[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public STRING(String[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.strings[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	private class BOOLEAN implements RowWriter{
/* GENERATED CODE */		private boolean[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public BOOLEAN(boolean[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.bools[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	private class JSDATE implements RowWriter{
/* GENERATED CODE */		private long[] arr;
/* GENERATED CODE */
/* GENERATED CODE */		public JSDATE(long[] arr) {
/* GENERATED CODE */			this.arr = arr;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void writeToRow(Row row) {
/* GENERATED CODE */			row.jsdates[0] = arr[index];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
