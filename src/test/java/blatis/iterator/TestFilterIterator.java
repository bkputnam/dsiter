package blatis.iterator;

import blatis.operator.EqualsOperator;
import blatis.operator.GreaterThanOperator;
import blatis.operator.ModuloOperator;
import blatis.row.ColumnAccessor;
import blatis.row.ConstantAccessor;
import org.junit.Test;
import org.junit.Assert.*;

public class TestFilterIterator {

    @Test
    public void testGreaterThan() {

        RangeIterator range = new RangeIterator(10);
        ColumnAccessor ca = range.getColumnDescriptor("value").getAccessor();

        FilterIterator it = new FilterIterator(
            range,
            new GreaterThanOperator(
                ca,
                new ConstantAccessor(5)
            ).asBoolAccessor()
        );

        IterUtils.assertValues(it, "value", new Integer[] { 6, 7, 8, 9 });
    }

    @Test
    public void testEvens() {

        RangeIterator range = new RangeIterator(10);
        ColumnAccessor ca = range.getColumnDescriptor("value").getAccessor();

        FilterIterator it = new FilterIterator(
            range,
            new EqualsOperator(
                new ModuloOperator(
                    ca,
                    new ConstantAccessor(2)
                ),
                new ConstantAccessor(0)
            ).asBoolAccessor()
        );

        IterUtils.assertValues(it, "value", new Integer[] { 0, 2, 4, 6, 8 });
    }
}
