package blatis.row;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

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
