package dsiter.accessor;

import dsiter.row.ColumnType;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSubtractAccessor {

	@Test
	public void testIntInt() {
		SubtractAccessor.INT x = new SubtractAccessor.INT_INT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.INT(3)
		);
		assertEquals(-1, x.getIntFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		SubtractAccessor.LONG x = new SubtractAccessor.INT_LONG(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(-1, x.getLongFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		SubtractAccessor.FLOAT x = new SubtractAccessor.INT_FLOAT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(-1, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testIntDouble() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.INT_DOUBLE(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   LONGS   /////////////////////

	@Test
	public void testLongInt() {
		SubtractAccessor.LONG x = new SubtractAccessor.LONG_INT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.INT(3)
		);
		assertEquals(-1, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		SubtractAccessor.LONG x = new SubtractAccessor.LONG_LONG(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(-1, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		SubtractAccessor.FLOAT x = new SubtractAccessor.LONG_FLOAT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(-1, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testLongDouble() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.LONG_DOUBLE(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   FLOATS   /////////////////////

	@Test
	public void testFloatInt() {
		SubtractAccessor.FLOAT x = new SubtractAccessor.FLOAT_INT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.INT(3)
		);
		assertEquals(-1, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatLong() {
		SubtractAccessor.FLOAT x = new SubtractAccessor.FLOAT_LONG(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(-1, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatFloat() {
		SubtractAccessor.FLOAT x = new SubtractAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(-1, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatDouble() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.FLOAT_DOUBLE(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   DOUBLES   /////////////////////

	@Test
	public void testDoubleInt() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.DOUBLE_INT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.INT(3)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleLong() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.DOUBLE_LONG(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleFloat() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.DOUBLE_FLOAT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleDouble() {
		SubtractAccessor.DOUBLE x = new SubtractAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(-1, x.getDoubleFromRow(new Row()), 0.0000000001);
	}
}
