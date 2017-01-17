/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import org.junit.Test;
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class TestLessThanEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtInt() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtLong() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtFloat() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtDouble() {
/* GENERATED CODE */		LessThanEqualsAccessor x = new LessThanEqualsAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
