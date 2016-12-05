package blatis.row;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

public class ConstantAccessor extends TypedRowAccessor {


    public ConstantAccessor(int val) {
        super.type = ColumnType.INT;
        super.innerAccessor = new INT(val);
    }

    public ConstantAccessor(long val) {
        super.type = ColumnType.LONG;
        super.innerAccessor = new LONG(val);
    }

    public ConstantAccessor(float val) {
        super.type = ColumnType.FLOAT;
        super.innerAccessor = new FLOAT(val);
    }

    public ConstantAccessor(double val) {
        super.type = ColumnType.DOUBLE;
        super.innerAccessor = new DOUBLE(val);
    }

    public ConstantAccessor(String val) {
        super.type = ColumnType.STRING;
        super.innerAccessor = new STRING(val);
    }

    public ConstantAccessor(boolean val) {
        super.type = ColumnType.BOOLEAN;
        super.innerAccessor = new BOOLEAN(val);
    }



    private class INT extends TypedRowAccessor.INT {
        private int val;

        public INT(int val) {
            this.val = val;
        }

        @Override
        public int getIntFromRow(Row row) { return val; }
    }

    private class LONG extends TypedRowAccessor.LONG {
        private long val;

        public LONG(long val) {
            this.val = val;
        }

        @Override
        public long getLongFromRow(Row row) { return val; }
    }

    private class FLOAT extends TypedRowAccessor.FLOAT {
        private float val;

        public FLOAT(float val) {
            this.val = val;
        }

        @Override
        public float getFloatFromRow(Row row) { return val; }
    }

    private class DOUBLE extends TypedRowAccessor.DOUBLE {
        private double val;

        public DOUBLE(double val) {
            this.val = val;
        }

        @Override
        public double getDoubleFromRow(Row row) { return val; }
    }

    private class STRING extends TypedRowAccessor.STRING {
        private String val;

        public STRING(String val) {
            this.val = val;
        }

        @Override
        public String getStringFromRow(Row row) { return val; }
    }

    private class BOOLEAN extends TypedRowAccessor.BOOLEAN {
        private boolean val;

        public BOOLEAN(boolean val) {
            this.val = val;
        }

        @Override
        public boolean getBoolFromRow(Row row) { return val; }
    }

}
