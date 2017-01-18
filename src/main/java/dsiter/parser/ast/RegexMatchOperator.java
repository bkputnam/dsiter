package dsiter.parser.ast;

import dsiter.accessor.ConstantAccessor;
import dsiter.accessor.RegexMatchAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;

public class RegexMatchOperator implements AstNode {
	private AstNode srcNode;
	private AstNode patternNode;

	public RegexMatchOperator(AstNode srcNode, AstNode patternNode) {
		this.srcNode = srcNode;
		this.patternNode = patternNode;
	}

	@Override
	public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
		IRowAccessor src = srcNode.link(cds);
		IRowAccessor pattern = patternNode.link(cds);

		if (!(pattern instanceof ConstantAccessor.STRING)) {
			throw new LinkException("RegexMatchOperator: pattern must be of type ConstantAccessor.STRING");
		}
		else if (src.getType() != ColumnType.STRING) {
			throw new LinkException("RegexMatchOperator: src must be of type ColumnType.STRING");
		}
		else {
			return new RegexMatchAccessor(
				(IRowAccessor.STRING)src,
				((ConstantAccessor.STRING)pattern).getStringFromRow(null)
			);
		}
	}
}
