package dsiter.accessor;

import dsiter.row.ColumnType;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDivideAccessor {

	@Test
	public void testIntInt() {
		DivideAccessor.INT x = new DivideAccessor.INT_INT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.INT(3)
		);
		assertEquals(0, x.getIntFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		DivideAccessor.LONG x = new DivideAccessor.INT_LONG(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(0, x.getLongFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		DivideAccessor.FLOAT x = new DivideAccessor.INT_FLOAT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(2/3F, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testIntDouble() {
		DivideAccessor.DOUBLE x = new DivideAccessor.INT_DOUBLE(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   LONGS   /////////////////////

	@Test
	public void testLongInt() {
		DivideAccessor.LONG x = new DivideAccessor.LONG_INT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.INT(3)
		);
		assertEquals(0, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		DivideAccessor.LONG x = new DivideAccessor.LONG_LONG(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(0, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		DivideAccessor.FLOAT x = new DivideAccessor.LONG_FLOAT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(2/3F, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testLongDouble() {
		DivideAccessor.DOUBLE x = new DivideAccessor.LONG_DOUBLE(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   FLOATS   /////////////////////

	@Test
	public void testFloatInt() {
		DivideAccessor.FLOAT x = new DivideAccessor.FLOAT_INT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.INT(3)
		);
		assertEquals(2/3F, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatLong() {
		DivideAccessor.FLOAT x = new DivideAccessor.FLOAT_LONG(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(2/3F, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatFloat() {
		DivideAccessor.FLOAT x = new DivideAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(2/3F, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatDouble() {
		DivideAccessor.DOUBLE x = new DivideAccessor.FLOAT_DOUBLE(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   DOUBLES   /////////////////////

	@Test
	public void testDoubleInt() {
		DivideAccessor.DOUBLE x = new DivideAccessor.DOUBLE_INT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.INT(3)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleLong() {
		DivideAccessor.DOUBLE x = new DivideAccessor.DOUBLE_LONG(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleFloat() {
		DivideAccessor.DOUBLE x = new DivideAccessor.DOUBLE_FLOAT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleDouble() {
		DivideAccessor.DOUBLE x = new DivideAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(2/3D, x.getDoubleFromRow(new Row()), 0.0000000001);
	}
}
