package dsiter.parser;

import dsiter.parser.ast.*;

import java.time.Instant;
import java.util.*;
import java.util.regex.Matcher;

/**
 * Class for parsing strings to
 * <a href="https://en.wikipedia.org/wiki/Abstract_syntax_tree">ASTs</a>.
 * This class is non-instantiable, and only publicly provides
 * the static method {@link #parseOperator(String)}
 */
public final class OperatorParser {

	// This class is effectively static: neither abstract nor instantiable
	private OperatorParser() { throw new Error("Programmer Error: OperatorParser should never be instantiated"); }

	/**
	 * Parse an astNode string representing an expression to an astNode
	 * tree that knows how to extract and compute that expression from
	 * a Row. Besides the expression to be parsed, this method also
	 * requires a description (in the form of a {@code ColumnDescriptor[]})
	 * of the rows that the returned astNode will be operating on
	 * (e.g. for the expression {@code "foo>5"} we need to know how to
	 * extract the column {@code "foo"})
	 *
	 * @param string   The expression to be parsed
	 * @return An astNode that can compute the given expression from a
	 * Row of the expected shape.
	 */
	public static AstNode parseOperator(String string) {
		ParserState state = new ParserState();
		return parseOperatorHelper(string, state);
	}

	// The API exposed by this class is effectively stateless: no state is really
	// needed to parse these expressions. However, in the interest of code
	// readability it's convenient to break the parser function up into several
	// smaller functions. Many of those functions need to access/modify the same
	// variables over and over again, so to avoid passing half-a-dozen parameters
	// each time, we bundle them up in this object.
	//
	// There are plenty of other ways we could have designed this, but this
	// method forces us to specify which helper functions need access to the
	// "state variables" and which ones are "even more stateless" than the
	// rest.
	private static class ParserState {
		public Stack<String> operatorStack;
		public Stack<AstNode> outputStack;

		public ParserState() {
			operatorStack = new Stack<>();
			outputStack = new Stack<>();
		}
	}

