package dsiter.reader;

import java.io.FileReader;
import java.io.Reader;

/**
 * {@link IReaderFactory} that produces {@link Reader} instances
 * that read a particular file.
 */
public class FileReaderFactory implements IReaderFactory {

	private String filename;

	/**
	 * Construct a new FileReaderFactory that produces {@link Reader} instances
	 * which read through {@code filename}
	 * @param filename The file to be read (repeatedly)
	 */
	public FileReaderFactory(String filename) {
		this.filename = filename;
	}

	@Override
	public Reader getReader() throws Exception {
		return new FileReader(filename);
	}
}
