package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.TakeWhileIterator;
import dsiter.parser.OperatorParser;
import dsiter.row.IRowAccessor;

public class TakeWhilePipe implements IPipe {

	private IRowAccessor.BOOLEAN predicate;
	private String predicateExpression;

	public TakeWhilePipe(IRowAccessor.BOOLEAN predicate) {
		this.predicate = predicate;
	}

	public TakeWhilePipe(String predicateExpression) {
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
		return new TakeWhileIterator(src, predicate);
	}
}
