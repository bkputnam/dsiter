package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAndOperator {

	@Test
	public void testTrueTrue() {
		AndOperator ao = new AndOperator(
			new ConstantAccessor(true),
			new ConstantAccessor(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		AndOperator ao = new AndOperator(
			new ConstantAccessor(true),
			new ConstantAccessor(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		AndOperator ao = new AndOperator(
			new ConstantAccessor(false),
			new ConstantAccessor(true)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		AndOperator ao = new AndOperator(
			new ConstantAccessor(false),
			new ConstantAccessor(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
