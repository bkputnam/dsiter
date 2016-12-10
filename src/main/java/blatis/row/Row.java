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
		
		if( src.ints == null ) {
			dest.ints = null;
		}
		else {
			if( dest.ints != null && dest.ints.length == src.ints.length ) {
				System.arraycopy(src.ints, 0, dest.ints, 0, src.ints.length);
			}
			else {
				dest.ints = src.ints.clone(); }
			}
		
		if( src.longs == null ) {
			dest.longs = null;
		}
		else {
			if( dest.longs != null && dest.longs.length == src.longs.length ) {
				System.arraycopy(src.longs, 0, dest.longs, 0, src.longs.length);
			}
			else {
				dest.longs = src.longs.clone(); }
			}
		
		if( src.floats == null ) {
			dest.floats = null;
		}
		else {
			if( dest.floats != null && dest.floats.length == src.floats.length ) {
				System.arraycopy(src.floats, 0, dest.floats, 0, src.floats.length);
			}
			else {
				dest.floats = src.floats.clone(); }
			}
		
		if( src.doubles == null ) {
			dest.doubles = null;
		}
		else {
			if( dest.doubles != null && dest.doubles.length == src.doubles.length ) {
				System.arraycopy(src.doubles, 0, dest.doubles, 0, src.doubles.length);
			}
			else {
				dest.doubles = src.doubles.clone(); }
			}
		
		if( src.strings == null ) {
			dest.strings = null;
		}
		else {
			if( dest.strings != null && dest.strings.length == src.strings.length ) {
				System.arraycopy(src.strings, 0, dest.strings, 0, src.strings.length);
			}
			else {
				dest.strings = src.strings.clone(); }
			}
		
		if( src.bools == null ) {
			dest.bools = null;
		}
		else {
			if( dest.bools != null && dest.bools.length == src.bools.length ) {
				System.arraycopy(src.bools, 0, dest.bools, 0, src.bools.length);
			}
			else {
				dest.bools = src.bools.clone(); }
			}
		
	}

}