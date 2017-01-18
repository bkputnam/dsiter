package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.parser.OperatorParser;
import dsiter.row.IRowAccessor;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSkipWhileIterator {

	@Test
	public void test1() throws Exception {

		IteratorCounter counter = new IteratorCounter();

		IDatasetIterator src = new RangeIterator(10)
			.pipe(counter.getPipe());

		IRowAccessor.BOOLEAN predicate = OperatorParser
			.parseOperator("value != 5")
			.link(src.getColumnDescriptors())
			.asBoolAccessor();

		try (
			SkipWhileIterator it = new SkipWhileIterator(src, predicate)
		) {
			IterUtils.assertValues(it, "value", new Integer[] { 5, 6, 7, 8, 9 });
		}

		assertEquals(1, counter.getCloseCount());

	}
}
