package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestNotEqualsOperator {

	@Test
	public void testIntFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(2)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testIntTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getIntInstance(2),
			ConstantAccessor.getIntInstance(3)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getLongInstance(2L)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getLongInstance(3L)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testStringFalse() {
		Random r = new Random(System.currentTimeMillis());
		String s1 = "Hello";
		String s2 = ("Hello" + r.nextInt()).substring(0, 5); // Make sure they're not the same instance

		assertFalse(s1 == s2); // Make sure we don't get a false success
		assertTrue(s1.equals(s2)); // Make sure I didn't mess up the string manipulation

		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getStringInstance(s1),
			ConstantAccessor.getStringInstance(s2)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testStringTrue() {
		Random r = new Random(System.currentTimeMillis());
		String s1 = "Hello";
		String s2 = ("Hollo" + r.nextInt()).substring(0, 5); // Make sure they're not the same instance

		assertFalse(s1 == s2); // Make sure we don't get a false success
		assertFalse(s1.equals(s2)); // Make sure I didn't mess up the string manipulation

		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getStringInstance(s1),
			ConstantAccessor.getStringInstance(s2)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getFloatInstance(2.0F)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getLongInstance(2L),
			ConstantAccessor.getFloatInstance(3.0F)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testJsDateFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z")
		);
		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testJsDateTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:00Z"),
				ConstantAccessor.getJsDateInstance("1970-01-01T00:00:01Z")
		);
		assertEquals(true, eq.getValueFromRow(new Row()));
	}
}
