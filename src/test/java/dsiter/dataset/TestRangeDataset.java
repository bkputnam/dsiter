package dsiter.dataset;

import static org.junit.Assert.*;

import dsiter.IterUtils;
import dsiter.iterator.IDatasetIterator;
import dsiter.row.RowShape;
import org.junit.Test;

public class TestRangeDataset {

	@Test
	public void testRange5() throws Exception {
		try (IDatasetIterator it = new RangeDataset(5).getIterator()) {
			IterUtils.assertValues(it, "value", new Integer[]{0, 1, 2, 3, 4});
		}
	}

	@Test
	public void testRange5To10() throws Exception {
		try (IDatasetIterator it = new RangeDataset(5, 10).getIterator()) {
			IterUtils.assertValues(it, "value", new Integer[]{5, 6, 7, 8, 9});
		}
	}

	@Test
	public void testRange0() throws Exception {
		try (IDatasetIterator it = new RangeDataset(0).getIterator()) {
			IterUtils.assertValues(it, "value", new Integer[0]);
		}
	}

	@Test
	public void testShape() throws Exception {

		try (IDatasetIterator it = new RangeDataset(1).getIterator()) {
			RowShape shape = it.computeShape();

			assertEquals(1, shape.getNumInts());
			assertEquals(0, shape.getNumLongs());
			assertEquals(0, shape.getNumFloats());
			assertEquals(0, shape.getNumDoubles());
			assertEquals(0, shape.getNumStrings());
			assertEquals(0, shape.getNumBools());
		}
	}
}