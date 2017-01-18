package dsiter.parser.ast;

public class AstMatcher {

	public static RangeBoundaries testSimpleRangeBoundaries(AstNode node) {
		if (node instanceof AndOperator) {
			return testDoubleBound((AndOperator)node);
		}
		else {
			return testSimpleBound(node);
		}
	}

	private static RangeBoundaries testDoubleBound(AndOperator node) {
		RangeBoundaries lhsBound = testSimpleBound(node.lhsNode);
		if (lhsBound == null) {
			return null;
		}

		RangeBoundaries rhsBound = testSimpleBound(node.rhsNode);
		if (rhsBound == null) {
			return null;
		}

		if (!lhsBound.column.columnName.equals(rhsBound.column.columnName)) {
			return null;
		}

		if (lhsBound.lowerBound != null && rhsBound.upperBound != null) {
			RangeBoundaries result = new RangeBoundaries();
			result.column = lhsBound.column;
			result.lowerBound = lhsBound.lowerBound;
			result.lowerBoundInclusive = lhsBound.lowerBoundInclusive;
			result.upperBound = rhsBound.upperBound;
			result.upperBoundInclusive = rhsBound.upperBoundInclusive;
			return result;
		}
		else if (lhsBound.upperBound != null && rhsBound.lowerBound != null) {
			RangeBoundaries result = new RangeBoundaries();
			result.column = lhsBound.column;
			result.upperBound = lhsBound.upperBound;
			result.upperBoundInclusive = lhsBound.upperBoundInclusive;
			result.lowerBound = rhsBound.lowerBound;
			result.lowerBoundInclusive = rhsBound.lowerBoundInclusive;
			return result;
		}
		else {
			return null;
		}
	}

	private static RangeBoundaries testSimpleBound(AstNode node) {
		if (node instanceof LessThanOperator) {
			LessThanOperator n = (LessThanOperator)node;
			return extractUpperBound(n.lhsNode, n.rhsNode, false);
		}
		else if (node instanceof GreaterThanOperator) {
			GreaterThanOperator n = (GreaterThanOperator)node;
			return extractLowerBound(n.lhsNode, n.rhsNode, false);
		}
		else if (node instanceof LessThanEqualsOperator) {
			LessThanEqualsOperator n = (LessThanEqualsOperator)node;
			return extractUpperBound(n.lhsNode, n.rhsNode, true);
		}
		else if (node instanceof GreaterThanEqualsOperator) {
			GreaterThanEqualsOperator n = (GreaterThanEqualsOperator)node;
			return extractLowerBound(n.lhsNode, n.rhsNode, true);
		}
		else {
			return null;
		}
	}

	private static RangeBoundaries extractLowerBound(AstNode lhs, AstNode rhs, boolean inclusive) {
		ColumnConst cc = toColumnConst(lhs, rhs);
		if (cc == null) {
			return null;
		}
		else {
			RangeBoundaries result = new RangeBoundaries();
			result.column = cc.column;
			result.lowerBound = cc.constant;
			result.lowerBoundInclusive = inclusive;
			return result;
		}
	}

	private static RangeBoundaries extractUpperBound(AstNode lhs, AstNode rhs, boolean inclusive) {
		ColumnConst cc = toColumnConst(lhs, rhs);
		if (cc == null) {
			return null;
		}
		else {
			RangeBoundaries result = new RangeBoundaries();
			result.column = cc.column;
			result.upperBound = cc.constant;
			result.upperBoundInclusive = inclusive;
			return result;
		}
	}

	private static ColumnConst toColumnConst(AstNode lhs, AstNode rhs) {
		ColumnConst result = null;
		if (lhs instanceof ColumnOperator && rhs instanceof ConstantOperator) {
			result = new ColumnConst();
			result.column = (ColumnOperator)lhs;
			result.constant = (ConstantOperator)rhs;
		}
		else if (lhs instanceof ConstantOperator && rhs instanceof ColumnOperator) {
			result = new ColumnConst();
			result.column = (ColumnOperator)rhs;
			result.constant = (ConstantOperator)lhs;
		}
		return result;
	}

	public static class RangeBoundaries {
		ColumnOperator column;

		ConstantOperator lowerBound;
		boolean lowerBoundInclusive;

		ConstantOperator upperBound;
		boolean upperBoundInclusive;
	}

	private static class ColumnConst {
		ColumnOperator column;
		ConstantOperator constant;
	}
}
