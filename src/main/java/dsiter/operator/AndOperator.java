package dsiter.operator;

import dsiter.row.ColumnType;
import dsiter.row.TypedRowAccessor;

/**
 * Binary operator that computes a logical AND operation.
 *
 * <p>
 *     You probably won't ever want to use this class directly;
 *     it's much simpler to use {@link dsiter.operator.parser.OperatorParser}
 *     directly. However, I certainly won't tell you you can't!
 * </p>
 */
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
