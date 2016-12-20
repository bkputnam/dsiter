package dsiter.iterator;

import dsiter.IterUtils;
import static dsiter.StdPipes.*;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLastIterator {

	@Test
	public void testLastOf5() {
		IDatasetIterator it = new LastIterator(
			new RangeIterator(5)
		);

		IterUtils.assertValues(it, "value", new Integer[] { 4 });
	}

	@Test
	public void testLastOf0() {
		IDatasetIterator it = new LastIterator(
			new RangeIterator(0)
		);

		IterUtils.assertValues(it, "value", new Integer[] { });
	}

	@Test
	public void testLengthOf5() {
		IDatasetIterator it = new LastIterator(
			new RangeIterator(5)
		);

		assertEquals(1, it.tryGetLength());
	}

	@Test
	public void testLengthOf0() {
		IDatasetIterator it = new LastIterator(
			new RangeIterator(0)
		);

		assertEquals(0, it.tryGetLength());
	}

	@Test
	public void testLengthOptimization() {
		IteratorCounter counter1 = new IteratorCounter();
		IteratorCounter counter2 = new IteratorCounter();

		IDatasetIterator it = new RangeIterator(10)
			.pipe(counter1.getPipe())
			.pipe(last())
			.pipe(counter2.getPipe());

		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();
		}

		// LastIterator shouldn't need to touch every Row if
		// the length is known ahead of time
		assertEquals(1, counter1.getGetCurrentRowCount());
		assertEquals(1, counter2.getGetCurrentRowCount());
	}

	@Test
	public void testLengthOptimization2() {
		IteratorCounter counter1 = new IteratorCounter();
		IteratorCounter counter2 = new IteratorCounter();

		IDatasetIterator it = new RangeIterator(10)
			.pipe(counter1.getPipe())
			.pipe(filter("value<5"))
			.pipe(last())
			.pipe(counter2.getPipe());

		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();
		}

		// If the length cannot be determined ahead of time, Last
		// will have to touch every Row
		assertEquals(10, counter1.getGetCurrentRowCount());
		assertEquals(1, counter2.getGetCurrentRowCount());
	}
}