	private static AstNode parseOperatorHelper(String string, ParserState state) {

		String[] tokens = Tokenizer.tokenize(string);

		// The following is a simple implementation of the Shunting Yard algorithm
		// https://en.wikipedia.org/wiki/Shunting-yard_algorithm
		//
		// A few minor modifications have been made to the algorithm:
		//	* The output queue is actually a stack, and operators are combined
		//		as they are added to the stack. This is equivalent to evaluating
		//		the reverse-polish-notation as it is generated. At the end of the
		//		algorithm there should only be one value on the stack; a single
		//		astNode instance representing the entire expression.

		AccessorContainer receiver = new AccessorContainer();

		// "While there are tokens to be read:"
		for(int tokenIndex=0; tokenIndex<tokens.length; tokenIndex++) {

			// "Read a token."
			String token = tokens[tokenIndex];

			// "If the token is a number, then push it to the output queue."
			// Note: for us, this applies equally to number literals, string literals and
			// column names.
			if(tryParseDatetime(token, receiver)) {
				state.outputStack.push(receiver.astNode);
			}
			else if(tryParseNumber(token, receiver)) {
				state.outputStack.push(receiver.astNode);
			}
			else if(token.startsWith("\"") && token.endsWith("\"")) {
				state.outputStack.push(
					new ConstantOperator.STRING(
						token.substring(1, token.length()-1)
					)
				);
			}
			else if(isColumn(token)) {
				state.outputStack.push(new ColumnOperator(token));
			}

			// "If the token is a function token, then push it onto the stack."
			else if(isFunction(token)) {
				state.operatorStack.push(token);
			}

			// """
			//	* If the token is a function argument separator (e.g., a comma):
			//		* Until the token at the top of the stack is a left parenthesis,
			// 			pop operators off the stack onto the output queue. If no left
			//			parentheses are encountered, either the separator was misplaced
			//			or parentheses were mismatched.
			// """
			// Note: for this implementation, left parenthesis are included in the
			// function token (e.g. "sqrt(") so we'll actually pop until we see a
			// function token.
			else if(token.equals(",")) {
				boolean foundFunction = false;
				do {
					String topOperator = state.operatorStack.peek();
					if(isFunction(token)) {
						foundFunction = true;
						continue;
					}
					else {
						popOperator(state);
					}
				} while(!foundFunction);
			}

			// """
			//	* If the token is an astNode, o1, then:
			//		* while there is an astNode token o2, at the top of the astNode stack and either
			//				? o1 is left-associative and its precedence is less than or equal to that of o2, or
			//				? o1 is right associative, and has precedence less than that of o2,
			//			* pop o2 off the astNode stack, onto the output queue;
			//		* at the end of iteration push o1 onto the astNode stack.
			// """
			else if(isOperator(token)) {
				String o1 = token;
				boolean done = false;
				while(!state.operatorStack.empty() && !done) {
					String o2 = state.operatorStack.peek();
					if(!isOperator(o2)) {
						done = true;
						continue;
					}
					int o1Precedence = OperatorInfo.getPrecedence(o1);
					int o2Precedence = OperatorInfo.getPrecedence(o2);
					boolean doPop = OperatorInfo.isLeftAssociative(o1)
						? (o1Precedence <= o2Precedence)
						: (o1Precedence < o2Precedence);
					done = !doPop;
					if(doPop) {
						popOperator(state); // pop o2
					}
				}
				state.operatorStack.push(o1);
			}

			// "If the token is a left parenthesis (i.e. "("), then push it onto the stack."
			else if(token.equals("(")) {
				state.operatorStack.push(token);
			}

			// """
			//	* If the token is a right parenthesis (i.e. ")"):
			//		* Until the token at the top of the stack is a left parenthesis,
			//			pop operators off the stack onto the output queue.
			//		* Pop the left parenthesis from the stack, but not onto the
			//			output queue.
			//		* If the token at the top of the stack is a function token, pop
			//			it onto the output queue.
			//		* If the stack runs out without finding a left parenthesis, then
			//			there are mismatched parentheses.
			// """
			// Note: since our function tokens include left parenthesis (e.g. "sqrt(")
			// we need to also check for that when popping things from the stack.
			else if(token.equals(")")) {
				boolean foundLParenOrFunction = false;
				String topOperator = "";
				while(!state.operatorStack.empty() && !foundLParenOrFunction) {
					topOperator = state.operatorStack.peek();
					if(!topOperator.equals("(") && !isFunction(topOperator)) {
						popOperator(state);
					}
					else {
						foundLParenOrFunction = true;
					}
				}
				if(!foundLParenOrFunction) {
					throw new IllegalArgumentException("Mismatched parenthesis in astNode string: \"" + string + "\" (extra ')')");
				}
				if(topOperator.equals("(")) {
					// pop the left parenthesis, but not onto the output queue
					// i.e. don't use popOperator()
					state.operatorStack.pop();
				}
				else {
					// top astNode is a function: pop both the astNode and the
					// left paren simultaneously
					popOperator(state);
				}
			}

			else {
				throw new IllegalArgumentException("Unrecognized token: \"" + token + "\"");
			}
		} // end foreach token loop

		//	* When there are no more tokens to read:
		//		* While there are still astNode tokens in the stack:
		//			* If the astNode token on the top of the stack is a parenthesis, then there are mismatched parentheses.
		//			* Pop the astNode onto the output queue.
		while(!state.operatorStack.empty()) {
			String topOperator = state.operatorStack.peek();
			if(topOperator.equals("(")) {
				throw new IllegalArgumentException("Mismatched parenthesis in astNode string: \"" + string + "\" (extra '(')");
			}
			popOperator(state);
		}

		if(state.outputStack.size() != 1) {
			// I'm too braindead to know what causes this right now, but if we get
			// here then clearly something went wrong.
			throw new IllegalArgumentException("Programmer Error: THERE CAN ONLY BE ONE!!");
		}

		return state.outputStack.pop();
	}

	static boolean isColumn(String token) {
		// Good enough for now.
		return isAlphaOrUnderscore(token.charAt(0)) && isAlphanumericWithUnderscores(token);
	}

