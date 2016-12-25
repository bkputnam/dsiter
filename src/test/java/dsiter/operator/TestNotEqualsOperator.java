package dsiter.operator;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestNotEqualsOperator {

	@Test
	public void testIntFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getInstance(2),
			ConstantAccessor.getInstance(2)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testIntTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getInstance(2),
			ConstantAccessor.getInstance(3)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getInstance(2L),
			ConstantAccessor.getInstance(2L)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getInstance(2L),
			ConstantAccessor.getInstance(3L)
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
			ConstantAccessor.getInstance(s1),
			ConstantAccessor.getInstance(s2)
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
			ConstantAccessor.getInstance(s1),
			ConstantAccessor.getInstance(s2)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatFalse() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getInstance(2L),
			ConstantAccessor.getInstance(2.0F)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatTrue() {
		NotEqualsOperator eq = new NotEqualsOperator(
			ConstantAccessor.getInstance(2L),
			ConstantAccessor.getInstance(3.0F)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}
}
