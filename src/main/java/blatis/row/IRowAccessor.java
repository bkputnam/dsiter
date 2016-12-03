package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public interface IRowAccessor {
    public Object getValueFromRow(Row row);
    public ColumnDescriptor.Type getType();
}
