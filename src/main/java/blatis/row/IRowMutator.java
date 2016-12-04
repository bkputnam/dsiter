package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public interface IRowMutator {
    public void setValueInRow(Row row, Object value);
    public ColumnType getType();
}
