/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import org.junit.Test;
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class TestGreaterThanAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtInt() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtLong() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtFloat() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtDouble() {
/* GENERATED CODE */		GreaterThanAccessor x = new GreaterThanAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
