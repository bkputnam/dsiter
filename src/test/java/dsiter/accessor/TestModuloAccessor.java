package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestModuloAccessor {

	@Test
	public void testIntInt() {
		ModuloAccessor x = new ModuloAccessor.INT_INT(
			new ConstantAccessor.INT(10),
			new ConstantAccessor.INT(3)
		);
		assertEquals(1, x.getValueFromRow(new Row()));
	}

	@Test
	public void testIntLong() {
		ModuloAccessor x = new ModuloAccessor.INT_LONG(
			new ConstantAccessor.INT(10),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(1L, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongInt() {
		ModuloAccessor x = new ModuloAccessor.LONG_INT(
			new ConstantAccessor.LONG(10L),
			new ConstantAccessor.INT(3)
		);
		assertEquals(1L, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLongLong() {
		ModuloAccessor x = new ModuloAccessor.LONG_LONG(
			new ConstantAccessor.LONG(10L),
			new ConstantAccessor.LONG(3L)
		);
		assertEquals(1L, x.getValueFromRow(new Row()));
	}
}
