package blatis;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.IterUtils;
import blatis.iterator.RangeIterator;
import org.junit.Test;

import static blatis.StdPipes.*;

/**
 * Created by bkputnam on 12/15/16.
 */
public class TestStdPipes {

	@Test
	public void testFilterPipe() {
		AbstractDatasetIterator iter = new RangeIterator(20)
			.pipe(filter("value%3=0"));
		IterUtils.assertValues(iter, "value", new Integer[] { 0, 3, 6, 9, 12, 15, 18 });
	}
}
