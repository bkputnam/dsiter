package blatis.operator;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bkputnam on 12/9/16.
 */
public class TestSqrtOperator {
	@Test
	public void testInt() {
		SqrtOperator so = new SqrtOperator(
			new ConstantAccessor(4)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testLong() {
		SqrtOperator so = new SqrtOperator(
			new ConstantAccessor(4L)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testFloat() {
		SqrtOperator so = new SqrtOperator(
			new ConstantAccessor(4F)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testDouble() {
		SqrtOperator so = new SqrtOperator(
			new ConstantAccessor(4D)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
}
