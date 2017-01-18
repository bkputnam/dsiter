package dsiter.pipe;

import dsiter.IterUtils;
import dsiter.IteratorExpectations;
import dsiter.accessor.ConstantAccessor;
import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.RangeIterator;
import dsiter.accessor.EqualsAccessor;
import dsiter.accessor.ModuloAccessor;
import dsiter.parser.ast.*;
import dsiter.row.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPipes {

	@Test
	public void testStride5() throws Exception {
		try (IDatasetIterator it = new RangeIterator(25)
				.pipe(new StridePipe(5))
		) {
			IterUtils.assertValues(it, "value", new Integer[]{0, 5, 10, 15, 20});
		}
	}

	@Test
	public void testLastPipe() throws Exception {
		try (IDatasetIterator it = new RangeIterator(25)
				.pipe(new LastPipe())
		) {
			IterUtils.assertValues(it, "value", new Integer[]{24});
		}
	}

	@Test
	public void testFilterPipe() throws Exception {
		AstNode isEvenPredicate = new EqualsOperator(
			new ModuloOperator(
				new ColumnOperator("value"),
				new ConstantOperator.INT(2)
			),
			new ConstantOperator.INT(0)
		);

		try (IDatasetIterator it = new RangeIterator(10)
				.pipe(new FilterPipe(isEvenPredicate))
		) {
			IterUtils.assertValues(it, "value", new Integer[]{0, 2, 4, 6, 8});
		}
	}

	@Test
	public void testFirstAndSkipPipes() throws Exception {
		try (IDatasetIterator it = new RangeIterator(10)
				.pipe(new SkipPipe(5))
				.pipe(new FirstPipe())
		) {
			IterUtils.assertValues(it, "value", new Integer[]{5});
		}
	}

	@Test
	public void testRenamePipe() throws Exception {
		try (IDatasetIterator it = new RangeIterator(5)
				.pipe(new RenamePipe("value", "a"))
		) {
			IterUtils.assertValues(it, "a", new Integer[]{0, 1, 2, 3, 4});
		}
	}

	@Test
	public void testZipPipe() throws Exception {
		try (IDatasetIterator it = new RangeIterator(5)
			.pipe(
				new ZipPipe(
					ArrayIterator.fromInts(1, 3, 5, 7, 9)
						.pipe(new RenamePipe("value", "a"))
				)
			)
		) {
			IteratorExpectations e = new IteratorExpectations();
			e.expectInts("value", 0, 1, 2, 3, 4);
			e.expectInts("a", 1, 3, 5, 7, 9);
			e.checkIterator(it);
		}
	}

	@Test
	public void testTakeWhilePipe() throws Exception {
		try (
			IDatasetIterator it = new RangeIterator(10)
				.pipe(new TakeWhilePipe("value != 5"))
		) {
			IterUtils.assertValues(it, "value", new Integer[] { 0, 1, 2, 3, 4 });
		}
	}

	@Test
	public void testSkipWhilePipe() throws Exception {
		try (
			IDatasetIterator it = new RangeIterator(10)
				.pipe(new SkipWhilePipe("value != 5"))
		) {
			IterUtils.assertValues(it, "value", new Integer[] { 5, 6, 7, 8, 9 });
		}
	}
}
