package dsiter.operator;

import dsiter.row.ColumnType;
import dsiter.row.TypedRowAccessor;

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
