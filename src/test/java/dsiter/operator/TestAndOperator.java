package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAndOperator {

	@Test
	public void testTrueTrue() {
		AndOperator ao = new AndOperator(
			ConstantAccessor.getInstance(true),
			ConstantAccessor.getInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		AndOperator ao = new AndOperator(
			ConstantAccessor.getInstance(true),
			ConstantAccessor.getInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		AndOperator ao = new AndOperator(
			ConstantAccessor.getInstance(false),
			ConstantAccessor.getInstance(true)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		AndOperator ao = new AndOperator(
			ConstantAccessor.getInstance(false),
			ConstantAccessor.getInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
