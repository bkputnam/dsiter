package dsiter.accessor;

import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class RegexMatchOperator extends TypedUnaryOperator {

	private Predicate<String> pattern;

	public RegexMatchOperator(IRowAccessor src, String regex) {
		super(src);
		pattern = Pattern.compile(regex).asPredicate();
	}

	@Override
	protected ColumnType getReturnType(ColumnType srcType) {
		return ColumnType.BOOLEAN;
	}

	@Override
	protected boolean testTypeCompatibility(ColumnType srcType) {
		return srcType == ColumnType.STRING;
	}

	@Override
	protected boolean handle_string_bool(String input) {
		return pattern.test(input);
	}
}
