package dsiter.dataset;

import dsiter.IterUtils;
import dsiter.IteratorExpectations;
import dsiter.reader.FileReaderFactory;
import dsiter.reader.StringReaderFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLineReaderDataset {

	@Test
	public void testStringReader() throws Exception {
		String src = "Hello there\nworld\nfoo\n\n";

		LineReaderDataset lrd = new LineReaderDataset(
			new StringReaderFactory(src)
		);

		String[] expectedLines = new String[] {
			"Hello there",
			"world",
			"foo",
			""
		};

		IterUtils.assertValues(lrd.getIterator(), "line", expectedLines);
	}

	@Test
	public void testFileReader() throws Exception {

		String filename = this.getClass().getResource("simple.csv").getFile();

		LineReaderDataset lrd = new LineReaderDataset(
			new FileReaderFactory(filename)
		);

		IteratorExpectations e = new IteratorExpectations();
		e.expectStrings("line",
			"foo	bar	baz",
			"1	1.5	frib",
			"2	2.5	frob",
			"3	3.5	fraz"
		);

		e.checkIterator(lrd.getIterator());
	}

	@Test
	public void testLength() throws Exception {
		LineReaderDataset lrd = LineReaderDataset.fromString("a\nb\nc");
		assertEquals(-1, lrd.getIterator().tryGetLength());
	}
}
