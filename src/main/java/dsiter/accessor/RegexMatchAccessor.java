package dsiter.accessor;

import dsiter.row.IRowAccessor;
import dsiter.row.Row;

import java.util.regex.Pattern;

public class RegexMatchAccessor implements IRowAccessor.BOOLEAN {

	private IRowAccessor.STRING src;
	private Pattern pattern;

	public RegexMatchAccessor(IRowAccessor.STRING src, String pattern) {
		this.src = src;
		this.pattern = Pattern.compile(pattern);
	}

	@Override
	public boolean getBoolFromRow(Row row) {
		return pattern.matcher(src.getStringFromRow(row)).matches();
	}
}
