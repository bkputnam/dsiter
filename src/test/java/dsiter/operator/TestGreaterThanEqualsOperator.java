package dsiter.operator;

import dsiter.IterUtils;
import dsiter.iterator.AbstractDatasetIterator;
import dsiter.iterator.RangeIterator;
import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static dsiter.StdPipes.filter;
import static org.junit.Assert.*;

public class TestGreaterThanEqualsOperator {

	@Test
	public void test_int_eq_int() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			new ConstantAccessor(1),
			new ConstantAccessor(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			new ConstantAccessor(2),
			new ConstantAccessor(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			new ConstantAccessor(0),
			new ConstantAccessor(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			new ConstantAccessor(1L),
			new ConstantAccessor(1L)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			new ConstantAccessor(1F),
			new ConstantAccessor(1F)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			new ConstantAccessor(1D),
			new ConstantAccessor(1D)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void testParser() {
		AbstractDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value>=15"));
		IterUtils.assertValues(iter, "value", new Integer[] { 15, 16, 17, 18, 19 });
	}
}
