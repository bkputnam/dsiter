package dsiter.accessor_old;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSqrtOperator {
	@Test
	public void testInt() {
		SqrtAccessor so = new SqrtAccessor(
			ConstantAccessor.getIntInstance(4)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testLong() {
		SqrtAccessor so = new SqrtAccessor(
			ConstantAccessor.getLongInstance(4L)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testFloat() {
		SqrtAccessor so = new SqrtAccessor(
			ConstantAccessor.getFloatInstance(4F)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
	@Test
	public void testDouble() {
		SqrtAccessor so = new SqrtAccessor(
			ConstantAccessor.getDoubleInstance(4D)
		);
		assertEquals(2D, so.getValueFromRow(new Row()));
	}
}
