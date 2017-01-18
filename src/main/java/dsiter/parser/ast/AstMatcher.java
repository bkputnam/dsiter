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

		return RangeBoundaries.tryMerge(lhsBound, rhsBound);
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
		ColumnConst cc = toColumnConst(lhs, rhs, false);
		if (cc == null) {
			return null;
		}
		else {
			return new RangeBoundaries(cc, inclusive);
		}
	}

	private static RangeBoundaries extractUpperBound(AstNode lhs, AstNode rhs, boolean inclusive) {
		ColumnConst cc = toColumnConst(lhs, rhs, true);
		if (cc == null) {
			return null;
		}
		else {
			return new RangeBoundaries(cc, inclusive);
		}
	}

	private static ColumnConst toColumnConst(AstNode lhs, AstNode rhs, boolean isUpper) {
		ColumnConst result = null;
		if (lhs instanceof ColumnOperator && rhs instanceof ConstantOperator) {
			result = new ColumnConst(
				(ColumnOperator)lhs,
				(ConstantOperator)rhs,
				isUpper
			);
		}
		else if (lhs instanceof ConstantOperator && rhs instanceof ColumnOperator) {
			result = new ColumnConst(
				(ColumnOperator)rhs,
				(ConstantOperator)lhs,
				!isUpper
			);
		}
		return result;
	}

	public static class RangeBoundaries {
		ColumnOperator column;

		ConstantOperator lowerBound;
		boolean lowerBoundInclusive;

		ConstantOperator upperBound;
		boolean upperBoundInclusive;

		private RangeBoundaries() {}

		public RangeBoundaries(ColumnConst cc, boolean isInclusive) {
			this(cc.column, cc.constant, cc.isUpperBound, isInclusive);
		}

		public RangeBoundaries(ColumnOperator column, ConstantOperator constant, boolean isUpper, boolean isInclusive) {
			this.column = column;
			if (isUpper) {
				upperBound = constant;
				upperBoundInclusive = isInclusive;
			}
			else {
				lowerBound = constant;
				lowerBoundInclusive = isInclusive;
			}
		}

		public static RangeBoundaries tryMerge(RangeBoundaries a, RangeBoundaries b) {
			if (a.lowerBound != null && b.upperBound != null) {
				RangeBoundaries result = new RangeBoundaries();
				result.column = a.column;
				result.lowerBound = a.lowerBound;
				result.lowerBoundInclusive = a.lowerBoundInclusive;
				result.upperBound = b.upperBound;
				result.upperBoundInclusive = b.upperBoundInclusive;
				return result;
			}
			else if (a.upperBound != null && b.lowerBound != null) {
				RangeBoundaries result = new RangeBoundaries();
				result.column = a.column;
				result.upperBound = a.upperBound;
				result.upperBoundInclusive = a.upperBoundInclusive;
				result.lowerBound = b.lowerBound;
				result.lowerBoundInclusive = b.lowerBoundInclusive;
				return result;
			}
			else {
				return null;
			}
		}
	}

	private static class ColumnConst {
		ColumnOperator column;
		ConstantOperator constant;
		boolean isUpperBound;

		public ColumnConst(ColumnOperator column, ConstantOperator constant, boolean isUpperBound) {
			this.column = column;
			this.constant = constant;
			this.isUpperBound = isUpperBound;
		}
	}
}
