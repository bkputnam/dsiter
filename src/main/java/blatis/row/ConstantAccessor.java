/* GENERATED CODE */package blatis.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public class ConstantAccessor extends TypedRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    public ConstantAccessor(int val) {
/* GENERATED CODE */        super.type = ColumnType.INT;
/* GENERATED CODE */        super.innerAccessor = new INT(val);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public ConstantAccessor(long val) {
/* GENERATED CODE */        super.type = ColumnType.LONG;
/* GENERATED CODE */        super.innerAccessor = new LONG(val);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public ConstantAccessor(float val) {
/* GENERATED CODE */        super.type = ColumnType.FLOAT;
/* GENERATED CODE */        super.innerAccessor = new FLOAT(val);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public ConstantAccessor(double val) {
/* GENERATED CODE */        super.type = ColumnType.DOUBLE;
/* GENERATED CODE */        super.innerAccessor = new DOUBLE(val);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public ConstantAccessor(String val) {
/* GENERATED CODE */        super.type = ColumnType.STRING;
/* GENERATED CODE */        super.innerAccessor = new STRING(val);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public ConstantAccessor(boolean val) {
/* GENERATED CODE */        super.type = ColumnType.BOOLEAN;
/* GENERATED CODE */        super.innerAccessor = new BOOLEAN(val);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    private class INT extends TypedRowAccessor.INT {
/* GENERATED CODE */        private int val;
/* GENERATED CODE */
/* GENERATED CODE */        public INT(int val) {
/* GENERATED CODE */            this.val = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public int getIntFromRow(Row row) { return val; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    private class LONG extends TypedRowAccessor.LONG {
/* GENERATED CODE */        private long val;
/* GENERATED CODE */
/* GENERATED CODE */        public LONG(long val) {
/* GENERATED CODE */            this.val = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public long getLongFromRow(Row row) { return val; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    private class FLOAT extends TypedRowAccessor.FLOAT {
/* GENERATED CODE */        private float val;
/* GENERATED CODE */
/* GENERATED CODE */        public FLOAT(float val) {
/* GENERATED CODE */            this.val = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public float getFloatFromRow(Row row) { return val; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    private class DOUBLE extends TypedRowAccessor.DOUBLE {
/* GENERATED CODE */        private double val;
/* GENERATED CODE */
/* GENERATED CODE */        public DOUBLE(double val) {
/* GENERATED CODE */            this.val = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public double getDoubleFromRow(Row row) { return val; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    private class STRING extends TypedRowAccessor.STRING {
/* GENERATED CODE */        private String val;
/* GENERATED CODE */
/* GENERATED CODE */        public STRING(String val) {
/* GENERATED CODE */            this.val = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public String getStringFromRow(Row row) { return val; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    private class BOOLEAN extends TypedRowAccessor.BOOLEAN {
/* GENERATED CODE */        private boolean val;
/* GENERATED CODE */
/* GENERATED CODE */        public BOOLEAN(boolean val) {
/* GENERATED CODE */            this.val = val;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        @Override
/* GENERATED CODE */        public boolean getBoolFromRow(Row row) { return val; }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */}
