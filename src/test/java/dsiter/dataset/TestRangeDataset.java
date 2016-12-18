package dsiter.dataset;

import static org.junit.Assert.*;

import dsiter.IterUtils;
import dsiter.row.RowShape;
import org.junit.Test;

import dsiter.iterator.AbstractDatasetIterator;

public class TestRangeDataset {

	@Test
	public void testRange5() {
		AbstractDatasetIterator it = new RangeDataset(5).getIterator();
		IterUtils.assertValues(it, "value", new Integer[] { 0, 1, 2, 3, 4 });
	}

	@Test
	public void testRange0() {
		AbstractDatasetIterator it = new RangeDataset(0).getIterator();
		IterUtils.assertValues(it, "value", new Integer[0]);
	}

	@Test
	public void testShape() {

		RowShape shape = (new RangeDataset(1)).getIterator().computeShape();

		assertEquals(1, shape.getNumInts());
		assertEquals(0, shape.getNumLongs());
		assertEquals(0, shape.getNumFloats());
		assertEquals(0, shape.getNumDoubles());
		assertEquals(0, shape.getNumStrings());
		assertEquals(0, shape.getNumBools());
	}
}