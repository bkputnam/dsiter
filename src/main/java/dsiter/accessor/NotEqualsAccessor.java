/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
                    /** IRowAccessor that tests the non-equality of two other IRowAccessors */
/* GENERATED CODE */public interface NotEqualsAccessor extends IRowAccessor.BOOLEAN {
/* GENERATED CODE */
                    	/** IRowAccessor that tests the non-equality of two Strings. */
/* GENERATED CODE */	public static class STRING_STRING implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.STRING lhs;
/* GENERATED CODE */		private IRowAccessor.STRING rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public STRING_STRING(IRowAccessor.STRING lhs, IRowAccessor.STRING rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return !lhs.getStringFromRow(row).equals(rhs.getStringFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) int and a(n) int. */
/* GENERATED CODE */	public static class INT_INT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public INT_INT(IRowAccessor.INT lhs, IRowAccessor.INT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) != rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) long. */
/* GENERATED CODE */	public static class LONG_LONG implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG_LONG(IRowAccessor.LONG lhs, IRowAccessor.LONG rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) != rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) float and a(n) float. */
/* GENERATED CODE */	public static class FLOAT_FLOAT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT_FLOAT(IRowAccessor.FLOAT lhs, IRowAccessor.FLOAT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) != rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) double and a(n) double. */
/* GENERATED CODE */	public static class DOUBLE_DOUBLE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE_DOUBLE(IRowAccessor.DOUBLE lhs, IRowAccessor.DOUBLE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) != rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) boolean and a(n) boolean. */
/* GENERATED CODE */	public static class BOOLEAN_BOOLEAN implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.BOOLEAN lhs;
/* GENERATED CODE */		private IRowAccessor.BOOLEAN rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public BOOLEAN_BOOLEAN(IRowAccessor.BOOLEAN lhs, IRowAccessor.BOOLEAN rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getBoolFromRow(row) != rhs.getBoolFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) long. */
/* GENERATED CODE */	public static class JSDATE_JSDATE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public JSDATE_JSDATE(IRowAccessor.JSDATE lhs, IRowAccessor.JSDATE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getJsDateFromRow(row) != rhs.getJsDateFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) int and a(n) long. */
/* GENERATED CODE */	public static class INT_LONG implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public INT_LONG(IRowAccessor.INT lhs, IRowAccessor.LONG rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) != rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) int and a(n) float. */
/* GENERATED CODE */	public static class INT_FLOAT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public INT_FLOAT(IRowAccessor.INT lhs, IRowAccessor.FLOAT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) != rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) int and a(n) double. */
/* GENERATED CODE */	public static class INT_DOUBLE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public INT_DOUBLE(IRowAccessor.INT lhs, IRowAccessor.DOUBLE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) != rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) int. */
/* GENERATED CODE */	public static class LONG_INT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG_INT(IRowAccessor.LONG lhs, IRowAccessor.INT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) != rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) float. */
/* GENERATED CODE */	public static class LONG_FLOAT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG_FLOAT(IRowAccessor.LONG lhs, IRowAccessor.FLOAT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) != rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) double. */
/* GENERATED CODE */	public static class LONG_DOUBLE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG_DOUBLE(IRowAccessor.LONG lhs, IRowAccessor.DOUBLE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) != rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) float and a(n) int. */
/* GENERATED CODE */	public static class FLOAT_INT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT_INT(IRowAccessor.FLOAT lhs, IRowAccessor.INT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) != rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) float and a(n) long. */
/* GENERATED CODE */	public static class FLOAT_LONG implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT_LONG(IRowAccessor.FLOAT lhs, IRowAccessor.LONG rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) != rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) float and a(n) double. */
/* GENERATED CODE */	public static class FLOAT_DOUBLE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT lhs;
/* GENERATED CODE */		private IRowAccessor.DOUBLE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT_DOUBLE(IRowAccessor.FLOAT lhs, IRowAccessor.DOUBLE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) != rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) double and a(n) int. */
/* GENERATED CODE */	public static class DOUBLE_INT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE_INT(IRowAccessor.DOUBLE lhs, IRowAccessor.INT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) != rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) double and a(n) long. */
/* GENERATED CODE */	public static class DOUBLE_LONG implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE_LONG(IRowAccessor.DOUBLE lhs, IRowAccessor.LONG rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) != rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) double and a(n) float. */
/* GENERATED CODE */	public static class DOUBLE_FLOAT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE lhs;
/* GENERATED CODE */		private IRowAccessor.FLOAT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE_FLOAT(IRowAccessor.DOUBLE lhs, IRowAccessor.FLOAT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) != rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) int. */
/* GENERATED CODE */	public static class JSDATE_INT implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.INT rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public JSDATE_INT(IRowAccessor.JSDATE lhs, IRowAccessor.INT rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getJsDateFromRow(row) != rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) long. */
/* GENERATED CODE */	public static class JSDATE_LONG implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.JSDATE lhs;
/* GENERATED CODE */		private IRowAccessor.LONG rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public JSDATE_LONG(IRowAccessor.JSDATE lhs, IRowAccessor.LONG rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getJsDateFromRow(row) != rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) int and a(n) long. */
/* GENERATED CODE */	public static class INT_JSDATE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public INT_JSDATE(IRowAccessor.INT lhs, IRowAccessor.JSDATE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) != rhs.getJsDateFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that tests the non-equality of a(n) long and a(n) long. */
/* GENERATED CODE */	public static class LONG_JSDATE implements NotEqualsAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG lhs;
/* GENERATED CODE */		private IRowAccessor.JSDATE rhs;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG_JSDATE(IRowAccessor.LONG lhs, IRowAccessor.JSDATE rhs) {
/* GENERATED CODE */			this.lhs = lhs;
/* GENERATED CODE */			this.rhs = rhs;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) != rhs.getJsDateFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
