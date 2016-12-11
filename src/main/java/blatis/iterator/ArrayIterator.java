package blatis.iterator;

import blatis.row.*;

/**
 * Created by bkputnam on 12/3/16.
 */
public class ArrayIterator extends AbstractDatasetIterator {

	private int index;
	private int length;
	private Row row;
	private ColumnType type;
	private RowWriter writer;

	private ArrayIterator() {
		row = new Row();
		index = -1;
	}

	
	public ArrayIterator(int... values) {
		this();
		row.ints = new int[1];
		length = values.length;
		type = ColumnType.INT;
		writer = new INT(values);
	}
	
	public ArrayIterator(long... values) {
		this();
		row.longs = new long[1];
		length = values.length;
		type = ColumnType.LONG;
		writer = new LONG(values);
	}
	
	public ArrayIterator(float... values) {
		this();
		row.floats = new float[1];
		length = values.length;
		type = ColumnType.FLOAT;
		writer = new FLOAT(values);
	}
	
	public ArrayIterator(double... values) {
		this();
		row.doubles = new double[1];
		length = values.length;
		type = ColumnType.DOUBLE;
		writer = new DOUBLE(values);
	}
	
	public ArrayIterator(String... values) {
		this();
		row.strings = new String[1];
		length = values.length;
		type = ColumnType.STRING;
		writer = new STRING(values);
	}
	
	public ArrayIterator(boolean... values) {
		this();
		row.bools = new boolean[1];
		length = values.length;
		type = ColumnType.BOOLEAN;
		writer = new BOOLEAN(values);
	}
	

	@Override
	public boolean tryMoveNext() {
		if(index < length-1) {
			index++;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Row getCurrentRow() {
		writer.writeToRow(row);
		return row;
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return new ColumnDescriptor[] {
			new ColumnDescriptor("value", type, 0)
		};
	}

	private interface RowWriter {
		void writeToRow(Row row);
	}

	
	private class INT implements RowWriter{
		private int[] arr;

		public INT(int[] arr) {
			this.arr = arr;
		}

		@Override
		public void writeToRow(Row row) {
			row.ints[0] = arr[index];
		}
	}
	
	private class LONG implements RowWriter{
		private long[] arr;

		public LONG(long[] arr) {
			this.arr = arr;
		}

		@Override
		public void writeToRow(Row row) {
			row.longs[0] = arr[index];
		}
	}
	
	private class FLOAT implements RowWriter{
		private float[] arr;

		public FLOAT(float[] arr) {
			this.arr = arr;
		}

		@Override
		public void writeToRow(Row row) {
			row.floats[0] = arr[index];
		}
	}
	
	private class DOUBLE implements RowWriter{
		private double[] arr;

		public DOUBLE(double[] arr) {
			this.arr = arr;
		}

		@Override
		public void writeToRow(Row row) {
			row.doubles[0] = arr[index];
		}
	}
	
	private class STRING implements RowWriter{
		private String[] arr;

		public STRING(String[] arr) {
			this.arr = arr;
		}

		@Override
		public void writeToRow(Row row) {
			row.strings[0] = arr[index];
		}
	}
	
	private class BOOLEAN implements RowWriter{
		private boolean[] arr;

		public BOOLEAN(boolean[] arr) {
			this.arr = arr;
		}

		@Override
		public void writeToRow(Row row) {
			row.bools[0] = arr[index];
		}
	}
	
}
