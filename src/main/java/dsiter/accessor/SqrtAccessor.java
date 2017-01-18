/* GENERATED CODE */package dsiter.accessor;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */import dsiter.row.Row;
/* GENERATED CODE */
/* GENERATED CODE */public interface SqrtAccessor extends IRowAccessor.DOUBLE {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	public static class INT implements SqrtAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.INT src;
/* GENERATED CODE */
/* GENERATED CODE */		public INT(IRowAccessor.INT src) {
/* GENERATED CODE */			this.src = src;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.sqrt(src.getIntFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class LONG implements SqrtAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.LONG src;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG(IRowAccessor.LONG src) {
/* GENERATED CODE */			this.src = src;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.sqrt(src.getLongFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class FLOAT implements SqrtAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.FLOAT src;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT(IRowAccessor.FLOAT src) {
/* GENERATED CODE */			this.src = src;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.sqrt(src.getFloatFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class DOUBLE implements SqrtAccessor {
/* GENERATED CODE */
/* GENERATED CODE */		private IRowAccessor.DOUBLE src;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE(IRowAccessor.DOUBLE src) {
/* GENERATED CODE */			this.src = src;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public double getDoubleFromRow(Row row) {
/* GENERATED CODE */			return Math.sqrt(src.getDoubleFromRow(row));
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
