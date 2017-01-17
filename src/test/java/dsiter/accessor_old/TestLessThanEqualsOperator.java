package dsiter.accessor_old;

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
		LessThanEqualsAccessor gte = new LessThanEqualsAccessor(
			ConstantAccessor.getIntInstance(1),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		LessThanEqualsAccessor gte = new LessThanEqualsAccessor(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		LessThanEqualsAccessor gte = new LessThanEqualsAccessor(
			ConstantAccessor.getIntInstance(0),
			ConstantAccessor.getIntInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		LessThanEqualsAccessor gte = new LessThanEqualsAccessor(
			ConstantAccessor.getLongInstance(1L),
			ConstantAccessor.getLongInstance(1L)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		LessThanEqualsAccessor gte = new LessThanEqualsAccessor(
			ConstantAccessor.getFloatInstance(1F),
			ConstantAccessor.getFloatInstance(1F)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		LessThanEqualsAccessor gte = new LessThanEqualsAccessor(
			ConstantAccessor.getDoubleInstance(1D),
			ConstantAccessor.getDoubleInstance(1D)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void testParser() throws Exception {
		IDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value<=5"));
		IterUtils.assertValues(iter, "value", new Integer[] { 0, 1, 2, 3, 4, 5 });
	}

	@Test
	public void test_jsdate_eq_int() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getIntInstance(0)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_int() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
				ConstantAccessor.getIntInstance(0)
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_int() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getIntInstance(1)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_jsdate_eq_long() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getLongInstance(0L)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_gt_long() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z"),
				ConstantAccessor.getLongInstance(0L)
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_jsdate_lt_long() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getLongInstance(1L)
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_eq_jsdate() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getIntInstance(0),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_int_gt_jsdate() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getIntInstance(1),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(false, op.getValueFromRow(new Row()));
	}
	@Test
	public void test_int_lt_jsdate() {
		LessThanEqualsAccessor op = new LessThanEqualsAccessor(
				ConstantAccessor.getIntInstance(0),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(true, op.getValueFromRow(new Row()));
	}
}
