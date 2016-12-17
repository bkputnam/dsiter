package blatis;

import blatis.iterator.*;
import blatis.row.ColumnAccessor;
import blatis.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

import static blatis.StdPipes.*;

public class TestStdPipes {

	@Test
	public void testFilterPipe() {
		AbstractDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value%3=0"));
		IterUtils.assertValues(iter, "value", new Integer[] { 0, 3, 6, 9, 12, 15, 18 });
	}

	@Test
	public void testFirstPipe() {
		AbstractDatasetIterator iter = new RangeIterator(20)
			.pipe(first());
		IterUtils.assertValues(iter, "value", new Integer[] { 0 });
	}

	@Test
	public void testLastPipe() {
		AbstractDatasetIterator iter = new RangeIterator(20)
			.pipe(last());
		IterUtils.assertValues(iter, "value", new Integer[] { 19 });
	}

	@Test
	public void testRenamePipe() {
		AbstractDatasetIterator iter = new RangeIterator(5)
			.pipe(rename("value", "i"));
		IterUtils.assertValues(iter, "i", new Integer[] { 0, 1, 2, 3, 4 });
	}

	@Test
	public void testSkipPipe() {
		AbstractDatasetIterator iter = new RangeIterator(10)
			.pipe(skip(5));
		IterUtils.assertValues(iter, "value", new Integer[] { 5, 6, 7, 8, 9 });
	}

	@Test
	public void testStridePipe() {
		AbstractDatasetIterator iter = new RangeIterator(10)
			.pipe(stride(3));
		IterUtils.assertValues(iter, "value", new Integer[] { 0, 3, 6, 9 });
	}

	@Test
	public void testZipPipe() {
		int[] intVals = new int[]{ 0, 1, 2, 3 };
		String[] strVals = new String[]{ "0", "1", "2", "3" };
		AbstractDatasetIterator iter1 = new ArrayIterator(intVals);
		AbstractDatasetIterator iter2 = new ArrayIterator(strVals).pipe(rename("value", "s"));

		AbstractDatasetIterator zi = iter1.pipe(zip(iter2));

		IteratorExpectations e = new IteratorExpectations();
		e.expectInts("value", intVals);
		e.expectStrings("s", strVals);
		e.checkIterator(zi);
	}
}
