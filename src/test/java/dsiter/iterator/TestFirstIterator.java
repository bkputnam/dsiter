package dsiter.iterator;

import dsiter.IterUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestFirstIterator {

	@Test
	public void testFirstOf5() {
		IDatasetIterator it = new FirstIterator(
			new RangeIterator(5)
		);

		IterUtils.assertValues(it, "value", new Integer[] { 0 });
	}

	@Test
	public void testFirstOf0() {
		IDatasetIterator it = new FirstIterator(
			new RangeIterator(0)
		);

		IterUtils.assertValues(it, "value", new Integer[] { });
	}

	@Test
	public void testLengthOf5() {
		IDatasetIterator it = new FirstIterator(
			new RangeIterator(5)
		);

		assertEquals(1, it.tryGetLength());
	}

	@Test
	public void testLengthOf0() {
		IDatasetIterator it = new FirstIterator(
			new RangeIterator(0)
		);

		assertEquals(0, it.tryGetLength());
	}
}
