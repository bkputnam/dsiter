package dsiter.accessor;

import static org.junit.Assert.*;

import dsiter.row.IRowAccessor;
import org.junit.Test;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;

public class TestPlusOperator {

    @Test
    public void testIntInt() {
        IRowAccessor ca1 = ConstantAccessor.getIntInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getIntInstance(2);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntLong() {
		IRowAccessor ca1 = ConstantAccessor.getIntInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getLongInstance(2L);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntFloat() {
		IRowAccessor ca1 = ConstantAccessor.getIntInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getFloatInstance(2F);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntDouble() {
		IRowAccessor ca1 = ConstantAccessor.getIntInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getDoubleInstance(2D);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntString() {
		IRowAccessor ca1 = ConstantAccessor.getIntInstance(1);
		IRowAccessor ca2 = ConstantAccessor.getStringInstance("2");

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    // LHS = LONG ===========================================================================

    @Test
    public void testLongInt() {
		IRowAccessor ca1 = ConstantAccessor.getLongInstance(1L);
		IRowAccessor ca2 = ConstantAccessor.getIntInstance(2);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongLong() {
        IRowAccessor ca1 = ConstantAccessor.getLongInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getLongInstance(2L);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongFloat() {
        IRowAccessor ca1 = ConstantAccessor.getLongInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getFloatInstance(2F);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongDouble() {
        IRowAccessor ca1 = ConstantAccessor.getLongInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getDoubleInstance(2D);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongString() {
        IRowAccessor ca1 = ConstantAccessor.getLongInstance(1L);
        IRowAccessor ca2 = ConstantAccessor.getStringInstance("2");

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    // LHS = FLOAT ===========================================================================

    @Test
    public void testFloatInt() {
        IRowAccessor ca1 = ConstantAccessor.getFloatInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getIntInstance(2);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatLong() {
        IRowAccessor ca1 = ConstantAccessor.getFloatInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getLongInstance(2L);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatFloat() {
        IRowAccessor ca1 = ConstantAccessor.getFloatInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getFloatInstance(2F);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatDouble() {
        IRowAccessor ca1 = ConstantAccessor.getFloatInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getDoubleInstance(2D);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatString() {
        IRowAccessor ca1 = ConstantAccessor.getFloatInstance(1F);
        IRowAccessor ca2 = ConstantAccessor.getStringInstance("2");

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("1.02", po.getValueFromRow(new Row()));
    }

    // LHS = DOUBLE ===========================================================================

    @Test
    public void testDoubleInt() {
        IRowAccessor ca1 = ConstantAccessor.getDoubleInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getIntInstance(2);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleLong() {
        IRowAccessor ca1 = ConstantAccessor.getDoubleInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getLongInstance(2L);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleFloat() {
        IRowAccessor ca1 = ConstantAccessor.getDoubleInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getFloatInstance(2F);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleDouble() {
        IRowAccessor ca1 = ConstantAccessor.getDoubleInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getDoubleInstance(2D);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleString() {
        IRowAccessor ca1 = ConstantAccessor.getDoubleInstance(1D);
        IRowAccessor ca2 = ConstantAccessor.getStringInstance("2");

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("1.02", po.getValueFromRow(new Row()));
    }

    // LHS = STRING ===========================================================================

    @Test
    public void testStringInt() {
        IRowAccessor ca1 = ConstantAccessor.getStringInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getIntInstance(2);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringLong() {
        IRowAccessor ca1 = ConstantAccessor.getStringInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getLongInstance(2L);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringFloat() {
        IRowAccessor ca1 = ConstantAccessor.getStringInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getFloatInstance(2F);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12.0", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringDouble() {
        IRowAccessor ca1 = ConstantAccessor.getStringInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getDoubleInstance(2D);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12.0", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringString() {
        IRowAccessor ca1 = ConstantAccessor.getStringInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getStringInstance("2");

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringBool() {
        IRowAccessor ca1 = ConstantAccessor.getStringInstance("1");
        IRowAccessor ca2 = ConstantAccessor.getBoolInstance(true);

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("1true", po.getValueFromRow(new Row()));
    }

    // LHS = BOOLEAN ===========================================================================

    @Test
    public void testBoolString() {
        IRowAccessor ca1 = ConstantAccessor.getBoolInstance(true);
        IRowAccessor ca2 = ConstantAccessor.getStringInstance("2");

        PlusAccessor po = new PlusAccessor(ca1, ca2);

        assertEquals("true2", po.getValueFromRow(new Row()));
    }
}
