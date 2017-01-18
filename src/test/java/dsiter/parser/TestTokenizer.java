package dsiter.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTokenizer {

	@Test
	public void testOr() {
		String[] tokens = Tokenizer.tokenize("foo||bar");
		assertArrayEquals(new String[] { "foo", "||", "bar"}, tokens);
	}

	@Test
	public void testOrSpaces() {
		String[] tokens = Tokenizer.tokenize("foo || bar");
		assertArrayEquals(new String[] { "foo", "||", "bar"}, tokens);
	}

	@Test
	public void testFunction() {
		String[] tokens = Tokenizer.tokenize("sqrt(foo)");
		assertArrayEquals(new String[] { "sqrt(", "foo", ")"}, tokens);
	}

	@Test
	public void testParenthesis() {
		String[] tokens = Tokenizer.tokenize("(i2+i3)*i4");
		assertArrayEquals(new String[] { "(", "i2", "+", "i3", ")", "*", "i4"}, tokens);
	}

	@Test
	public void testParenthesisSpaces() {
		String[] tokens = Tokenizer.tokenize(" ( i2 + i3 ) * i4 ");
		assertArrayEquals(new String[] { "(", "i2", "+", "i3", ")", "*", "i4"}, tokens);
	}

	@Test
	public void testGratuitousSpaces() {
		String[] tokens = Tokenizer.tokenize("  ( i2 +      i3   ) *   i4  ");
		assertArrayEquals(new String[] { "(", "i2", "+", "i3", ")", "*", "i4"}, tokens);
	}

	@Test
	public void testStringLiteral() {
		String[] tokens = Tokenizer.tokenize("foo=\"hello world\"");
		assertArrayEquals(new String[] { "foo", "=", "\"hello world\""}, tokens);
	}

	@Test
	public void testStringLiteral2() {
		String[] tokens = Tokenizer.tokenize("\"hello world\"");
		assertArrayEquals(new String[] { "\"hello world\""}, tokens);
	}

	@Test
	public void testStringLiteral3() {
		String[] tokens = Tokenizer.tokenize("\"\"");
		assertArrayEquals(new String[] { "\"\""}, tokens);
	}

	@Test
	public void testIntLiteral() {
		String[] tokens = Tokenizer.tokenize("foo=1");
		assertArrayEquals(new String[] { "foo", "=", "1"}, tokens);
	}

	@Test
	public void testNegIntLiteral() {
		String[] tokens = Tokenizer.tokenize("foo=-1");
		assertArrayEquals(new String[] { "foo", "=", "-1"}, tokens);
	}

	@Test
	public void testFloatLiteral() {
		String[] tokens = Tokenizer.tokenize("foo=1.2");
		assertArrayEquals(new String[] { "foo", "=", "1.2"}, tokens);
	}

	@Test
	public void testNegFloatLiteral() {
		String[] tokens = Tokenizer.tokenize("foo=-1.2");
		assertArrayEquals(new String[] { "foo", "=", "-1.2"}, tokens);
	}

	@Test
	public void testDate_full() {
		String[] tokens = Tokenizer.tokenize("foo=2016-01-01T00:00:00Z");
		assertArrayEquals(new String[] { "foo", "=", "2016-01-01T00:00:00Z"}, tokens);
	}

	@Test
	public void testDate_noTimezone() {
		String[] tokens = Tokenizer.tokenize("foo=2016-01-01T00:00:00");
		assertArrayEquals(new String[] { "foo", "=", "2016-01-01T00:00:00"}, tokens);
	}

	@Test
	public void testDate_noTime() {
		String[] tokens = Tokenizer.tokenize("foo=2016-01-01");
		assertArrayEquals(new String[] { "foo", "=", "2016-01-01"}, tokens);
	}

	@Test
	public void testDate_noTimeWithTimezone() {
		// Not 100% sure this is a valid ISO 8601 date string, but it seems like
		// there ought to be a way to support timezones even if you don't have a
		// time.
		String[] tokens = Tokenizer.tokenize("foo=2016-01-01Z");
		assertArrayEquals(new String[] { "foo", "=", "2016-01-01Z"}, tokens);
	}
}
