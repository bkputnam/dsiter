package dsiter.accessor;

import dsiter.IterUtils;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.IDatasetIterator;
import dsiter.parser.RegexParseException;
import dsiter.row.ColumnType;
import dsiter.row.IColumnAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;
import static dsiter.StdPipes.*;

public class TestRegexMatchAccessor {

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

	private static class RmoTester {

		private RegexMatchAccessor rmo;
		private Row row;

		public RmoTester(String pattern) {
			rmo = new RegexMatchAccessor(
				IColumnAccessor.getInstance(ColumnType.STRING, 0).asStringAccessor(),
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