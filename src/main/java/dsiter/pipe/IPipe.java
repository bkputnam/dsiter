package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;

/**
 * Interface representing a pipe operation to a future
 * iterator. Pipe operations are conceptually similar to
 * <a href="https://en.wikipedia.org/wiki/Pipeline_(Unix)">pipes</a>
 * in shell scripting: they take the output of one iterator
 * and make it the input to another iterator.
 *
 * <p>
 *     Pipe instances in dsiter are type-specific: they
 *     encode all of the information required to make a
 *     specific type of transforming iterator, except for
 *     the source iterator to be transformed. The source iterator
 *     is supplied later by calling {@link #attachTo}.
 * </p>
 * <p>
 *     A Pipe can also be considered a
 *     <a href="https://en.wikipedia.org/wiki/Partial_application">partial application</a>
 *     of an iterator
 *     (similar to <a href="https://en.wikipedia.org/wiki/Currying">currying</a>
 *     in functional programming): it specifies everything that the constructor needs
 *     except for the source iterator.
 * </p>
 * <p>
 *     For example,
 *     a {@link StridePipe} contains all of the information required to
 *     make a {@link dsiter.iterator.StrideIterator} except
 *     for the source iterator. An actual instance of {@code StrideIterator}
 *     is not constructed, however, until a source iterator is passed
 *     via {@code attachTo}.
 * </p>
 */
public interface IPipe {

	/**
	 * Attach this pipe to the passed source iterator. This will usually
	 * construct a new iterator that uses {@code src} as its source, but
	 * the actual method is not explicitly specified.
	 *
	 * @param src The source iterator
	 * @return An iterator with this pipe attached to it (conceptually, if
	 * not necessarily physically)
	 */
	IDatasetIterator attachTo(IDatasetIterator src);

}