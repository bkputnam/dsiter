package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;

public class ColumnOperator implements AstNode {
	private String columnName;

	public ColumnOperator(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
		for(ColumnDescriptor cd : cds) {
			if (cd.getName().equals(columnName)) {
				return cd.getAccessor();
			}
		}
		throw new LinkException("Unknown column name '" + columnName + "'");
	}
}
