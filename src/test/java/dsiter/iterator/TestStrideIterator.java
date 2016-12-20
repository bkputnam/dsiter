package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.RangeIterator;
import org.junit.Test;
import static org.junit.Assert.*;

import dsiter.iterator.StrideIterator;
import dsiter.iterator.LastIterator;

public class TestStrideIterator {

	@Test
	public void testStride4() {

		IDatasetIterator it = new StrideIterator(
			new RangeIterator(10),
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

		IDatasetIterator it = new LastIterator(
			new StrideIterator(
				new RangeIterator(10),
				4
			)
		);

		IterUtils.assertValues(
			it,
			"value",
			new Integer[] { 8 }
		);
	}

	@Test
	public void testLength() {

		IDatasetIterator it = new StrideIterator(
			new RangeIterator(10),
			4
		);

		assertEquals(3, it.tryGetLength());
	}
}