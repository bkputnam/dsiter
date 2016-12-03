package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class ModuloOperator extends BinaryOperator {

    public ModuloOperator(IRowAccessor lhs, IRowAccessor rhs) {
        super(lhs, rhs);
    }

    @Override
    public ColumnType getType() {
        return ColumnType.INT;
    }

    @Override
    protected boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType) {
        return bothTypesAre(ColumnType.INT);
    }

    protected Object getValue(int lhs, int rhs) { return lhs % rhs; }
}
