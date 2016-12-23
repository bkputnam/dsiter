package dsiter.pipe;

import static org.junit.Assert.*;

import dsiter.IterUtils;
import dsiter.iterator.RangeIterator;
import org.junit.Test;

import dsiter.row.ColumnDescriptor;
import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.RenameIterator;

public class TestRenameIterator {

	@Test
	public void testRename() throws Exception {

		IDatasetIterator it = new RenameIterator(
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

	@Test
	public void testLength() {

		IDatasetIterator it = new RenameIterator(
				new RangeIterator(10),
				"value",
				"a"
		);

		assertEquals(10, it.tryGetLength());
	}

	@Test
	public void testStringEquals() throws Exception {

		String from = "__value__".substring(2, 7);

		IDatasetIterator it = new RenameIterator(
				new RangeIterator(10),
				from,
				"a"
		);

		IterUtils.assertValues(
				it,
				"a",
				new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }
		);
	}

}