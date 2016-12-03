package blatis.operator;

import static org.junit.Assert.*;
import org.junit.Test;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import blatis.operator.PlusOperator;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestPlusOperator {

    @Test
    public void testIntInt() {
        ConstantAccessor ca1 = new ConstantAccessor(1);
        ConstantAccessor ca2 = new ConstantAccessor(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntLong() {
        ConstantAccessor ca1 = new ConstantAccessor(1);
        ConstantAccessor ca2 = new ConstantAccessor(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntFloat() {
        ConstantAccessor ca1 = new ConstantAccessor(1);
        ConstantAccessor ca2 = new ConstantAccessor(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntDouble() {
        ConstantAccessor ca1 = new ConstantAccessor(1);
        ConstantAccessor ca2 = new ConstantAccessor(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testIntString() {
        ConstantAccessor ca1 = new ConstantAccessor(1);
        ConstantAccessor ca2 = new ConstantAccessor("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    // LHS = LONG ===========================================================================

    @Test
    public void testLongInt() {
        ConstantAccessor ca1 = new ConstantAccessor(1L);
        ConstantAccessor ca2 = new ConstantAccessor(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongLong() {
        ConstantAccessor ca1 = new ConstantAccessor(1L);
        ConstantAccessor ca2 = new ConstantAccessor(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3L, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongFloat() {
        ConstantAccessor ca1 = new ConstantAccessor(1L);
        ConstantAccessor ca2 = new ConstantAccessor(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongDouble() {
        ConstantAccessor ca1 = new ConstantAccessor(1L);
        ConstantAccessor ca2 = new ConstantAccessor(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testLongString() {
        ConstantAccessor ca1 = new ConstantAccessor(1L);
        ConstantAccessor ca2 = new ConstantAccessor("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    // LHS = FLOAT ===========================================================================

    @Test
    public void testFloatInt() {
        ConstantAccessor ca1 = new ConstantAccessor(1F);
        ConstantAccessor ca2 = new ConstantAccessor(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatLong() {
        ConstantAccessor ca1 = new ConstantAccessor(1F);
        ConstantAccessor ca2 = new ConstantAccessor(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatFloat() {
        ConstantAccessor ca1 = new ConstantAccessor(1F);
        ConstantAccessor ca2 = new ConstantAccessor(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3F, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatDouble() {
        ConstantAccessor ca1 = new ConstantAccessor(1F);
        ConstantAccessor ca2 = new ConstantAccessor(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatString() {
        ConstantAccessor ca1 = new ConstantAccessor(1F);
        ConstantAccessor ca2 = new ConstantAccessor("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("1.02", po.getValueFromRow(new Row()));
    }

    // LHS = DOUBLE ===========================================================================

    @Test
    public void testDoubleInt() {
        ConstantAccessor ca1 = new ConstantAccessor(1D);
        ConstantAccessor ca2 = new ConstantAccessor(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleLong() {
        ConstantAccessor ca1 = new ConstantAccessor(1D);
        ConstantAccessor ca2 = new ConstantAccessor(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleFloat() {
        ConstantAccessor ca1 = new ConstantAccessor(1D);
        ConstantAccessor ca2 = new ConstantAccessor(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleDouble() {
        ConstantAccessor ca1 = new ConstantAccessor(1D);
        ConstantAccessor ca2 = new ConstantAccessor(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals(3D, po.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleString() {
        ConstantAccessor ca1 = new ConstantAccessor(1D);
        ConstantAccessor ca2 = new ConstantAccessor("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("1.02", po.getValueFromRow(new Row()));
    }

    // LHS = STRING ===========================================================================

    @Test
    public void testStringInt() {
        ConstantAccessor ca1 = new ConstantAccessor("1");
        ConstantAccessor ca2 = new ConstantAccessor(2);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringLong() {
        ConstantAccessor ca1 = new ConstantAccessor("1");
        ConstantAccessor ca2 = new ConstantAccessor(2L);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringFloat() {
        ConstantAccessor ca1 = new ConstantAccessor("1");
        ConstantAccessor ca2 = new ConstantAccessor(2F);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12.0", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringDouble() {
        ConstantAccessor ca1 = new ConstantAccessor("1");
        ConstantAccessor ca2 = new ConstantAccessor(2D);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12.0", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringString() {
        ConstantAccessor ca1 = new ConstantAccessor("1");
        ConstantAccessor ca2 = new ConstantAccessor("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("12", po.getValueFromRow(new Row()));
    }

    @Test
    public void testStringBool() {
        ConstantAccessor ca1 = new ConstantAccessor("1");
        ConstantAccessor ca2 = new ConstantAccessor(true);

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("1true", po.getValueFromRow(new Row()));
    }

    // LHS = BOOLEAN ===========================================================================

    @Test
    public void testBoolString() {
        ConstantAccessor ca1 = new ConstantAccessor(true);
        ConstantAccessor ca2 = new ConstantAccessor("2");

        PlusOperator po = new PlusOperator(ca1, ca2);

        assertEquals("true2", po.getValueFromRow(new Row()));
    }
}
