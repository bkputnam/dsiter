package dsiter.row;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestParserMutator {

    @Test
    public void testInts() {
        IParserMutator pm = IParserMutator.getInstance(ColumnType.INT, 0);

        Row dest = new Row();
        dest.ints = new int[1];

        pm.parseAndMutate("12345", dest);

        assertEquals(12345, dest.ints[0]);
    }

    @Test
    public void testLongs() {
        IParserMutator pm = IParserMutator.getInstance(ColumnType.LONG, 0);

        Row dest = new Row();
        dest.longs = new long[1];

        pm.parseAndMutate("1234567890123456789", dest);

        assertEquals(1234567890123456789L, dest.longs[0]);
    }

    @Test
    public void testFloats() {
        IParserMutator pm = IParserMutator.getInstance(ColumnType.FLOAT, 0);

        Row dest = new Row();
        dest.floats = new float[1];

        pm.parseAndMutate("3.14", dest);

        assertEquals(3.14F, dest.floats[0], 0.0000001);
    }

    @Test
    public void testDoubles() {
        IParserMutator pm = IParserMutator.getInstance(ColumnType.DOUBLE, 0);

        Row dest = new Row();
        dest.doubles = new double[1];

        pm.parseAndMutate("3.14", dest);

        assertEquals(3.14D, dest.doubles[0], 0.00000000001);
    }

    @Test
    public void testStrings() {
        IParserMutator pm = IParserMutator.getInstance(ColumnType.STRING, 0);

        Row dest = new Row();
        dest.strings = new String[1];

        pm.parseAndMutate("12345", dest);

        assertEquals("12345", dest.strings[0]);
    }

    @Test
    public void testBools() {
        IParserMutator pm = IParserMutator.getInstance(ColumnType.BOOLEAN, 0);

        Row dest = new Row();
        dest.bools = new boolean[1];

        pm.parseAndMutate("True", dest);

        assertEquals(true, dest.bools[0]);
    }
}
