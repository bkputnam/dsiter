/* GENERATED CODE */package dsiter.parser.ast;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnDescriptor;
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.accessor.GreaterThanEqualsAccessor;
/* GENERATED CODE */
/* GENERATED CODE */import java.util.Map;
/* GENERATED CODE */
/* GENERATED CODE */public class GreaterThanEqualsOperator implements AstNode {
/* GENERATED CODE */
/* GENERATED CODE */	AstNode lhsNode;
/* GENERATED CODE */	AstNode rhsNode;
/* GENERATED CODE */
/* GENERATED CODE */	public GreaterThanEqualsOperator(AstNode lhsNode, AstNode rhsNode) {
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
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.INT_INT(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.FLOAT && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.FLOAT)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.FLOAT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.FLOAT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.DOUBLE && rhsType == ColumnType.DOUBLE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */				(IRowAccessor.DOUBLE)lhs,
/* GENERATED CODE */				(IRowAccessor.DOUBLE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.JSDATE && rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.JSDATE_JSDATE(
/* GENERATED CODE */				(IRowAccessor.JSDATE)lhs,
/* GENERATED CODE */				(IRowAccessor.JSDATE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.JSDATE && rhsType == ColumnType.INT) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.JSDATE_INT(
/* GENERATED CODE */				(IRowAccessor.JSDATE)lhs,
/* GENERATED CODE */				(IRowAccessor.INT)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.JSDATE && rhsType == ColumnType.LONG) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.JSDATE_LONG(
/* GENERATED CODE */				(IRowAccessor.JSDATE)lhs,
/* GENERATED CODE */				(IRowAccessor.LONG)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.INT && rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.INT_JSDATE(
/* GENERATED CODE */				(IRowAccessor.INT)lhs,
/* GENERATED CODE */				(IRowAccessor.JSDATE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if (lhsType == ColumnType.LONG && rhsType == ColumnType.JSDATE) {
/* GENERATED CODE */			return new GreaterThanEqualsAccessor.LONG_JSDATE(
/* GENERATED CODE */				(IRowAccessor.LONG)lhs,
/* GENERATED CODE */				(IRowAccessor.JSDATE)rhs
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new LinkException(
/* GENERATED CODE */				"Unsupported operand types for GreaterThanEqualsOperator: (" +
/* GENERATED CODE */				lhsType + ", " + rhsType + ")"
/* GENERATED CODE */			);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Override
/* GENERATED CODE */	public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */		if (!(compareTo instanceof GreaterThanEqualsOperator)) {
/* GENERATED CODE */			return false;
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			GreaterThanEqualsOperator other = (GreaterThanEqualsOperator)compareTo;
/* GENERATED CODE */			return
/* GENERATED CODE */				lhsNode.matches(other.lhsNode, columnMap, constantMap) &&
/* GENERATED CODE */				rhsNode.matches(other.rhsNode, columnMap, constantMap);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */}
