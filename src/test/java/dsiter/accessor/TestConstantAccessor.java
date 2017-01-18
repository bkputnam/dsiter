package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestConstantAccessor {

	@Test
	public void testInt() {
		ConstantAccessor.INT x = new ConstantAccessor.INT(1);
		assertEquals(1, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLong() {
		ConstantAccessor.LONG x = new ConstantAccessor.LONG(1L);
		assertEquals(1L, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloat() {
		ConstantAccessor.FLOAT x = new ConstantAccessor.FLOAT(1F);
		assertEquals(1F, (float)x.getValueFromRow(new Row()), 0.0000001F);
	}

	@Test
	public void testDouble() {
		ConstantAccessor.DOUBLE x = new ConstantAccessor.DOUBLE(1D);
		assertEquals(1D, (double)x.getValueFromRow(new Row()), 0.0000001D);
	}

	@Test
	public void testString() {
		ConstantAccessor.STRING x = new ConstantAccessor.STRING("1");
		assertEquals("1", x.getValueFromRow(new Row()));
	}

	@Test
	public void testBool() {
		ConstantAccessor.BOOLEAN x = new ConstantAccessor.BOOLEAN(true);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testJsDate() {
		ConstantAccessor.JSDATE x = new ConstantAccessor.JSDATE(0);
		assertEquals(0L, x.getValueFromRow(new Row()));
	}
}
