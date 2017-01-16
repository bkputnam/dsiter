package dsiter.operator.parser;

import dsiter.IterUtils;
import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.ZipIterator;
import dsiter.pipe.RenamePipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;
import static dsiter.StdPipes.*;

/**
 * Created by bkputnam on 12/10/16.
 */
public class TestOperatorParser {

	private static IDatasetIterator dummyIterator() {
		return new ZipIterator(
			ArrayIterator.fromInts(new int[] { 1 }).pipe(new RenamePipe("value", "i1")),
			ArrayIterator.fromInts(new int[] { 2 }).pipe(new RenamePipe("value", "i2")),
			ArrayIterator.fromInts(new int[] { 3 }).pipe(new RenamePipe("value", "i3")),
			ArrayIterator.fromInts(new int[] { 4 }).pipe(new RenamePipe("value", "i4")),
			ArrayIterator.fromLongs(new long[] { 1234567890123456789L }).pipe(new RenamePipe("value", "l")),
			ArrayIterator.fromFloats(new float[] { 3.14F }).pipe(new RenamePipe("value", "f")),
			ArrayIterator.fromDoubles(new double[] { 2.71 }).pipe(new RenamePipe("value", "d")),
			ArrayIterator.fromStrings(new String[] { "hello world" }).pipe(new RenamePipe("value", "s")),
			ArrayIterator.fromBools(new boolean[] { true }).pipe(new RenamePipe("value", "bt")),
			ArrayIterator.fromBools(new boolean[] { false }).pipe(new RenamePipe("value", "bf"))
		);
	}

	@Test
	public void testPlusOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i1+l");
			assertTrue(iter.tryMoveNext());
			assertEquals(1234567890123456790L, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testMinusOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i4-i2");
			assertTrue(iter.tryMoveNext());
			assertEquals(2, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testTimesOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i4*i2");
			assertTrue(iter.tryMoveNext());
			assertEquals(8, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testDivideOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i4/i2");
			assertTrue(iter.tryMoveNext());
			assertEquals(2, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testDivideOperatorReals() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "d/f");
			assertTrue(iter.tryMoveNext());
			assertEquals(2.71 / 3.14, (double) parsed.getValueFromRow(iter.getCurrentRow()), 0.0001);
		}
	}

	@Test
	public void testModuloOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i3/i2");
			assertTrue(iter.tryMoveNext());
			assertEquals(1, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testNotOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "!bt");
			assertTrue(iter.tryMoveNext());
			assertEquals(false, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testCaretOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i3^i4");
			assertTrue(iter.tryMoveNext());
			assertEquals(81, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testAndOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "bt&&bf");
			assertTrue(iter.tryMoveNext());
			assertEquals(false, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testOrOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "bt||bf");
			assertTrue(iter.tryMoveNext());
			assertEquals(true, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testRepeatedPluses() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i1+i1+i1+i1");
			assertTrue(iter.tryMoveNext());
			assertEquals(4, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testRepeatedDivides() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "d/f/f");
			assertTrue(iter.tryMoveNext());
			assertEquals(2.71 / 3.14 / 3.14, (double) parsed.getValueFromRow(iter.getCurrentRow()), 0.0000001);
		}
	}

	@Test
	public void testRepeatedExponents() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i2^i3^i2");
			assertTrue(iter.tryMoveNext());
			// (2^3)^2 == 64
			// 2^(3^2) == 512
			assertEquals(512, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testPrecedence() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i2+i3*i4");
			assertTrue(iter.tryMoveNext());
			// (2+3)*4 == 20
			// 2+(3*4) == 14
			assertEquals(14, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testParenthesis() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "(i2+i3)*i4");
			assertTrue(iter.tryMoveNext());
			// (2+3)*4 == 20
			// 2+(3*4) == 14
			assertEquals(20, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testSpaces() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), " ( i2 + i3    ) * i4 ");
			assertTrue(iter.tryMoveNext());
			// (2+3)*4 == 20
			// 2+(3*4) == 14
			assertEquals(20, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testSqrtOperator() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "(i2+i3)*i4+sqrt(i4)");
			assertTrue(iter.tryMoveNext());
			assertEquals(22.0, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testStringEqualsTrue() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "s=\"hello world\"");
			assertTrue(iter.tryMoveNext());
			assertEquals(true, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testStringEqualsFalse() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "s=\"blergh\"");
			assertTrue(iter.tryMoveNext());
			assertEquals(false, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testNotEquals1() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i1!=2");
			assertTrue(iter.tryMoveNext());
			assertEquals(true, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testNotEquals2() throws Exception {
		try (IDatasetIterator iter = dummyIterator()) {
			IRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i1!=1");
			assertTrue(iter.tryMoveNext());
			assertEquals(false, parsed.getValueFromRow(iter.getCurrentRow()));
		}
	}

	@Test
	public void testDateParser1() {
		IRowAccessor accessor = OperatorParser.parseOperator(new ColumnDescriptor[0], "1970-01-01T00:00:00Z");
		Object val = accessor.getValueFromRow(new Row());
		assertEquals(0L, val);
	}

	@Test
	public void testDateParser2() {
		IRowAccessor accessor = OperatorParser.parseOperator(new ColumnDescriptor[0], "1970-01-01T00:00:05Z");
		Object val = accessor.getValueFromRow(new Row());
		assertEquals(5000L, val);
	}

	@Test
	public void testDateParser3() {
		IRowAccessor accessor = OperatorParser.parseOperator(new ColumnDescriptor[0], "1970-01-01T00:00:05");
		Object val = accessor.getValueFromRow(new Row());
		assertEquals(5000L, val);
	}

	@Test
	public void testDateParser4() {
		IRowAccessor accessor = OperatorParser.parseOperator(new ColumnDescriptor[0], "1970-01-01Z");
		Object val = accessor.getValueFromRow(new Row());
		assertEquals(0L, val);
	}

	@Test
	public void testDateParser5() {
		IRowAccessor accessor = OperatorParser.parseOperator(new ColumnDescriptor[0], "1970-01-01");
		Object val = accessor.getValueFromRow(new Row());
		assertEquals(0L, val);
	}

	@Test
	public void testDateParser6() throws Exception {
		IDatasetIterator it = ArrayIterator.fromJsDates(
			Instant.parse("1970-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("1980-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("1990-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("2000-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("2001-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("2002-01-01T00:00:00Z").toEpochMilli()
		)
		.pipe(filter("value>=2000-01-01"));

		IterUtils.assertValues(it, "value", new Long[] {
			Instant.parse("2000-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("2001-01-01T00:00:00Z").toEpochMilli(),
			Instant.parse("2002-01-01T00:00:00Z").toEpochMilli()
		});
	}
}
