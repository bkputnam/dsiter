package dsiter.accessor;

import dsiter.row.IRowAccessor;
import dsiter.row.Row;

/** IRowAccessor that computes the logical OR of two other IRowAccessors. */
public class OrAccessor implements IRowAccessor.BOOLEAN {

	IRowAccessor.BOOLEAN lhs;
	IRowAccessor.BOOLEAN rhs;

	public OrAccessor(IRowAccessor.BOOLEAN lhs, IRowAccessor.BOOLEAN rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public boolean getBoolFromRow(Row row) {
		return lhs.getBoolFromRow(row) || rhs.getBoolFromRow(row);
	}
}
