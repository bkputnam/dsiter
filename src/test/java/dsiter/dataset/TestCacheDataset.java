package dsiter.dataset;

import dsiter.IterUtils;
import dsiter.iterator.ArrayIterator;
import dsiter.iterator.IDatasetIterator;
import org.junit.Test;

public class TestCacheDataset {

	@Test
	public void test1() throws Exception {
		RangeDataset src = new RangeDataset(5);
		CacheDataset cache = new CacheDataset(src, 60);

		IterUtils.assertValues(cache.getIterator(), "value", new Integer[] { 0, 1, 2, 3, 4 });
		IterUtils.assertValues(cache.getIterator(), "value", new Integer[] { 0, 1, 2, 3, 4 });
		IterUtils.assertValues(cache.getIterator(), "value", new Integer[] { 0, 1, 2, 3, 4 });
		IterUtils.assertValues(cache.getIterator(), "value", new Integer[] { 0, 1, 2, 3, 4 });
	}

	@Test
	public void testCacheExpires() throws Exception {
		MutableFlagDataset src = new MutableFlagDataset();
		CacheDataset cache = new CacheDataset(src, 0.01);

		// flag should initially false
		IterUtils.assertValues(cache.getIterator(), "value", new Boolean[] { false });

		// change flag to true. Cache iterator should still be cached
		src.flag = true;
		IterUtils.assertValues(cache.getIterator(), "value", new Boolean[] { false });

		// Sleep for 0.02 sec. Cache times out at 0.01 sec, so this should be enough
		// to clear the cache.
		Thread.sleep(20);

		// Now the value should have updated
		IterUtils.assertValues(cache.getIterator(), "value", new Boolean[] { true });
	}

	@Test
	public void testThatNegativeOneDoesntExpire() throws Exception {
		MutableFlagDataset src = new MutableFlagDataset();
		CacheDataset cache = new CacheDataset(src);

		IterUtils.assertValues(cache.getIterator(), "value", new Boolean[] { false });

		// Test that the cache doesn't immediately chance when this happens
		src.flag = true;
		IterUtils.assertValues(cache.getIterator(), "value", new Boolean[] { false });

		// Test that the cache doesn't update after a small timeout. There is no way to test
		// that it never changes at any point in the future, so hopefully this is good enough
		// without slowing down our test suite.
		Thread.sleep(20);
		IterUtils.assertValues(cache.getIterator(), "value", new Boolean[] { false });
	}

	private static class MutableFlagDataset implements IDataset {

		public boolean flag = false;

		@Override
		public IDatasetIterator getIterator() throws Exception {
			return ArrayIterator.fromBools(flag);
		}
	}
}
