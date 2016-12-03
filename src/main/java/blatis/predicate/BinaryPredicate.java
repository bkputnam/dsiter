package blatis.predicate;

import blatis.row.IRowAccessor;
import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public abstract class BinaryPredicate implements IPredicate {

    protected IRowAccessor lhs;
    protected IRowAccessor rhs;

    public BinaryPredicate(IRowAccessor lhs, IRowAccessor rhs) {
        if( lhs == null ) { throw new IllegalArgumentException("lhs cannot be null"); }
        if( rhs == null ) { throw new IllegalArgumentException("rhs cannot be null"); }

        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public abstract boolean testRow(Row row);
}
