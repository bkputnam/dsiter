package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrOperator {

	@Test
	public void testTrueTrue() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getBoolInstance(true),
			ConstantAccessor.getBoolInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getBoolInstance(true),
			ConstantAccessor.getBoolInstance(false)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getBoolInstance(false),
			ConstantAccessor.getBoolInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getBoolInstance(false),
			ConstantAccessor.getBoolInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
