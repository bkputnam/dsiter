package blatis.operation;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import blatis.dataset.RangeDataset;
import blatis.dataset.ColumnDescriptor;
import blatis.dataset.Row;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.IterUtils;

public class TestStrideOperation {

	@Test
	public void testStride3() {

		RangeDataset rd = new RangeDataset(10);
		AbstractDatasetIterator it = rd.getIterator();

		StrideOperation so = new StrideOperation(3);
		it = so.applyTo(it);

		List<Object> values = IterUtils.getColumn(it, "value");
		int[] expectedValues = new int[] { 0, 3, 6, 9 };

		for( int i=0; i<values.size(); i++ ) {
			assertEquals( (int)values.get(i), expectedValues[i] );
		}
	}

	@Test
	public void testStrideLast() {

		RangeDataset rd = new RangeDataset(10);
		AbstractDatasetIterator it = rd.getIterator();

		StrideOperation so = new StrideOperation(3);
		it = so.applyTo(it);

		LastOperation lo = new LastOperation();
		it = lo.applyTo(it);

		List<Object> values = IterUtils.getColumn(it, "value");
		int[] expectedValues = new int[] { 9 };

		for( int i=0; i<values.size(); i++ ) {
			assertEquals( (int)values.get(i), expectedValues[i] );
		}
	}
}