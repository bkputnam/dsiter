package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.operator.parser.OperatorParser;
import dsiter.row.IRowAccessor;
import org.junit.Test;

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
}
