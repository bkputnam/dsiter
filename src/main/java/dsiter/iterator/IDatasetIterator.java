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
	 * @throws Exception Implementation specific
	 */
	boolean tryMoveNext() throws Exception;

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
	 * @throws Exception Implementation specific
	 */
	Row getCurrentRow() throws Exception;

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
	long tryGetLength();

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
	ColumnDescriptor[] getColumnDescriptors();

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
	default ColumnDescriptor getColumnDescriptor(String name) {
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
	default RowShape computeShape() {
		return new RowShape(this.getColumnDescriptors());
	}

	/**
	 * Attach a pipe to the current iterator
	 *
	 * @param pipe The pipe to be attached to this iterator
	 * @return An iterator that represents this iterator with the pipe attached
	 * @throws Exception Rarely happens, but since some iterators apply pipes by repeatedly
	 * 		calling tryMoveNext, this method could throw anything that that method could throw.
	 */
	default IDatasetIterator pipe(IPipe pipe) throws Exception {
		if (this.tryAbsorb(pipe)) {
			return this;
		}
		else {
			return pipe.attachTo(this);
		}
	}

	/**
	 * Attempt to 'absorb' a pipe into the iterator.
	 *
	 * For example, an iterator may have a way to efficiently filter certain kinds of rows
	 * and, if so, it may choose to absorb some FilterPipe instances instead of allowing
	 * them to behave in their normal, potentially inefficient, manner (FilterPipes must
	 * create a Row instance for every possible Row so that they can inspect them and decide
	 * if they must be filtered out or not. There are sometimes much more efficient ways to
	 * filter out rows that don't involve reading them at all).
	 *
	 * An important
	 * example is datasets that interface with some sort of database system or large
	 * sorted file system: when they see certain kinds of IPipes they may be able to reduce
	 * their workload by incorporating the pipe into the base query (for databases) or by
	 * only reading the relevant subset of the files (for filesystem-based datasets).
	 *
	 * It's important to note that absorbing a pipe necessarily modifies an iterator in some
	 * way. Attempting to absorb a pipe may modify the iterator even if {@code tryAbsorb}
	 * returns {@code false}; the pipe is said to be <i>partially absorbed</i>. When {@code tryAbsorb}
	 * returns {@code true} this means that the pipe has been <i>fully absorbed</i> and
	 * should be discarded. A <i>partially absorbed</i> pipe should still be applied as if
	 * it wasn't absorbed, but the iterator may still have made some optimizations under the
	 * hood (indeed; the caller has no way to tell whether a pipe was partially absorbed or
	 * not absorbed at all and the two situations should be treated identically).
	 *
	 * As an example of why a partially applied pipe might be useful, imagine a dataset that
	 * is a series of CSV files. The rows in the files are ordered by time, as are the files.
	 * If a {@code filter("time>2016-01-01")} pipe is applied, the dataset iterator will be
	 * able to exclude all files that are strictly before {@code 2016-01-01}. However, the
	 * first file may include a mix of rows that are before {@code 2016-01-01} and rows that
	 * are after. The iterator has managed to exclude a potentially large portion of rows
	 * that are guaranteed not to match the filter but not all of them, so the filter still
	 * needs to be applied to the remaining rows. If {@code 2016-01-01} happens to be an
	 * exact boundary between CSV files then perhaps the iterator will be able to fully
	 * apply the {@code FilterPipe} - depends on how optimized that particular implementation
	 * is.
	 *
	 * @param pipe The pipe that the iterator should try to absorb
	 * @return True, if the pipe was completely absorbed (and should be discarded), else false.
	 * @throws Exception Rarely happens, but since some iterators apply pipes by repeatedly calling
	 * 		tryMoveNext, this method could throw anything that that method could throw.
	 */
	// Note: no default implementation to force authors to think about this
	boolean tryAbsorb(IPipe pipe) throws Exception;
}