package dsiter.reader;

import java.io.Reader;
import java.io.StringReader;

/**
 * {@link IReaderFactory} for {@link StringReader} instances.
 * {@link Reader} instances returned from {@link #getReader()}
 * will all read from the same string.
 */
public class StringReaderFactory implements IReaderFactory {

	String src;

	/**
	 * Construct a new StringReaderFactory that produces {@link Reader}
	 * instances that all read from the string {@code src}.
	 * @param src The string to be read by the {@code Readers}
	 */
	public StringReaderFactory(String src) {
		this.src = src;
	}

	@Override
	public Reader getReader() throws Exception {
		return new StringReader(src);
	}
}
