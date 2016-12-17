package blatis.reader;

import java.io.FileReader;
import java.io.Reader;
import java.net.URL;

public class FileReaderFactory implements IReaderFactory {

	private String filename;

	public FileReaderFactory(String filename) {
		this.filename = filename;
	}

//	public static FileReaderFactory fromResource(String resourceName) {
//		ClassLoader cl = FileReaderFactory.class.getClassLoader();
//		URL url = cl.getResource(resourceName);
//		String fullName = cl.getResource(resourceName).getPath();
//		return new FileReaderFactory(fullName);
//	}

	@Override
	public Reader getReader() throws Exception {
		return new FileReader(filename);
	}
}
