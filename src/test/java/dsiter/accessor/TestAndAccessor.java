package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAndAccessor {

	@Test
	public void testTrueTrue() {
		AndAccessor x = new AndAccessor(
			new ConstantAccessor.BOOLEAN(true),
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		AndAccessor x = new AndAccessor(
			new ConstantAccessor.BOOLEAN(true),
			new ConstantAccessor.BOOLEAN(false)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		AndAccessor x = new AndAccessor(
			new ConstantAccessor.BOOLEAN(false),
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		AndAccessor x = new AndAccessor(
			new ConstantAccessor.BOOLEAN(false),
			new ConstantAccessor.BOOLEAN(false)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}
}
