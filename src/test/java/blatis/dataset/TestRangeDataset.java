package blatis.dataset;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import blatis.dataset.RangeDataset;
import blatis.dataset.ColumnDescriptor;
import blatis.dataset.Row;
import blatis.iterator.AbstractDatasetIterator;

public class TestRangeDataset {

	@Test
	public void testRange5() {
		int[] expected = new int[] { 0, 1, 2, 3, 4 };

		RangeDataset rd = new RangeDataset(5);
		AbstractDatasetIterator it = rd.getIterator();

		ColumnDescriptor cd = it.getColumnDescriptor("value");
		ColumnAccessor colAccessor = cd.getAccessor();

		int index = 0;
		while( it.tryMoveNext() ) {
			Row row = it.getCurrentRow();
			int val = (int)colAccessor.getValueFromRow(row);
			assertEquals(val, expected[index]);
			index++;
		}
	}
}