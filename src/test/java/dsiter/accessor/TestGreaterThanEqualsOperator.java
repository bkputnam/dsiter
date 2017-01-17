package dsiter.accessor;

import dsiter.IterUtils;
import dsiter.iterator.IDatasetIterator;
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
			ConstantAccessor.getIntInstance(1),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			ConstantAccessor.getLongInstance(1L),
			ConstantAccessor.getLongInstance(1L)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			ConstantAccessor.getFloatInstance(1F),
			ConstantAccessor.getFloatInstance(1F)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		GreaterThanEqualsOperator gte = new GreaterThanEqualsOperator(
			ConstantAccessor.getDoubleInstance(1D),
			ConstantAccessor.getDoubleInstance(1D)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void testParser() throws Exception {
		IDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value>=15"));
		IterUtils.assertValues(iter, "value", new Integer[] { 15, 16, 17, 18, 19 });
	}

	@Test
	public void test_jsdate_eq_jsdate() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_jsdate() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_jsdate() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_jsdate_eq_int() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getIntInstance(0)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_int() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
			ConstantAccessor.getIntInstance(0)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_int() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getIntInstance(1)
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_jsdate_eq_long() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getLongInstance(0L)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_long() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
			ConstantAccessor.getLongInstance(0L)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_long() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getLongInstance(1L)
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_eq_jsdate() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_int_gt_jsdate() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getIntInstance(1),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_int_lt_jsdate() {
		GreaterThanEqualsOperator op = new GreaterThanEqualsOperator(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}
}
