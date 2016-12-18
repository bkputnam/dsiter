package dsiter.operator.parser;

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
}
