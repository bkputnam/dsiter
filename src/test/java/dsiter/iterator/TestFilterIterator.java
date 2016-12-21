package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.operator.parser.OperatorParser;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static dsiter.StdPipes.filter;
import static org.junit.Assert.*;

public class TestFilterIterator {

    @Test
    public void testGreaterThan() {

        RangeIterator range = new RangeIterator(10);

        FilterIterator it = new FilterIterator(
            range,
			OperatorParser.parseOperator(range.getColumnDescriptors(), "value>5").asBoolAccessor()
        );

        IterUtils.assertValues(it, "value", new Integer[] { 6, 7, 8, 9 });
    }

    @Test
    public void testEvens() {

        RangeIterator range = new RangeIterator(10);
        IRowAccessor ca = range.getColumnDescriptor("value").getAccessor();

        FilterIterator it = new FilterIterator(
            range,
			OperatorParser.parseOperator(range.getColumnDescriptors(), "value%2=0").asBoolAccessor()
        );

        IterUtils.assertValues(it, "value", new Integer[] { 0, 2, 4, 6, 8 });
    }

    @Test
	public void testLength() {
		RangeIterator range = new RangeIterator(10);

		FilterIterator it = new FilterIterator(
			range,
			OperatorParser.parseOperator(range.getColumnDescriptors(), "value>5").asBoolAccessor()
		);

		assertEquals(-1, it.tryGetLength());
	}

	@Test
	public void testFilterDoesntDuplicateCallsToGetCurrentRow() {
		IteratorCounter counter1 = new IteratorCounter();
		IteratorCounter counter2 = new IteratorCounter();

		IDatasetIterator it = new RangeIterator(10)
			.pipe(counter1.getPipe())
			.pipe(filter("value%2=0"))
			.pipe(counter2.getPipe());

		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();
		}

		// counter1 should be 10 because filter iterator needs to check
		// every Row in the src iterator. counter2 should be 5 because
		// that's the number of Rows returned. Previous implementations
		// had counter1 at 15 because every test of the predicate called
		// src.getCurrentRow(), as did filterIterator.getCurrentRow(),
		// so this test is testing that that isn't the case anymore
		assertEquals(10, counter1.getGetCurrentRowCount());
		assertEquals(5, counter2.getGetCurrentRowCount());
	}
}
