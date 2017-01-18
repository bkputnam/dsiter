package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNotOperator {

	@Test
	public void testTrue() {
		AstNode x = new NotOperator(
			new ConstantOperator.BOOLEAN(true)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(false, y.getValueFromRow(new Row()));
	}

	@Test
	public void testFalse() {
		AstNode x = new NotOperator(
			new ConstantOperator.BOOLEAN(false)
		);
		IRowAccessor y = x.link(new ColumnDescriptor[0]);
		assertEquals(true, y.getValueFromRow(new Row()));
	}
}
