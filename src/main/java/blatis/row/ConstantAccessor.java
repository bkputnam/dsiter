package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class ConstantAccessor implements IRowAccessor {

    Object value;
    ColumnType type;

    public ConstantAccessor(int val) {
        value = val;
        type = ColumnType.INT;
    }

    public ConstantAccessor(long val) {
        value = val;
        type = ColumnType.LONG;
    }

    public ConstantAccessor(float val) {
        value = val;
        type = ColumnType.FLOAT;
    }

    public ConstantAccessor(double val) {
        value = val;
        type = ColumnType.DOUBLE;
    }

    public ConstantAccessor(String val) {
        value = val;
        type = ColumnType.STRING;
    }

    public ConstantAccessor(boolean val) {
        value = val;
        type = ColumnType.BOOLEAN;
    }

    @Override
    public Object getValueFromRow(Row row) {
        return value;
    }

    @Override
    public ColumnType getType() {
        return type;
    }
}
