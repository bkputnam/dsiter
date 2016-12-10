package blatis.row;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

public class Row {

	public int[] ints;
	public long[] longs;
	public float[] floats;
	public double[] doubles;
	public String[] strings;
	public boolean[] bools;

	public Row() { }


	public Row(int... vals) { this.ints = vals.clone(); }
	public Row(long... vals) { this.longs = vals.clone(); }
	public Row(float... vals) { this.floats = vals.clone(); }
	public Row(double... vals) { this.doubles = vals.clone(); }
	public Row(String... vals) { this.strings = vals.clone(); }
	public Row(boolean... vals) { this.bools = vals.clone(); }

	public Row(RowShape shape) {

		if(shape.getNumInts() > 0) {
			ints = new int[shape.getNumInts()];
		}
		if(shape.getNumLongs() > 0) {
			longs = new long[shape.getNumLongs()];
		}
		if(shape.getNumFloats() > 0) {
			floats = new float[shape.getNumFloats()];
		}
		if(shape.getNumDoubles() > 0) {
			doubles = new double[shape.getNumDoubles()];
		}
		if(shape.getNumStrings() > 0) {
			strings = new String[shape.getNumStrings()];
		}
		if(shape.getNumBools() > 0) {
			bools = new boolean[shape.getNumBools()];
		}
	}

	public Row clone() {
		Row result = new Row();
		Row.copyTo(this, result);
		return result;
	}

	public static void copyTo(Row src, Row dest) {
		
		if( src.ints != null ) { dest.ints = src.ints.clone(); }
		if( src.longs != null ) { dest.longs = src.longs.clone(); }
		if( src.floats != null ) { dest.floats = src.floats.clone(); }
		if( src.doubles != null ) { dest.doubles = src.doubles.clone(); }
		if( src.strings != null ) { dest.strings = src.strings.clone(); }
		if( src.bools != null ) { dest.bools = src.bools.clone(); }
	}

}