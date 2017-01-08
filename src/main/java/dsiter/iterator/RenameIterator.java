package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.row.Row;
import dsiter.row.ColumnDescriptor;

/**
 * An iterator that renames one of the columns of its
 * source iterator. (No changes are made to the actual
 * data, or to the source iterator)
 */
public class RenameIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private ColumnDescriptor[] cds;

	/**
	 * Construct an iterator that renames the column named
	 * {@code from} to {@code to}. For example
	 * {@code new RenameIterator(src, "foo", "bar")}
	 * constructs an iterator that is identical to {@code src},
	 * except that the {@code "foo"} column is now named
	 * {@code "bar"}
	 *
	 * @param src  The source iterator
	 * @param from The name of the column to be renamed
	 * @param to   The new name of the renamed column
	 */
	public RenameIterator(IDatasetIterator src, String from, String to) {
		this.src = src;

		ColumnDescriptor[] srcCds = src.getColumnDescriptors();
		cds = new ColumnDescriptor[srcCds.length];
		for(int i=0; i<srcCds.length; i++) {
			ColumnDescriptor srcCd = srcCds[i];
			cds[i] = (!srcCd.getName().equals(from))
				? srcCd
				: new ColumnDescriptor(to, srcCd.getType(), srcCd.getRowArrayIndex());
		}
	}

	@Override
	public boolean tryMoveNext() throws Exception {
		return src.tryMoveNext();
	}

	@Override
	public Row getCurrentRow() throws Exception {
		return src.getCurrentRow();
	}

	@Override
	public long tryGetLength() {
		return src.tryGetLength();
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return cds;
	}

	@Override
	public void close() throws Exception {
		src.close();
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) {
		return src.tryAbsorb(pipe);
	}
}