package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

import java.util.HashMap;
import java.util.Map;

public interface AstNode {

	IRowAccessor link(ColumnDescriptor[] cds) throws LinkException;

	boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap);
}
