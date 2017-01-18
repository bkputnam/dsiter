package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestColumnOperator {

	@Test
	public void test1() {
		AstNode x = new ColumnOperator(
			"bar"
		);
		IRowAccessor y = x.link(new ColumnDescriptor[] {
			new ColumnDescriptor("foo", ColumnType.INT, 0),
			new ColumnDescriptor("bar", ColumnType.INT, 1),
			new ColumnDescriptor("baz", ColumnType.INT, 2)
		});

		Row row = new Row();
		row.ints = new int[] {1, 2, 3};

		assertEquals(2, y.getValueFromRow(row));
	}
}
