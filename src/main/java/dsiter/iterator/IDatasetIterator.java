package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.Row;
import dsiter.row.RowShape;
import dsiter.row.ColumnDescriptor;

public interface IDatasetIterator extends AutoCloseable {

	/**
	 * Attempt to move the iterator's cursor.
	 *
	 * <p>
	 *     Some implementations will be able to
	 *     implement this method lazily; for
	 *     example an {@code ArrayIterator} may
	 *     simply update a pointer or an index
	 *     without actually constructing anything.
	 *     Other implementations will need to
	 *     do more work to determine whether or
	 *     not another {@code Row} is available.
	 * </p>
	 *
	 * <p>
	 *     Calling {@code tryMoveNext()} may change the
	 *     value of {@code getCurrentRow()}, even if
	 *     {@code tryMoveNext()} returns false. If
	 *     {@code tryMoveNext()} returns false, the
	 *     value returned from {@code getCurrentRow()}
	 *     is not guaranteed to be valid. Similarly,
	 *     because most iterator implementations
	 *     reuse {@code Row} objects, the same
	 *     caveats apply to {@code Row} objects that
	 *     have been saved off from previous calls
	 *     to {@code getCurrentRow()}. If another class
	 *     requires a {@code Row} instance that
	 *     doesn't mutate between calls to
	 *     {@code tryMoveNext()}, it is responsible
	 *     for creating its own copy of that {@code Row}
	 *     (e.g. via {@link dsiter.row.RowCopier})
	 * </p>
	 *
	 * @return {@code true} if the cursor was
	 * 		successfully moved to the next item, or
	 * 		{@code false} if there are no more items
	 * 		to be iterated over.
	 */
	public boolean tryMoveNext();

	/**
	 * Return the current Row.
	 *
	 * <p>
	 *     In much the same way that tryMoveNext()
	 *     will be lazy for some implementations,
	 *     getCurrentRow() may be comparatively
	 *     expensive, if it must do all the work
	 *     of creating a Row.
	 * </p>
	 *
	 * <p>
	 *     Calling {@code getCurrentRow()} more than once
	 *     per call to {@code tryMoveNext()} should
	 *     be valid for all implementations (it should
	 *     return an identical {@code Row} every time,
	 *     perhaps even the same instance). However,
	 *     since {@code getCurrentRow()} may be expensive
	 *     for many implementations, this behavior is not
	 *     recommended.
	 * </p>
	 * @return Row The current Row
	 */
	public Row getCurrentRow() throws Exception;

	/**
	 * Return the iterator's length, if known, or -1 if
	 * the length is not known. Regardless, this will
	 * not cause any change in the state of the iterator
	 * (i.e. no calls to tryMoveNext() will be made)
	 *
	 * @return The length of the iterator, or -1 if unknown
	 */
	// Note: no default method to force implementors to
	// think about this
	public long tryGetLength();

	/**
	 * Return descriptions of all columns supported by this
	 * iterator.
	 *
	 * <p>
	 *     The Rows returned by a given iterator may contain
	 *     more values than are described by the returned
	 *     ColumnDescriptors. This is a simple and efficient
	 *     way to delete a column; simply remove the
	 *     {@code ColumnDescriptor} that describes that column
	 *     and all other iterators and writers should treat
	 *     that value as if it doesn't exist.
	 * </p>
	 *
	 * <p>
	 *     Note: the order of the returned column desciptors
	 *     may matter for many applications (e.g. most
	 *     writers will write them in that order).
	 * </p>
	 * @return This iterator's ColumnDescriptors
	 */
	public ColumnDescriptor[] getColumnDescriptors();

	/**
	 * Look up a ColumnDescriptor by name
	 *
	 * <p>
	 *     The default implementation of this method simply
	 *     iterates over {@code getColumnDescriptors()} and
	 *     returns the first column whose name matches.
	 *     Implementations of this interface may override
	 *     this method to
	 *     provide a more efficient lookup mechanism
	 *     (e.g. a HashMap) if they so desire.
	 * </p>
	 *
	 * @param name The name of the column to be described
	 * @return A ColumnDescriptor describing the named column,
	 * or {@code null} if no such column exists
	 */
	default public ColumnDescriptor getColumnDescriptor(String name) {
		ColumnDescriptor[] cds = this.getColumnDescriptors();

		for( int i=0; i<cds.length; i++ ) {
			if( cds[i].getName().equals(name) ) {
				return cds[i];
			}
		}

		return null;
	}

	/**
	 * Compute the {@code RowShape} of this iterators columns by counting how many
	 * of each type there are.
	 *
	 * @see dsiter.pipe.IPipe
	 * @see dsiter.StdPipes
	 *
	 * @return a {@code RowShape} instance describing the shape of the {@code Rows} returned
	 * by this iterator.
	 */
	default public RowShape computeShape() {
		return new RowShape(this.getColumnDescriptors());
	}

	/**
	 * Attach a pipe to the current iterator
	 *
	 * @param pipe The pipe to be attached to this iterator
	 * @return An iterator that represents this iterator with the pipe attached
	 */
	default public IDatasetIterator pipe(IPipe pipe) {
		return pipe.attachTo(this);
	}
}