package dsiter.operator;

import static org.junit.Assert.*;

import dsiter.row.IRowAccessor;
import org.junit.Test;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;

public class TestPlusOperator {

    @Test
    public void testIntInt() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getInstance(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntLong() {
		IRowAccessor ca1 = ConstantAccessor.getInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getInstance(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntFloat() {
		IRowAccessor ca1 = ConstantAccessor.getInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getInstance(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntDouble() {
		IRowAccessor ca1 = ConstantAccessor.getInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getInstance(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntString() {
		IRowAccessor ca1 = ConstantAccessor.getInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getInstance("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    // LHS = LONG ===========================================================================

    @Test
    public void testLongInt() {
		IRowAccessor ca1 = ConstantAccessor.getInstance(1L);
		IRowAccessor ca2 = ConstantAccessor.getInstance(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongLong() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongFloat() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongDouble() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongString() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getInstance("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    // LHS = FLOAT ===========================================================================

    @Test
    public void testFloatInt() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatLong() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatFloat() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatDouble() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatString() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getInstance("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("1.02", po.getValueFromRow(new Row()));
    }

    // LHS = DOUBLE ===========================================================================

    @Test
    public void testDoubleInt() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleLong() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleFloat() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleDouble() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getInstance(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleString() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getInstance("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("1.02", po.getValueFromRow(new Row()));
    }

    // LHS = STRING ===========================================================================

    @Test
    public void testStringInt() {
        IRowAccessor ca1 = ConstantAccessor.getInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getInstance(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringLong() {
        IRowAccessor ca1 = ConstantAccessor.getInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getInstance(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringFloat() {
        IRowAccessor ca1 = ConstantAccessor.getInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getInstance(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12.0", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringDouble() {
        IRowAccessor ca1 = ConstantAccessor.getInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getInstance(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12.0", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringString() {
        IRowAccessor ca1 = ConstantAccessor.getInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getInstance("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringBool() {
        IRowAccessor ca1 = ConstantAccessor.getInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getInstance(true);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("1true", po.getValueFromRow(new Row()));
    }

    // LHS = BOOLEAN ===========================================================================

    @Test
    public void testBoolString() {
        IRowAccessor ca1 = ConstantAccessor.getInstance(true);
        IRowAccessor ca2 = ConstantAccessor.getInstance("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("true2", po.getValueFromRow(new Row()));
    }
}
