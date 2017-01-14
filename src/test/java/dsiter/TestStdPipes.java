package dsiter;

import dsiter.iterator.*;
import org.junit.Test;

import static dsiter.StdPipes.*;

public class TestStdPipes {

	@Test
	public void testFilterPipe() throws Exception {
		try (IDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value%3=0"))
		) {
			IterUtils.assertValues(iter, "value", new Integer[]{0, 3, 6, 9, 12, 15, 18});
		}
	}

	@Test
	public void testFirstPipe() throws Exception {
		try (IDatasetIterator iter = new RangeIterator(20)
			.pipe(first())
		) {
			IterUtils.assertValues(iter, "value", new Integer[]{0});
		}
	}

	@Test
	public void testLastPipe() throws Exception {
		try (IDatasetIterator iter = new RangeIterator(20)
			.pipe(last())
		) {
			IterUtils.assertValues(iter, "value", new Integer[]{19});
		}
	}

	@Test
	public void testRenamePipe() throws Exception {
		try (IDatasetIterator iter = new RangeIterator(5)
			.pipe(rename("value", "i"))
		) {
			IterUtils.assertValues(iter, "i", new Integer[]{0, 1, 2, 3, 4});
		}
	}

	@Test
	public void testSkipPipe() throws Exception {
		try (IDatasetIterator iter = new RangeIterator(10)
			.pipe(skip(5))
		) {
			IterUtils.assertValues(iter, "value", new Integer[]{5, 6, 7, 8, 9});
		}
	}

	@Test
	public void testStridePipe() throws Exception {
		try (IDatasetIterator iter = new RangeIterator(10)
			.pipe(stride(3))
		) {
			IterUtils.assertValues(iter, "value", new Integer[]{0, 3, 6, 9});
		}
	}

	@Test
	public void testZipPipe() throws Exception {
		int[] intVals = new int[]{ 0, 1, 2, 3 };
		String[] strVals = new String[]{ "0", "1", "2", "3" };
		IDatasetIterator iter1 = new ArrayIterator(intVals);
		IDatasetIterator iter2 = new ArrayIterator(strVals).pipe(rename("value", "s"));

		try (IDatasetIterator zi = iter1.pipe(zip(iter2))) {

			IteratorExpectations e = new IteratorExpectations();
			e.expectInts("value", intVals);
			e.expectStrings("s", strVals);
			e.checkIterator(zi);
		}
	}

	@Test
	public void testTake() throws Exception {
		try (IDatasetIterator it = new RangeIterator(10).pipe(take(5))) {
			IterUtils.assertValues(it, "value", new Integer[]{0, 1, 2, 3, 4});
		}
	}

	@Test
	public void testTakeWhile() throws Exception {
		try (
			IDatasetIterator it = new RangeIterator(10)
				.pipe(takeWhile("value != 6"))
		) {
			IterUtils.assertValues(it, "value", new Integer[] { 0, 1, 2, 3, 4, 5 });
		}
	}
}
