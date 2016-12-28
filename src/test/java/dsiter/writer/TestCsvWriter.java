package dsiter.writer;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.RenameIterator;
import dsiter.iterator.ZipIterator;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static dsiter.StdPipes.*;

public class TestCsvWriter {

	@Test
	public void testCsv() throws Exception {
		int[] vals1 = new int[] { 1, 2, 3, 4, 5, };
		float[] vals2 = new float[] { 3.142f, 2.718f, 0f, 1f, -1f };
		boolean[] vals3 = new boolean[] { true, true, false, false, false };
		String[] vals4 = new String[] { "hello", "world", "foo", "bar", "baz" };

		IDatasetIterator it1 = new ArrayIterator(vals1).pipe(rename("value", "a"));
		IDatasetIterator it2 = new ArrayIterator(vals2).pipe(rename("value", "b"));
		IDatasetIterator it3 = new ArrayIterator(vals3).pipe(rename("value", "c"));
		IDatasetIterator it4 = new ArrayIterator(vals4).pipe(rename("value", "d"));

		try (ZipIterator it = new ZipIterator(it1, it2, it3, it4)) {
			OutputStream os = new ByteArrayOutputStream();
			CsvWriter csvw = new CsvWriter();
			csvw.writeTo(it, os);

			String expected =
				"a,b,c,d\n" +
					"1,3.142,true,\"hello\"\n" +
					"2,2.718,true,\"world\"\n" +
					"3,0.0,false,\"foo\"\n" +
					"4,1.0,false,\"bar\"\n" +
					"5,-1.0,false,\"baz\"\n";

			assertEquals(expected, os.toString());
		}
	}
}
