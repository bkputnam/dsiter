package blatis.iterator;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

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


			switch(type) {
				
				case INT: numInts++; break;
				case LONG: numLongs++; break;
				case FLOAT: numFloats++; break;
				case DOUBLE: numDoubles++; break;
				case STRING: numStrings++; break;
				case BOOLEAN: numBools++; break;
				default: throw new Error("This should be impossible");
			}
		}

		return new RowShape(numInts, numLongs, numFloats, numDoubles, numStrings, numBools);
	}
}