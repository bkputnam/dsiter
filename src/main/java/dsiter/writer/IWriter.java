package dsiter.writer;

import dsiter.iterator.IDatasetIterator;

import java.io.OutputStream;

/**
 * Interface for classes that consume {@link IDatasetIterator} instances
 * and write them to an {@link OutputStream} in some format or another.
 */
public interface IWriter {

	/**
	 * Write the passed iterator to the passed OutputStream, in an
	 * implementation-specific format.
	 *
	 * @param it        The iterator to be written
	 * @param outStream The OutputStream to be written to
	 */
    public void writeTo(IDatasetIterator it, OutputStream outStream);
}
