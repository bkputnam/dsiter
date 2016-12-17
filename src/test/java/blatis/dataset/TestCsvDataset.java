package blatis.dataset;

import blatis.iterator.AbstractDatasetIterator;
import blatis.row.ColumnDescriptor;
import blatis.row.ColumnType;
import blatis.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestCsvDataset {

	@Test
	public void testSimpleCsv() throws IOException, URISyntaxException {
		String filename = this.getClass().getResource("simple.csv").getFile();
		CsvDataset ds = new CsvDataset(filename);

		AbstractDatasetIterator iter = ds.getIterator();
		ColumnDescriptor[] cds = iter.getColumnDescriptors();

		assertEquals("foo", cds[0].getName());
		assertEquals(ColumnType.LONG, cds[0].getType());
		assertEquals(0, cds[0].getRowArrayIndex());

		assertEquals("bar", cds[1].getName());
		assertEquals(ColumnType.DOUBLE, cds[1].getType());
		assertEquals(0, cds[1].getRowArrayIndex());

		assertEquals("baz", cds[2].getName());
		assertEquals(ColumnType.STRING, cds[2].getType());
		assertEquals(0, cds[2].getRowArrayIndex());

		long[] expectedLongs = new long[] { 1, 2, 3 };
		double[] expectedDoubles = new double[] { 1.5, 2.5, 3.5 };
		String[] expectedStrings = new String[] { "frib", "frob", "fraz" };

		int index = 0;
		while(iter.tryMoveNext()) {
			Row row = iter.getCurrentRow();

			assertEquals(expectedLongs[index], row.longs[0]);
			assertEquals(expectedDoubles[index], row.doubles[0], 0.000001);
			assertEquals(expectedStrings[index], row.strings[0]);

			index++;
		}

		assertEquals(3, index);
	}
}
