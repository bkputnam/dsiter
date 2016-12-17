/* GENERATED CODE */package blatis.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public abstract class TypedRowAccessor implements IRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */    protected ColumnType type;
/* GENERATED CODE */    protected IRowAccessor innerAccessor;
/* GENERATED CODE */
/* GENERATED CODE */    @Override
/* GENERATED CODE */    public Object getValueFromRow(Row row) {
/* GENERATED CODE */        return innerAccessor.getValueFromRow(row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    @Override
/* GENERATED CODE */    public ColumnType getType() {
/* GENERATED CODE */        return innerAccessor.getType();
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    public INT asIntAccessor() { return (INT)innerAccessor; }
/* GENERATED CODE */    public LONG asLongAccessor() { return (LONG)innerAccessor; }
/* GENERATED CODE */    public FLOAT asFloatAccessor() { return (FLOAT)innerAccessor; }
/* GENERATED CODE */    public DOUBLE asDoubleAccessor() { return (DOUBLE)innerAccessor; }
/* GENERATED CODE */    public STRING asStringAccessor() { return (STRING)innerAccessor; }
/* GENERATED CODE */    public BOOLEAN asBoolAccessor() { return (BOOLEAN)innerAccessor; }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    public abstract static class INT implements IRowAccessor {
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public Object getValueFromRow(Row row) { return getIntFromRow(row); }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.INT; }
/* GENERATED CODE */
/* GENERATED CODE */        public abstract int getIntFromRow(Row row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public abstract static class LONG implements IRowAccessor {
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public Object getValueFromRow(Row row) { return getLongFromRow(row); }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.LONG; }
/* GENERATED CODE */
/* GENERATED CODE */        public abstract long getLongFromRow(Row row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public abstract static class FLOAT implements IRowAccessor {
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public Object getValueFromRow(Row row) { return getFloatFromRow(row); }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.FLOAT; }
/* GENERATED CODE */
/* GENERATED CODE */        public abstract float getFloatFromRow(Row row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public abstract static class DOUBLE implements IRowAccessor {
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public Object getValueFromRow(Row row) { return getDoubleFromRow(row); }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.DOUBLE; }
/* GENERATED CODE */
/* GENERATED CODE */        public abstract double getDoubleFromRow(Row row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public abstract static class STRING implements IRowAccessor {
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public Object getValueFromRow(Row row) { return getStringFromRow(row); }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.STRING; }
/* GENERATED CODE */
/* GENERATED CODE */        public abstract String getStringFromRow(Row row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public abstract static class BOOLEAN implements IRowAccessor {
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public Object getValueFromRow(Row row) { return getBoolFromRow(row); }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.BOOLEAN; }
/* GENERATED CODE */
/* GENERATED CODE */        public abstract boolean getBoolFromRow(Row row);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */}
