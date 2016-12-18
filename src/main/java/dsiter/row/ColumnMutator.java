/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public class ColumnMutator implements IRowMutator {
/* GENERATED CODE */
/* GENERATED CODE */    protected int index;
/* GENERATED CODE */    protected IRowMutator innerMutator;
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    public ColumnMutator(ColumnType type, int index) {
/* GENERATED CODE */
/* GENERATED CODE */		if(type == ColumnType.INT) {
/* GENERATED CODE */			innerMutator = new INT(index);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.LONG) {
/* GENERATED CODE */			innerMutator = new LONG(index);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.FLOAT) {
/* GENERATED CODE */			innerMutator = new FLOAT(index);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.DOUBLE) {
/* GENERATED CODE */			innerMutator = new DOUBLE(index);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.STRING) {
/* GENERATED CODE */			innerMutator = new STRING(index);
/* GENERATED CODE */		}
/* GENERATED CODE */		else if(type == ColumnType.BOOLEAN) {
/* GENERATED CODE */			innerMutator = new BOOLEAN(index);
/* GENERATED CODE */		}
/* GENERATED CODE */		else {
/* GENERATED CODE */			throw new Error("This should be impossible");
/* GENERATED CODE */		}
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */        innerMutator.setValueInRow(row, value);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public ColumnType getType() {
/* GENERATED CODE */        return innerMutator.getType();
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    public INT asIntMutator() { return (INT)innerMutator; }
/* GENERATED CODE */    public LONG asLongMutator() { return (LONG)innerMutator; }
/* GENERATED CODE */    public FLOAT asFloatMutator() { return (FLOAT)innerMutator; }
/* GENERATED CODE */    public DOUBLE asDoubleMutator() { return (DOUBLE)innerMutator; }
/* GENERATED CODE */    public STRING asStringMutator() { return (STRING)innerMutator; }
/* GENERATED CODE */    public BOOLEAN asBoolMutator() { return (BOOLEAN)innerMutator; }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    public static class INT implements IRowMutator {
/* GENERATED CODE */        private int index;
/* GENERATED CODE */
/* GENERATED CODE */        public INT(int index) {
/* GENERATED CODE */            this.index = index;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public void setIntInRow(Row row, int val) {
/* GENERATED CODE */            row.ints[index] = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */            setIntInRow(row, (int)value);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.INT; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public static class LONG implements IRowMutator {
/* GENERATED CODE */        private int index;
/* GENERATED CODE */
/* GENERATED CODE */        public LONG(int index) {
/* GENERATED CODE */            this.index = index;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public void setLongInRow(Row row, long val) {
/* GENERATED CODE */            row.longs[index] = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */            setLongInRow(row, (long)value);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.LONG; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public static class FLOAT implements IRowMutator {
/* GENERATED CODE */        private int index;
/* GENERATED CODE */
/* GENERATED CODE */        public FLOAT(int index) {
/* GENERATED CODE */            this.index = index;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public void setFloatInRow(Row row, float val) {
/* GENERATED CODE */            row.floats[index] = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */            setFloatInRow(row, (float)value);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.FLOAT; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public static class DOUBLE implements IRowMutator {
/* GENERATED CODE */        private int index;
/* GENERATED CODE */
/* GENERATED CODE */        public DOUBLE(int index) {
/* GENERATED CODE */            this.index = index;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public void setDoubleInRow(Row row, double val) {
/* GENERATED CODE */            row.doubles[index] = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */            setDoubleInRow(row, (double)value);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.DOUBLE; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public static class STRING implements IRowMutator {
/* GENERATED CODE */        private int index;
/* GENERATED CODE */
/* GENERATED CODE */        public STRING(int index) {
/* GENERATED CODE */            this.index = index;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public void setStringInRow(Row row, String val) {
/* GENERATED CODE */            row.strings[index] = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */            setStringInRow(row, (String)value);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.STRING; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public static class BOOLEAN implements IRowMutator {
/* GENERATED CODE */        private int index;
/* GENERATED CODE */
/* GENERATED CODE */        public BOOLEAN(int index) {
/* GENERATED CODE */            this.index = index;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public void setBoolInRow(Row row, boolean val) {
/* GENERATED CODE */            row.bools[index] = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public void setValueInRow(Row row, Object value) {
/* GENERATED CODE */            setBoolInRow(row, (boolean)value);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        public ColumnType getType() { return ColumnType.BOOLEAN; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */}
