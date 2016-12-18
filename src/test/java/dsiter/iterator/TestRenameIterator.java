package dsiter.pipe;

import static org.junit.Assert.*;

import dsiter.IterUtils;
import dsiter.iterator.RangeIterator;
import org.junit.Test;

import dsiter.row.ColumnDescriptor;
import dsiter.iterator.AbstractDatasetIterator;
import dsiter.iterator.RenameIterator;

public class TestRenameIterator {

	@Test
	public void testRename() {

		AbstractDatasetIterator it = new RenameIterator(
			new RangeIterator(10),
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