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
public class TestGreaterThanPredicate {


    @Test
    public void testGtPredicateIntTrue() {

        Row row = new Row();
        row.ints = new int[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.INT, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateIntFalse() {

        Row row = new Row();
        row.ints = new int[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.INT, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateLongTrue() {

        Row row = new Row();
        row.longs = new long[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.LONG, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateLongFalse() {

        Row row = new Row();
        row.longs = new long[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.LONG, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateFloatTrue() {

        Row row = new Row();
        row.floats = new float[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.FLOAT, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateFloatFalse() {

        Row row = new Row();
        row.floats = new float[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.FLOAT, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateDoubleTrue() {

        Row row = new Row();
        row.doubles = new double[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.DOUBLE, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateDoubleFalse() {

        Row row = new Row();
        row.doubles = new double[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.DOUBLE, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateIntEquals() {
        Row row = new Row();
        row.ints = new int[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.INT, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateLongEquals() {
        Row row = new Row();
        row.longs = new long[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.LONG, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateFloatEquals() {
        Row row = new Row();
        row.floats = new float[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.FLOAT, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testGtPredicateDoubleEquals() {
        Row row = new Row();
        row.doubles = new double[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnDescriptor.Type.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnDescriptor.Type.DOUBLE, 1).getAccessor();

        GreaterThanPredicate ltp = new GreaterThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

}
