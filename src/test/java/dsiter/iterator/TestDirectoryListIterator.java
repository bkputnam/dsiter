package dsiter.iterator;

import dsiter.row.IColumnAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TestDirectoryListIterator {

	@Test
	public void testDirs() throws Exception {
		String dir = this.getClass().getResource("directorylist/").toURI().getPath();
		DirectoryListIterator it = new DirectoryListIterator(dir);

		Map<String, Boolean> seenDir = new HashMap<>();
		seenDir.put(dir + "a.txt", false);
		seenDir.put(dir + "b.txt", false);
		seenDir.put(dir + "dir1/c.txt", false);
		seenDir.put(dir + "dir1/d.txt", false);

		Map<String, Long> expectedSizes = new HashMap<>();
		expectedSizes.put(dir + "a.txt", 9L);
		expectedSizes.put(dir + "b.txt", 5L);
		expectedSizes.put(dir + "dir1/c.txt", 5L);
		expectedSizes.put(dir + "dir1/d.txt", 0L);

		IColumnAccessor getFilename = it.getColumnDescriptor("filename").getAccessor();
		IColumnAccessor getSize = it.getColumnDescriptor("size").getAccessor();

		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();
			String filename = (String)getFilename.getValueFromRow(row);
			Long size = (Long)getSize.getValueFromRow(row);

			assertEquals(false, seenDir.get(filename));
			seenDir.put(filename, true);

			assertEquals(expectedSizes.get(filename), size);
		}

		for (Boolean b : seenDir.values()) {
			assertTrue(b);
		}
	}
}
