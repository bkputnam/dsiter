/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
                    /** IRowAccessor that computes the difference between two other IRowAccessors. */
/* GENERATED CODE */public interface SubtractAccessor extends IRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/** SubtractAccessor that returns a int */
/* GENERATED CODE */	public interface INT extends SubtractAccessor, IRowAccessor.INT { }
                    	/** SubtractAccessor that returns a long */
/* GENERATED CODE */	public interface LONG extends SubtractAccessor, IRowAccessor.LONG { }
                    	/** SubtractAccessor that returns a float */
/* GENERATED CODE */	public interface FLOAT extends SubtractAccessor, IRowAccessor.FLOAT { }
                    	/** SubtractAccessor that returns a double */
/* GENERATED CODE */	public interface DOUBLE extends SubtractAccessor, IRowAccessor.DOUBLE { }
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a int and a int. */
/* GENERATED CODE */	public class INT_INT implements INT {
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
/* GENERATED CODE */		public int getIntFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) - rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a int and a long. */
/* GENERATED CODE */	public class INT_LONG implements LONG {
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
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) - rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a int and a float. */
/* GENERATED CODE */	public class INT_FLOAT implements FLOAT {
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
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) - rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a int and a double. */
/* GENERATED CODE */	public class INT_DOUBLE implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getIntFromRow(row) - rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a long and a int. */
/* GENERATED CODE */	public class LONG_INT implements LONG {
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
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) - rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a long and a long. */
/* GENERATED CODE */	public class LONG_LONG implements LONG {
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
/* GENERATED CODE */		public long getLongFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) - rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a long and a float. */
/* GENERATED CODE */	public class LONG_FLOAT implements FLOAT {
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
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) - rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a long and a double. */
/* GENERATED CODE */	public class LONG_DOUBLE implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getLongFromRow(row) - rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a float and a int. */
/* GENERATED CODE */	public class FLOAT_INT implements FLOAT {
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
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) - rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a float and a long. */
/* GENERATED CODE */	public class FLOAT_LONG implements FLOAT {
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
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) - rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a float and a float. */
/* GENERATED CODE */	public class FLOAT_FLOAT implements FLOAT {
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
/* GENERATED CODE */		public float getFloatFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) - rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a float and a double. */
/* GENERATED CODE */	public class FLOAT_DOUBLE implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getFloatFromRow(row) - rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a double and a int. */
/* GENERATED CODE */	public class DOUBLE_INT implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) - rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a double and a long. */
/* GENERATED CODE */	public class DOUBLE_LONG implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) - rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a double and a float. */
/* GENERATED CODE */	public class DOUBLE_FLOAT implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) - rhs.getFloatFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/** IRowAccessor that computes the difference between a double and a double. */
/* GENERATED CODE */	public class DOUBLE_DOUBLE implements DOUBLE {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return lhs.getDoubleFromRow(row) - rhs.getDoubleFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
