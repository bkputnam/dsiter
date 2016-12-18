package dsiter.iterator;

import static org.junit.Assert.*;

import dsiter.IterUtils;
import org.junit.Test;

import dsiter.row.RowShape;

public class TestRangeIterator {

	@Test
	public void testRange5() {
		IterUtils.assertValues(
			new RangeIterator(5),
			"value",
			new Integer[] { 0, 1, 2, 3, 4 }
		);
	}

	@Test
	public void testRange0() {
		IterUtils.assertValues(
			new RangeIterator(0),
			"value",
			new Integer[] {}
		);
	}

	@Test
	public void testShape() {

		RowShape shape = (new RangeIterator(1)).computeShape();

		assertEquals(1, shape.getNumInts());
		assertEquals(0, shape.getNumLongs());
		assertEquals(0, shape.getNumFloats());
		assertEquals(0, shape.getNumDoubles());
		assertEquals(0, shape.getNumStrings());
		assertEquals(0, shape.getNumBools());
	}

	@Test
	public void testShape0() {

		RowShape shape = (new RangeIterator(0)).computeShape();

		assertEquals(1, shape.getNumInts());
		assertEquals(0, shape.getNumLongs());
		assertEquals(0, shape.getNumFloats());
		assertEquals(0, shape.getNumDoubles());
		assertEquals(0, shape.getNumStrings());
		assertEquals(0, shape.getNumBools());
	}
}