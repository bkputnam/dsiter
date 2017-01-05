package dsiter.iterator;

import dsiter.IterUtils;
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
}