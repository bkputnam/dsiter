/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */import org.junit.Test;
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class TestNthRootAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntInt() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.INT_INT(
/* GENERATED CODE */			new ConstantAccessor.INT(8),
/* GENERATED CODE */			new ConstantAccessor.INT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntLong() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.INT_LONG(
/* GENERATED CODE */			new ConstantAccessor.INT(8),
/* GENERATED CODE */			new ConstantAccessor.LONG(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntFloat() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.INT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.INT(8),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testIntDouble() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.INT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.INT(8),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongInt() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.LONG_INT(
/* GENERATED CODE */			new ConstantAccessor.LONG(8),
/* GENERATED CODE */			new ConstantAccessor.INT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongLong() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.LONG_LONG(
/* GENERATED CODE */			new ConstantAccessor.LONG(8),
/* GENERATED CODE */			new ConstantAccessor.LONG(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongFloat() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.LONG_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.LONG(8),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testLongDouble() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.LONG_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.LONG(8),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatInt() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.FLOAT_INT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(8),
/* GENERATED CODE */			new ConstantAccessor.INT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatLong() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.FLOAT_LONG(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(8),
/* GENERATED CODE */			new ConstantAccessor.LONG(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatFloat() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.FLOAT_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(8),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testFloatDouble() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.FLOAT_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.FLOAT(8),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleInt() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.DOUBLE_INT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(8),
/* GENERATED CODE */			new ConstantAccessor.INT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleLong() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.DOUBLE_LONG(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(8),
/* GENERATED CODE */			new ConstantAccessor.LONG(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleFloat() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.DOUBLE_FLOAT(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(8),
/* GENERATED CODE */			new ConstantAccessor.FLOAT(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	@Test
/* GENERATED CODE */	public void testDoubleDouble() {
/* GENERATED CODE */		IRowAccessor x = new NthRootAccessor.DOUBLE_DOUBLE(
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(8),
/* GENERATED CODE */			new ConstantAccessor.DOUBLE(3)
/* GENERATED CODE */		);
/* GENERATED CODE */		assertEquals(2D, x.getValueFromRow(new Row()));
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */
/* GENERATED CODE */}
