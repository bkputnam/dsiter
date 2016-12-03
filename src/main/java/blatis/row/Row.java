package blatis.row;

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

		if( ints != null ) { result.ints = ints.clone(); }
		if( longs != null ) { result.longs = longs.clone(); }
		if( floats != null ) { result.floats = floats.clone(); }
		if( doubles != null ) { result.doubles = doubles.clone(); }
		if( strings != null ) { result.strings = strings.clone(); }
		if( bools != null ) { result.bools = bools.clone(); }

		return result;
	}
	
}