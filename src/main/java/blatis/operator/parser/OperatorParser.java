package blatis.operator.parser;

import blatis.row.*;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by bkputnam on 12/9/16.
 */
public class OperatorParser {

	// Higher first index means higher precedence (grouped tighter)
	static String[][] operatorPrecedences = new String[][]{
		{"||", "&&"},
		{"%"},
		{"+", "-"},
		{"*", "/"},
		{"!"}
	};

	static Set<String> operatorStrings;
	static Map<String, Integer> operatorPrecedenceLookup;

	static {
		operatorStrings = new HashSet<>();
		operatorPrecedenceLookup = new HashMap<>();

		for(int precedence=0; precedence<operatorPrecedences.length; precedence++) {
			for(int i=0; i<operatorPrecedences[precedence].length; i++) {
				String operatorStr = operatorPrecedences[precedence][i];
				operatorStrings.add(operatorStr);
				operatorPrecedenceLookup.put(operatorStr, precedence);

			}
		}
	}

	public static TypedRowAccessor parseOperator(ColumnDescriptor[] metadata, String string) {

		HashMap<String, ColumnAccessor> accessorLookup = new HashMap<>();
		for(int i=0; i<metadata.length; i++) {
			ColumnDescriptor cd = metadata[i];
			accessorLookup.put(cd.getName(), cd.getAccessor());
		}

		String[] tokens = tokenize(string);

		// The following is a simple implementation of the Shunting Yard algorithm
		// https://en.wikipedia.org/wiki/Shunting-yard_algorithm
		//
		// The one modification made to the wikipedia algorithm, is that operators
		// are combined upon being sent to the output. Hence, output is a stack
		// instead of a queue, because we'll be popping things off the stack as
		// we go. At the end, there should only be one item on the stack; a single
		// operator representing the whole expression.

		Stack<TypedRowAccessor> operatorStack = new Stack<TypedRowAccessor>();
		Stack<TypedRowAccessor> outputStack = new Stack<TypedRowAccessor>();

		for(int tokenIndex=0; tokenIndex<tokens.length; tokenIndex++) {
			String token = tokens[tokenIndex];
			if(isColumn(token)) {
				ColumnAccessor ca = accessorLookup.get(token);
				if(ca == null) { throw new IllegalArgumentException("Unable to find column \"" + token + "\""); }
				outputStack.push(ca);
			}
			else if(isOperator(token)) {

			}
			else {
				throw new IllegalArgumentException("Unrecognized token: \"" + token + "\"");
			}
		}

		return null;
	}

	static String[] tokenize(String input) {
		String[] chunks = input.split("\\b");
		String[] result = new String[chunks.length];
		for(int i=0; i<chunks.length; i++) {
			result[i] = chunks[i].trim();
		}
		return result;
	}

	static boolean isColumn(String token) {
		char firstChar = token.charAt(0);
		return ((firstChar > 'a' && firstChar < 'z') || (firstChar > 'A' && firstChar < 'Z'));
	}

	static boolean isOperator(String token) {
		return operatorStrings.contains(token);
	}

	static class AccessorContainer {
		public IRowAccessor accessor;
	}

	static boolean tryParseNumber(String token, AccessorContainer accessorReceiver) {
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
			accessorReceiver.accessor = new ConstantAccessor(intVal);
			return true;
		}
		catch (NumberFormatException e1) {
			try {
				long longVal = Long.parseLong(token);
				accessorReceiver.accessor = new ConstantAccessor(longVal);
				return true;
			}
			catch (NumberFormatException e2) {
				try {
					double doubleVal = Double.parseDouble(token);
					accessorReceiver.accessor = new ConstantAccessor(doubleVal);
					return true;
				}
				catch (NumberFormatException e3) {
					return false;
				}
			}
		}
	}

}
