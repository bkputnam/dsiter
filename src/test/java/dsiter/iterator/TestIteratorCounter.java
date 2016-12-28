package dsiter.iterator;

import static dsiter.StdPipes.*;

import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestIteratorCounter {

	@Test
	public void testIteratorCounter() throws Exception {
		IteratorCounter counter1 = new IteratorCounter();
		IteratorCounter counter2 = new IteratorCounter();

		IDatasetIterator it = new RangeIterator(10)
			.pipe(counter1.getPipe())
			.pipe(stride(3)) // 0 3 6 9
			.pipe(counter2.getPipe());

		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();
		}

		assertEquals(10, counter1.getTryMoveNextCount());
		assertEquals(4, counter1.getGetCurrentRowCount());

		assertEquals(4, counter2.getTryMoveNextCount());
		assertEquals(4, counter2.getGetCurrentRowCount());
	}

	@Test
	public void testGetColumnDescriptorsCount() {

		IteratorCounter counter = new IteratorCounter();

		IDatasetIterator it = new RangeIterator(10)
			.pipe(counter.getPipe());

		assertEquals(0, counter.getTryMoveNextCount());
		assertEquals(0, counter.getGetCurrentRowCount());
		assertEquals(0, counter.getGetColumnDescriptorsCount());
		assertEquals(0, counter.getTryGetLengthCount());

		ColumnDescriptor[] cds = it.getColumnDescriptors();

		assertEquals(0, counter.getTryMoveNextCount());
		assertEquals(0, counter.getGetCurrentRowCount());
		assertEquals(1, counter.getGetColumnDescriptorsCount());
		assertEquals(0, counter.getTryGetLengthCount());
	}

	@Test
	public void testGetTryGetLengthCount() {

		IteratorCounter counter = new IteratorCounter();

		IDatasetIterator it = new RangeIterator(10)
			.pipe(counter.getPipe());

		assertEquals(0, counter.getTryMoveNextCount());
		assertEquals(0, counter.getGetCurrentRowCount());
		assertEquals(0, counter.getGetColumnDescriptorsCount());
		assertEquals(0, counter.getTryGetLengthCount());

		long len = it.tryGetLength();

		assertEquals(0, counter.getTryMoveNextCount());
		assertEquals(0, counter.getGetCurrentRowCount());
		assertEquals(0, counter.getGetColumnDescriptorsCount());
		assertEquals(1, counter.getTryGetLengthCount());
	}

	@Test
	public void testClosesCount_try() throws Exception {
		IteratorCounter counter = new IteratorCounter();

		try (IDatasetIterator it = new RangeIterator(5).pipe(counter.getPipe())) {
			int index = 0;
			while(it.tryMoveNext()) {
				Row r = it.getCurrentRow();
				assertEquals(index++, r.ints[0]);
			}
		}

		assertEquals(1, counter.getCloseCount());
	}

	@Test
	public void testClosesCount_manual() throws Exception {
		IteratorCounter counter = new IteratorCounter();
		IDatasetIterator it = new RangeIterator(5).pipe(counter.getPipe());

		int index = 0;
		while(it.tryMoveNext()) {
			Row r = it.getCurrentRow();
			assertEquals(index++, r.ints[0]);
		}
		it.close();

		assertEquals(1, counter.getCloseCount());
	}
}
