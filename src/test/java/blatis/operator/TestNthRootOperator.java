package blatis.operator;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNthRootOperator {

	@Test
	public void testIntRoot() {
		NthRootOperator no = new NthRootOperator(
			new ConstantAccessor(8),
			new ConstantAccessor(3)
		);
		assertEquals(2, no.getValueFromRow(new Row()));
	}

	@Test
	public void testLongRoot() {
		NthRootOperator no = new NthRootOperator(
			new ConstantAccessor(8L),
			new ConstantAccessor(3L)
		);
		assertEquals(2L, no.getValueFromRow(new Row()));
	}

	@Test
	public void testFloatRoot() {
		NthRootOperator no = new NthRootOperator(
			new ConstantAccessor(8F),
			new ConstantAccessor(3F)
		);
		assertEquals(2F, no.getValueFromRow(new Row()));
	}

	@Test
	public void testDoubleRoot() {
		NthRootOperator no = new NthRootOperator(
			new ConstantAccessor(8D),
			new ConstantAccessor(3D)
		);
		assertEquals(2D, no.getValueFromRow(new Row()));
	}
}
