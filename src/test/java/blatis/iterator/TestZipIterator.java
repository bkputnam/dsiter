package blatis.pipe;

import static org.junit.Assert.*;

import org.junit.Test;

import blatis.dataset.RangeDataset;
import blatis.row.ColumnDescriptor;
import blatis.row.ColumnAccessor;
import blatis.row.Row;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.StrideIterator;
import blatis.iterator.RenameIterator;
import blatis.iterator.ZipIterator;

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
}