package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.Row;
import dsiter.row.RowShape;
import dsiter.row.ColumnDescriptor;

public abstract class AbstractDatasetIterator {

	public abstract boolean tryMoveNext();
	public abstract Row getCurrentRow();
	public abstract ColumnDescriptor[] getColumnDescriptors();

	public ColumnDescriptor getColumnDescriptor(String name) {
		ColumnDescriptor[] cds = this.getColumnDescriptors();

		for( int i=0; i<cds.length; i++ ) {
			if( cds[i].getName().equals(name) ) {
				return cds[i];
			}
		}

		throw new RuntimeException("Failed to find column descriptor '" + name + "'");
	}

	public RowShape computeShape() {
		return new RowShape(this.getColumnDescriptors());
	}

	public AbstractDatasetIterator pipe(IPipe pipe) {
		return pipe.applyTo(this);
	}
}