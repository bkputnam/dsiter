package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.operator.parser.OperatorParser;
import dsiter.row.IRowAccessor;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTakeWhileIterator {

	@Test
	public void test1() throws Exception {

		IDatasetIterator src = new ArrayIterator(
			1,2,3,4,1,2,3,4,1,2,3,4
		);

		IRowAccessor.BOOLEAN predicate = OperatorParser.parseOperator(
			src.getColumnDescriptors(),
			"value!=4"
		).asBoolAccessor();

		TakeWhileIterator twi = new TakeWhileIterator(src, predicate);

		IterUtils.assertValues(twi, "value", new Integer[] {
			1,2,3
		});
	}

	@Test
	public void testClosesSrcIter() throws Exception {

		IteratorCounter counter = new IteratorCounter();
		IDatasetIterator src = new RangeIterator(10).pipe(counter.getPipe());

		IRowAccessor.BOOLEAN predicate = OperatorParser.parseOperator(
			src.getColumnDescriptors(),
			"value!=4"
		).asBoolAccessor();

		try (
			TakeWhileIterator it = new TakeWhileIterator(src, predicate)
		) {
			IterUtils.assertValues(it, "value", new Integer[] {
				0,1,2,3
			});
		}

		assertEquals(1, counter.getCloseCount());
	}
}
