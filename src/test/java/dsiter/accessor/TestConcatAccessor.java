package dsiter.accessor;

import dsiter.row.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestConcatAccessor {

	@Test
	public void test1() {
		ConcatAccessor x = new ConcatAccessor(
			new ConstantAccessor.STRING("foo"),
			new ConstantAccessor.STRING("bar")
		);
		assertEquals("foobar", x.getValueFromRow(new Row()));
	}

	@Test
	public void test2() {
		ConcatAccessor x = new ConcatAccessor(
			new ConstantAccessor.STRING(""),
			new ConstantAccessor.STRING("bar")
		);
		assertEquals("bar", x.getValueFromRow(new Row()));
	}

	@Test
	public void test3() {
		ConcatAccessor x = new ConcatAccessor(
			new ConstantAccessor.STRING("foo"),
			new ConstantAccessor.STRING("")
		);
		assertEquals("foo", x.getValueFromRow(new Row()));
	}
}
