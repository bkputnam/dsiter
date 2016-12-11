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
			new ArrayIterator(new int[] { 1 }).pipe(new RenamePipe("value", "i")),
			new ArrayIterator(new long[] { 1234567890123456789L }).pipe(new RenamePipe("value", "l")),
			new ArrayIterator(new float[] { 3.14F }).pipe(new RenamePipe("value", "f")),
			new ArrayIterator(new double[] { 2.71 }).pipe(new RenamePipe("value", "d")),
			new ArrayIterator(new String[] { "hello world" }).pipe(new RenamePipe("value", "s")),
			new ArrayIterator(new boolean[] { true }).pipe(new RenamePipe("value", "b"))
		);
	}

	@Test
	public void testPlusOperator() {
		AbstractDatasetIterator iter = dummyIterator();
		TypedRowAccessor parsed = OperatorParser.parseOperator(iter.getColumnDescriptors(), "i+l");
		assertTrue(iter.tryMoveNext());
		assertEquals(1234567890123456790L, parsed.getValueFromRow(iter.getCurrentRow()));
	}
}
