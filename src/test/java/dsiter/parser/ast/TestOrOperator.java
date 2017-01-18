package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOrOperator {

	@Test
	public void testTrueTrue() {
		AstNode x = new OrOperator(
			new ConstantOperator.BOOLEAN(true),
			new ConstantOperator.BOOLEAN(true)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(true, y.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		AstNode x = new OrOperator(
			new ConstantOperator.BOOLEAN(true),
			new ConstantOperator.BOOLEAN(false)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(true, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		AstNode x = new OrOperator(
			new ConstantOperator.BOOLEAN(false),
			new ConstantOperator.BOOLEAN(true)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(true, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		AstNode x = new OrOperator(
			new ConstantOperator.BOOLEAN(false),
			new ConstantOperator.BOOLEAN(false)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(false, y.getValueFromRow(new Row()));
	}

	@Test
	public void testMatches() {
		TestMatch.testBinaryOperator((lhs, rhs) -> new OrOperator(lhs, rhs));
	}
}
