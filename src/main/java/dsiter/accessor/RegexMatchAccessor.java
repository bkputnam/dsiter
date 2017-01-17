package dsiter.accessor;

import dsiter.row.IRowAccessor;
import dsiter.row.Row;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class RegexMatchAccessor implements IRowAccessor.BOOLEAN {

	private IRowAccessor.STRING src;
	private Predicate<String> predicate;

	public RegexMatchAccessor(IRowAccessor.STRING src, String pattern) {
		this.src = src;
		predicate = Pattern.compile(pattern).asPredicate();
	}

	@Override
	public boolean getBoolFromRow(Row row) {
		return predicate.test(src.getStringFromRow(row));
	}
}
