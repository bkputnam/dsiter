package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.pipe.SkipPipe;
import dsiter.row.Row;
import dsiter.row.ColumnDescriptor;
import static dsiter.StdPipes.*;

/**
 * Construct an iterator that only returns 1 in every
 * {@code stride} rows from its source iterator. Returned
 * rows will begin with the first, then the {@code stride}-th,
 * and the {@code (stride*2)}-th, and so on.
 *
 * <p>For example, this iterator</p>
 * <pre>{@code
 * new StrideIterator(
 *     new RangeIterator(10),
 *     4
 * )
 * }</pre>
 * <p>will return the values {@code 0, 4, 8}</p>
 */
public class StrideIterator implements IDatasetIterator {

	private IDatasetIterator src;
	private long stride;
	private boolean isFirstTime = true;

	private SkipPipe skipPipe;
	private boolean useSkipPipeOptimization = true;

	public StrideIterator(IDatasetIterator src, long stride) {
		this.src = src;
		this.stride = stride;
		skipPipe = new SkipPipe(stride-1);
	}

	public long getStride() {
		return stride;
	}

	@Override
	public long tryGetLength() {
		long srcLen = src.tryGetLength();
		if (srcLen == -1) {
			return -1;
		}
		else {
			return (long)Math.ceil((double)srcLen / stride);
		}
	}

	@Override
	public boolean tryMoveNext() throws Exception {
		if( isFirstTime ) {
			isFirstTime = false;
		}
		else {
			maybeOptimizedSkip(skipPipe);
		}
		return src.tryMoveNext();
	}

	private boolean maybeOptimizedSkip(SkipPipe pipe) throws Exception {
		if (useSkipPipeOptimization) {
			// if it fails once, don't bother trying again
			useSkipPipeOptimization = src.tryAbsorb(pipe);
		}
		if (!useSkipPipeOptimization) {
			if (!manualSkip(pipe.getHowMany())) {
				return false;
			}
		}
		return true;
	}

	private boolean manualSkip(long howMany) throws Exception {
		long remainingSkips = howMany;
		while(remainingSkips > 0) {
			remainingSkips--;
			if(!src.tryMoveNext()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Row getCurrentRow() throws Exception {
		return src.getCurrentRow();
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return this.src.getColumnDescriptors();
	}

	@Override
	public void close() throws Exception {
		src.close();
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) throws Exception {
		if (pipe instanceof SkipPipe) {
			long howMany = ((SkipPipe)pipe).getHowMany();
			maybeOptimizedSkip(new SkipPipe(howMany * stride));
			return true;
		}
		else {
			return false;
		}
	}
}