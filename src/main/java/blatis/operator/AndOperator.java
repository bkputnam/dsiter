package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.TypedRowAccessor;

public class AndOperator extends TypedBinaryOperator {

	public AndOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
		super(lhs, rhs);
	}

	@Override
	public ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType) {
		return ColumnType.BOOLEAN;
	}

	@Override
	protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
		return bothTypesAre(ColumnType.BOOLEAN);
	}

	@Override
	protected boolean handle_boolean_boolean_boolean(boolean lhs, boolean rhs) { return lhs && rhs; }
}
