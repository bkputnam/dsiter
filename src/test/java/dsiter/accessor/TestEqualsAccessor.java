package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEqualsAccessor {

	@Test
	public void testIntIntTrue() {
		EqualsAccessor x = new EqualsAccessor.INT_INT(
			new ConstantAccessor.INT(1),
			new ConstantAccessor.INT(1)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testIntIntFalse() {
		EqualsAccessor x = new EqualsAccessor.INT_INT(
			new ConstantAccessor.INT(1),
			new ConstantAccessor.INT(0)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLongTrue() {
		EqualsAccessor x = new EqualsAccessor.LONG_LONG(
			new ConstantAccessor.LONG(1L),
			new ConstantAccessor.LONG(1L)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatFloatTrue() {
		EqualsAccessor x = new EqualsAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(1F),
			new ConstantAccessor.FLOAT(1F)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleDoubleTrue() {
		EqualsAccessor x = new EqualsAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(1D),
			new ConstantAccessor.DOUBLE(1D)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testStringStringTrue() {
		EqualsAccessor x = new EqualsAccessor.STRING_STRING(
			new ConstantAccessor.STRING("1"),
			new ConstantAccessor.STRING("1")
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testBoolBoolTrue() {
		EqualsAccessor x = new EqualsAccessor.BOOLEAN_BOOLEAN(
			new ConstantAccessor.BOOLEAN(true),
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDateDateTrue() {
		EqualsAccessor x = new EqualsAccessor.JSDATE_JSDATE(
			new ConstantAccessor.JSDATE(1),
			new ConstantAccessor.JSDATE(1)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}
}
