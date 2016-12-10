package blatis.operator;

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class NotOperator extends TypedUnaryOperator {

	public NotOperator(TypedRowAccessor src) {
		super(src);
    }

	@Override
	protected ColumnType getReturnType(ColumnType srcType) {
		return ColumnType.BOOLEAN;
	}

	@Override
	protected boolean testTypeCompatibility(ColumnType srcType) {
		return srcType == ColumnType.BOOLEAN;
	}

	@Override
	public boolean handle_boolean_boolean(boolean src) { return !src; }
}
