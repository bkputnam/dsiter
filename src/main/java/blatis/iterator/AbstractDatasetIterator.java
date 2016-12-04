package blatis.iterator;

import blatis.pipe.IPipe;
import blatis.row.ColumnType;
import blatis.row.Row;
import blatis.row.RowShape;
import blatis.row.ColumnDescriptor;

public abstract class AbstractDatasetIterator {
	public abstract boolean tryMoveNext();
	public abstract Row getCurrentRow();
	public abstract ColumnDescriptor[] getColumnDescriptors();

	public AbstractDatasetIterator pipe(IPipe pipe) {
		return pipe.applyTo(this);
	}

	public ColumnDescriptor getColumnDescriptor(String name) {
		ColumnDescriptor[] cds = this.getColumnDescriptors();

		for( int i=0; i<cds.length; i++ ) {
			if( cds[i].getName().equals(name) ) {
				return cds[i];
			}
		}

		throw new RuntimeException("Failed to find column descriptor '" + name + "'");
	}

	public RowShape getShape() {
		int numInts = 0;
		int numLongs = 0;
		int numFloats = 0;
		int numDoubles = 0;
		int numStrings = 0;
		int numBools = 0;

		ColumnDescriptor[] cds = this.getColumnDescriptors();
		for(int i=0; i<cds.length; i++) {
			ColumnDescriptor cd = cds[i];
			ColumnType type = cd.getType();

			if(type == ColumnType.INT) {
				numInts++;
			}
			else if(type == ColumnType.LONG) {
				numLongs++;
			}
			else if(type == ColumnType.FLOAT) {
				numFloats++;
			}
			else if(type == ColumnType.DOUBLE) {
				numDoubles++;
			}
			else if(type == ColumnType.STRING) {
				numStrings++;
			}
			else if(type == ColumnType.BOOLEAN) {
				numBools++;
			}
		}

		return new RowShape(numInts, numLongs, numFloats, numDoubles, numStrings, numBools);
	}
}