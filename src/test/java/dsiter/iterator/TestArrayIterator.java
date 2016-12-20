package dsiter.iterator;

import dsiter.IterUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayIterator {

    @Test
    public void testIntIterator() {
        ArrayIterator it = new ArrayIterator(3, 1, 4, 1, 5, 9);
        IterUtils.assertValues(it, "value", new Integer[] { 3, 1, 4, 1, 5, 9 });
    }

    @Test
    public void testLongIterator() {
        ArrayIterator it = new ArrayIterator(3L, 1L, 4L, 1L, 5L, 9L);
        IterUtils.assertValues(it, "value", new Long[] { 3L, 1L, 4L, 1L, 5L, 9L });
    }

    @Test
    public void testFloatIterator() {
        ArrayIterator it = new ArrayIterator(3F, 1F, 4F, 1F, 5F, 9F);
        IterUtils.assertValues(it, "value", new Float[] { 3F, 1F, 4F, 1F, 5F, 9F });
    }

    @Test
    public void testDoubleIterator() {
        ArrayIterator it = new ArrayIterator(3D, 1D, 4D, 1D, 5D, 9D);
        IterUtils.assertValues(it, "value", new Double[] { 3D, 1D, 4D, 1D, 5D, 9D });
    }

    @Test
    public void testStringIterator() {
        ArrayIterator it = new ArrayIterator("3", "1", "4", "1", "5", "9");
        IterUtils.assertValues(it, "value", new String[] { "3", "1", "4", "1", "5", "9" });
    }

    @Test
    public void testBoolIterator() {
        ArrayIterator it = new ArrayIterator(true, false, false, true);
        IterUtils.assertValues(it, "value", new Boolean[] { true, false, false, true });
    }

    @Test
	public void testLength() {
		ArrayIterator it = new ArrayIterator(true, false, false, true);
		assertEquals(4, it.tryGetLength());
	}
}
