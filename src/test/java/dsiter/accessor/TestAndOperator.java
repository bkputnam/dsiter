package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAndOperator {

	@Test
	public void testTrueTrue() {
		AndAccessor ao = new AndAccessor(
			ConstantAccessor.getBoolInstance(true),
			ConstantAccessor.getBoolInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		AndAccessor ao = new AndAccessor(
			ConstantAccessor.getBoolInstance(true),
			ConstantAccessor.getBoolInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		AndAccessor ao = new AndAccessor(
			ConstantAccessor.getBoolInstance(false),
			ConstantAccessor.getBoolInstance(true)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		AndAccessor ao = new AndAccessor(
			ConstantAccessor.getBoolInstance(false),
			ConstantAccessor.getBoolInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
