package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrOperator {

	@Test
	public void testTrueTrue() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getInstance(true),
			ConstantAccessor.getInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getInstance(true),
			ConstantAccessor.getInstance(false)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getInstance(false),
			ConstantAccessor.getInstance(true)
		);

		assertEquals(true, ao.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		OrOperator ao = new OrOperator(
			ConstantAccessor.getInstance(false),
			ConstantAccessor.getInstance(false)
		);

		assertEquals(false, ao.getValueFromRow(new Row()));
	}
}
