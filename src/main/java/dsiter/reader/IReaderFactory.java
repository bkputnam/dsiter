package dsiter.reader;

import dsiter.dataset.IDataset;

import java.io.Reader;

/**
 * Interface for classes that produce {@link Reader} instances
 *
 * <p>
 *     Many Datasets must create {@link Reader} instances for every
 *     invocation of {@link IDataset#getIterator()}. Those classes
 *     may not want to tie themselves to a particular type of
 *     {@code Reader}, and may take an instance of
 *     {@code IReaderFactor} instead.
 * </p>
 */
public interface IReaderFactory {

	/**
	 * Get a new {@link Reader} instance
	 *
	 * @return A new {@link Reader} instance
	 * @throws Exception Subclasses may throw unspecified Exceptions
	 * (e.g. {@link java.io.FileNotFoundException} and {@link java.io.IOException}
	 * are common Exceptions to be thrown)
	 */
	public Reader getReader() throws Exception;
}
