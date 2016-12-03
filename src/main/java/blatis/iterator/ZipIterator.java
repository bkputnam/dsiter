package blatis.iterator;

import java.util.Set;
import java.util.HashSet;

import blatis.row.Row;
import blatis.row.RowShape;
import blatis.row.ColumnDescriptor;

public class ZipIterator extends AbstractDatasetIterator {

	private AbstractDatasetIterator leftSrc;
	private AbstractDatasetIterator rightSrc;

	private ColumnDescriptor[] combinedColumnDescriptors;
	private Row combinedRow;
	private RowShape leftShape;
	private RowShape rightShape;

	public ZipIterator(AbstractDatasetIterator leftSrc, AbstractDatasetIterator rightSrc) {
		this.leftSrc = leftSrc;
		this.rightSrc = rightSrc;

		ColumnDescriptor[] leftCds = leftSrc.getColumnDescriptors();
		ColumnDescriptor[] rightCds = rightSrc.getColumnDescriptors();
		leftShape = leftSrc.getShape();
		rightShape = rightSrc.getShape();
		combinedColumnDescriptors = new ColumnDescriptor[ leftCds.length + rightCds.length ];

		Set<String> leftColNames = new HashSet<String>();
		for(int i=0; i<leftCds.length; i++) {
			leftColNames.add(leftCds[i].getName());
			combinedColumnDescriptors[i] = leftCds[i];
		}

		for(int i=0; i<rightCds.length; i++) {
			ColumnDescriptor rcd = rightCds[i];
			String rightName = rcd.getName();
			ColumnDescriptor.Type rightType = rcd.getType();

			if(leftColNames.contains(rightName)) {
				throw new RuntimeException("Programmer error: cannot zip two iterators with a common column name (" + rightName + ")");
			}

			combinedColumnDescriptors[i + leftCds.length] = new ColumnDescriptor(
				rightName,
				rightType,
				leftShape.getNum(rightType) + rcd.getRowArrayIndex()
			);
		}

		combinedRow = new Row(this.getShape());
	}

	public boolean tryMoveNext() {
		return leftSrc.tryMoveNext() && rightSrc.tryMoveNext();
	}

	public Row getCurrentRow() {
		Row leftRow = leftSrc.getCurrentRow();
		for(int i=0; i<leftShape.getNumInts(); i++) {
			combinedRow.ints[i] = leftRow.ints[i];
		}
		for(int i=0; i<leftShape.getNumLongs(); i++) {
			combinedRow.longs[i] = leftRow.longs[i];
		}
		for(int i=0; i<leftShape.getNumFloats(); i++) {
			combinedRow.floats[i] = leftRow.floats[i];
		}
		for(int i=0; i<leftShape.getNumDoubles(); i++) {
			combinedRow.doubles[i] = leftRow.doubles[i];
		}
		for(int i=0; i<leftShape.getNumStrings(); i++) {
			combinedRow.strings[i] = leftRow.strings[i];
		}
		for(int i=0; i<leftShape.getNumBools(); i++) {
			combinedRow.bools[i] = leftRow.bools[i];
		}

		Row rightRow = rightSrc.getCurrentRow();
		for(int i=0; i<rightShape.getNumInts(); i++) {
			combinedRow.ints[i + leftShape.getNumInts()] = rightRow.ints[i];
		}
		for(int i=0; i<rightShape.getNumLongs(); i++) {
			combinedRow.longs[i + leftShape.getNumLongs()] = rightRow.longs[i];
		}
		for(int i=0; i<rightShape.getNumFloats(); i++) {
			combinedRow.floats[i + leftShape.getNumFloats()] = rightRow.floats[i];
		}
		for(int i=0; i<rightShape.getNumDoubles(); i++) {
			combinedRow.doubles[i + leftShape.getNumDoubles()] = rightRow.doubles[i];
		}
		for(int i=0; i<rightShape.getNumStrings(); i++) {
			combinedRow.strings[i + leftShape.getNumStrings()] = rightRow.strings[i];
		}
		for(int i=0; i<rightShape.getNumBools(); i++) {
			combinedRow.bools[i + leftShape.getNumBools()] = rightRow.bools[i];
		}

		return combinedRow;
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return combinedColumnDescriptors;
	}

}