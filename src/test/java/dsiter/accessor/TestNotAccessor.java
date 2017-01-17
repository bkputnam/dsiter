package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNotAccessor {

	@Test
	public void testTrue() {
		NotAccessor x = new NotAccessor(
			new ConstantAccessor.BOOLEAN(true)
		);
		assertEquals(false, x.getValueFromRow(new Row()));
	}

	@Test
	public void testFalse() {
		NotAccessor x = new NotAccessor(
			new ConstantAccessor.BOOLEAN(false)
		);
		assertEquals(true, x.getValueFromRow(new Row()));
	}
}
