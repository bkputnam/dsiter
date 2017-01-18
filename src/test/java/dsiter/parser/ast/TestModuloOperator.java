package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestModuloOperator {

	@Test
	public void testIntInt() {
		AstNode x = new ModuloOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(1, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		AstNode x = new ModuloOperator(
			new ConstantOperator.INT(10),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(1L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongInt() {
		AstNode x = new ModuloOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.INT(3)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(1L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		AstNode x = new ModuloOperator(
			new ConstantOperator.LONG(10L),
			new ConstantOperator.LONG(3L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(1L, y.getValueFromRow(new Row()));
	}

	@Test
	public void testMatches() {
		TestMatch.testBinaryOperator((lhs, rhs) -> new ModuloOperator(lhs, rhs));
	}
}
