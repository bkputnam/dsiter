package dsiter.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Private class that tokenizes expression for the OperatorParser.
 * There's no great magic here - just a lot of heuristics to chop
 * up the expression correctly. It's a minor miracle it works as
 * well as it does...
 */
final class Tokenizer {

	private Tokenizer() { throw new AssertionError("Tokenizer is non-instantiable"); }

	public static String[] tokenize(String input) {

		List<String> chunks = new ArrayList<>();
		input = input.trim();
		TokenType prevType = TokenType.NOTHING;

		int index = 0;
		while (index < input.length()) {
			TokenResult result = parseToken(input, index, prevType);
			chunks.add(result.token);
			prevType = result.type;

			index = result.endIndex;
			while (index < input.length() && isWhitespace(input.charAt(index))) {
				index++;
			}
		}

		return chunks.toArray(new String[0]);
	}

	private static TokenResult parseToken(String str, int startIndex, TokenType prevType) {
		char firstChar = str.charAt(startIndex);

		if (firstChar == '-') {
			// Special logic for '-' because it can be either a standalone astNode
			// (as in "a-b" i.e. "a minus b") or the start of a number (as in "-13")
			if (prevType == TokenType.IDENTIFIER || prevType == TokenType.NUMBER) {
				return new TokenResult(
					str.substring(startIndex, startIndex+1),
					startIndex+1,
					TokenType.OPERATOR
				);
			}
			else {
				return parseNum(str, startIndex);
			}
		}

		int operatorLength = OperatorInfo.operatorLengthAt(str, startIndex);
		if (operatorLength != -1) {
			return new TokenResult(
				str.substring(startIndex, startIndex+operatorLength),
				startIndex+operatorLength,
				TokenType.OPERATOR
			);
		}
		else if (firstChar == '"') {
			return parseStringToken(str, startIndex);
		}
		else if (isParen(firstChar)) {
			return new TokenResult(
				str.substring(startIndex, startIndex+1),
				startIndex+1,
				TokenType.PAREN
			);
		}
		else if (isNum(firstChar) || firstChar == '-') {
			int dateLength = TimeParser.dateLengthAt(str, startIndex);
			if (dateLength != -1) {
				return new TokenResult(
					str.substring(startIndex, startIndex + dateLength),
					startIndex + dateLength,
					TokenType.DATETIME
				);
			}
			else {
				return parseNum(str, startIndex);
			}
		}
		else if (isIdentifierHead(firstChar)) {
			return parseIdentifier(str, startIndex);
		}
		else {
			throw new Error(
				"Not sure how to tokenize: \"" +
				str.substring(
					startIndex,
					Math.min(str.length(), startIndex+10)
				) +
				"...\""
			);
		}
	}

	private static TokenResult parseStringToken(String str, int startIndex) {
		int endIndex = startIndex+1;
		char c;

		while ((c = str.charAt(endIndex)) != '"') {
			// Look for the sequence "backslash+quote" and if so ignore it
			// (skip both chars at once)
			if (
				c == '\\' &&
				endIndex<(str.length()-1) &&
				str.charAt(endIndex+1) == '"'
			) {
				endIndex++;
			}
			endIndex++;
		}

		return new TokenResult(
			str.substring(startIndex, endIndex+1), // +1 includes last '"'
			endIndex+1,
			TokenType.STRING
		);
	}

	private static TokenResult parseIdentifier(String str, int startIndex) {
		int endIndex = startIndex+1;
		while (
			endIndex<str.length() &&
			isIdentifierTail(str.charAt(endIndex))
		)
		{
			endIndex++;
		}

		TokenType type = TokenType.IDENTIFIER;
		if (endIndex<str.length() && str.charAt(endIndex) == '(') {
			// Potentially include one '(' at the end of an identifier, so that functions parse
			// as "foo(" instead of "foo", "("
			endIndex++;
			type = TokenType.FUNCTION;
		}

		return new TokenResult(
			str.substring(startIndex, endIndex),
			endIndex,
			type
		);
	}

	private static TokenResult parseNum(String str, int startIndex) {
		int endIndex = startIndex+1;
		while (
			endIndex<str.length() &&
			(
				isNum(str.charAt(endIndex)) ||
				str.charAt(endIndex) == '.'
			)
		)
		{
			endIndex++;
		}

		return new TokenResult(
			str.substring(startIndex, endIndex),
			endIndex,
			TokenType.NUMBER
		);
	}

	private static class TokenResult {
		public String token;
		public int endIndex;
		public TokenType type;

		public TokenResult(String token, int endIndex, TokenType type) {
			this.token = token;
			this.endIndex = endIndex;
			this.type = type;
		}
	}

	private enum TokenType {
		NOTHING,
		IDENTIFIER,
		FUNCTION,
		STRING,
		NUMBER,
		PAREN,
		OPERATOR,
		DATETIME
	}

	private static boolean isAlpha(char c) {
		return (c >= 'a' && c <= 'z') ||
			(c >= 'A' && c <= 'Z');
	}

	private static boolean isNum(char c) {
		return (c >= '0' && c <= '9');
	}

	private static boolean isAlphanum(char c) {
		return isAlpha(c) || isNum(c);
	}

	private static boolean isIdentifierHead(char c) {
		return isAlpha(c) || c == '_';
	}

	private static boolean isIdentifierTail(char c) {
		return isAlphanum(c) || c == '_';
	}

	private static boolean isParen(char c) {
		return c == '(' || c == ')';
	}

	private static boolean isWhitespace(char c) {
		// simple definition, may refine later.
		return Character.isWhitespace(c);
	}
}
