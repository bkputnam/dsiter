package blatis.operator.parser;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.ArrayIterator;
import blatis.iterator.ZipIterator;
import blatis.pipe.RenamePipe;
import blatis.row.Row;
import blatis.row.TypedRowAccessor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by bkputnam on 12/10/16.
 */
public class TestOperatorParser {

	private static AbstractDatasetIterator dummyIterator() {
		return new ZipIterator(
			new ArrayIterator(new int[] { 1 }).pipe(new RenamePipe("value", "i1")),
			new ArrayIterator(new int[] { 2 }).pipe(new RenamePipe("value", "i2")),
			new ArrayIterator(new int[] { 3 }).pipe(new RenamePipe("value", "i3")),
			new ArrayIterator(new int[] { 4 }).pipe(new RenamePipe("value", "i4")),
			new ArrayIterator(new long[] { 1234567890123456789L }).pipe(new RenamePipe("value", "l")),
			new ArrayIterator(new float[] { 3.14F }).pipe(new RenamePipe("value", "f")),
			new ArrayIterator(new double[] { 2.71 }).pipe(new RenamePipe("value", "d")),
			new ArrayIterator(new String[] { "hello world" }).pipe(new RenamePipe("value", "s")),
			new ArrayIterator(new boolean[] { true }).pipe(new RenamePipe("value", "bt")),
			new ArrayIterator(new boolean[] { false }).pipe(new RenamePipe("value", "bf"))
		);
	}

	@Test
	public void testPlusOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i1+l");
		assertTrue(iter.tryMoveNext());
		assertEquals(1234567890123456790L, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testMinusOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i4-i2");
		assertTrue(iter.tryMoveNext());
		assertEquals(2, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testTimesOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i4*i2");
		assertTrue(iter.tryMoveNext());
		assertEquals(8, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testDivideOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i4/i2");
		assertTrue(iter.tryMoveNext());
		assertEquals(2, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testDivideOperatorReals() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "d/f");
		assertTrue(iter.tryMoveNext());
		assertEquals(2.71/3.14, (double)parsed.getValueFromRow(iter.getCurrentRow()), 0.0001);
	}

	@Test
	public void testModuloOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i3/i2");
		assertTrue(iter.tryMoveNext());
		assertEquals(1, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testNotOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "!bt");
		assertTrue(iter.tryMoveNext());
		assertEquals(false, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testCaretOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i3^i4");
		assertTrue(iter.tryMoveNext());
		assertEquals(81, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testAndOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "bt&&bf");
		assertTrue(iter.tryMoveNext());
		assertEquals(false, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testOrOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "bt||bf");
		assertTrue(iter.tryMoveNext());
		assertEquals(true, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testRepeatedPluses() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i1+i1+i1+i1");
		assertTrue(iter.tryMoveNext());
		assertEquals(4, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testRepeatedDivides() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "d/f/f");
		assertTrue(iter.tryMoveNext());
		assertEquals(2.71/3.14/3.14, (double)parsed.getValueFromRow(iter.getCurrentRow()), 0.0000001);
	}

	@Test
	public void testRepeatedExponents() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i2^i3^i2");
		assertTrue(iter.tryMoveNext());
		// (2^3)^2 == 64
		// 2^(3^2) == 512
		assertEquals(512, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testPrecedence() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i2+i3*i4");
		assertTrue(iter.tryMoveNext());
		// (2+3)*4 == 20
		// 2+(3*4) == 14
		assertEquals(14, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testParenthesis() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "(i2+i3)*i4");
		assertTrue(iter.tryMoveNext());
		// (2+3)*4 == 20
		// 2+(3*4) == 14
		assertEquals(20, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testSpaces() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), " ( i2 + i3    ) * i4 ");
		assertTrue(iter.tryMoveNext());
		// (2+3)*4 == 20
		// 2+(3*4) == 14
		assertEquals(20, parsed.getValueFromRow(iter.getCurrentRow()));
	}

	@Test
	public void testSqrtOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "(i2+i3)*i4+sqrt(i4)");
		assertTrue(iter.tryMoveNext());
		assertEquals(22.0, parsed.getValueFromRow(iter.getCurrentRow()));
	}
}
