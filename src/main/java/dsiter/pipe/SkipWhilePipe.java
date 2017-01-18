package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.SkipWhileIterator;
import dsiter.parser.OperatorParser;
import dsiter.parser.ast.AstNode;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

public class SkipWhilePipe implements IPipe {

	private AstNode astNode;

	public SkipWhilePipe(AstNode astNode) {
		this.astNode = astNode;
	}

	public SkipWhilePipe(String predicateExpression) {
		this.astNode = OperatorParser.parseOperator(predicateExpression);
	}

	@Override
	public IDatasetIterator attachTo(IDatasetIterator src) {
		IRowAccessor predicate = astNode.link(src.getColumnDescriptors());
		if (predicate.getType() != ColumnType.BOOLEAN) {
			throw new RuntimeException("SkipWhile must be a boolean expression");
		}
		return new SkipWhileIterator(src, (IRowAccessor.BOOLEAN)predicate);
	}
}
