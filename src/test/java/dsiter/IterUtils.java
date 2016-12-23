package dsiter;

import java.util.List;
import java.util.ArrayList;

import dsiter.iterator.IDatasetIterator;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;

public class IterUtils {

	public static List<Object> getColumn(IDatasetIterator it, String colName) throws Exception {

		IRowAccessor ca = it.getColumnDescriptor(colName).getAccessor();

		List<Object> values = new ArrayList<Object>();
		while( it.tryMoveNext() ) {
			Row row = it.getCurrentRow();
			values.add( ca.getValueFromRow(row) );
		}

		return values;
	}

	public static <T> void assertValues(IDatasetIterator it, String colName, T[] expectedValues) throws Exception {

		IRowAccessor ca = it.getColumnDescriptor(colName).getAccessor();

		int rowCount = 0;
		while( it.tryMoveNext() ) {
			Row row = it.getCurrentRow();
			Object value = ca.getValueFromRow(row);
			if( !value.equals( expectedValues[rowCount] ) ) {
				throw new RuntimeException("Expected: " + expectedValues[rowCount] + ", got: " + value );
			}
			rowCount++;
		}

		if( rowCount != expectedValues.length ) {
			throw new RuntimeException("Expected " + expectedValues.length + " rows, got " + rowCount);
		}
	}

}