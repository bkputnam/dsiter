/* GENERATED CODE */package dsiter.parser.ast;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.ColumnDescriptor;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import org.junit.Test;
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class TestGreaterThanEqualsOperator {
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testMatches() {
/* GENERATED CODE */		TestMatch.testBinaryOperator((lhs, rhs) -> new GreaterThanEqualsOperator(lhs, rhs));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(0),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(0),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(0),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(0),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(0),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(0),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(0),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(0),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(0),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(0),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(0),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(0),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.FLOAT(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtFloat() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtDouble() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.DOUBLE(1),
/* GENERATED CODE */			new ConstantOperator.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateLtJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(0),
/* GENERATED CODE */			new ConstantOperator.JSDATE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateEqJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(1),
/* GENERATED CODE */			new ConstantOperator.JSDATE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateGtJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(1),
/* GENERATED CODE */			new ConstantOperator.JSDATE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateLtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(0),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateEqInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(1),
/* GENERATED CODE */			new ConstantOperator.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateGtInt() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(1),
/* GENERATED CODE */			new ConstantOperator.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateLtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(0),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateEqLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(1),
/* GENERATED CODE */			new ConstantOperator.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testJsDateGtLong() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.JSDATE(1),
/* GENERATED CODE */			new ConstantOperator.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(0),
/* GENERATED CODE */			new ConstantOperator.JSDATE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.JSDATE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.INT(1),
/* GENERATED CODE */			new ConstantOperator.JSDATE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(0),
/* GENERATED CODE */			new ConstantOperator.JSDATE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(false, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.JSDATE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtJsDate() {
/* GENERATED CODE */		AstNode x = new GreaterThanEqualsOperator(
/* GENERATED CODE */			new ConstantOperator.LONG(1),
/* GENERATED CODE */			new ConstantOperator.JSDATE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		IRowAccessor y = x.link(new ColumnDescriptor[0]);
/* GENERATED CODE */		assertEquals(true, y.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
