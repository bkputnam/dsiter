/* GENERATED CODE */package dsiter.parser.ast;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnDescriptor;
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.accessor.LessThanEqualsAccessor;
/* GENERATED CODE */
/* GENERATED CODE */public class LessThanEqualsOperator implements AstNode {
/* GENERATED CODE */
/* GENERATED CODE */	private AstNode lhsNode;
/* GENERATED CODE */	private AstNode rhsNode;
/* GENERATED CODE */
/* GENERATED CODE */	public LessThanEqualsOperator(AstNode lhsNode, AstNode rhsNode) {
/* GENERATED CODE */		this.lhsNode = lhsNode;
/* GENERATED CODE */		this.rhsNode = rhsNode;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public IRowAccessor link(ColumnDescriptor[] cds) {
/* GENERATED CODE */		IRowAccessor lhs = lhsNode.link(cds);
/* GENERATED CODE */		IRowAccessor rhs = rhsNode.link(cds);
/* GENERATED CODE */
/* GENERATED CODE */		ColumnType lhsType = lhs.getType();
/* GENERATED CODE */		ColumnType rhsType = rhs.getType();
/* GENERATED CODE */
/* GENERATED CODE */		
/* GENERATED CODE */		if (lhsType == ColumnType.INT && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.INT_INT(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.JSDATE && rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.JSDATE_JSDATE(
/* GENERATED CODE */				(IRowAccessor.JSDATE)lhs,
/* GENERATED CODE */				(IRowAccessor.JSDATE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.JSDATE && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.JSDATE_INT(
/* GENERATED CODE */				(IRowAccessor.JSDATE)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.JSDATE && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.JSDATE_LONG(
/* GENERATED CODE */				(IRowAccessor.JSDATE)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.INT_JSDATE(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.JSDATE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			return new LessThanEqualsAccessor.LONG_JSDATE(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.JSDATE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new LinkException(
/* GENERATED CODE */				"Unsupported operand types for LessThanEqualsOperator: (" +
/* GENERATED CODE */				lhsType + ", " + rhsType + ")"
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */}
