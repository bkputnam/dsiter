package dsiter.parser;

import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOperatorParserInternals {

	@Test
	public void testNumberParser_int() {
		OperatorParser.AccessorContainer receiver = new OperatorParser.AccessorContainer();
		boolean success = OperatorParser.tryParseNumber("1", receiver);
		assertEquals(true, success);
		IRowAccessor accessor = receiver.astNode.link(new ColumnDescriptor[0]);
		assertEquals(ColumnType.INT, accessor.getType());
		assertEquals(1, accessor.getValueFromRow(new Row()));
	}

	@Test
	public void testNumberParser_long() {
		OperatorParser.AccessorContainer receiver = new OperatorParser.AccessorContainer();
		boolean success = OperatorParser.tryParseNumber("1234567890123456789", receiver);
		assertEquals(true, success);
		IRowAccessor accessor = receiver.astNode.link(new ColumnDescriptor[0]);
		assertEquals(ColumnType.LONG, accessor.getType());
		assertEquals(1234567890123456789L, accessor.getValueFromRow(new Row()));
	}

	@Test
	public void testNumberParser_float() {
		OperatorParser.AccessorContainer receiver = new OperatorParser.AccessorContainer();
		boolean success = OperatorParser.tryParseNumber("3.14", receiver);
		assertEquals(true, success);

		// Note: due to some difficulties in the parsing method, I couldn't figure out
		// how to tell "strings that should be floats" from "strings that should be
		// doubles" so I made them all doubles. Therefore, even though the name of this
		// method has "float" in the name, and we passed a relative simple floating-point
		// number, we still expect to see a double here.
		IRowAccessor accessor = receiver.astNode.link(new ColumnDescriptor[0]);
		assertEquals(ColumnType.DOUBLE, accessor.getType());
		assertEquals(3.14D, accessor.getValueFromRow(new Row()));
	}

	@Test
	public void testNumberParser_double() {
		OperatorParser.AccessorContainer receiver = new OperatorParser.AccessorContainer();
		boolean success = OperatorParser.tryParseNumber("3.14159265358979", receiver);
		assertEquals(true, success);
		IRowAccessor accessor = receiver.astNode.link(new ColumnDescriptor[0]);
		assertEquals(ColumnType.DOUBLE, accessor.getType());
		assertEquals(3.14159265358979, accessor.getValueFromRow(new Row()));
	}

	@Test
	public void testIsFunction() {
		assertEquals(true, OperatorParser.isFunction("sqrt("));
	}
}
