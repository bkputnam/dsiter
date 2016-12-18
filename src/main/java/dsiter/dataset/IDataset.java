package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;

/**
 * Base interface for Datasets.
 *
 * Datasets represent some form of readable tabular data,
 * like a CSV file or a database table. Their main
 * responsibility is to return iterators over themselves.
 *
 * In many cases it's simpler to just create an iterator
 * directly; for example `new RangeIterator(10)` does the
 * same thing as `new RangeDataset(10).getIterator()` and
 * is much more concise. Datasets are mostly useful when
 * you need to create a number of identical iterators
 * (e.g. one iterator per request in a web server)
 */
public interface IDataset {

	public IDatasetIterator getIterator() throws Exception;

}
