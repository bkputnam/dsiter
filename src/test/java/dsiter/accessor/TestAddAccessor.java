package dsiter.accessor;

import dsiter.row.ColumnType;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAddAccessor {

	@Test
	public void testIntInt() {
		AddAccessor.INT x = new AddAccessor.INT_INT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.INT(3)
		);
		assertEquals(5, x.getIntFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		AddAccessor.LONG x = new AddAccessor.INT_LONG(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(5, x.getLongFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		AddAccessor.FLOAT x = new AddAccessor.INT_FLOAT(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(5, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testIntDouble() {
		AddAccessor.DOUBLE x = new AddAccessor.INT_DOUBLE(
			new ConstantAccessor.INT(2),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   LONGS   /////////////////////

	@Test
	public void testLongInt() {
		AddAccessor.LONG x = new AddAccessor.LONG_INT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.INT(3)
		);
		assertEquals(5, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		AddAccessor.LONG x = new AddAccessor.LONG_LONG(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(5, x.getLongFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		AddAccessor.FLOAT x = new AddAccessor.LONG_FLOAT(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(5, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testLongDouble() {
		AddAccessor.DOUBLE x = new AddAccessor.LONG_DOUBLE(
			new ConstantAccessor.LONG(2L),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   FLOATS   /////////////////////

	@Test
	public void testFloatInt() {
		AddAccessor.FLOAT x = new AddAccessor.FLOAT_INT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.INT(3)
		);
		assertEquals(5, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatLong() {
		AddAccessor.FLOAT x = new AddAccessor.FLOAT_LONG(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(5, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatFloat() {
		AddAccessor.FLOAT x = new AddAccessor.FLOAT_FLOAT(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(5, x.getFloatFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testFloatDouble() {
		AddAccessor.DOUBLE x = new AddAccessor.FLOAT_DOUBLE(
			new ConstantAccessor.FLOAT(2F),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	/////////////////////   DOUBLES   /////////////////////

	@Test
	public void testDoubleInt() {
		AddAccessor.DOUBLE x = new AddAccessor.DOUBLE_INT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.INT(3)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleLong() {
		AddAccessor.DOUBLE x = new AddAccessor.DOUBLE_LONG(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleFloat() {
		AddAccessor.DOUBLE x = new AddAccessor.DOUBLE_FLOAT(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.FLOAT(3F)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}

	@Test
	public void testDoubleDouble() {
		AddAccessor.DOUBLE x = new AddAccessor.DOUBLE_DOUBLE(
			new ConstantAccessor.DOUBLE(2D),
			new ConstantAccessor.DOUBLE(3D)
		);
		assertEquals(5, x.getDoubleFromRow(new Row()), 0.0000000001);
	}
}
