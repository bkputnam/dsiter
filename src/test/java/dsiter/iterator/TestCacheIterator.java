package dsiter.iterator;

import dsiter.IteratorExpectations;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCacheIterator {

	@Test
	public void basicTest() throws Exception {
		Row[] cache = new Row[] {
			Row.fromInts( 2, 3, 4 ),
			Row.fromInts( 5, 6, 7 ),
			Row.fromInts( 8, 9, 10 ),
			Row.fromInts( 11, 12, 13 )
		};
		ColumnDescriptor[] cds = new ColumnDescriptor[] {
			new ColumnDescriptor("x", ColumnType.INT, 0),
			new ColumnDescriptor("y", ColumnType.INT, 1),
			new ColumnDescriptor("z", ColumnType.INT, 2)
		};

		CacheIterator it = new CacheIterator(cache, cds);

		assertArrayEquals(cds, it.getColumnDescriptors());

		IteratorExpectations e = new IteratorExpectations();
		e.expectInts("x", 2, 5, 8, 11);
		e.expectInts("y", 3, 6, 9, 12);
		e.expectInts("z", 4, 7, 10, 13);
		e.checkIterator(it);
	}

	@Test
	public void testDoesntModifySrc() throws Exception {
		Row[] cache = new Row[] {
			Row.fromInts( 2, 3, 4 ),
			Row.fromInts( 5, 6, 7 ),
			Row.fromInts( 8, 9, 10 ),
			Row.fromInts( 11, 12, 13 )
		};
		ColumnDescriptor[] cds = new ColumnDescriptor[] {
			new ColumnDescriptor("x", ColumnType.INT, 0),
			new ColumnDescriptor("y", ColumnType.INT, 1),
			new ColumnDescriptor("z", ColumnType.INT, 2)
		};

		CacheIterator it = new CacheIterator(cache, cds);

		while (it.tryMoveNext()) {
			Row row = it.getCurrentRow();

			// Modify the returned row. Later we'll assert that this
			// modification doesn't affect the source array (cache)
			row.ints[0] = 42;
			row.ints[1] = 42;
			row.ints[2] = 42;
		}

		// Assert that all of the cache values are unchanged.
		// Take advantage of the fact that they count up starting
		// at 2.
		int val = 2;
		for(int rowIndex=0; rowIndex<cache.length; rowIndex++) {
			for(int colIndex=0; colIndex<3; colIndex++) {
				assertEquals(val, cache[rowIndex].ints[colIndex]);
				val++;
			}
		}
	}
}
