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
	private int stride;
	private boolean isFirstTime = true;

	private SkipPipe skipPipe;
	private boolean useSkipPipeOptimization = true;

	public StrideIterator(IDatasetIterator src, int stride) {
		this.src = src;
		this.stride = stride;
		skipPipe = new SkipPipe(stride-1);
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
			if (useSkipPipeOptimization) {
				useSkipPipeOptimization = src.tryAbsorb(skipPipe); // if it fails once, don't bother trying again
			}
			if (!useSkipPipeOptimization) {
				int remainingSkips = stride - 1;
				while(remainingSkips > 0) {
					remainingSkips--;
					if(!src.tryMoveNext()) {
						return false;
					}
				}
			}
		}
		return src.tryMoveNext();
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
	public boolean tryAbsorb(IPipe pipe) {
		if (pipe instanceof SkipPipe) {
			long howMany = ((SkipPipe)pipe).getHowMany();
			src = src.pipe(skip(stride * howMany));
			return true;
		}
		else {
			return false;
		}
	}
}