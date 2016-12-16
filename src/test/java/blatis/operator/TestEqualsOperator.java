package blatis.operator;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by bkputnam on 12/15/16.
 */
public class TestEqualsOperator {

	@Test
	public void testIntTrue() {
		EqualsOperator eq = new EqualsOperator(
			new ConstantAccessor(2),
			new ConstantAccessor(2)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testIntFalse() {
		EqualsOperator eq = new EqualsOperator(
			new ConstantAccessor(2),
			new ConstantAccessor(3)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongTrue() {
		EqualsOperator eq = new EqualsOperator(
			new ConstantAccessor(2L),
			new ConstantAccessor(2L)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFalse() {
		EqualsOperator eq = new EqualsOperator(
			new ConstantAccessor(2L),
			new ConstantAccessor(3L)
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
			new ConstantAccessor(s1),
			new ConstantAccessor(s2)
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
			new ConstantAccessor(s1),
			new ConstantAccessor(s2)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatTrue() {
		EqualsOperator eq = new EqualsOperator(
			new ConstantAccessor(2L),
			new ConstantAccessor(2.0F)
		);

		assertEquals(true, eq.getValueFromRow(new Row()));
	}

	@Test
	public void testLongFloatFalse() {
		EqualsOperator eq = new EqualsOperator(
			new ConstantAccessor(2L),
			new ConstantAccessor(3.0F)
		);

		assertEquals(false, eq.getValueFromRow(new Row()));
	}
}
