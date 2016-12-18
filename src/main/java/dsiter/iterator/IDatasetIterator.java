package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.Row;
import dsiter.row.RowShape;
import dsiter.row.ColumnDescriptor;

public interface IDatasetIterator {

	public abstract boolean tryMoveNext();
	public abstract Row getCurrentRow();
	public abstract ColumnDescriptor[] getColumnDescriptors();

	default public ColumnDescriptor getColumnDescriptor(String name) {
		ColumnDescriptor[] cds = this.getColumnDescriptors();

		for( int i=0; i<cds.length; i++ ) {
			if( cds[i].getName().equals(name) ) {
				return cds[i];
			}
		}

		throw new RuntimeException("Failed to find column descriptor '" + name + "'");
	}

	default public RowShape computeShape() {
		return new RowShape(this.getColumnDescriptors());
	}

	default public IDatasetIterator pipe(IPipe pipe) {
		return pipe.applyTo(this);
	}
}