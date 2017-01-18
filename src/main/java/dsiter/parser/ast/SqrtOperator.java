package dsiter.parser.ast;

import dsiter.accessor.SqrtAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

import java.util.Map;

public class SqrtOperator implements AstNode {
	private AstNode srcNode;

	public SqrtOperator(AstNode srcNode) {
		this.srcNode = srcNode;
	}

	@Override
	public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
		IRowAccessor src = srcNode.link(cds);
		ColumnType srcType = src.getType();

		if (srcType == ColumnType.INT) {
			return new SqrtAccessor.INT((IRowAccessor.INT)src);
		}
		else if (srcType == ColumnType.LONG) {
			return new SqrtAccessor.LONG((IRowAccessor.LONG)src);
		}
		else if (srcType == ColumnType.FLOAT) {
			return new SqrtAccessor.FLOAT((IRowAccessor.FLOAT)src);
		}
		else if (srcType == ColumnType.DOUBLE) {
			return new SqrtAccessor.DOUBLE((IRowAccessor.DOUBLE)src);
		}
		else {
			throw new LinkException("Unsupported operand type for SqrtOperator: " + srcType);
		}
	}

	@Override
	public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
		if (!(compareTo instanceof SqrtOperator)) {
			return false;
		}
		else {
			SqrtOperator other = (SqrtOperator)compareTo;
			return srcNode.matches(other.srcNode, columnMap, constantMap);
		}
	}
}
