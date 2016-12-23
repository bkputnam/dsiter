package dsiter.operator;

import dsiter.IterUtils;
import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.RangeIterator;
import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static dsiter.StdPipes.filter;
import static org.junit.Assert.assertEquals;

/**
 * Created by bkputnam on 12/15/16.
 */
public class TestGreaterThanOperator {

	@Test
	public void test_int_eq_int() {
		GreaterThanOperator gte = new GreaterThanOperator(
			ConstantAccessor.getInstance(1),
			ConstantAccessor.getInstance(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_gt_int() {
		GreaterThanOperator gte = new GreaterThanOperator(
			ConstantAccessor.getInstance(2),
			ConstantAccessor.getInstance(1)
		);

		assertEquals(true, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_int_lt_int() {
		GreaterThanOperator gte = new GreaterThanOperator(
			ConstantAccessor.getInstance(0),
			ConstantAccessor.getInstance(1)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_long_eq_long() {
		GreaterThanOperator gte = new GreaterThanOperator(
			ConstantAccessor.getInstance(1L),
			ConstantAccessor.getInstance(1L)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_float_eq_float() {
		GreaterThanOperator gte = new GreaterThanOperator(
			ConstantAccessor.getInstance(1F),
			ConstantAccessor.getInstance(1F)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void test_double_eq_double() {
		GreaterThanOperator gte = new GreaterThanOperator(
			ConstantAccessor.getInstance(1D),
			ConstantAccessor.getInstance(1D)
		);

		assertEquals(false, gte.getValueFromRow(new Row()));
	}

	@Test
	public void testParser() throws Exception {
		IDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value>15"));
		IterUtils.assertValues(iter, "value", new Integer[] { 16, 17, 18, 19 });
	}
}
