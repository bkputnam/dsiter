package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;

public class SkipWhileIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private IRowAccessor.BOOLEAN predicate;
	private boolean skipCompleted = false;
	private long numSkipped = 0;
	private Row row;

	public SkipWhileIterator(IDatasetIterator src, IRowAccessor.BOOLEAN predicate) {
		this.src = src;
		this.predicate = predicate;
	}

	@Override
	public boolean tryMoveNext() throws Exception {

		// Most of the time getCurrentRow() can just return src.getCurrentRow(), however things get a little
		// tricky with that first Row that doesn't match the predicate. We have to pull it here so that we
		// can test it. We could just pull it again in getCurrentRow(), but it might be an expensive operation
		// so it would be better to avoid that if we can. So, we cache it in `row`. If `row` is null at the
		// end of this method, no Row has been pulled from src and getCurrentRow() should call src.getCurrentRow()
		// like normal. If `row` is not null at the end, then a Row has been pulled and this should be the next
		// thing returned from getCurrentRow (in lieu of another call to src.getCurrentRow())
		row = null;
		if (skipCompleted) {
			return src.tryMoveNext();
		}
		else {
			while(!skipCompleted) {
				boolean movedNext = src.tryMoveNext();
				if (!movedNext) {
					skipCompleted = true;
					return false;
				}

				row = src.getCurrentRow();
				if (predicate.getBoolFromRow(row)) {
					numSkipped++;
				}
				else {
					skipCompleted = true;
				}
			}
			return true;
		}
	}

	@Override
	public Row getCurrentRow() throws Exception {
		if (row != null) {
			return row;
		}
		else {
			return src.getCurrentRow();
		}
	}

	@Override
	public long tryGetLength() {
		// I can't think of a situation where this will ever be useful, but we can compute the length
		// of a SkipWhileIterator once we've finished skipping records: it's the length of the source
		// iterator minus the number we skipped. Obvious exception: if the source iterator doesn't
		// know its own length then this doesn't apply.
		if (skipCompleted) {
			long srcLength = src.tryGetLength();
			if (srcLength == -1) {
				return -1;
			}
			else {
				return srcLength - numSkipped;
			}
		}
		else {
			return -1;
		}
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return src.getColumnDescriptors();
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) throws Exception {
		// Once skip is completed, this iterator essentially becomes the source iterator so we
		// can just pass pipes right on through.
		if (!skipCompleted) {
			return false;
		}
		else {
			return src.tryAbsorb(pipe);
		}
	}

	@Override
	public void close() throws Exception {
		src.close();
	}
}
