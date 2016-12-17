package blatis.reader;

import java.io.FileReader;
import java.io.Reader;
import java.net.URL;

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
