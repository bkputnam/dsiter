package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestEqualsOperator {

	@Test
	public void testIntTrue() {
		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(2)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testIntFalse() {
		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(3)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongTrue() {
		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getLongInstance(2L)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFalse() {
		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getLongInstance(3L)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testStringTrue() {
		Random r = new Random(System.currentTimeMillis());
		String s1 = "Hello";
		String s2 = ("Hello" + r.nextInt()).substring(0, 5); // Make sure they're not the same instance

		assertFalse(s1 == s2); // Make sure we don't get a false success
		assertTrue(s1.equals(s2)); // Make sure I didn't mess up the string manipulation

		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getStringInstance(s1),
			ConstantAccessor.getStringInstance(s2)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testStringFalse() {
		Random r = new Random(System.currentTimeMillis());
		String s1 = "Hello";
		String s2 = ("Hollo" + r.nextInt()).substring(0, 5); // Make sure they're not the same instance

		assertFalse(s1 == s2); // Make sure we don't get a false success
		assertFalse(s1.equals(s2)); // Make sure I didn't mess up the string manipulation

		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getStringInstance(s1),
			ConstantAccessor.getStringInstance(s2)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatTrue() {
		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getFloatInstance(2.0F)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatFalse() {
		EqualsOperator eq = new EqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getFloatInstance(3.0F)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testJsDateTrue() {
		EqualsOperator eq = new EqualsOperator(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testJsDateFalse() {
		EqualsOperator eq = new EqualsOperator(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(false, eq.getValueFromRow(new Row()));
	}
}
