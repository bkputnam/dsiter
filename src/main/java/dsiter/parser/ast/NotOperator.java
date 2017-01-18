package dsiter.parser.ast;

import dsiter.accessor.NotAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

public class NotOperator implements AstNode {
	private AstNode srcNode;

	public NotOperator(AstNode srcNode) {
		this.srcNode = srcNode;
	}

	@Override
	public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
		IRowAccessor src = srcNode.link(cds);

		if (src.getType() == ColumnType.BOOLEAN) {
			return new NotAccessor((IRowAccessor.BOOLEAN)src);
		}
		else {
			throw new LinkException("Invalid operand type for NotOperator: " + src.getType());
		}
	}
}
