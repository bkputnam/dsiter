/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
                    /**
                     * IRowAccessor that computes the modulus of two IRowAccessors.
                     */
/* GENERATED CODE */public interface ModuloAccessor extends IRowAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/** ModuloAccessor that returns a int. */
/* GENERATED CODE */	public interface INT extends ModuloAccessor, IRowAccessor.INT { }
                    	/** ModuloAccessor that returns a long. */
/* GENERATED CODE */	public interface LONG extends ModuloAccessor, IRowAccessor.LONG { }
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the modulus of a(n) int and a(n) int.
                    	 */
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
/* GENERATED CODE */			return lhs.getIntFromRow(row) % rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the modulus of a(n) int and a(n) long.
                    	 */
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
/* GENERATED CODE */			return lhs.getIntFromRow(row) % rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the modulus of a(n) long and a(n) int.
                    	 */
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
/* GENERATED CODE */			return lhs.getLongFromRow(row) % rhs.getIntFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * IRowAccessor that computes the modulus of a(n) long and a(n) long.
                    	 */
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
/* GENERATED CODE */			return lhs.getLongFromRow(row) % rhs.getLongFromRow(row);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
