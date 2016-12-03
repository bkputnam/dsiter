package blatis.predicate;

import static org.junit.Assert.*;

import blatis.row.ColumnAccessor;
import blatis.row.ColumnDescriptor;
import blatis.row.ColumnType;
import blatis.row.Row;
import org.junit.Test;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestLessThanEqualPredicate {


    @Test
    public void testLtePredicateIntTrue() {

        Row row = new Row();
        row.ints = new int[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.INT, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateIntFalse() {

        Row row = new Row();
        row.ints = new int[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.INT, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateLongTrue() {

        Row row = new Row();
        row.longs = new long[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.LONG, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateLongFalse() {

        Row row = new Row();
        row.longs = new long[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.LONG, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateFloatTrue() {

        Row row = new Row();
        row.floats = new float[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.FLOAT, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateFloatFalse() {

        Row row = new Row();
        row.floats = new float[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.FLOAT, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateDoubleTrue() {

        Row row = new Row();
        row.doubles = new double[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.DOUBLE, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateDoubleFalse() {

        Row row = new Row();
        row.doubles = new double[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.DOUBLE, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateIntEquals() {
        Row row = new Row();
        row.ints = new int[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.INT, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateLongEquals() {
        Row row = new Row();
        row.longs = new long[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.LONG, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateFloatEquals() {
        Row row = new Row();
        row.floats = new float[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.FLOAT, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtePredicateDoubleEquals() {
        Row row = new Row();
        row.doubles = new double[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.DOUBLE, 1).getAccessor();

        LessThanEqualPredicate ltp = new LessThanEqualPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

}
