/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public class Row {
/* GENERATED CODE */
/* GENERATED CODE */	public int[] ints;
/* GENERATED CODE */	public long[] longs;
/* GENERATED CODE */	public float[] floats;
/* GENERATED CODE */	public double[] doubles;
/* GENERATED CODE */	public String[] strings;
/* GENERATED CODE */	public boolean[] bools;
/* GENERATED CODE */
/* GENERATED CODE */	public Row() { }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */	public Row(int... vals) { this.ints = vals.clone(); }
/* GENERATED CODE */	public Row(long... vals) { this.longs = vals.clone(); }
/* GENERATED CODE */	public Row(float... vals) { this.floats = vals.clone(); }
/* GENERATED CODE */	public Row(double... vals) { this.doubles = vals.clone(); }
/* GENERATED CODE */	public Row(String... vals) { this.strings = vals.clone(); }
/* GENERATED CODE */	public Row(boolean... vals) { this.bools = vals.clone(); }
/* GENERATED CODE */
/* GENERATED CODE */	public Row(RowShape shape) {
/* GENERATED CODE */
/* GENERATED CODE */		if(shape.getNumInts() > 0) {
/* GENERATED CODE */			ints = new int[shape.getNumInts()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumLongs() > 0) {
/* GENERATED CODE */			longs = new long[shape.getNumLongs()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumFloats() > 0) {
/* GENERATED CODE */			floats = new float[shape.getNumFloats()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumDoubles() > 0) {
/* GENERATED CODE */			doubles = new double[shape.getNumDoubles()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumStrings() > 0) {
/* GENERATED CODE */			strings = new String[shape.getNumStrings()];
/* GENERATED CODE */		}
/* GENERATED CODE */		if(shape.getNumBools() > 0) {
/* GENERATED CODE */			bools = new boolean[shape.getNumBools()];
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */}