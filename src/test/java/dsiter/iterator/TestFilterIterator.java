package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.operator.parser.OperatorParser;
import dsiter.row.ColumnAccessor;
import org.junit.Test;

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
        ColumnAccessor ca = range.getColumnDescriptor("value").getAccessor();

        FilterIterator it = new FilterIterator(
            range,
			OperatorParser.parseOperator(range.getColumnDescriptors(), "value%2=0").asBoolAccessor()
        );

        IterUtils.assertValues(it, "value", new Integer[] { 0, 2, 4, 6, 8 });
    }
}
