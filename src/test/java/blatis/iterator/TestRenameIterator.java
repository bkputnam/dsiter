package blatis.operation;

import static org.junit.Assert.*;

import org.junit.Test;

import blatis.dataset.RangeDataset;
import blatis.row.ColumnDescriptor;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.RenameIterator;
import blatis.iterator.IterUtils;

public class TestRenameIterator {

	@Test
	public void testRename() {

		AbstractDatasetIterator it = new RenameIterator(
			(new RangeDataset(10)).getIterator(),
			"value",
			"a"
		);

		ColumnDescriptor[] cds = it.getColumnDescriptors();
		assertEquals(1, cds.length);
		assertEquals("a", cds[0].getName());

		IterUtils.assertValues(
			it,
			"a",
			new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }
		);
	}

}