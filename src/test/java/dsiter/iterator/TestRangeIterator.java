package dsiter.iterator;

import static org.junit.Assert.*;

import dsiter.IterUtils;
import dsiter.pipe.SkipPipe;
import dsiter.row.Row;
import org.junit.Test;

import dsiter.row.RowShape;

public class TestRangeIterator {

	@Test
	public void testRange5() throws Exception {
		try (RangeIterator ri = new RangeIterator(5)) {
			IterUtils.assertValues(
				ri,
				"value",
				new Integer[]{0, 1, 2, 3, 4}
			);
		}
	}

	@Test
	public void testRange5To10() throws Exception {
		try (RangeIterator ri = new RangeIterator(5, 10)) {
			IterUtils.assertValues(
				ri,
				"value",
				new Integer[]{5, 6, 7, 8, 9}
			);
		}
	}

	@Test
	public void testMinInt() throws Exception {
		try (RangeIterator ri = new RangeIterator(Integer.MIN_VALUE, Integer.MIN_VALUE+5)) {
			IterUtils.assertValues(
				ri,
				"value",
				new Integer[]{
					Integer.MIN_VALUE + 0,
					Integer.MIN_VALUE + 1,
					Integer.MIN_VALUE + 2,
					Integer.MIN_VALUE + 3,
					Integer.MIN_VALUE + 4
				}
			);
		}
	}

	@Test
	public void testMaxInt() throws Exception {
		try (RangeIterator ri = new RangeIterator(Integer.MAX_VALUE-5, Integer.MAX_VALUE)) {
			IterUtils.assertValues(
				ri,
				"value",
				new Integer[]{
					Integer.MAX_VALUE - 5,
					Integer.MAX_VALUE - 4,
					Integer.MAX_VALUE - 3,
					Integer.MAX_VALUE - 2,
					Integer.MAX_VALUE - 1
				}
			);
		}
	}


	//@Test
	public void testAllInts() {
		// This is mostly just a test to see how long a large RangeIterator
		// takes to iterate
		long startMs, count;
		long expectedCount = (long) Integer.MAX_VALUE - (long) Integer.MIN_VALUE;
		try (RangeIterator it = new RangeIterator(Integer.MIN_VALUE, Integer.MAX_VALUE) ) {
			int val = Integer.MIN_VALUE;
			count = 0;
			startMs = System.currentTimeMillis();
			while (it.tryMoveNext()) {
				Row r = it.getCurrentRow();
				assertEquals(val, r.ints[0]);
				val++;
				count++;
			}
		}
		System.out.println("testAllInts finished in " + ((System.currentTimeMillis() - startMs)/1000D) + " seconds");

		assertEquals(expectedCount, count);
	}

	@Test
	public void testRange0() throws Exception {
		try (RangeIterator ri = new RangeIterator(0)) {
			IterUtils.assertValues(
				ri,
				"value",
				new Integer[]{}
			);
		}
	}

	@Test
	public void testShape() {

		try (RangeIterator ri = new RangeIterator(1)) {
			RowShape shape = (ri).computeShape();

			assertEquals(1, shape.getNumInts());
			assertEquals(0, shape.getNumLongs());
			assertEquals(0, shape.getNumFloats());
			assertEquals(0, shape.getNumDoubles());
			assertEquals(0, shape.getNumStrings());
			assertEquals(0, shape.getNumBools());
		}
	}

	@Test
	public void testShape0() {

		try (RangeIterator ri = new RangeIterator(0)) {
			RowShape shape = (ri).computeShape();

			assertEquals(1, shape.getNumInts());
			assertEquals(0, shape.getNumLongs());
			assertEquals(0, shape.getNumFloats());
			assertEquals(0, shape.getNumDoubles());
			assertEquals(0, shape.getNumStrings());
			assertEquals(0, shape.getNumBools());
		}
	}

	@Test
	public void testLength() {
		try (RangeIterator it = new RangeIterator(5, 10)) {
			assertEquals(5, it.tryGetLength());
		}
	}

	@Test
	public void tryAbsorbSkip() throws Exception {
		try (RangeIterator ri = new RangeIterator(10)) {
			assertEquals(true, ri.tryAbsorb(new SkipPipe(5)));
			IterUtils.assertValues(ri, "value", new Integer[] { 5, 6, 7, 8, 9 });
		}
	}
}