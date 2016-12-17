package blatis.iterator;

import blatis.row.Row;
import blatis.row.ColumnDescriptor;

public class RenameIterator extends AbstractDatasetIterator {

	private AbstractDatasetIterator src;
	private ColumnDescriptor[] cds;

	public RenameIterator(AbstractDatasetIterator src, String from, String to) {
		this.src = src;

		ColumnDescriptor[] srcCds = src.getColumnDescriptors();
		cds = new ColumnDescriptor[srcCds.length];
		for(int i=0; i<srcCds.length; i++) {
			ColumnDescriptor srcCd = srcCds[i];
			cds[i] = srcCd.getName() != from
				? srcCd
				: new ColumnDescriptor(to, srcCd.getType(), srcCd.getRowArrayIndex());
		}
	}

	public boolean tryMoveNext() {
		return src.tryMoveNext();
	}

	public Row getCurrentRow() {
		return src.getCurrentRow();
	}

	public ColumnDescriptor[] getColumnDescriptors() {
		return cds;
	}

}