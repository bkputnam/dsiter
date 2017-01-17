package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrOperator {

	@Test
	public void testTrueTrue() {
		OrAccessor ao = new OrAccessor(
			ConstantAccessor.getBoolInstance(true),
			ConstantAccessor.getBoolInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		OrAccessor ao = new OrAccessor(
			ConstantAccessor.getBoolInstance(true),
			ConstantAccessor.getBoolInstance(false)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		OrAccessor ao = new OrAccessor(
			ConstantAccessor.getBoolInstance(false),
			ConstantAccessor.getBoolInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		OrAccessor ao = new OrAccessor(
			ConstantAccessor.getBoolInstance(false),
			ConstantAccessor.getBoolInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
