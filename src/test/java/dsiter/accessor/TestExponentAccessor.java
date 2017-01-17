package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestExponentAccessor {

	@Test
	public void testIntInt() {
		ExponentAccessor x = new ExponentAccessor.INT_INT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.INT(3)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		ExponentAccessor x = new ExponentAccessor.INT_LONG(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		ExponentAccessor x = new ExponentAccessor.INT_FLOAT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testIntDouble() {
		ExponentAccessor x = new ExponentAccessor.INT_DOUBLE(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	/////////////////////////   LONGS   /////////////////////////

	@Test
	public void testLongInt() {
		ExponentAccessor x = new ExponentAccessor.LONG_INT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.INT(3)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		ExponentAccessor x = new ExponentAccessor.LONG_LONG(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		ExponentAccessor x = new ExponentAccessor.LONG_FLOAT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongDouble() {
		ExponentAccessor x = new ExponentAccessor.LONG_DOUBLE(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	/////////////////////////   FLOATS   /////////////////////////

	@Test
	public void testFloatInt() {
		ExponentAccessor x = new ExponentAccessor.FLOAT_INT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.INT(3)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatLong() {
		ExponentAccessor x = new ExponentAccessor.FLOAT_LONG(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatFloat() {
		ExponentAccessor x = new ExponentAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatDouble() {
		ExponentAccessor x = new ExponentAccessor.FLOAT_DOUBLE(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	/////////////////////////   DOUBLES   /////////////////////////

	@Test
	public void testDoubleInt() {
		ExponentAccessor x = new ExponentAccessor.DOUBLE_INT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.INT(3)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleLong() {
		ExponentAccessor x = new ExponentAccessor.DOUBLE_LONG(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleFloat() {
		ExponentAccessor x = new ExponentAccessor.DOUBLE_FLOAT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleDouble() {
		ExponentAccessor x = new ExponentAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(8D, x.getValueFromRow(new Row()));
	}
}
