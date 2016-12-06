package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class NotOperator extends TypedRowAccessor.BOOLEAN {

    private TypedRowAccessor.BOOLEAN src;

	public NotOperator(TypedRowAccessor src) {
        if(src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if(src.getType() != ColumnType.BOOLEAN) {
            throw new IllegalArgumentException("src must have type ColumnType.BOOLEAN");
        }

        this.src = src.asBoolAccessor();
    }

	@Override
	public boolean getBoolFromRow(Row row) {
		return !src.getBoolFromRow(row);
	}

    @Override
    public ColumnType getType() {
        return ColumnType.BOOLEAN;
    }
}
