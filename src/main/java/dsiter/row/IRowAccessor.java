package dsiter.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public interface IRowAccessor {
    public Object getValueFromRow(Row row);
    public ColumnType getType();
}