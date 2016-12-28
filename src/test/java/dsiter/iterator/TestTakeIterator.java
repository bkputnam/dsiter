package dsiter.iterator;

import dsiter.IterUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTakeIterator {

	@Test
	public void testTake5() throws Exception {
		try (TakeIterator ti = new TakeIterator(
			new RangeIterator(10),
			5
		)) {
			IterUtils.assertValues(ti, "value", new Integer[]{0, 1, 2, 3, 4});
		}
	}

	@Test
	public void testLen10() throws Exception {
		try (TakeIterator ti = new TakeIterator(
			new RangeIterator(10),
			10
		)) {
			assertEquals(10, ti.tryGetLength());
		}
	}

	@Test
	public void testLen5of10() throws Exception {
		try (TakeIterator ti = new TakeIterator(
			new RangeIterator(10),
			5
		)) {
			assertEquals(5, ti.tryGetLength());
		}
	}

	@Test
	public void testLen10of5() throws Exception {
		try (TakeIterator ti = new TakeIterator(
			new RangeIterator(5),
			10
		)) {
			assertEquals(5, ti.tryGetLength());
		}
	}
}
