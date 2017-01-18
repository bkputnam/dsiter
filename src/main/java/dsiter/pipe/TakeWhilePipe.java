package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.TakeWhileIterator;
import dsiter.parser.OperatorParser;
import dsiter.parser.ast.AstNode;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

public class TakeWhilePipe implements IPipe {

	private AstNode astNode;

	public TakeWhilePipe(AstNode astNode) {
		this.astNode = astNode;
	}

	public TakeWhilePipe(String predicateExpression) {
		this.astNode = OperatorParser.parseOperator(predicateExpression);
	}

	@Override
	public IDatasetIterator attachTo(IDatasetIterator src) {
		IRowAccessor predicate = astNode.link(src.getColumnDescriptors());
		if (predicate.getType() != ColumnType.BOOLEAN) {
			throw new RuntimeException("TakeWhile must be a boolean expression");
		}
		return new TakeWhileIterator(src, (IRowAccessor.BOOLEAN)predicate);
	}
}
