package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.SkipWhileIterator;
import dsiter.parser.OperatorParser;
import dsiter.row.IRowAccessor;

public class SkipWhilePipe implements IPipe {

	private IRowAccessor.BOOLEAN predicate;
	private String predicateExpression;

	public SkipWhilePipe(IRowAccessor.BOOLEAN predicate) {
		this.predicate = predicate;
	}

	public SkipWhilePipe(String predicateExpression) {
		this.predicateExpression = predicateExpression;
	}

	@Override
	public IDatasetIterator attachTo(IDatasetIterator src) {
		if (predicate == null) {
			predicate = OperatorParser.parseOperator(
				src.getColumnDescriptors(),
				predicateExpression
			).asBoolAccessor();
		}
		return new SkipWhileIterator(src, predicate);
	}
}
