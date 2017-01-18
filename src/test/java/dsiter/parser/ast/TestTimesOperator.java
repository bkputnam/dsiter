package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTimesOperator {

	@Test
	public void testIntInt() {
		AstNode x = new TimesOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10 * 3, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		AstNode x = new TimesOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10 * 3L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		AstNode x = new TimesOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10 * 3F, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntDouble() {
		AstNode x = new TimesOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10 * 3D, y.getValueFromRow(new Row()));
	}

	/////////////////// LONGS ///////////////////

	@Test
	public void testLongInt() {
		AstNode x = new TimesOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10L * 3, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		AstNode x = new TimesOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10L * 3L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		AstNode x = new TimesOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10L * 3F, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongDouble() {
		AstNode x = new TimesOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10L * 3D, y.getValueFromRow(new Row()));
	}

	/////////////////// FLOATS ///////////////////

	@Test
	public void testFloatInt() {
		AstNode x = new TimesOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10F * 3, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatLong() {
		AstNode x = new TimesOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10F * 3L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatFloat() {
		AstNode x = new TimesOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10F * 3F, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatDouble() {
		AstNode x = new TimesOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10F * 3D, y.getValueFromRow(new Row()));
	}

	/////////////////// DOUBLES ///////////////////

	@Test
	public void testDoubleInt() {
		AstNode x = new TimesOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10D * 3, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleLong() {
		AstNode x = new TimesOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10D * 3L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleFloat() {
		AstNode x = new TimesOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10D * 3F, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleDouble() {
		AstNode x = new TimesOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(10D * 3F, y.getValueFromRow(new Row()));
	}
}
