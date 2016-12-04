package blatis.writer;

import blatis.iterator.AbstractDatasetIterator;

import java.io.OutputStream;

/**
 * Created by bkputnam on 12/3/16.
 */
public interface IWriter {
    public void writeTo(AbstractDatasetIterator it, OutputStream outStream);
}
