/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
                    /**
                     * IRowAccessor that computes the value of one IRowAccessor raised to the power of another IRowAccessor.
                     */
/* GENERATED CODE */public interface ExponentAccessor extends IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) int raised to the power of a(n) int.
                    	 */
/* GENERATED CODE */	public static class INT_INT implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) int raised to the power of a(n) long.
                    	 */
/* GENERATED CODE */	public static class INT_LONG implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) int raised to the power of a(n) float.
                    	 */
/* GENERATED CODE */	public static class INT_FLOAT implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) int raised to the power of a(n) double.
                    	 */
/* GENERATED CODE */	public static class INT_DOUBLE implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) long raised to the power of a(n) int.
                    	 */
/* GENERATED CODE */	public static class LONG_INT implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) long raised to the power of a(n) long.
                    	 */
/* GENERATED CODE */	public static class LONG_LONG implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) long raised to the power of a(n) float.
                    	 */
/* GENERATED CODE */	public static class LONG_FLOAT implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) long raised to the power of a(n) double.
                    	 */
/* GENERATED CODE */	public static class LONG_DOUBLE implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) float raised to the power of a(n) int.
                    	 */
/* GENERATED CODE */	public static class FLOAT_INT implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) float raised to the power of a(n) long.
                    	 */
/* GENERATED CODE */	public static class FLOAT_LONG implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) float raised to the power of a(n) float.
                    	 */
/* GENERATED CODE */	public static class FLOAT_FLOAT implements ExponentAccessor {
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
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.pow(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) float raised to the power of a(n) double.
                    	 */
/* GENERATED CODE */	public static class FLOAT_DOUBLE implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) double raised to the power of a(n) int.
                    	 */
/* GENERATED CODE */	public static class DOUBLE_INT implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) double raised to the power of a(n) long.
                    	 */
/* GENERATED CODE */	public static class DOUBLE_LONG implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) double raised to the power of a(n) float.
                    	 */
/* GENERATED CODE */	public static class DOUBLE_FLOAT implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the value of a(n) double raised to the power of a(n) double.
                    	 */
/* GENERATED CODE */	public static class DOUBLE_DOUBLE implements ExponentAccessor {
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
/* GENERATED CODE */			return Math.pow(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
