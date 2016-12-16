package blatis.operator;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bkputnam on 12/15/16.
 */
public class TestLessThanEqualsOperator {

	@Test
	public void test_int_eq_int() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			new ConstantAccessor(1),
			new ConstantAccessor(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			new ConstantAccessor(2),
			new ConstantAccessor(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			new ConstantAccessor(0),
			new ConstantAccessor(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			new ConstantAccessor(1L),
			new ConstantAccessor(1L)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			new ConstantAccessor(1F),
			new ConstantAccessor(1F)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		LessThanEqualsOperator gte = new LessThanEqualsOperator(
			new ConstantAccessor(1D),
			new ConstantAccessor(1D)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}
}
