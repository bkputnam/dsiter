package dsiter.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import dsiter.row.*;

public class ZipIterator extends AbstractDatasetIterator {


	private AbstractDatasetIterator[] srcIters;
	private int[] srcIterColumnCounts;

	private ColumnDescriptor[] combinedColumnDescriptors;
	private ColumnMutator[] mutators;
	private ColumnAccessor[] accessors;
	private Row combinedRow;

	public ZipIterator(AbstractDatasetIterator... srcIters) {
		this.srcIters = srcIters;

		RowShape shape = new RowShape();
		List<ColumnMutator> mutatorList = new ArrayList<ColumnMutator>();
		List<ColumnAccessor> accessorList = new ArrayList<ColumnAccessor>();
		List<ColumnDescriptor> columnDescriptorList = new ArrayList<ColumnDescriptor>();
		Set<String> names = new HashSet<String>();
		srcIterColumnCounts = new int[srcIters.length];

		for(int i=0; i<srcIters.length; i++) {
			AbstractDatasetIterator it = srcIters[i];
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

	public boolean tryMoveNext() {
		for(int i=0; i<srcIters.length; i++) {
			if(!srcIters[i].tryMoveNext()) {
				return false;
			}
		}
		return true;
	}

	public Row getCurrentRow() {
		int combinedIndex = 0;
		for(int iterIndex=0; iterIndex<srcIters.length; iterIndex++) {
			AbstractDatasetIterator it = srcIters[iterIndex];
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

	public ColumnDescriptor[] getColumnDescriptors() {
		return combinedColumnDescriptors;
	}

}