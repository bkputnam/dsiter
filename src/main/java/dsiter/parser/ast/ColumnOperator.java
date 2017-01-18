package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

import java.util.Map;

public class ColumnOperator implements AstNode {
	String columnName;

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

	@Override
	public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
		if (!(compareTo instanceof ColumnOperator)) {
			return false;
		}
		else {
			ColumnOperator other = (ColumnOperator)compareTo;
			String otherName = other.columnName;
			if (columnMap.containsKey(columnName)) {
				return columnMap.get(columnName).equals(otherName);
			}
			else {
				columnMap.put(columnName, otherName);
				return true;
			}
		}
	}
}
