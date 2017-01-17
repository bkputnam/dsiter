package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaretOperator {
	@Test
	public void testInt() {
		CaretAccessor co = new CaretAccessor(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(3)
		);

		assertEquals(8, co.getValueFromRow(new Row()));
	}

	@Test
	public void testLong() {
		CaretAccessor co = new CaretAccessor(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getLongInstance(3L)
		);

		assertEquals(8L, co.getValueFromRow(new Row()));
	}

	@Test
	public void testFloat() {
		CaretAccessor co = new CaretAccessor(
			ConstantAccessor.getFloatInstance(2F),
			ConstantAccessor.getFloatInstance(3F)
		);

		assertEquals(8F, co.getValueFromRow(new Row()));
	}

	@Test
	public void testDouble() {
		CaretAccessor co = new CaretAccessor(
			ConstantAccessor.getDoubleInstance(2D),
			ConstantAccessor.getDoubleInstance(3D)
		);

		assertEquals(8D, co.getValueFromRow(new Row()));
	}
}
