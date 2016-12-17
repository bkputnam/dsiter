/* GENERATED CODE */package blatis.iterator;
/* GENERATED CODE */
/* GENERATED CODE */import blatis.row.*;
/* GENERATED CODE */
/* GENERATED CODE */public class ArrayIterator extends AbstractDatasetIterator {
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
/* GENERATED CODE */	public ArrayIterator(int... values) {
/* GENERATED CODE */		this();
/* GENERATED CODE */		row.ints = new int[1];
/* GENERATED CODE */		length = values.length;
/* GENERATED CODE */		type = ColumnType.INT;
/* GENERATED CODE */		writer = new INT(values);
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public ArrayIterator(long... values) {
/* GENERATED CODE */		this();
/* GENERATED CODE */		row.longs = new long[1];
/* GENERATED CODE */		length = values.length;
/* GENERATED CODE */		type = ColumnType.LONG;
/* GENERATED CODE */		writer = new LONG(values);
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public ArrayIterator(float... values) {
/* GENERATED CODE */		this();
/* GENERATED CODE */		row.floats = new float[1];
/* GENERATED CODE */		length = values.length;
/* GENERATED CODE */		type = ColumnType.FLOAT;
/* GENERATED CODE */		writer = new FLOAT(values);
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public ArrayIterator(double... values) {
/* GENERATED CODE */		this();
/* GENERATED CODE */		row.doubles = new double[1];
/* GENERATED CODE */		length = values.length;
/* GENERATED CODE */		type = ColumnType.DOUBLE;
/* GENERATED CODE */		writer = new DOUBLE(values);
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public ArrayIterator(String... values) {
/* GENERATED CODE */		this();
/* GENERATED CODE */		row.strings = new String[1];
/* GENERATED CODE */		length = values.length;
/* GENERATED CODE */		type = ColumnType.STRING;
/* GENERATED CODE */		writer = new STRING(values);
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public ArrayIterator(boolean... values) {
/* GENERATED CODE */		this();
/* GENERATED CODE */		row.bools = new boolean[1];
/* GENERATED CODE */		length = values.length;
/* GENERATED CODE */		type = ColumnType.BOOLEAN;
/* GENERATED CODE */		writer = new BOOLEAN(values);
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
/* GENERATED CODE */	public ColumnDescriptor[] getColumnDescriptors() {
/* GENERATED CODE */		return new ColumnDescriptor[] {
/* GENERATED CODE */			new ColumnDescriptor("value", type, 0)
/* GENERATED CODE */		};
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
/* GENERATED CODE */}
