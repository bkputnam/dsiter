package dsiter.accessor;

import dsiter.row.IRowAccessor;
import dsiter.row.Row;

/**
 * IRowAccessor that computes the concatenation of two String IRowAccessors.
 */
public class ConcatAccessor implements IRowAccessor.STRING {

	private IRowAccessor.STRING lhs;
	private IRowAccessor.STRING rhs;

	public ConcatAccessor(IRowAccessor.STRING lhs, IRowAccessor.STRING rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public String getStringFromRow(Row row) {
		return lhs.getStringFromRow(row) + rhs.getStringFromRow(row);
	}
}
