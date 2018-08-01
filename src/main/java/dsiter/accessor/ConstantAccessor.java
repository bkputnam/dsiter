/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
                    /**
                     * IRowAccessor that always returns a constant value.
                     */
/* GENERATED CODE */public interface ConstantAccessor extends IRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type int. */
/* GENERATED CODE */	public static class INT implements ConstantAccessor, IRowAccessor.INT {
/* GENERATED CODE */		private int value;
/* GENERATED CODE */
/* GENERATED CODE */		public INT (int value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type long. */
/* GENERATED CODE */	public static class LONG implements ConstantAccessor, IRowAccessor.LONG {
/* GENERATED CODE */		private long value;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG (long value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type float. */
/* GENERATED CODE */	public static class FLOAT implements ConstantAccessor, IRowAccessor.FLOAT {
/* GENERATED CODE */		private float value;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT (float value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type double. */
/* GENERATED CODE */	public static class DOUBLE implements ConstantAccessor, IRowAccessor.DOUBLE {
/* GENERATED CODE */		private double value;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE (double value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type String. */
/* GENERATED CODE */	public static class STRING implements ConstantAccessor, IRowAccessor.STRING {
/* GENERATED CODE */		private String value;
/* GENERATED CODE */
/* GENERATED CODE */		public STRING (String value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public String getStringFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type boolean. */
/* GENERATED CODE */	public static class BOOLEAN implements ConstantAccessor, IRowAccessor.BOOLEAN {
/* GENERATED CODE */		private boolean value;
/* GENERATED CODE */
/* GENERATED CODE */		public BOOLEAN (boolean value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that returns a constant value of type long. */
/* GENERATED CODE */	public static class JSDATE implements ConstantAccessor, IRowAccessor.JSDATE {
/* GENERATED CODE */		private long value;
/* GENERATED CODE */
/* GENERATED CODE */		public JSDATE (long value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public long getJsDateFromRow(Row row) {
/* GENERATED CODE */			return value;
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
