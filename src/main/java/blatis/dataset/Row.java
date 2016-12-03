package blatis.dataset;

public class Row {
	public int[] ints;
	public long[] longs;
	public float[] floats;
	public double[] doubles;
	public String[] strings;
	public boolean[] bools;

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