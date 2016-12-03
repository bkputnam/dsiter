package blatis.predicate;

import blatis.row.Row;

/**
 * Created by bkputnam on 12/3/16.
 */
public interface IPredicate {
    public boolean testRow(Row row);
}
