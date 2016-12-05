package blatis.row;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

public abstract class TypedRowAccessor implements IRowAccessor {

    protected ColumnType type;
    protected IRowAccessor innerAccessor;

    @Override
    public Object getValueFromRow(Row row) {
        return innerAccessor.getValueFromRow(row);
    }

    @Override
    public ColumnType getType() {
        return innerAccessor.getType();
    }


    public INT asIntAccessor() { return (INT)innerAccessor; }
    public LONG asLongAccessor() { return (LONG)innerAccessor; }
    public FLOAT asFloatAccessor() { return (FLOAT)innerAccessor; }
    public DOUBLE asDoubleAccessor() { return (DOUBLE)innerAccessor; }
    public STRING asStringAccessor() { return (STRING)innerAccessor; }
    public BOOLEAN asBoolAccessor() { return (BOOLEAN)innerAccessor; }


    public abstract static class INT implements IRowAccessor {
        @Override
        public Object getValueFromRow(Row row) { return getIntFromRow(row); }

        @Override
        public ColumnType getType() { return ColumnType.INT; }

        public abstract int getIntFromRow(Row row);
    }

    public abstract static class LONG implements IRowAccessor {
        @Override
        public Object getValueFromRow(Row row) { return getLongFromRow(row); }

        @Override
        public ColumnType getType() { return ColumnType.LONG; }

        public abstract long getLongFromRow(Row row);
    }

    public abstract static class FLOAT implements IRowAccessor {
        @Override
        public Object getValueFromRow(Row row) { return getFloatFromRow(row); }

        @Override
        public ColumnType getType() { return ColumnType.FLOAT; }

        public abstract float getFloatFromRow(Row row);
    }

    public abstract static class DOUBLE implements IRowAccessor {
        @Override
        public Object getValueFromRow(Row row) { return getDoubleFromRow(row); }

        @Override
        public ColumnType getType() { return ColumnType.DOUBLE; }

        public abstract double getDoubleFromRow(Row row);
    }

    public abstract static class STRING implements IRowAccessor {
        @Override
        public Object getValueFromRow(Row row) { return getStringFromRow(row); }

        @Override
        public ColumnType getType() { return ColumnType.STRING; }

        public abstract String getStringFromRow(Row row);
    }

    public abstract static class BOOLEAN implements IRowAccessor {
        @Override
        public Object getValueFromRow(Row row) { return getBoolFromRow(row); }

        @Override
        public ColumnType getType() { return ColumnType.BOOLEAN; }

        public abstract boolean getBoolFromRow(Row row);
    }


}
