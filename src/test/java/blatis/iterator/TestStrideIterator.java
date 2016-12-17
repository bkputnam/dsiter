package blatis.pipe;

import blatis.IterUtils;
import org.junit.Test;

import blatis.dataset.RangeDataset;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.StrideIterator;
import blatis.iterator.LastIterator;

public class TestStrideIterator {

	@Test
	public void testStride4() {

		AbstractDatasetIterator it = new StrideIterator(
			(new RangeDataset(10)).getIterator(),
			4
		);

		IterUtils.assertValues(
			it,
			"value",
			new Integer[] { 0, 4, 8 }
		);
	}

	@Test
	public void testStrideLast() {

		AbstractDatasetIterator it = new LastIterator(
			new StrideIterator(
				(new RangeDataset(10)).getIterator(),
				4
			)
		);

		IterUtils.assertValues(
			it,
			"value",
			new Integer[] { 8 }
		);
	}
}