package blatis.operator;

import blatis.IterUtils;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.RangeIterator;
import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;

import static blatis.StdPipes.filter;
import static org.junit.Assert.assertEquals;

/**
 * Created by bkputnam on 12/15/16.
 */
public class TestGreaterThanOperator {

	@Test
	public void test_int_eq_int() {
		GreaterThanOperator gte = new GreaterThanOperator(
			new ConstantAccessor(1),
			new ConstantAccessor(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		GreaterThanOperator gte = new GreaterThanOperator(
			new ConstantAccessor(2),
			new ConstantAccessor(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		GreaterThanOperator gte = new GreaterThanOperator(
			new ConstantAccessor(0),
			new ConstantAccessor(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		GreaterThanOperator gte = new GreaterThanOperator(
			new ConstantAccessor(1L),
			new ConstantAccessor(1L)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		GreaterThanOperator gte = new GreaterThanOperator(
			new ConstantAccessor(1F),
			new ConstantAccessor(1F)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		GreaterThanOperator gte = new GreaterThanOperator(
			new ConstantAccessor(1D),
			new ConstantAccessor(1D)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void testParser() {
		AbstractDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value>15"));
		IterUtils.assertValues(iter, "value", new Integer[] { 16, 17, 18, 19 });
	}
}
