package dsiter.parser;

import dsiter.IterUtils;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.IDatasetIterator;
import dsiter.parser.ast.LinkException;
import org.junit.Test;

import static dsiter.StdPipes.filter;
import static dsiter.StdPipes.rename;
import static dsiter.StdPipes.zip;

public class TestRegexParsing {

	@Test
	public void testFilterAndParser() throws Exception {

		String[] samples = new String[] {
			"W",
			"WW",
			"WaW",
			"WaaaaaaW",
			"aaaaaWaaaaaaWaaaaa",
			"aaaaaWaaaaaaaaaaa"
		};

		String[] expected = new String[] {
			"WW",
			"WaW",
			"WaaaaaaW",
			"aaaaaWaaaaaaWaaaaa"
		};

		IDatasetIterator it = ArrayIterator.fromStrings(samples).pipe(filter("value~\"W.*W\""));

		IterUtils.assertValues(it, "value", expected);
	}

	@Test(expected=LinkException.class)
	public void testParserException1() throws Exception {
		IDatasetIterator it = ArrayIterator.fromStrings().pipe(filter("value~3"));
	}

	@Test(expected=LinkException.class)
	public void testParserException2() throws Exception {
		IDatasetIterator it = ArrayIterator.fromStrings()
			.pipe(zip(
				ArrayIterator.fromStrings(new String[0]).pipe(rename("value", "foo"))
			));
		IDatasetIterator it2 = it.pipe(filter("value~foo"));
	}

}
