package blatis.operator;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrOperator {

	@Test
	public void testTrueTrue() {
		OrOperator ao = new OrOperator(
			new ConstantAccessor(true),
			new ConstantAccessor(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		OrOperator ao = new OrOperator(
			new ConstantAccessor(true),
			new ConstantAccessor(false)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		OrOperator ao = new OrOperator(
			new ConstantAccessor(false),
			new ConstantAccessor(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		OrOperator ao = new OrOperator(
			new ConstantAccessor(false),
			new ConstantAccessor(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
