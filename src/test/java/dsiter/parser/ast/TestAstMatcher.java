package dsiter.parser.ast;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAstMatcher {

	@Test
	public void testGt() {

		AstNode x = new GreaterThanOperator(
			new ColumnOperator("foo"),
			new ConstantOperator.INT(5)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);

		assertNotNull(bounds);
		assertEquals("foo", bounds.column.columnName);
		assertEquals(5, bounds.lowerBound.getValue());
		assertEquals(false, bounds.lowerBoundInclusive);
		assertEquals(null, bounds.upperBound);
		assertEquals(false, bounds.upperBoundInclusive);
	}

	@Test
	public void testGte() {

		AstNode x = new GreaterThanEqualsOperator(
			new ColumnOperator("foo"),
			new ConstantOperator.INT(5)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);

		assertNotNull(bounds);
		assertEquals("foo", bounds.column.columnName);
		assertEquals(5, bounds.lowerBound.getValue());
		assertEquals(true, bounds.lowerBoundInclusive);
		assertEquals(null, bounds.upperBound);
		assertEquals(false, bounds.upperBoundInclusive);
	}

	@Test
	public void testLt() {

		AstNode x = new LessThanOperator(
			new ColumnOperator("foo"),
			new ConstantOperator.INT(5)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);

		assertNotNull(bounds);
		assertEquals("foo", bounds.column.columnName);
		assertEquals(null, bounds.lowerBound);
		assertEquals(false, bounds.lowerBoundInclusive);
		assertEquals(5, bounds.upperBound.getValue());
		assertEquals(false, bounds.upperBoundInclusive);
	}

	@Test
	public void testLte() {

		AstNode x = new LessThanEqualsOperator(
			new ColumnOperator("foo"),
			new ConstantOperator.INT(5)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);

		assertNotNull(bounds);
		assertEquals("foo", bounds.column.columnName);
		assertEquals(null, bounds.lowerBound);
		assertEquals(false, bounds.lowerBoundInclusive);
		assertEquals(5, bounds.upperBound.getValue());
		assertEquals(true, bounds.upperBoundInclusive);
	}

	@Test
	public void testLteReversed() {

		AstNode x = new LessThanEqualsOperator(
			new ConstantOperator.INT(5),
			new ColumnOperator("foo")
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);

		assertNotNull(bounds);
		assertEquals("foo", bounds.column.columnName);
		assertEquals(5, bounds.lowerBound.getValue());
		assertEquals(true, bounds.lowerBoundInclusive);
		assertEquals(null, bounds.upperBound);
		assertEquals(false, bounds.upperBoundInclusive);
	}

	@Test
	public void testDouble() {

		AstNode x = new AndOperator(
			new LessThanEqualsOperator(
				new ColumnOperator("foo"),
				new ConstantOperator.INT(10)

			),
			new GreaterThanEqualsOperator(
				new ColumnOperator("foo"),
				new ConstantOperator.INT(5)
			)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);

		assertNotNull(bounds);
		assertEquals("foo", bounds.column.columnName);
		assertEquals(5, bounds.lowerBound.getValue());
		assertEquals(true, bounds.lowerBoundInclusive);
		assertEquals(10, bounds.upperBound.getValue());
		assertEquals(true, bounds.upperBoundInclusive);
	}

	@Test
	public void testDoubleFail1() {

		AstNode x = new AndOperator(
			new LessThanEqualsOperator(
				new ConstantOperator.INT(5),
				new ColumnOperator("foo")
			),
			new LessThanEqualsOperator(
				new ConstantOperator.INT(5),
				new ColumnOperator("foo")
			)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);
		assertNull(bounds);
	}

	@Test
	public void testDoubleFail2() {

		AstNode x = new AndOperator(
			new LessThanEqualsOperator(
				new ConstantOperator.INT(5),
				new ColumnOperator("foo")
			),
			new GreaterThanEqualsOperator(
				new ConstantOperator.INT(5),
				new ColumnOperator("bar")
			)
		);

		AstMatcher.RangeBoundaries bounds = AstMatcher.testSimpleRangeBoundaries(x);
		assertNull(bounds);
	}
}
