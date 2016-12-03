package blatis.iterator;

import blatis.operator.ModuloOperator;
import blatis.predicate.EqualsPredicate;
import blatis.predicate.GreaterThanPredicate;
import blatis.row.ColumnAccessor;
import blatis.row.ConstantAccessor;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestFilterIterator {

    @Test
    public void testGreaterThan() {

        RangeIterator range = new RangeIterator(10);
        ColumnAccessor ca = range.getColumnDescriptor("value").getAccessor();

        FilterIterator it = new FilterIterator(
            range,
            new GreaterThanPredicate(
                ca,
                new ConstantAccessor(5)
            )
        );

        IterUtils.assertValues(it, "value", new Integer[] { 6, 7, 8, 9 });
    }

    @Test
    public void testEvens() {

        RangeIterator range = new RangeIterator(10);
        ColumnAccessor ca = range.getColumnDescriptor("value").getAccessor();

        FilterIterator it = new FilterIterator(
            range,
            new EqualsPredicate(
                new ModuloOperator(
                    ca,
                    new ConstantAccessor(2)
                ),
                new ConstantAccessor(0)
            )
        );

        IterUtils.assertValues(it, "value", new Integer[] { 0, 2, 4, 6, 8 });
    }
}
