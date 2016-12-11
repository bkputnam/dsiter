package blatis.pipe;

import static org.junit.Assert.*;

import blatis.iterator.*;
import org.junit.Test;

import blatis.dataset.RangeDataset;
import blatis.row.ColumnDescriptor;
import blatis.row.ColumnAccessor;
import blatis.row.Row;

public class TestZipIterator {

	@Test
	public void testZipIterator() {

		AbstractDatasetIterator leftIter = new RenameIterator(
			(new RangeDataset(5)).getIterator(),
			"value",
			"a"
		);
		AbstractDatasetIterator rightIter = new RenameIterator(
			new StrideIterator(
				(new RangeDataset(10)).getIterator(),
				2
			),
			"value",
			"b"
		);

		AbstractDatasetIterator it = new ZipIterator(leftIter, rightIter);

		ColumnDescriptor[] cds = it.getColumnDescriptors();
		assertEquals(2, cds.length);
		assertEquals("a", cds[0].getName());
		assertEquals("b", cds[1].getName());

		ColumnAccessor[] cas = new ColumnAccessor[] {
			cds[0].getAccessor(),
			cds[1].getAccessor(),
		};

		int[][] expectedVals = new int[][] {
			{0, 0},
			{1, 2},
			{2, 4},
			{3, 6},
			{4, 8}
		};

		int count = 0;
		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();

			assertEquals(expectedVals[count][0], cas[0].getValueFromRow(row));
			assertEquals(expectedVals[count][1], cas[1].getValueFromRow(row));
			count++;
		}

		assertEquals(5, count);
	}

	@Test
	public void testMultiZip() {

		int[] vals1 = new int[] { 1, 2, 3, 4, 5, };
		float[] vals2 = new float[] { 3.142f, 2.718f, 0f, 1f, -1f };
		boolean[] vals3 = new boolean[] { true, true, false, false, false };
		String[] vals4 = new String[] { "hello", "world", "foo", "bar", "baz" };

		AbstractDatasetIterator it1 = new RenameIterator(new ArrayIterator(vals1), "value", "a");
		AbstractDatasetIterator it2 = new RenameIterator(new ArrayIterator(vals2), "value", "b");
		AbstractDatasetIterator it3 = new RenameIterator(new ArrayIterator(vals3), "value", "c");
		AbstractDatasetIterator it4 = new RenameIterator(new ArrayIterator(vals4), "value", "d");

		ZipIterator it = new ZipIterator(it1, it2, it3, it4);

		ColumnDescriptor[] cds = it.getColumnDescriptors();
		ColumnAccessor ca1 = cds[0].getAccessor();
		ColumnAccessor ca2 = cds[1].getAccessor();
		ColumnAccessor ca3 = cds[2].getAccessor();
		ColumnAccessor ca4 = cds[3].getAccessor();

		int index = 0;
		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();

			assertEquals(vals1[index], ca1.getValueFromRow(row));
			assertEquals(vals2[index], ca2.getValueFromRow(row));
			assertEquals(vals3[index], ca3.getValueFromRow(row));
			assertEquals(vals4[index], ca4.getValueFromRow(row));

			index++;
		}
	}
}