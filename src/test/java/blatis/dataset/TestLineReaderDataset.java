package blatis.dataset;

import blatis.IteratorExpectations;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.IterUtils;
import blatis.reader.FileReaderFactory;
import blatis.reader.StringReaderFactory;
import blatis.row.Row;
import org.junit.Test;

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
}
