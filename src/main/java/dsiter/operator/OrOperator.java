package dsiter.operator;

import dsiter.row.ColumnType;
import dsiter.row.TypedRowAccessor;

public class OrOperator extends TypedBinaryOperator {

	public OrOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
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
	protected boolean handle_boolean_boolean_boolean(boolean lhs, boolean rhs) { return lhs || rhs; }
}
