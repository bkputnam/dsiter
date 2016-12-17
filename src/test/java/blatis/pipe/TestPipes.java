package blatis.pipe;

import blatis.IterUtils;
import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.ArrayIterator;
import blatis.iterator.RangeIterator;
import blatis.operator.EqualsOperator;
import blatis.operator.ModuloOperator;
import blatis.row.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPipes {

    @Test
    public void testStride5() {

        AbstractDatasetIterator it = new RangeIterator(25)
                .pipe(new StridePipe(5));
        IterUtils.assertValues(it, "value", new Integer[] {0, 5, 10, 15, 20});
    }

    @Test
    public void testLastPipe() {

        AbstractDatasetIterator it = new RangeIterator(25)
                .pipe(new LastPipe());
        IterUtils.assertValues(it, "value", new Integer[] {24});
    }

    @Test
    public void testFilterPipe() {

		TypedRowAccessor.BOOLEAN isEvenPredicate = new EqualsOperator(
                new ModuloOperator(
                        new ColumnAccessor(ColumnType.INT, 0),
                        new ConstantAccessor(2)
                ),
                new ConstantAccessor(0)
        ).asBoolAccessor();

        AbstractDatasetIterator it = new RangeIterator(10)
                .pipe(new FilterPipe(isEvenPredicate));
        IterUtils.assertValues(it, "value", new Integer[] {0, 2, 4, 6, 8});
    }

    @Test
    public void testFirstAndSkipPipes() {

        AbstractDatasetIterator it = new RangeIterator(10)
                .pipe(new SkipPipe(5))
                .pipe(new FirstPipe());
        IterUtils.assertValues(it, "value", new Integer[] {5});
    }

    @Test
    public void testRenamePipe() {

        AbstractDatasetIterator it = new RangeIterator(5)
                .pipe(new RenamePipe("value", "a"));

        IterUtils.assertValues(it, "a", new Integer[] {0, 1, 2, 3, 4});
    }

    @Test
    public void testZipPipe() {

        AbstractDatasetIterator it = new RangeIterator(5)
            .pipe(
                new ZipPipe(
                    new ArrayIterator(1, 3, 5, 7, 9)
                        .pipe(new RenamePipe("value", "a"))
                )
            );

        ColumnAccessor ca1 = it.getColumnDescriptor("value").getAccessor();
        ColumnAccessor ca2 = it.getColumnDescriptor("a").getAccessor();

        int[][] expected = new int[][] {
            {0, 1},
            {1, 3},
            {2, 5},
            {3, 7},
            {4, 9}
        };

        int count = 0;
        while(it.tryMoveNext()) {
            Row row = it.getCurrentRow();

            assertEquals(expected[count][0], ca1.getValueFromRow(row));
            assertEquals(expected[count][1], ca2.getValueFromRow(row));
            count++;
        }
        assertEquals(5, count);
    }
}
