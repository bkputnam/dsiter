package dsiter;

import dsiter.iterator.IDatasetIterator;
import dsiter.pipe.*;

public class StdPipes {
	public static IPipe filter(String filter) {
		return new FilterPipe(filter);
	}

	public static IPipe first() {
		return new FirstPipe();
	}

	public static IPipe last() {
		return new LastPipe();
	}

	public static IPipe rename(String from, String to) {
		return new RenamePipe(from, to);
	}

	public static IPipe skip(long howMany) {
		return new SkipPipe(howMany);
	}

	public static IPipe stride(int stride) {
		return new StridePipe(stride);
	}

	public static IPipe zip(IDatasetIterator... iters) {
		return new ZipPipe(iters);
	}

	public static IPipe take(long howMany) {
		return new TakePipe(howMany);
	}
}
