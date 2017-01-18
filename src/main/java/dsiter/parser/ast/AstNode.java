package dsiter.parser.ast;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

public interface AstNode {
	IRowAccessor link(ColumnDescriptor[] cds) throws LinkException;
}
