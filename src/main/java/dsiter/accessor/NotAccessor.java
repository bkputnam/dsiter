package dsiter.accessor;

import dsiter.row.IRowAccessor;
import dsiter.row.Row;

public class NotAccessor implements IRowAccessor.BOOLEAN {

	private IRowAccessor.BOOLEAN src;

	public NotAccessor(IRowAccessor.BOOLEAN src) {
		this.src = src;
	}

	@Override
	public boolean getBoolFromRow(Row row) {
		return !src.getBoolFromRow(row);
	}
}
