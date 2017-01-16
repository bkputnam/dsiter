package dsiter.operator;

import dsiter.IterUtils;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.IDatasetIterator;
import dsiter.row.ColumnType;
import dsiter.row.IColumnAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static dsiter.StdPipes.*;

import static org.junit.Assert.*;

public class TestRegexMatchOperator {

	@Test
	public void testW() {
		RmoTester t = new RmoTester("W");
		t.expect(true, "W");
		t.expect(true, "aW");
		t.expect(true, "Wa");
		t.expect(true, "aaaaWaaaaaWaaaaaa");


		t.expect(false, "a");
		t.expect(false, "aaaaaaa");
	}

	@Test
	public void testDotStar() {
		RmoTester t = new RmoTester("W.*W");
		t.expect(false, "W");
		t.expect(true, "WW");
		t.expect(true, "WaW");
		t.expect(true, "WaaaaaaW");
		t.expect(true, "aaaaaWaaaaaaWaaaaa");
		t.expect(false, "aaaaaWaaaaaaaaaaa");
	}

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

	@Test(expected=RegexParseException.class)
	public void testParserException1() {
		IDatasetIterator it = ArrayIterator.fromStrings().pipe(filter("value~3"));
	}

	@Test(expected=RegexParseException.class)
	public void testParserException2() {
		IDatasetIterator it = ArrayIterator.fromStrings()
			.pipe(zip(
				ArrayIterator.fromStrings(new String[0]).pipe(rename("value", "foo"))
			));
		IDatasetIterator it2 = it.pipe(filter("value~foo"));
	}

	private static class RmoTester {

		private RegexMatchOperator rmo;
		private Row row;

		public RmoTester(String pattern) {
			rmo = new RegexMatchOperator(
				IColumnAccessor.getInstance(ColumnType.STRING, 0),
				pattern
			);

			row = new Row();
			row.strings = new String[1];
		}

		public void expect(boolean expectedResult, String sample) {
			row.strings[0] = sample;
			assertEquals(expectedResult, rmo.getValueFromRow(row));
		}
	}
}
