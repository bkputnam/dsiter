package dsiter.reader;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderFactory implements IReaderFactory {

	private String filename;

	public FileReaderFactory(String filename) {
		this.filename = filename;
	}

	@Override
	public Reader getReader() throws Exception {
		return new FileReader(filename);
	}
}
