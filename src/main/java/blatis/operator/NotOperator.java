package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class NotOperator implements IRowAccessor {

    private IRowAccessor src;

    public NotOperator(IRowAccessor src) {
        if(src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if(src.getType() != ColumnType.BOOLEAN) {
            throw new IllegalArgumentException("src must have type ColumnType.BOOLEAN");
        }

        this.src = src;
    }

    @Override
    public Object getValueFromRow(Row row) {
        return !(boolean)src.getValueFromRow(row);
    }

    @Override
    public ColumnType getType() {
        return ColumnType.BOOLEAN;
    }
}
