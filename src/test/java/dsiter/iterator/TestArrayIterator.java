package dsiter.iterator;

import dsiter.IterUtils;
import dsiter.pipe.SkipPipe;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayIterator {

    @Test
    public void testIntIterator() throws Exception {
        try (ArrayIterator it = ArrayIterator.fromInts(3, 1, 4, 1, 5, 9)) {
			IterUtils.assertValues(it, "value", new Integer[]{3, 1, 4, 1, 5, 9});
		}
    }

    @Test
    public void testLongIterator() throws Exception {
        try (ArrayIterator it = ArrayIterator.fromLongs(3L, 1L, 4L, 1L, 5L, 9L)) {
			IterUtils.assertValues(it, "value", new Long[]{3L, 1L, 4L, 1L, 5L, 9L});
		}
    }

    @Test
    public void testFloatIterator() throws Exception {
		try (ArrayIterator it = ArrayIterator.fromFloats(3F, 1F, 4F, 1F, 5F, 9F)) {
			IterUtils.assertValues(it, "value", new Float[]{3F, 1F, 4F, 1F, 5F, 9F});
		}
    }

    @Test
    public void testDoubleIterator() throws Exception {
		try (ArrayIterator it = ArrayIterator.fromDoubles(3D, 1D, 4D, 1D, 5D, 9D)) {
			IterUtils.assertValues(it, "value", new Double[]{3D, 1D, 4D, 1D, 5D, 9D});
		}
    }

    @Test
    public void testStringIterator() throws Exception {
		try (ArrayIterator it = ArrayIterator.fromStrings("3", "1", "4", "1", "5", "9")) {
			IterUtils.assertValues(it, "value", new String[]{"3", "1", "4", "1", "5", "9"});
		}
    }

    @Test
    public void testBoolIterator() throws Exception {
		try (ArrayIterator it = ArrayIterator.fromBools(true, false, false, true)) {
			IterUtils.assertValues(it, "value", new Boolean[]{true, false, false, true});
		}
    }

    @Test
	public void testLength() {
		try (ArrayIterator it = ArrayIterator.fromBools(true, false, false, true)) {
			assertEquals(4, it.tryGetLength());
		}
	}

	@Test
	public void tryAbsorbSkip() throws Exception {
		try (ArrayIterator it = ArrayIterator.fromInts(new int[] { 3, 1, 4, 1, 5, 9, 2, 6 })) {
			assertEquals(true, it.tryAbsorb(new SkipPipe(5)));
			IterUtils.assertValues(it, "value", new Integer[] { 9, 2, 6 });
		}
	}
}
