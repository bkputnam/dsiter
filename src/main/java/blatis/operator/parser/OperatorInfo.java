package blatis.operator.parser;

import java.util.*;

class OperatorInfo {

	public static int getNumParams(String opStr) {

		OperatorInfoItem opInfo = operatorLookup.get(opStr);
		if(opInfo != null) {
			return opInfo.numParams;
		}

		FunctionInfoItem fInfo = functionLookup.get(opStr);
		if(fInfo != null) {
			return fInfo.numParams;
		}

		throw new IllegalArgumentException("Unable to find opStr: \"" + opStr + "\"");
	}

	public static boolean isLeftAssociative(String opStr) {
		return operatorLookup.get(opStr).isLeftAssociative;
	}

	public static int getPrecedence(String opStr) {
		return precedenceLookup.get(opStr);
	}

	public static boolean isFunction(String opStr) {
		return functionLookup.containsKey(opStr);
	}

	public static boolean isOperator(String opStr) {
		return operatorLookup.containsKey(opStr);
	}

	//////////////////////////////////////////////////////////////////

	// Higher first index means higher precedence (grouped tighter)
	private static String[][] operatorPrecedences = new String[][]{
		{"||", "&&"},
		{"%"},
		{"+", "-"},
		{"*", "/"},
		{"!"},
		{"^"}
	};

	private static Set<OperatorInfoItem> operatorSet = new HashSet<>(Arrays.asList(
		new OperatorInfoItem("||", 2),
		new OperatorInfoItem("&&", 2),
		new OperatorInfoItem("%", 2),
		new OperatorInfoItem("+", 2),
		new OperatorInfoItem("-", 2),
		new OperatorInfoItem("*", 2),
		new OperatorInfoItem("/", 2),
		new OperatorInfoItem("!", 1),
		new OperatorInfoItem("^", 2, false)
	));

	private static Set<FunctionInfoItem> functionSet = new HashSet<>(Arrays.asList(
		new FunctionInfoItem("sqrt(", 1),
		new FunctionInfoItem("nroot(", 2)
	));

	private static Map<String, FunctionInfoItem> functionLookup;

	private static Map<String, OperatorInfoItem> operatorLookup;
	private static Map<String, Integer> precedenceLookup;

	static {
		operatorLookup = new HashMap<>();
		for(OperatorInfoItem opInfo : operatorSet) {
			operatorLookup.put(opInfo.str, opInfo);
		}

		precedenceLookup = new HashMap<>();
		for(int precedence=0; precedence<operatorPrecedences.length; precedence++) {
			for(int i=0; i<operatorPrecedences[precedence].length; i++) {
				precedenceLookup.put(operatorPrecedences[precedence][i], new Integer(precedence));
			}
		}

		// Sanity check: make sure all operators have a precedence
		for(OperatorInfoItem opInfo : operatorSet) {
			assert(precedenceLookup.containsKey(opInfo.str));
		}

		// Sanity check: make sure everything in precedenceLookup is
		// a real operator
		for(Map.Entry<String, Integer> kvp : precedenceLookup.entrySet()) {
			assert(operatorLookup.containsKey(kvp.getKey()));
		}

		functionLookup = new HashMap<>();
		for(FunctionInfoItem fInfo : functionSet) {
			functionLookup.put(fInfo.str, fInfo);
		}
	}


	private static class OperatorInfoItem {
		public String str;
		public int numParams;
		public boolean isLeftAssociative;

		public OperatorInfoItem(String str, int numParams) {
			this(str, numParams, true);
		}

		public OperatorInfoItem(String str, int numParams, boolean isLeftAssociative) {
			this.str = str;
			this.numParams = numParams;
			this.isLeftAssociative = isLeftAssociative;
		}
	}

	private static class FunctionInfoItem {
		public String str;
		public int numParams;

		public FunctionInfoItem(String str, int numParams) {
			this.str = str;
			this.numParams = numParams;
		}
	}
}
