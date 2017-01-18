package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNthRootOperator {

	@Test
	public void testIntInt() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10, 1.0 / 3), y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntInt2() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.INT(8),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(2D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10, 1.0 / 3L), y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10, 1.0 / 3F), y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntDouble() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10, 1.0 / 3D), y.getValueFromRow(new Row()));
	}

	/////////////////// LONGS ///////////////////

	@Test
	public void testLongInt() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10L, 1.0 / 3), y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10L, 1.0 / 3L), y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10L, 1.0 / 3F), y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongDouble() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10L, 1.0 / 3D), y.getValueFromRow(new Row()));
	}

	/////////////////// FLOATS ///////////////////

	@Test
	public void testFloatInt() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10F, 1.0 / 3), y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatLong() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10F, 1.0 / 3L), y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatFloat() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10F, 1.0 / 3F), y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatDouble() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.FLOAT(10F),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10F, 1.0 / 3D), y.getValueFromRow(new Row()));
	}

	/////////////////// DOUBLES ///////////////////

	@Test
	public void testDoubleInt() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10D, 1.0 / 3), y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleLong() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10D, 1.0 / 3L), y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleFloat() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10D, 1.0 / 3F), y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleDouble() {
		AstNode x = new NthRootOperator(
			new ConstantOperator.DOUBLE(10D),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(Math.pow(10D, 1.0 / 3D), y.getValueFromRow(new Row()));
	}
}
