package dsiter.parser.ast;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMatch {

	public static void testBinaryOperator(BiFunction<AstNode, AstNode, AstNode> fn) {
		AstNode thisShouldMatch = fn.apply(
			new ColumnOperator("col-1"),
			new ConstantOperator.INT(1234)
		);

		AstNode pattern = fn.apply(
			new ColumnOperator("col"),
			new NamedConstantOperator("num")
		);

		Map<String, String> columnMap = new HashMap<>();
		Map<String, ConstantOperator> constantMap = new HashMap<>();

		assertEquals(true, pattern.matches(thisShouldMatch, columnMap, constantMap));
		assertEquals("col-1", columnMap.get("col"));
		assertEquals(1234, constantMap.get("num").link(null).getValueFromRow(null));

		AstNode thisShouldNotMatch;
		if (pattern instanceof AndOperator) {
			thisShouldNotMatch = new OrOperator(
				new ColumnOperator("col-1"),
				new ConstantOperator.INT(1234)
			);
		}
		else {
			thisShouldNotMatch = new AndOperator(
				new ColumnOperator("col-1"),
				new ConstantOperator.INT(1234)
			);
		}

		assertEquals(false, pattern.matches(thisShouldNotMatch, columnMap, constantMap));
	}

	public static void testUnaryOperator(Function<AstNode, AstNode> fn) {
		AstNode columnMatch = fn.apply(
			new ColumnOperator("col-1")
		);

		AstNode columnPattern = fn.apply(
			new ColumnOperator("col")
		);

		Map<String, String> columnMap = new HashMap<>();
		Map<String, ConstantOperator> constantMap = new HashMap<>();

		assertEquals(true, columnPattern.matches(columnMatch, columnMap, constantMap));
		assertEquals("col-1", columnMap.get("col"));

		AstNode constantMatch = fn.apply(
			new ConstantOperator.INT(1234)
		);

		AstNode constantPattern = fn.apply(
			new NamedConstantOperator("foo")
		);

		assertEquals(true, constantPattern.matches(constantMatch, columnMap, constantMap));
		assertEquals(1234, constantMap.get("foo").link(null).getValueFromRow(null));

		assertEquals(false, columnPattern.matches(constantMatch, columnMap, constantMap));
		assertEquals(false, constantPattern.matches(columnMatch, columnMap, constantMap));

		AstNode shouldNotMatch;
		if (columnPattern instanceof NotOperator) {
			shouldNotMatch = new SqrtOperator(
				new ColumnOperator("col-1")
			);
		}
		else {
			shouldNotMatch = new NotOperator(
				new ColumnOperator("col-1")
			);
		}

		assertEquals(false, constantPattern.matches(shouldNotMatch, columnMap, constantMap));
	}
}
