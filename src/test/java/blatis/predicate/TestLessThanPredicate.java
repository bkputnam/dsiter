package blatis.predicate;

import static org.junit.Assert.*;

import blatis.predicate.LessThanPredicate;
import blatis.row.ColumnAccessor;
import blatis.row.ColumnDescriptor;
import blatis.row.ColumnType;
import blatis.row.Row;
import org.junit.Test;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestLessThanPredicate {


    @Test
    public void testLtPredicateIntTrue() {

        Row row = new Row();
        row.ints = new int[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.INT, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateIntFalse() {

        Row row = new Row();
        row.ints = new int[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.INT, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateLongTrue() {

        Row row = new Row();
        row.longs = new long[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.LONG, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateLongFalse() {

        Row row = new Row();
        row.longs = new long[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.LONG, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateFloatTrue() {

        Row row = new Row();
        row.floats = new float[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.FLOAT, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateFloatFalse() {

        Row row = new Row();
        row.floats = new float[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.FLOAT, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateDoubleTrue() {

        Row row = new Row();
        row.doubles = new double[] { 1, 2 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.DOUBLE, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertTrue(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateDoubleFalse() {

        Row row = new Row();
        row.doubles = new double[] { 2, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.DOUBLE, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateIntEquals() {
        Row row = new Row();
        row.ints = new int[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.INT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.INT, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateLongEquals() {
        Row row = new Row();
        row.longs = new long[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.LONG, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.LONG, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateFloatEquals() {
        Row row = new Row();
        row.floats = new float[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.FLOAT, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.FLOAT, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

    @Test
    public void testLtPredicateDoubleEquals() {
        Row row = new Row();
        row.doubles = new double[] { 1, 1 };

        ColumnAccessor ca1 = new ColumnDescriptor("a", ColumnType.DOUBLE, 0).getAccessor();
        ColumnAccessor ca2 = new ColumnDescriptor("b", ColumnType.DOUBLE, 1).getAccessor();

        LessThanPredicate ltp = new LessThanPredicate(ca1, ca2);

        assertFalse(ltp.testRow(row));
    }

}
