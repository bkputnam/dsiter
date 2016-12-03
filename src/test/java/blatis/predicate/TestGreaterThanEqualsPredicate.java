package blatis.predicate;

import static org.junit.Assert.*;

import blatis.predicate.LessThanPredicate;
import blatis.row.ColumnAccessor;
import blatis.row.ColumnDescriptor;
import blatis.row.Row;
import org.junit.Test;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestGreaterThanEqualsPredicate {


    @Test
    public void testGtePredicateIntTrue() {

        Row row = new Row();
        row.ints = new int[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.INT, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateIntFalse() {

        Row row = new Row();
        row.ints = new int[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.INT, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateLongTrue() {

        Row row = new Row();
        row.longs = new long[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.LONG, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateLongFalse() {

        Row row = new Row();
        row.longs = new long[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.LONG, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateFloatTrue() {

        Row row = new Row();
        row.floats = new float[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.FLOAT, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateFloatFalse() {

        Row row = new Row();
        row.floats = new float[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.FLOAT, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateDoubleTrue() {

        Row row = new Row();
        row.doubles = new double[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.DOUBLE, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateDoubleFalse() {

        Row row = new Row();
        row.doubles = new double[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.DOUBLE, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateIntEquals() {
        Row row = new Row();
        row.ints = new int[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.INT, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateLongEquals() {
        Row row = new Row();
        row.longs = new long[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.LONG, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateFloatEquals() {
        Row row = new Row();
        row.floats = new float[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.FLOAT, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtePredicateDoubleEquals() {
        Row row = new Row();
        row.doubles = new double[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.DOUBLE, 1).getAccessor();

        GreaterThanEqualsPredicate ltp = new GreaterThanEqualsPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

}
