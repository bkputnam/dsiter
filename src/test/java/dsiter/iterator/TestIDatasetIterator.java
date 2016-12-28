package dsiter.iterator;

import dsiter.row.IRowAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestIDatasetIterator {

	@Test
	public void testColumnLookup() throws Exception {
		try (IDatasetIterator it = new RangeIterator(5)) {

			ColumnDescriptor ca = it.getColumnDescriptor("value");

			assertNotNull(ca);
			assertEquals("value", ca.getName());
		}
	}

	@Test
	public void testColumnLookupDoesntThrow() throws Exception {
		try (IDatasetIterator it = new RangeIterator(5)) {

			ColumnDescriptor ca = it.getColumnDescriptor("not a real column");

			assertNull(ca);
		}
	}
}
