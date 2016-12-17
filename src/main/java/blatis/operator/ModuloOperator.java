package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.TypedRowAccessor;

public class ModuloOperator extends TypedBinaryOperator {

    public ModuloOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
        super(lhs, rhs);
    }

	@Override
	protected ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType) {
		return eitherTypeIs(ColumnType.LONG)
			? ColumnType.LONG
			: ColumnType.INT;
	}

    @Override
    protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
        return (
			(lhsType == ColumnType.INT || lhsType == ColumnType.LONG) &&
			(rhsType == ColumnType.INT || rhsType == ColumnType.LONG)
		);
    }

	@Override
	protected int handle_int_int_int(int lhs, int rhs) { return lhs % rhs; }

	@Override
	protected long handle_int_long_long(int lhs, long rhs) { return lhs % rhs; }

	@Override
	protected long handle_long_int_long(long lhs, int rhs) { return lhs % rhs; }

	@Override
	protected long handle_long_long_long(long lhs, long rhs) { return lhs % rhs; }
}
