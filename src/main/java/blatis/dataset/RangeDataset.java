package blatis.dataset;

import blatis.iterator.AbstractDatasetIterator;
import blatis.dataset.ColumnDescriptor;

public class RangeDataset extends AbstractDataset {

	private int numVals;

	public RangeDataset(int numVals) {
		this.numVals = numVals;
	}

	public AbstractDatasetIterator getIterator() {
		return new RangeIterator(this.numVals);
	}

	private static class RangeIterator extends AbstractDatasetIterator {

		private int curVal = -1;
		private int numVals;

		private static ColumnDescriptor[] columns = {
			new ColumnDescriptor("value", ColumnDescriptor.Type.INT, 0)
		};

		private Row row;

		public RangeIterator(int numVals) {
			this.numVals = numVals;

			row = new Row();
			row.ints = new int[] { -1 };
		}

		public ColumnDescriptor[] getColumnDescriptors() {
			return columns.clone();
		}

		public boolean tryMoveNext() {
			if( curVal < numVals - 1 ) {
				curVal++;
				return true;
			}
			else {
				return false;
			}
		}

		public Row getCurrentRow() {
			row.ints[0] = this.curVal;
			return row;
		}
	}
}