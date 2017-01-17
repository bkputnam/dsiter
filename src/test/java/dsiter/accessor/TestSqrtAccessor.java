package dsiter.accessor;

import dsiter.row.IRowAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSqrtAccessor {

	@Test
	public void testInt() {
		IRowAccessor x = new SqrtAccessor.INT(
			new ConstantAccessor.INT(16)
		);
		assertEquals(4D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testLong() {
		IRowAccessor x = new SqrtAccessor.LONG(
			new ConstantAccessor.LONG(16L)
		);
		assertEquals(4D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFloat() {
		IRowAccessor x = new SqrtAccessor.FLOAT(
			new ConstantAccessor.FLOAT(16F)
		);
		assertEquals(4D, x.getValueFromRow(new Row()));
	}

	@Test
	public void testDouble() {
		IRowAccessor x = new SqrtAccessor.DOUBLE(
			new ConstantAccessor.DOUBLE(16D)
		);
		assertEquals(4D, x.getValueFromRow(new Row()));
	}
}
