package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class ModuloOperator extends TypedBinaryOperator {

    public ModuloOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
        super(lhs, rhs);
    }

	@Override
	protected ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType) {
		return ColumnType.INT;
	}

    @Override
    protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
        return bothTypesAre(ColumnType.INT);
    }

	@Override
    protected int handle_int_int_int(int lhs, int rhs) { return lhs % rhs; }
}
