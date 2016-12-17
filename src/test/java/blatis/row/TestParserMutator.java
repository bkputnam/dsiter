package blatis.row;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestParserMutator {

	@Test
	public void testIntParser() {
		IParserMutator pm = ParserMutator.getInstance(ColumnType.INT, 0);

		Row row = new Row(new int[1]);

		pm.parseAndMutate("123", row);

		assertEquals(123, row.ints[0]);
	}

	@Test
	public void testLongParser() {
		IParserMutator pm = ParserMutator.getInstance(ColumnType.LONG, 0);

		Row row = new Row(new long[1]);

		pm.parseAndMutate("1234567890123456789", row);

		assertEquals(1234567890123456789L, row.longs[0]);
	}

	@Test
	public void testFloatParser() {
		IParserMutator pm = ParserMutator.getInstance(ColumnType.FLOAT, 0);

		Row row = new Row(new float[1]);

		pm.parseAndMutate("3.14", row);

		assertEquals(3.14F, row.floats[0], 0.0001);
	}

	@Test
	public void testDoubleParser() {
		IParserMutator pm = ParserMutator.getInstance(ColumnType.DOUBLE, 0);

		Row row = new Row(new double[1]);

		pm.parseAndMutate("3.1415926", row);

		assertEquals(3.1415926, row.doubles[0], 0.000000001);
	}

	@Test
	public void testStringParser() {
		IParserMutator pm = ParserMutator.getInstance(ColumnType.STRING, 0);

		Row row = new Row(new String[1]);

		pm.parseAndMutate("3.1415926", row);

		assertEquals("3.1415926", row.strings[0]);
	}

	@Test
	public void testBoolParser() {
		IParserMutator pm = ParserMutator.getInstance(ColumnType.BOOLEAN, 0);

		Row row = new Row(new boolean[1]);

		pm.parseAndMutate("True", row);

		assertEquals(true, row.bools[0]);
	}
}
