package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.pipe.SkipPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;

public class TakeIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private long numToTake;
	private long remainingToTake;

	public TakeIterator(IDatasetIterator src, long numToTake) {
		this.src = src;
		this.numToTake = remainingToTake = numToTake;
	}

	@Override
	public boolean tryMoveNext() throws Exception {
		if (remainingToTake == 0) {
			return false;
		}
		else {
			remainingToTake--;
			return src.tryMoveNext();
		}
	}

	@Override
	public Row getCurrentRow() throws Exception {
		return src.getCurrentRow();
	}

	@Override
	public long tryGetLength() {
		long srcLen = src.tryGetLength();
		if (srcLen == -1) {
			return srcLen;
		}
		else {
			return srcLen >= numToTake ? numToTake : srcLen;
		}
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return src.getColumnDescriptors();
	}

	@Override
	public void close() throws Exception {
		src.close();
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) throws Exception {
		if (pipe instanceof SkipPipe) {
			long howMany = ((SkipPipe)pipe).getHowMany();
			src = src.pipe(pipe);
			remainingToTake = Math.max(0, remainingToTake-howMany);
			return true;
		}
		else {
			return false;
		}
	}
}
