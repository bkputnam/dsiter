package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOrAccessor {

	@Test
	public void testTrueTrue() {
		OrAccessor x = new OrAccessor(
			new ConstantAccessor.BOOLEAN(true),
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testTrueFalse() {
		OrAccessor x = new OrAccessor(
			new ConstantAccessor.BOOLEAN(true),
			new ConstantAccessor.BOOLEAN(false)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseTrue() {
		OrAccessor x = new OrAccessor(
			new ConstantAccessor.BOOLEAN(false),
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFalseFalse() {
		OrAccessor x = new OrAccessor(
			new ConstantAccessor.BOOLEAN(false),
			new ConstantAccessor.BOOLEAN(false)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}
}
