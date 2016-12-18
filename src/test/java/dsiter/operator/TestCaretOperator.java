package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaretOperator {
	@Test
	public void testInt() {
		CaretOperator co = new CaretOperator(
			new ConstantAccessor(2),
			new ConstantAccessor(3)
		);

		assertEquals(8, co.getValueFromRow(new Row()));
	}

	@Test
	public void testLong() {
		CaretOperator co = new CaretOperator(
			new ConstantAccessor(2L),
			new ConstantAccessor(3L)
		);

		assertEquals(8L, co.getValueFromRow(new Row()));
	}

	@Test
	public void testFloat() {
		CaretOperator co = new CaretOperator(
			new ConstantAccessor(2F),
			new ConstantAccessor(3F)
		);

		assertEquals(8F, co.getValueFromRow(new Row()));
	}

	@Test
	public void testDouble() {
		CaretOperator co = new CaretOperator(
			new ConstantAccessor(2D),
			new ConstantAccessor(3D)
		);

		assertEquals(8D, co.getValueFromRow(new Row()));
	}
}
