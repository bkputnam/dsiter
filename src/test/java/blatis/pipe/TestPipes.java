package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.IterUtils;
import blatis.iterator.RangeIterator;
import blatis.operator.ModuloOperator;
import blatis.predicate.EqualsPredicate;
import blatis.predicate.IPredicate;
import blatis.row.ColumnAccessor;
import blatis.row.ColumnType;
import blatis.row.ConstantAccessor;
import org.junit.Test;

/**
 * Created by bkputnam on 12/3/16.
 */
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

        IPredicate isEvenPredicate = new EqualsPredicate(
                new ModuloOperator(
                        ColumnAccessor.create(ColumnType.INT, 0),
                        new ConstantAccessor(2)
                ),
                new ConstantAccessor(0)
        );

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
}
