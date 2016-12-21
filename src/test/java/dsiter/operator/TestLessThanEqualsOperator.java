package dsiter.operator;

import dsiter.IterUtils;
import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.RangeIterator;
import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static dsiter.StdPipes.filter;
import static org.junit.Assert.assertEquals;

public class TestLessThanEqualsOperator {

	@Test
	public void test_int_eq_int() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			ConstantAccessor.getInstance(1),
			ConstantAccessor.getInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			ConstantAccessor.getInstance(2),
			ConstantAccessor.getInstance(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			ConstantAccessor.getInstance(0),
			ConstantAccessor.getInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			ConstantAccessor.getInstance(1L),
			ConstantAccessor.getInstance(1L)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			ConstantAccessor.getInstance(1F),
			ConstantAccessor.getInstance(1F)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			ConstantAccessor.getInstance(1D),
			ConstantAccessor.getInstance(1D)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void testParser() {
		IDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value<=5"));
		IterUtils.assertValues(iter, "value", new Integer[] { 0, 1, 2, 3, 4, 5 });
	}
}
