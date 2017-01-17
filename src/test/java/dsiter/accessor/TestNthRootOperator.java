package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNthRootOperator {

	@Test
	public void testIntRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getIntInstance(8),
			ConstantAccessor.getIntInstance(3)
		);
		assertEquals(2, no.getValueFromRow(new Row()));
	}

	@Test
	public void testLongRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getLongInstance(8L),
			ConstantAccessor.getLongInstance(3L)
		);
		assertEquals(2L, no.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getFloatInstance(8F),
			ConstantAccessor.getFloatInstance(3F)
		);
		assertEquals(2F, no.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getDoubleInstance(8D),
			ConstantAccessor.getDoubleInstance(3D)
		);
		assertEquals(2D, no.getValueFromRow(new Row()));
	}
}
