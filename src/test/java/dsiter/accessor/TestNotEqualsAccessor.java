package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNotEqualsAccessor {

	@Test
	public void testIntIntTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.INT_INT(
			new ConstantAccessor.INT(1),
			new ConstantAccessor.INT(1)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testIntIntFalse() {
		NotEqualsAccessor x = new NotEqualsAccessor.INT_INT(
			new ConstantAccessor.INT(1),
			new ConstantAccessor.INT(0)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLongTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.LONG_LONG(
			new ConstantAccessor.LONG(1L),
			new ConstantAccessor.LONG(1L)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatFloatTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(1F),
			new ConstantAccessor.FLOAT(1F)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleDoubleTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(1D),
			new ConstantAccessor.DOUBLE(1D)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testStringStringTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.STRING_STRING(
			new ConstantAccessor.STRING("1"),
			new ConstantAccessor.STRING("1")
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testBoolBoolTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.BOOLEAN_BOOLEAN(
			new ConstantAccessor.BOOLEAN(true),
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDateDateTrue() {
		NotEqualsAccessor x = new NotEqualsAccessor.JSDATE_JSDATE(
			new ConstantAccessor.JSDATE(1),
			new ConstantAccessor.JSDATE(1)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}
}
