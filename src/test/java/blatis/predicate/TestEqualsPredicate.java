package blatis.predicate;

import static org.junit.Assert.*;

import blatis.row.ColumnAccessor;
import blatis.row.ColumnType;
import blatis.row.Row;
import org.junit.Test;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestEqualsPredicate {

    @Test
    public void testIntEquals() {
        ColumnType type = ColumnType.INT;
        Row row = new Row(1, 1);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertTrue(ep.testRow(row));
    }

    @Test
    public void testIntNotEquals() {
        ColumnType type = ColumnType.INT;
        Row row = new Row(1, 2);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertFalse(ep.testRow(row));
    }

    @Test
    public void testLongEquals() {
        ColumnType type = ColumnType.LONG;
        Row row = new Row(1L, 1L);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertTrue(ep.testRow(row));
    }

    @Test
    public void testLongNotEquals() {
        ColumnType type = ColumnType.LONG;
        Row row = new Row(1L, 2L);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertFalse(ep.testRow(row));
    }

    @Test
    public void testFloatEquals() {
        ColumnType type = ColumnType.FLOAT;
        Row row = new Row(1F, 1F);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertTrue(ep.testRow(row));
    }

    @Test
    public void testFloatNotEquals() {
        ColumnType type = ColumnType.FLOAT;
        Row row = new Row(1F, 2F);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertFalse(ep.testRow(row));
    }

    @Test
    public void testDoubleEquals() {
        ColumnType type = ColumnType.DOUBLE;
        Row row = new Row(1D, 1D);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertTrue(ep.testRow(row));
    }

    @Test
    public void testDoubleNotEquals() {
        ColumnType type = ColumnType.DOUBLE;
        Row row = new Row(1D, 2D);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertFalse(ep.testRow(row));
    }

    @Test
    public void testStringEquals() {
        ColumnType type = ColumnType.STRING;
        Row row = new Row("foo", "foo");

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertTrue(ep.testRow(row));
    }

    @Test
    public void testStringNotEquals() {
        ColumnType type = ColumnType.STRING;
        Row row = new Row("foo", "bar");

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertFalse(ep.testRow(row));
    }

    @Test
    public void testBoolEquals() {
        ColumnType type = ColumnType.BOOLEAN;
        Row row = new Row(true, true);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertTrue(ep.testRow(row));
    }

    @Test
    public void testBoolNotEquals() {
        ColumnType type = ColumnType.BOOLEAN;
        Row row = new Row(true, false);

        ColumnAccessor ca1 = new ColumnAccessor(type, 0);
        ColumnAccessor ca2 = new ColumnAccessor(type, 1);

        EqualsPredicate ep = new EqualsPredicate(ca1, ca2);

        assertFalse(ep.testRow(row));
    }
}
