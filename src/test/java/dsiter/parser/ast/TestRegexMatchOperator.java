package dsiter.parser.ast;

import dsiter.accessor.RegexMatchAccessor;
import dsiter.accessor.TestRegexMatchAccessor;
import dsiter.row.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

	private static class RmoTester {

		private String pattern;

		public RmoTester(String pattern) {
			this.pattern = pattern;
		}

		public void expect(boolean expectedResult, String sample) {
			AstNode x = new RegexMatchOperator(
				new ConstantOperator.STRING(sample),
				new ConstantOperator.STRING(pattern)
			);
			IRowAccessor y = x.link(new ColumnDescriptor[0]);
			assertEquals(expectedResult, y.getValueFromRow(new Row()));
		}
	}
}
