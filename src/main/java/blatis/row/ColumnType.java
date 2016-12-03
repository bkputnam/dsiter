package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public enum ColumnType {
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    STRING,
    BOOLEAN;

    public boolean isNumeric() {
        return this == INT || this == LONG || this == FLOAT || this == DOUBLE;
    }
}
