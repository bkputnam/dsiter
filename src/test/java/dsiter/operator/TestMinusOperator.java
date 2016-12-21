package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMinusOperator {

    // LHS = INT ==========================================================================================

    @Test
    public void testIntInt() {
        int lhs = 1;
        int rhs = 5;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testIntLong() {
        int lhs = 1;
        long rhs = 5L;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testIntFloat() {
        int lhs = 1;
        float rhs = 5F;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testIntDouble() {
        int lhs = 1;
        double rhs = 5D;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    // LHS = LONG ==========================================================================================

    @Test
    public void testLongInt() {
        long lhs = 1L;
        int rhs = 5;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testLongLong() {
        long lhs = 1L;
        long rhs = 5L;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testLongFloat() {
        long lhs = 1L;
        float rhs = 5F;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testLongDouble() {
        long lhs = 1L;
        double rhs = 5D;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    // LHS = FLOAT ==========================================================================================

    @Test
    public void testFloatInt() {
        float lhs = 1F;
        int rhs = 5;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatLong() {
        float lhs = 1F;
        long rhs = 5L;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatFloat() {
        float lhs = 1F;
        float rhs = 5F;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testFloatDouble() {
        float lhs = 1F;
        double rhs = 5D;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    // LHS = DOUBLE ==========================================================================================

    @Test
    public void testDoubleInt() {
        double lhs = 1D;
        int rhs = 5;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleLong() {
        double lhs = 1D;
        long rhs = 5L;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleFloat() {
        double lhs = 1D;
        float rhs = 5F;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }

    @Test
    public void testDoubleDouble() {
        double lhs = 1D;
        double rhs = 5D;

        MinusOperator mo = new MinusOperator(
                ConstantAccessor.getInstance(lhs),
                ConstantAccessor.getInstance(rhs)
        );

        assertEquals(lhs - rhs, mo.getValueFromRow(new Row()));
    }
}
