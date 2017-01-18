package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSqrtOperator {

	@Test
	public void testInt() {
		AstNode x = new SqrtOperator(
			new ConstantOperator.INT(16)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(4D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testLong() {
		AstNode x = new SqrtOperator(
			new ConstantOperator.LONG(16L)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(4D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFloat() {
		AstNode x = new SqrtOperator(
			new ConstantOperator.FLOAT(16F)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(4D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testDouble() {
		AstNode x = new SqrtOperator(
			new ConstantOperator.DOUBLE(16D)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(4D, y.getValueFromRow(new Row()));
	}

	@Test
	public void testMatches() {
		TestMatch.testUnaryOperator((src) -> new SqrtOperator(src));
	}
}
