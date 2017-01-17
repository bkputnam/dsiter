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
		GreaterThanEqualsAccessor gte = new GreaterThanEqualsAccessor(
			ConstantAccessor.getIntInstance(1),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		GreaterThanEqualsAccessor gte = new GreaterThanEqualsAccessor(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		GreaterThanEqualsAccessor gte = new GreaterThanEqualsAccessor(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		GreaterThanEqualsAccessor gte = new GreaterThanEqualsAccessor(
			ConstantAccessor.getLongInstance(1L),
			ConstantAccessor.getLongInstance(1L)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		GreaterThanEqualsAccessor gte = new GreaterThanEqualsAccessor(
			ConstantAccessor.getFloatInstance(1F),
			ConstantAccessor.getFloatInstance(1F)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		GreaterThanEqualsAccessor gte = new GreaterThanEqualsAccessor(
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
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_jsdate() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_jsdate() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_jsdate_eq_int() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getIntInstance(0)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_int() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
			ConstantAccessor.getIntInstance(0)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_int() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getIntInstance(1)
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_jsdate_eq_long() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getLongInstance(0L)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_long() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
			ConstantAccessor.getLongInstance(0L)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_long() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
			ConstantAccessor.getLongInstance(1L)
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_eq_jsdate() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_int_gt_jsdate() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getIntInstance(1),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_int_lt_jsdate() {
		GreaterThanEqualsAccessor op = new GreaterThanEqualsAccessor(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}
}
