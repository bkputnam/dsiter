/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import org.junit.Test;
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class TestLessThanAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntEqDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntGtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongEqDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongGtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatEqDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatGtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtInt() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.INT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtLong() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.LONG(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtFloat() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(true, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleEqDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleGtDouble() {
/* GENERATED CODE */		LessThanAccessor x = new LessThanAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(1),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(0)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(false, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
