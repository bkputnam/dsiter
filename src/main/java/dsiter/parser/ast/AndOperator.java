package dsiter.parser.ast;

import dsiter.accessor.AndAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

import java.util.Map;

public class AndOperator implements AstNode {

	AstNode lhsNode;
	AstNode rhsNode;

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

	@Override
	public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
		if (!(compareTo instanceof AndOperator)) {
			return false;
		}
		else {
			AndOperator other = (AndOperator)compareTo;
			return
				lhsNode.matches(other.lhsNode, columnMap, constantMap) &&
				rhsNode.matches(other.rhsNode, columnMap, constantMap);
		}
	}
}
