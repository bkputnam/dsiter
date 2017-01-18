/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import org.junit.Test;
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class TestGreaterThanEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtInt() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtLong() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtFloat() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtDouble() {
/* GENERATED CODE */		GreaterThanEqualsAccessor x = new GreaterThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
