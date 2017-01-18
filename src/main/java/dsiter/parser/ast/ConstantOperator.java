/* GENERATED CODE */package dsiter.parser.ast;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.accessor.ConstantAccessor;
/* GENERATED CODE */import dsiter.row.ColumnDescriptor;
/* GENERATED CODE */import dsiter.row.IRowAccessor;
/* GENERATED CODE */
/* GENERATED CODE */import java.util.Map;
/* GENERATED CODE */
/* GENERATED CODE */public interface ConstantOperator extends AstNode {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	public static class INT implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private int value;
/* GENERATED CODE */
/* GENERATED CODE */		public INT(int value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.INT(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class LONG implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private long value;
/* GENERATED CODE */
/* GENERATED CODE */		public LONG(long value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.LONG(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class FLOAT implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private float value;
/* GENERATED CODE */
/* GENERATED CODE */		public FLOAT(float value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.FLOAT(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class DOUBLE implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private double value;
/* GENERATED CODE */
/* GENERATED CODE */		public DOUBLE(double value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.DOUBLE(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class STRING implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private String value;
/* GENERATED CODE */
/* GENERATED CODE */		public STRING(String value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.STRING(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class BOOLEAN implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private boolean value;
/* GENERATED CODE */
/* GENERATED CODE */		public BOOLEAN(boolean value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.BOOLEAN(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	public static class JSDATE implements ConstantOperator {
/* GENERATED CODE */
/* GENERATED CODE */		private long value;
/* GENERATED CODE */
/* GENERATED CODE */		public JSDATE(long value) {
/* GENERATED CODE */			this.value = value;
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
/* GENERATED CODE */			return new ConstantAccessor.JSDATE(value);
/* GENERATED CODE */		}
/* GENERATED CODE */
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
/* GENERATED CODE */			throw new Error("Use NamedConstantAccessor instead.");
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */
/* GENERATED CODE */}
