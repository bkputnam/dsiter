package blatis.iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import blatis.iterator.AbstractDatasetIterator;
import blatis.dataset.ColumnAccessor;
import blatis.dataset.Row;

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

}