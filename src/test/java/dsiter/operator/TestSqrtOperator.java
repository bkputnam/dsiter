package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSqrtOperator {
	@Test
	public void testInt() {
		SqrtOperator so = new SqrtOperator(
			ConstantAccessor.getInstance(4)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testLong() {
		SqrtOperator so = new SqrtOperator(
			ConstantAccessor.getInstance(4L)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testFloat() {
		SqrtOperator so = new SqrtOperator(
			ConstantAccessor.getInstance(4F)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testDouble() {
		SqrtOperator so = new SqrtOperator(
			ConstantAccessor.getInstance(4D)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
}
