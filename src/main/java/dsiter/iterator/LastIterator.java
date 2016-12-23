package dsiter.iterator;

import dsiter.row.Row;
import dsiter.row.ColumnDescriptor;
import dsiter.row.RowCopier;
import static dsiter.StdPipes.skip;

/**
 * An iterator that only returns the last element of
 * another source iterator
 *
 * <p>
 *     Note: this implementation can be fairly slow,
 *     because it must necessarily read and copy
 *     every {@code Row} in the source iterator.
 *     This is because of two things:
 * </p>
 * <ol>
 *     <li>
 *         This iterator cannot know whether a
 *         {@code Row} is the last one until
 *         the next call to {@code src.tryMoveNext()}
 *         returns false.
 *     </li>
 *     <li>
 *         Calling {@code src.tryMoveNext()} may
 *         change the value of
 *         {@code src.getCurrentRow()}, even if it
 *         returns {@code false}
 *     </li>
 * </ol>
 *
 * @see IDatasetIterator#tryMoveNext()
 */
public class LastIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private Row row;
	private RowCopier copier;
	private boolean alreadyReadRow = false;

	public LastIterator(IDatasetIterator src) {
		this.src = src;
		copier = new RowCopier(src.getColumnDescriptors());
	}

	public boolean tryMoveNext() {

		long srcLen = src.tryGetLength();
		if (srcLen == 0) {
			return false;
		}
		else if (srcLen == -1) {
			boolean foundAny = false;

			// Unfortunately, lastIterator needs to call getCurrentRow() on
			// each and every row, and also must save off a copy when it does
			// that. This is because we need to call tryMoveNext() until
			// it returns false, and any call to src.tryMoveNext() can
			// change or invalidate the value of src.getCurrentRow(), even
			// one that returns false.
			row = new Row(copier.getDestShape());
			while( src.tryMoveNext() ) {
				foundAny = true;

				Row srcRow;
				try {
					srcRow = src.getCurrentRow();
				}
				catch (Exception e) {
					return false;
				}

				copier.copyTo(srcRow, row);
			}
			alreadyReadRow = foundAny;
			return foundAny;
		}
		else {
			return src.pipe(skip(srcLen-1)).tryMoveNext();
		}
	}

	public Row getCurrentRow() throws Exception {
		if (alreadyReadRow) {
			return row;
		}
		else {
			return src.getCurrentRow();
		}
	}

	@Override
	public long tryGetLength() {
		long srcLen = src.tryGetLength();
		if (srcLen == -1 || srcLen == 0) {
			return srcLen;
		}
		else {
			return 1;
		}
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return copier.getDestColumnDescriptors();
	}

}