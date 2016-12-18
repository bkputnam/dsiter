package dsiter.pipe;

import static org.junit.Assert.*;

import dsiter.IteratorExpectations;
import dsiter.iterator.*;
import org.junit.Test;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnAccessor;

public class TestZipIterator {

	@Test
	public void testZipIterator() {

		IDatasetIterator leftIter = new RenameIterator(
			new RangeIterator(5),
			"value",
			"a"
		);
		IDatasetIterator rightIter = new RenameIterator(
			new StrideIterator(
				new RangeIterator(10),
				2
			),
			"value",
			"b"
		);

		IDatasetIterator it = new ZipIterator(leftIter, rightIter);

		ColumnDescriptor[] cds = it.getColumnDescriptors();
		assertEquals(2, cds.length);
		assertEquals("a", cds[0].getName());
		assertEquals("b", cds[1].getName());

		ColumnAccessor[] cas = new ColumnAccessor[] {
			cds[0].getAccessor(),
			cds[1].getAccessor(),
		};

		IteratorExpectations e = new IteratorExpectations();
		e.expectInts("a", 0, 1, 2, 3, 4);
		e.expectInts("b", 0, 2, 4, 6, 8);

		e.checkIterator(it);
	}

	@Test
	public void testMultiZip() {

		int[] vals1 = new int[] { 1, 2, 3, 4, 5, };
		float[] vals2 = new float[] { 3.142f, 2.718f, 0f, 1f, -1f };
		boolean[] vals3 = new boolean[] { true, true, false, false, false };
		String[] vals4 = new String[] { "hello", "world", "foo", "bar", "baz" };

		IDatasetIterator it1 = new RenameIterator(new ArrayIterator(vals1), "value", "a");
		IDatasetIterator it2 = new RenameIterator(new ArrayIterator(vals2), "value", "b");
		IDatasetIterator it3 = new RenameIterator(new ArrayIterator(vals3), "value", "c");
		IDatasetIterator it4 = new RenameIterator(new ArrayIterator(vals4), "value", "d");

		ZipIterator it = new ZipIterator(it1, it2, it3, it4);

		IteratorExpectations e = new IteratorExpectations();
		e.expectInts("a", vals1);
		e.expectFloats("b", vals2);
		e.expectBools("c", vals3);
		e.expectStrings("d", vals4);

		e.checkIterator(it);
	}
}