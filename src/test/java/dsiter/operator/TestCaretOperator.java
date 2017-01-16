package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaretOperator {
	@Test
	public void testInt() {
		CaretOperator co = new CaretOperator(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(3)
		);

		assertEquals(8, co.getValueFromRow(new Row()));
	}

	@Test
	public void testLong() {
		CaretOperator co = new CaretOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getLongInstance(3L)
		);

		assertEquals(8L, co.getValueFromRow(new Row()));
	}

	@Test
	public void testFloat() {
		CaretOperator co = new CaretOperator(
			ConstantAccessor.getFloatInstance(2F),
			ConstantAccessor.getFloatInstance(3F)
		);

		assertEquals(8F, co.getValueFromRow(new Row()));
	}

	@Test
	public void testDouble() {
		CaretOperator co = new CaretOperator(
			ConstantAccessor.getDoubleInstance(2D),
			ConstantAccessor.getDoubleInstance(3D)
		);

		assertEquals(8D, co.getValueFromRow(new Row()));
	}
}
