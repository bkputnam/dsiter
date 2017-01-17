package dsiter.parser.ast;

import dsiter.accessor.AndAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

public class AndOperator implements AstNode {

	private AstNode lhsNode;
	private AstNode rhsNode;

	public AndOperator(AstNode lhsNode, AstNode rhsNode) {
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
	}

	@Override
	public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
		IRowAccessor lhs = lhsNode.link(cds);
		IRowAccessor rhs = rhsNode.link(cds);

		if (
			lhs.getType() != ColumnType.BOOLEAN ||
			rhs.getType() != ColumnType.BOOLEAN
		) {
			throw new LinkException("AndOperator: lhs and rhs must both have type ColumnType.BOOLEAN");
		}

		return new AndAccessor(
			(IRowAccessor.BOOLEAN)lhs,
			(IRowAccessor.BOOLEAN)rhs
		);
	}
}
