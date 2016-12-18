package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;

/**
 * Base interface for Datasets.
 *
 * <p>
 *     Datasets represent some form of readable tabular data,
 *     like a CSV file or a database table. Their main
 *     responsibility is to return iterators over themselves.
 * </p>
 *
 * <p>
 *     In many cases it's simpler to just create an iterator
 *     directly; for example {@code new RangeIterator(10)} does the
 *     same thing as {@code new RangeDataset(10).getIterator()} and
 *     is much more concise. Datasets are mostly useful when
 *     you need to create a number of identical iterators
 *     (e.g. one iterator per request in a web server)
 * </p>
 */
public interface IDataset {

	/**
	 * Get an iterator over this dataset
	 *
	 * @return an iterator over this dataset
	 * @throws Exception Unspecified exceptions may be thrown by various implementations
	 */
	public IDatasetIterator getIterator() throws Exception;

}
