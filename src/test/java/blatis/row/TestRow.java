package blatis.row;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * Created by bkputnam on 12/9/16.
 */
public class TestRow {

	@Test
	public void testNullCopies() {
		Row row1 = new Row(new int[] { 2, 3, 4});
		Row row2 = new Row(new float[] {5, 6, 7});

		Row.copyTo(row1, row2);
		assertEquals(null, row2.floats);
		assertArrayEquals(new int[] { 2, 3, 4}, row2.ints);
	}

	@Test
	public void allTogetherNow() {
		Row src = new Row();
		src.bools = new boolean[] { true, true, false, true };
		src.strings = new String[] { "foo", "bar", "baz" };
		src.doubles = new double[] { 3.14, 2.71, -1 };
		src.floats = new float[] { 6.28f, 5.42f, -2 };
		src.ints = new int[] { 1, 2, 3, 4, 5, 6 };
		src.longs = new long[] { 1234567890123456789L };

		Row dest = new Row();
		Row.copyTo(src, dest);

		// This bit is auto-generated to make sure we didn't miss any arrays
		// in the test
		
			
				assertArrayEquals(src.ints, dest.ints);
			
		
			
				assertArrayEquals(src.longs, dest.longs);
			
		
			
				assertArrayEquals(src.floats, dest.floats, 0.0f);
			
		
			
				assertArrayEquals(src.doubles, dest.doubles, 0.0f);
			
		
			
				assertArrayEquals(src.strings, dest.strings);
			
		
			
				assertArrayEquals(src.bools, dest.bools);
			
		
	}
}
