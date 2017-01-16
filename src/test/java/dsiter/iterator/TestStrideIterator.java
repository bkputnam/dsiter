package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.pipe.IPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;
import static dsiter.StdPipes.*;

public class TestStrideIterator {

	@Test
	public void testStride4() throws Exception {

		try (IDatasetIterator it = new StrideIterator(
			new RangeIterator(10),
			4
		)) {

			IterUtils.assertValues(
				it,
				"value",
				new Integer[]{0, 4, 8}
			);
		}
	}

	@Test
	public void testStrideLast() throws Exception {

		try (IDatasetIterator it = new RangeIterator(10)
			 .pipe(stride(4))
			 .pipe(last());
		) {

			IterUtils.assertValues(
				it,
				"value",
				new Integer[]{8}
			);
		}
	}

	@Test
	public void testLength() throws Exception {

		try (IDatasetIterator it = new StrideIterator(
			new RangeIterator(10),
			4
		)) {

			assertEquals(3, it.tryGetLength());
		}
	}

	@Test
	public void testUnoptimizedIterator() throws Exception {
		IDatasetIterator it = new UnoptimizedIterator(
			new RangeIterator(10)
		).pipe(stride(3));

		IterUtils.assertValues(it, "value", new Integer[] {
			0, 3, 6, 9
		});
	}

	private static class UnoptimizedIterator implements IDatasetIterator {

		private IDatasetIterator src;

		public UnoptimizedIterator(IDatasetIterator src) {
			this.src = src;
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
			return -1;
		}

		@Override
		public ColumnDescriptor[] getColumnDescriptors() {
			return src.getColumnDescriptors();
		}

		@Override
		public boolean tryAbsorb(IPipe pipe) {
			return false;
		}

		@Override
		public void close() throws Exception {
			src.close();
		}
	}
}