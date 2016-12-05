package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class ColumnMutator implements IRowMutator {

    protected int index;
    protected IRowMutator innerMutator;



    public ColumnMutator(ColumnType type, int index) {

		if(type == ColumnType.INT) {
			innerMutator = new INT(index);
		}
		else if(type == ColumnType.LONG) {
			innerMutator = new LONG(index);
		}
		else if(type == ColumnType.FLOAT) {
			innerMutator = new FLOAT(index);
		}
		else if(type == ColumnType.DOUBLE) {
			innerMutator = new DOUBLE(index);
		}
		else if(type == ColumnType.STRING) {
			innerMutator = new STRING(index);
		}
		else if(type == ColumnType.BOOLEAN) {
			innerMutator = new BOOLEAN(index);
		}
		else {
			throw new Error("This should be impossible");
		}
    }

    public void setValueInRow(Row row, Object value) {
        innerMutator.setValueInRow(row, value);
    }

    public ColumnType getType() {
        return innerMutator.getType();
    }


    public INT asIntMutator() { return (INT)innerMutator; }
    public LONG asLongMutator() { return (LONG)innerMutator; }
    public FLOAT asFloatMutator() { return (FLOAT)innerMutator; }
    public DOUBLE asDoubleMutator() { return (DOUBLE)innerMutator; }
    public STRING asStringMutator() { return (STRING)innerMutator; }
    public BOOLEAN asBoolMutator() { return (BOOLEAN)innerMutator; }


    public static class INT implements IRowMutator {
        private int index;

        public INT(int index) {
            this.index = index;
        }

        public void setIntInRow(Row row, int val) {
            row.ints[index] = val;
        }

        @Override
        public void setValueInRow(Row row, Object value) {
            setIntInRow(row, (int)value);
        }

        public ColumnType getType() { return ColumnType.INT; }
    }

    public static class LONG implements IRowMutator {
        private int index;

        public LONG(int index) {
            this.index = index;
        }

        public void setLongInRow(Row row, long val) {
            row.longs[index] = val;
        }

        @Override
        public void setValueInRow(Row row, Object value) {
            setLongInRow(row, (long)value);
        }

        public ColumnType getType() { return ColumnType.LONG; }
    }

    public static class FLOAT implements IRowMutator {
        private int index;

        public FLOAT(int index) {
            this.index = index;
        }

        public void setFloatInRow(Row row, float val) {
            row.floats[index] = val;
        }

        @Override
        public void setValueInRow(Row row, Object value) {
            setFloatInRow(row, (float)value);
        }

        public ColumnType getType() { return ColumnType.FLOAT; }
    }

    public static class DOUBLE implements IRowMutator {
        private int index;

        public DOUBLE(int index) {
            this.index = index;
        }

        public void setDoubleInRow(Row row, double val) {
            row.doubles[index] = val;
        }

        @Override
        public void setValueInRow(Row row, Object value) {
            setDoubleInRow(row, (double)value);
        }

        public ColumnType getType() { return ColumnType.DOUBLE; }
    }

    public static class STRING implements IRowMutator {
        private int index;

        public STRING(int index) {
            this.index = index;
        }

        public void setStringInRow(Row row, String val) {
            row.strings[index] = val;
        }

        @Override
        public void setValueInRow(Row row, Object value) {
            setStringInRow(row, (String)value);
        }

        public ColumnType getType() { return ColumnType.STRING; }
    }

    public static class BOOLEAN implements IRowMutator {
        private int index;

        public BOOLEAN(int index) {
            this.index = index;
        }

        public void setBoolInRow(Row row, boolean val) {
            row.bools[index] = val;
        }

        @Override
        public void setValueInRow(Row row, Object value) {
            setBoolInRow(row, (boolean)value);
        }

        public ColumnType getType() { return ColumnType.BOOLEAN; }
    }


}
