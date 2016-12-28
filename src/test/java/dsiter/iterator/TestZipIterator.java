package dsiter.iterator;

import static org.junit.Assert.*;

import dsiter.IteratorExpectations;
import org.junit.Test;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import static dsiter.StdPipes.*;

public class TestZipIterator {

	@Test
	public void testZipIterator() throws Exception {

		IteratorCounter leftCounter = new IteratorCounter();
		IteratorCounter rightCounter1 = new IteratorCounter();
		IteratorCounter rightCounter2 = new IteratorCounter();

		IDatasetIterator leftIter = new RangeIterator(5)
			.pipe(leftCounter.getPipe())
			.pipe(rename("value", "a"));
		IDatasetIterator rightIter = new RangeIterator(10)
			.pipe(rightCounter1.getPipe())
			.pipe(stride(2))
			.pipe(rightCounter2.getPipe())
			.pipe(rename("value", "b"));

		try (IDatasetIterator it = new ZipIterator(leftIter, rightIter)) {

			ColumnDescriptor[] cds = it.getColumnDescriptors();
			assertEquals(2, cds.length);
			assertEquals("a", cds[0].getName());
			assertEquals("b", cds[1].getName());

			IRowAccessor[] cas = new IRowAccessor[]{
				cds[0].getAccessor(),
				cds[1].getAccessor(),
			};

			IteratorExpectations e = new IteratorExpectations();
			e.expectInts("a", 0, 1, 2, 3, 4);
			e.expectInts("b", 0, 2, 4, 6, 8);

			e.checkIterator(it);
		}

		assertEquals(1, leftCounter.getCloseCount());
		assertEquals(1, rightCounter1.getCloseCount());
		assertEquals(1, rightCounter2.getCloseCount());
	}

	@Test
	public void testMultiZip() throws Exception {

		int[] vals1 = new int[] { 1, 2, 3, 4, 5, };
		float[] vals2 = new float[] { 3.142f, 2.718f, 0f, 1f, -1f };
		boolean[] vals3 = new boolean[] { true, true, false, false, false };
		String[] vals4 = new String[] { "hello", "world", "foo", "bar", "baz" };

		IteratorCounter counter1 = new IteratorCounter();
		IteratorCounter counter2 = new IteratorCounter();
		IteratorCounter counter3 = new IteratorCounter();
		IteratorCounter counter4 = new IteratorCounter();

		IDatasetIterator it1 = new ArrayIterator(vals1)
			.pipe(counter1.getPipe())
			.pipe(rename("value", "a"));
		IDatasetIterator it2 = new ArrayIterator(vals2)
			.pipe(counter2.getPipe())
			.pipe(rename("value", "b"));
		IDatasetIterator it3 = new ArrayIterator(vals3)
			.pipe(counter3.getPipe())
			.pipe(rename("value", "c"));
		IDatasetIterator it4 = new ArrayIterator(vals4)
			.pipe(counter4.getPipe())
			.pipe(rename("value", "d"));

		IteratorExpectations e = new IteratorExpectations();
		e.expectInts("a", vals1);
		e.expectFloats("b", vals2);
		e.expectBools("c", vals3);
		e.expectStrings("d", vals4);

		try (
			ZipIterator it = new ZipIterator(it1, it2, it3, it4);
		) {
			e.checkIterator(it);
		}

		assertEquals(1, counter1.getCloseCount());
		assertEquals(1, counter2.getCloseCount());
		assertEquals(1, counter3.getCloseCount());
		assertEquals(1, counter4.getCloseCount());
	}

	@Test
	public void testLength() {

		IDatasetIterator zi = new ZipIterator(
			new RangeIterator(3).pipe(rename("value", "i1")),
			new RangeIterator(5).pipe(rename("value", "i2")),
			new RangeIterator(10).pipe(rename("value", "i3"))
		);

		assertEquals(3, zi.tryGetLength());
	}

	@Test
	public void testLengthNegOne() throws Exception {

		try (IDatasetIterator zi = new ZipIterator(
			new RangeIterator(3).pipe(rename("value", "i1")),
			new RangeIterator(5).pipe(rename("value", "i2")),
			new RangeIterator(10).pipe(rename("value", "i3")).pipe(filter("i3<5"))
		)) {
			assertEquals(-1, zi.tryGetLength());
		}
	}

	@Test
	public void testMultiLengthLast() throws Exception {

		IteratorExpectations e = new IteratorExpectations();
		e.expectInts("i1", new int[] { 2 });
		e.expectInts("i2", new int[] { 2 });
		e.expectInts("i3", new int[] { 2 });

		try (
			IDatasetIterator zi = new ZipIterator(
				new RangeIterator(3).pipe(rename("value", "i1")),
				new RangeIterator(5).pipe(rename("value", "i2")),
				new RangeIterator(10).pipe(rename("value", "i3")).pipe(filter("i3<5"))
			)
			.pipe(last());
		) {
			e.checkIterator(zi);
		}
	}
}