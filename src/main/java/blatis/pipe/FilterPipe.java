package blatis.pipe;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.FilterIterator;
import blatis.operator.parser.OperatorParser;
import blatis.row.TypedRowAccessor;

/**
 * Created by bkputnam on 12/3/16.
 */
public class FilterPipe implements IPipe {

	TypedRowAccessor.BOOLEAN predicate;
	String filterStr;

	public FilterPipe(TypedRowAccessor.BOOLEAN predicate) {
		this.predicate = predicate;
	}

	public FilterPipe(String filterStr) { this.filterStr = filterStr; }

    @Override
    public AbstractDatasetIterator applyTo(AbstractDatasetIterator src) {
		if( predicate == null ) {
			predicate = OperatorParser.parseOperator(
				src.getColumnDescriptors(),
				filterStr
			).asBoolAccessor();
		}
		return new FilterIterator(src, predicate);
    }
}
