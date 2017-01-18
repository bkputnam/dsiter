package dsiter.accessor;

import dsiter.row.ColumnType;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMultiplyAccessor {

	@Test
	public void testIntInt() {
		MultiplyAccessor.INT x = new MultiplyAccessor.INT_INT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.INT(3)
		);
		assertEquals(6, x.getIntFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		MultiplyAccessor.LONG x = new MultiplyAccessor.INT_LONG(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(6, x.getLongFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		MultiplyAccessor.FLOAT x = new MultiplyAccessor.INT_FLOAT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(6, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testIntDouble() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.INT_DOUBLE(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   LONGS   /////////////////////

	@Test
	public void testLongInt() {
		MultiplyAccessor.LONG x = new MultiplyAccessor.LONG_INT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.INT(3)
		);
		assertEquals(6, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		MultiplyAccessor.LONG x = new MultiplyAccessor.LONG_LONG(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(6, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		MultiplyAccessor.FLOAT x = new MultiplyAccessor.LONG_FLOAT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(6, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testLongDouble() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.LONG_DOUBLE(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   FLOATS   /////////////////////

	@Test
	public void testFloatInt() {
		MultiplyAccessor.FLOAT x = new MultiplyAccessor.FLOAT_INT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.INT(3)
		);
		assertEquals(6, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatLong() {
		MultiplyAccessor.FLOAT x = new MultiplyAccessor.FLOAT_LONG(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(6, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatFloat() {
		MultiplyAccessor.FLOAT x = new MultiplyAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(6, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatDouble() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.FLOAT_DOUBLE(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   DOUBLES   /////////////////////

	@Test
	public void testDoubleInt() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.DOUBLE_INT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.INT(3)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleLong() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.DOUBLE_LONG(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleFloat() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.DOUBLE_FLOAT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleDouble() {
		MultiplyAccessor.DOUBLE x = new MultiplyAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(6, x.getDoubleFromRow(new Row()), 0.0000000001);
	}
}
