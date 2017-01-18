package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCaretOperator {

	@Test
	public void testIntInt() {
		AstNode x = new CaretOperator(
			new ConstantOperator.INT(2),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		AstNode x = new CaretOperator(
			new ConstantOperator.INT(2),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntFloat() {
		AstNode x = new CaretOperator(
			new ConstantOperator.INT(2),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntDouble() {
		AstNode x = new CaretOperator(
			new ConstantOperator.INT(2),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	//////////////////////// LONGS ////////////////////////

	@Test
	public void testLongInt() {
		AstNode x = new CaretOperator(
			new ConstantOperator.LONG(2L),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		AstNode x = new CaretOperator(
			new ConstantOperator.LONG(2L),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloat() {
		AstNode x = new CaretOperator(
			new ConstantOperator.LONG(2L),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongDouble() {
		AstNode x = new CaretOperator(
			new ConstantOperator.LONG(2L),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	//////////////////////// FLOATS ////////////////////////

	@Test
	public void testFloatInt() {
		AstNode x = new CaretOperator(
			new ConstantOperator.FLOAT(2F),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatLong() {
		AstNode x = new CaretOperator(
			new ConstantOperator.FLOAT(2F),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatFloat() {
		AstNode x = new CaretOperator(
			new ConstantOperator.FLOAT(2F),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatDouble() {
		AstNode x = new CaretOperator(
			new ConstantOperator.FLOAT(2F),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	//////////////////////// DOUBLES ////////////////////////

	@Test
	public void testDoubleInt() {
		AstNode x = new CaretOperator(
			new ConstantOperator.DOUBLE(2D),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleLong() {
		AstNode x = new CaretOperator(
			new ConstantOperator.DOUBLE(2D),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleFloat() {
		AstNode x = new CaretOperator(
			new ConstantOperator.DOUBLE(2D),
			new ConstantOperator.FLOAT(3F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleDouble() {
		AstNode x = new CaretOperator(
			new ConstantOperator.DOUBLE(2D),
			new ConstantOperator.DOUBLE(3D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(8D, y.getValueFromRow(new Row()));
	}
}
