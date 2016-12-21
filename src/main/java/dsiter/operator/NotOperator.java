package dsiter.operator;

import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

/**
 * Unary operator that computes the logical NOT of {@code src}
 *
 * <p>
 *     You probably won't ever want to use this class directly;
 *     it's much simpler to use {@link dsiter.operator.parser.OperatorParser}
 *     directly. However, I certainly won't tell you you can't!
 * </p>
 */
public class NotOperator extends TypedUnaryOperator {

	public NotOperator(IRowAccessor src) {
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
