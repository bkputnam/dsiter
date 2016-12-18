package dsiter.writer;

import dsiter.iterator.IDatasetIterator;

import java.io.OutputStream;

/**
 * Created by bkputnam on 12/3/16.
 */
public interface IWriter {
    public void writeTo(IDatasetIterator it, OutputStream outStream);
}
