package dsiter.pipe;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.FilterIterator;
import dsiter.parser.OperatorParser;
import dsiter.parser.ast.AstNode;
import dsiter.row.ColumnType;
import dsiter.row.IRowAccessor;

/**
 * Pipe class for {@link FilterIterator}
 */
public class FilterPipe implements IPipe {

	private AstNode astNode;

	public FilterPipe(AstNode astNode) {
		this.astNode = astNode;
	}

	public FilterPipe(String filterStr) {
		this.astNode = OperatorParser.parseOperator(filterStr);
	}

    @Override
    public IDatasetIterator attachTo(IDatasetIterator src) {
		IRowAccessor accessor = astNode.link(src.getColumnDescriptors());
		if (accessor.getType() != ColumnType.BOOLEAN) {
			throw new RuntimeException("Filter must be a boolean expression");
		}
		return new FilterIterator(src, (IRowAccessor.BOOLEAN)accessor);
    }
}