	static boolean isAlphaOrUnderscore(char c) {
		return
			(c >= 'a' && c <= 'z') ||
			(c >= 'A' && c <= 'Z') ||
			c == '_';
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

	static boolean isFunction(String token) {
		char lastChar = token.charAt(token.length()-1);
		if(lastChar != '(') {
			return false;
		}
		else {
			// Strip off the trailing '(' and check if the remainder exists
			// in our functionNames set
			return OperatorInfo.isFunction(token);
		}
	}

	static boolean isOperator(String token) {
		return OperatorInfo.isOperator(token);
	}

	static class AccessorContainer {
		public AstNode astNode;
	}

	static boolean tryParseNumber(String token, AccessorContainer accessorReceiver) {

		// Speed optimization: checking just the first character manually should
		// save us from the big, slow, ugly try-catch mess below, most of the time.
		// Since tryParseNumber is one of the first things we try to parse, we're
		// expecting a high "failure" rate here.
		char firstChar = token.charAt(0);
		boolean isNumeric = (firstChar >= '0' && firstChar <= '9') || (firstChar == '-');
		if(!isNumeric) {
			return false;
		}

		// Note: this code will never attempt to parse a string as a Float, it will always
		// try to parse as a Double. The Float.parseFloat function won't throw if the
		// string has too much precision, like a large int will with Integer.parseInt.
		// Barring that, I haven't come up with a good way to differentiate "strings that
		// should be floats" from "strings that should be doubles" so I just made them
		// all doubles (that seems to be the usual practice in most Java code, anyway)
		try {
			int intVal = Integer.parseInt(token);
			accessorReceiver.astNode = new ConstantOperator.INT(intVal);
			return true;
		}
		catch (NumberFormatException e1) {
			try {
				long longVal = Long.parseLong(token);
				accessorReceiver.astNode = new ConstantOperator.LONG(longVal);
				return true;
			}
			catch (NumberFormatException e2) {
				try {
					double doubleVal = Double.parseDouble(token);
					accessorReceiver.astNode = new ConstantOperator.DOUBLE(doubleVal);
					return true;
				}
				catch (NumberFormatException e3) {
					return false;
				}
			}
		}
	}

	static boolean tryParseDatetime(String token, AccessorContainer receiver) {
		Matcher matcher = TimeParser.dateTimePattern.matcher(token);
		if (matcher.matches()) {
			switch (token.length()) {
				case 10: /* yyyy-mm-dd */ token += "T00:00:00Z"; break;
				case 11: /* yyyy-mm-ddZ */ token = token.substring(0, 10) + "T00:00:00Z"; break;
				case 19: /* yyyy-mm-ddT00:00:00 */ token += "Z"; break;
				case 20: /* yyyy-mm-ddT00:00:00Z */ break; // do nothing, token is already complete
				default:
					// If we hit this error, it means the regex let through a match of unexpected length
					// (probably means the regex has been changed since this was first written)
					throw new Error("This should be impossible");
			}
			Instant time = Instant.parse(token);
			receiver.astNode = new ConstantOperator.JSDATE(time.toEpochMilli());
			return true;
		}
		else {
			return false;
		}
	}

	static void popOperator(ParserState state) {
		String opStr = state.operatorStack.pop();
		AstNode opInst = operatorTokenToInstance(opStr, state);
		state.outputStack.push(opInst);
	}

	static AstNode operatorTokenToInstance(String operator, ParserState state) {

		if(OperatorInfo.getNumParams(operator) == 2) {

			// Remember: these are backwards because we're dealing with a stack
			// (lhs is first, so got pushed onto stack sooner)
			AstNode rhs = state.outputStack.pop();
			AstNode lhs = state.outputStack.pop();

			// This is probably a silly way to implement an astNode lookup.
			if(operator.equals("=")) {
				return new EqualsOperator(lhs, rhs);
			}
			else if(operator.equals("!=")) {
				return new NotEqualsOperator(lhs, rhs);
			}
			else if(operator.equals("<")) {
				return new LessThanOperator(lhs, rhs);
			}
			else if(operator.equals(">")) {
				return new GreaterThanOperator(lhs, rhs);
			}
			else if(operator.equals("<=")) {
				return new LessThanEqualsOperator(lhs, rhs);
			}
			else if(operator.equals(">=")) {
				return new GreaterThanEqualsOperator(lhs, rhs);
			}
			else if(operator.equals("||")) {
				return new OrOperator(lhs, rhs);
			}
			else if(operator.equals("&&")) {
				return new AndOperator(lhs, rhs);
			}
			else if(operator.equals("%")) {
				return new ModuloOperator(lhs, rhs);
			}
			else if(operator.equals("+")) {
				return new PlusOperator(lhs, rhs);
			}
			else if(operator.equals("-")) {
				return new MinusOperator(lhs, rhs);
			}
			else if(operator.equals("*")) {
				return new TimesOperator(lhs, rhs);
			}
			else if(operator.equals("/")) {
				return new DivideOperator(lhs, rhs);
			}
			else if(operator.equals("nroot(")) {
				return new NthRootOperator(lhs, rhs);
			}
			else if(operator.equals("^")) {
				return new CaretOperator(lhs, rhs);
			}
			else if(operator.equals("~")) {
				return new RegexMatchOperator(lhs, rhs);
			}
			else {
				throw new Error("Programmer Error: unrecognized binary astNode token: \"" + operator + "\"");
			}
		}
		else if(OperatorInfo.getNumParams(operator) == 1) {
			AstNode src = state.outputStack.pop();

			if(operator.equals("!")) {
				return new NotOperator(src);
			}
			else if(operator.equals("sqrt(")) {
				return new SqrtOperator(src);
			}
			else {
				throw new Error("Programmer Error: unrecognized unary astNode token: \"" + operator + "\"");
			}
		}
		else {
			throw new Error(
				"Programmer Error: Unable to determine type of \"" + operator + "\" astNode." +
				" This should be impossible."
			);
		}
	}

}
