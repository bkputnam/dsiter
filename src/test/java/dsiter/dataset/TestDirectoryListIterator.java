package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;
import dsiter.row.IColumnAccessor;
import dsiter.row.Row;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class TestDirectoryListIterator {
	private static String testDirectoryPath;

	@Before
	public void before() throws Exception {
		testDirectoryPath =
			this
				.getClass()
				.getResource("directorylist/")
				.toURI()
				.getPath();
	}

	@Test
	public void testDirs() throws Exception {
		DirectoryListDataset ds = new DirectoryListDataset(testDirectoryPath);
		IDatasetIterator it = ds.getIterator();

		Map<String, Boolean> seenDir = new HashMap<>();
		seenDir.put(testDirectoryPath + "a.txt", false);
		seenDir.put(testDirectoryPath + "b.txt", false);
		seenDir.put(testDirectoryPath + "dir1/c.txt", false);
		seenDir.put(testDirectoryPath + "dir1/d.txt", false);

		Map<String, Long> expectedSizes = new HashMap<>();
		expectedSizes.put(testDirectoryPath + "a.txt", 9L);
		expectedSizes.put(testDirectoryPath + "b.txt", 5L);
		expectedSizes.put(testDirectoryPath + "dir1/c.txt", 5L);
		expectedSizes.put(testDirectoryPath + "dir1/d.txt", 0L);

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
