package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNthRootOperator {

	@Test
	public void testIntRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getInstance(8),
			ConstantAccessor.getInstance(3)
		);
		assertEquals(2, no.getValueFromRow(new Row()));
	}

	@Test
	public void testLongRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getInstance(8L),
			ConstantAccessor.getInstance(3L)
		);
		assertEquals(2L, no.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getInstance(8F),
			ConstantAccessor.getInstance(3F)
		);
		assertEquals(2F, no.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleRoot() {
		NthRootOperator no = new NthRootOperator(
			ConstantAccessor.getInstance(8D),
			ConstantAccessor.getInstance(3D)
		);
		assertEquals(2D, no.getValueFromRow(new Row()));
	}
}
