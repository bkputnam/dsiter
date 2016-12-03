package blatis.iterator;

import blatis.dataset.Row;
import blatis.dataset.ColumnDescriptor;

public class RenameIterator extends AbstractDatasetIterator {

	private AbstractDatasetIterator src;
	private String fromName;
	private String toName;

	public RenameIterator(AbstractDatasetIterator src, String from, String to) {
		this.src = src;
		this.fromName = from;
		this.toName = to;
	}

	public boolean tryMoveNext() {
		return src.tryMoveNext();
	}

	public Row getCurrentRow() {
		return src.getCurrentRow();
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		ColumnDescriptor[] cds = this.src.getColumnDescriptors();
		ColumnDescriptor[] copy = new ColumnDescriptor[cds.length];

		for(int i=0; i<cds.length; i++) {
			ColumnDescriptor cd = cds[i];
			copy[i] = cd.getName() != fromName
				? cd
				: new ColumnDescriptor( toName, cd.getType(), cd.getRowArrayIndex() );
		}

		return copy;
	}

}