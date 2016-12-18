package dsiter.reader;

import java.io.Reader;
import java.io.StringReader;

public class StringReaderFactory implements IReaderFactory {

	String src;

	public StringReaderFactory(String src) {
		this.src = src;
	}

	@Override
	public Reader getReader() throws Exception {
		return new StringReader(src);
	}
}
