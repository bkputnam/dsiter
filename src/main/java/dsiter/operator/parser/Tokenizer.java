package dsiter.operator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Private class that tokenizes expression for the OperatorParser.
 * There's no great magic here - just a lot of heuristics to chop
 * up the expression correctly. It's a minor miracle it works as
 * well as it does...
 */
class Tokenizer {

	public static String[] tokenize(String input) {
		List<String> chunks = Arrays.asList(input.split("\\b"));
		List<String> result = new ArrayList<String>(chunks.size()*2); // initialCapacity should be overkill

		String lastChunk = "";
		for(int i=0; i<chunks.size(); i++) {
			processChunk(chunks.get(i), result);
		}
		return result.toArray(new String[0]);
	}

	private static void processChunk(String chunk, List<String> output) {
		chunk = chunk.trim();
		if(chunk.equals("")) {
			return;
		}
		String lastChunk = output.size() == 0 ? "" : output.get(output.size()-1);

		if(chunk.equals("(") && isAlphanumericWithUnderscores(lastChunk)) {
			// Functions should be tokenized as "foo(" rather than "foo", "("
			// but parenthesis should be respected by themselves. Functions
			// will be preceded by an identifier ("sqrt("), while parenthesis
			// will be preceded by another operator ("||(")
			int lastIndex = output.size()-1;
			output.set(lastIndex, lastChunk + "(");
		}
		else if(chunk.endsWith("(") && chunk.length() > 1) {
			// Separate operators that got glommed together like "||("
			processChunk(chunk.substring(0, chunk.length()-1), output);
			processChunk("(", output);
		}
		else if(chunk.startsWith(")") && chunk.length() > 1) {
			// Separate operators that got glommed together like ")||"
			processChunk(")", output);
			processChunk(chunk.substring(1), output);
		}
		else {
			output.add(chunk);
		}
	}

	static boolean isAlphanumericOrUnderscore(char c) {
		return
			(c >= 'a' && c <= 'z') ||
				(c >= 'A' && c <= 'Z') ||
				(c >= '0' && c <= '9') ||
				c == '_';
	}

	static boolean isAlphanumericWithUnderscores(String token) {
		int len = token.length();

		// Speed optimization: check the characters in
		// reverse order. Function tokens look a lot
		// like column tokens but they always have a
		// '(' as the last character. If we check that
		// first it should allow us to return false
		// sooner in those cases.
		for(int i=len-1; i>=0; i--) {
			if(!isAlphanumericOrUnderscore(token.charAt(i))) {
				return false;
			}
		}
		return len > 0;
	}
}
