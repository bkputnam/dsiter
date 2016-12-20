package dsiter.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import dsiter.row.*;

/**
 * An iterator that combines the output of multiple source iterators
 * into one. Names are preserved during the transformation, but a
 * RuntimeException will be thrown if two columns with the same name
 * are zipped together.
 */
public class ZipIterator implements IDatasetIterator {

	private IDatasetIterator[] srcIters;
	private int[] srcIterColumnCounts;

	private ColumnDescriptor[] combinedColumnDescriptors;
	private ColumnMutator[] mutators;
	private ColumnAccessor[] accessors;
	private Row combinedRow;

	/**
	 * Construct a new ZipIterator that zips together all of
	 * {@code srcIters}
	 *
	 * @param srcIters The iterators to be zipped together
	 */
	public ZipIterator(IDatasetIterator... srcIters) {
		this.srcIters = srcIters;

		RowShape shape = new RowShape();
		List<ColumnMutator> mutatorList = new ArrayList<ColumnMutator>();
		List<ColumnAccessor> accessorList = new ArrayList<ColumnAccessor>();
		List<ColumnDescriptor> columnDescriptorList = new ArrayList<ColumnDescriptor>();
		Set<String> names = new HashSet<String>();
		srcIterColumnCounts = new int[srcIters.length];

		for(int i=0; i<srcIters.length; i++) {
			IDatasetIterator it = srcIters[i];
			ColumnDescriptor[] itCds = it.getColumnDescriptors();
			srcIterColumnCounts[i] = itCds.length;

			for(ColumnDescriptor cd : itCds) {
				ColumnType type = cd.getType();
				int rowArrayIndex = shape.getNum(type);

				columnDescriptorList.add(new ColumnDescriptor(
					cd.getName(),
					cd.getType(),
					rowArrayIndex
				));
				accessorList.add(cd.getAccessor());

				String name = cd.getName();
				if(names.contains(name)) {
					throw new RuntimeException("Cannot zip iterators with a common column name (" + name + ")");
				}
				names.add(name);

				mutatorList.add(new ColumnMutator(
					type,
					rowArrayIndex
				));
				shape.incrNum(type);
			}
		}

		mutators = mutatorList.toArray(new ColumnMutator[0]);
		accessors = accessorList.toArray(new ColumnAccessor[0]);
		combinedColumnDescriptors = columnDescriptorList.toArray(new ColumnDescriptor[0]);
		combinedRow = new Row(shape);
	}

	@Override
	public long tryGetLength() {
		long minLength = Long.MAX_VALUE;
		for(int i=0; i<srcIters.length; i++) {
			IDatasetIterator srcIter = srcIters[i];
			long len = srcIter.tryGetLength();
			if (len == -1) {
				return -1;
			}
			else if (len < minLength) {
				minLength = len;
			}
		}
		return minLength;
	}

	@Override
	public boolean tryMoveNext() {
		for(int i=0; i<srcIters.length; i++) {
			if(!srcIters[i].tryMoveNext()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Row getCurrentRow() {
		int combinedIndex = 0;
		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
			IDatasetIterator it = srcIters[iterIndex];
			int itColCount = srcIterColumnCounts[iterIndex];
			Row itRow = it.getCurrentRow();

			for(int iterColIndex=0; iterColIndex<itColCount; iterColIndex++) {
				Object o = accessors[combinedIndex].getValueFromRow(itRow);
				mutators[combinedIndex].setValueInRow(
					combinedRow,
					o
				);
				combinedIndex++;
			}
		}

		return combinedRow;
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return combinedColumnDescriptors;
	}

}