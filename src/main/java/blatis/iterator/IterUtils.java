package blatis.iterator;

import java.util.List;
import java.util.ArrayList;

import blatis.row.ColumnAccessor;
import blatis.row.Row;

public class IterUtils {

	public static List<Object> getColumn(AbstractDatasetIterator it, String colName) {

		ColumnAccessor ca = it.getColumnDescriptor(colName).getAccessor();

		List<Object> values = new ArrayList<Object>();
		while( it.tryMoveNext() ) {
			Row row = it.getCurrentRow();
			values.add( ca.getValueFromRow(row) );
		}

		return values;
	}

	public static <T> void assertValues(AbstractDatasetIterator it, String colName, T[] expectedValues) {

		ColumnAccessor ca = it.getColumnDescriptor(colName).getAccessor();

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