package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.FilterIterator;
import dsiter.operator.parser.OperatorParser;
import dsiter.row.TypedRowAccessor;

/**
 * Pipe class for {@link FilterIterator}
 */
public class FilterPipe implements IPipe {

	TypedRowAccessor.BOOLEAN predicate;
	String filterStr;

	public FilterPipe(TypedRowAccessor.BOOLEAN predicate) {
		this.predicate = predicate;
	}

	public FilterPipe(String filterStr) { this.filterStr = filterStr; }

    @Override
    public IDatasetIterator attachTo(IDatasetIterator src) {
		if( predicate == null ) {
			predicate = OperatorParser.parseOperator(
				src.getColumnDescriptors(),
				filterStr
			).asBoolAccessor();
		}
		return new FilterIterator(src, predicate);
    }
}
