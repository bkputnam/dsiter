package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNotEqualsOperator {

	@Test
	public void testStringStringTrue() {
		AstNode x = new NotEqualsOperator(
			new ConstantOperator.STRING("foo"),
			new ConstantOperator.STRING("foo")
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(false, y.getValueFromRow(new Row()));
	}

	@Test
	public void testStringStringFalse() {
		AstNode x = new NotEqualsOperator(
			new ConstantOperator.STRING("foo"),
			new ConstantOperator.STRING("bar")
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(true, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntIntTrue() {
		AstNode x = new NotEqualsOperator(
			new ConstantOperator.INT(1),
			new ConstantOperator.INT(1)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(false, y.getValueFromRow(new Row()));
	}

	@Test
	public void testIntIntFalse() {
		AstNode x = new NotEqualsOperator(
			new ConstantOperator.INT(1),
			new ConstantOperator.INT(2)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(true, y.getValueFromRow(new Row()));
	}

	@Test
	public void testMatches() {
		TestMatch.testBinaryOperator((lhs, rhs) -> new NotEqualsOperator(lhs, rhs));
	}
}
