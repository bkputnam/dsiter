package blatis.operator;

///////////////////////////////////////////
//	DO NOT EDIT!!!
//
//	This is generated code. Edit the template instead.
///////////////////////////////////////////

import blatis.row.ColumnType;
import blatis.row.IRowAccessor;
import blatis.row.Row;
import blatis.row.TypedRowAccessor;

public abstract class TypedUnaryOperator extends TypedRowAccessor {

	TypedRowAccessor src;

	public TypedUnaryOperator(TypedRowAccessor src) {
		this.src = src;

		if(src == null) { throw new IllegalArgumentException("src cannot be null"); }

		ColumnType srcType = src.getType();

        if(!testTypeCompatibility(srcType)) {
            throw new IllegalArgumentException("Incompatible type: " + srcType);
        }

		ColumnType returnType = super.type = this.getReturnType(srcType);
		super.innerAccessor = getInnerAccessor(src, srcType);
	}

	protected abstract ColumnType getReturnType(ColumnType srcType);
	protected abstract boolean testTypeCompatibility(ColumnType srcType);



	private IRowAccessor getInnerAccessor(TypedRowAccessor src, ColumnType returnType) {
		ColumnType srcType = src.getType();

		if(srcType == ColumnType.INT) {
			if(returnType == ColumnType.INT) {
				return new INT_INT(src);
			}
			else if(returnType == ColumnType.LONG) {
				return new INT_LONG(src);
			}
			else if(returnType == ColumnType.FLOAT) {
				return new INT_FLOAT(src);
			}
			else if(returnType == ColumnType.DOUBLE) {
				return new INT_DOUBLE(src);
			}
			else if(returnType == ColumnType.STRING) {
				return new INT_STRING(src);
			}
			else if(returnType == ColumnType.BOOLEAN) {
				return new INT_BOOLEAN(src);
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(srcType == ColumnType.LONG) {
			if(returnType == ColumnType.INT) {
				return new LONG_INT(src);
			}
			else if(returnType == ColumnType.LONG) {
				return new LONG_LONG(src);
			}
			else if(returnType == ColumnType.FLOAT) {
				return new LONG_FLOAT(src);
			}
			else if(returnType == ColumnType.DOUBLE) {
				return new LONG_DOUBLE(src);
			}
			else if(returnType == ColumnType.STRING) {
				return new LONG_STRING(src);
			}
			else if(returnType == ColumnType.BOOLEAN) {
				return new LONG_BOOLEAN(src);
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(srcType == ColumnType.FLOAT) {
			if(returnType == ColumnType.INT) {
				return new FLOAT_INT(src);
			}
			else if(returnType == ColumnType.LONG) {
				return new FLOAT_LONG(src);
			}
			else if(returnType == ColumnType.FLOAT) {
				return new FLOAT_FLOAT(src);
			}
			else if(returnType == ColumnType.DOUBLE) {
				return new FLOAT_DOUBLE(src);
			}
			else if(returnType == ColumnType.STRING) {
				return new FLOAT_STRING(src);
			}
			else if(returnType == ColumnType.BOOLEAN) {
				return new FLOAT_BOOLEAN(src);
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(srcType == ColumnType.DOUBLE) {
			if(returnType == ColumnType.INT) {
				return new DOUBLE_INT(src);
			}
			else if(returnType == ColumnType.LONG) {
				return new DOUBLE_LONG(src);
			}
			else if(returnType == ColumnType.FLOAT) {
				return new DOUBLE_FLOAT(src);
			}
			else if(returnType == ColumnType.DOUBLE) {
				return new DOUBLE_DOUBLE(src);
			}
			else if(returnType == ColumnType.STRING) {
				return new DOUBLE_STRING(src);
			}
			else if(returnType == ColumnType.BOOLEAN) {
				return new DOUBLE_BOOLEAN(src);
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(srcType == ColumnType.STRING) {
			if(returnType == ColumnType.INT) {
				return new STRING_INT(src);
			}
			else if(returnType == ColumnType.LONG) {
				return new STRING_LONG(src);
			}
			else if(returnType == ColumnType.FLOAT) {
				return new STRING_FLOAT(src);
			}
			else if(returnType == ColumnType.DOUBLE) {
				return new STRING_DOUBLE(src);
			}
			else if(returnType == ColumnType.STRING) {
				return new STRING_STRING(src);
			}
			else if(returnType == ColumnType.BOOLEAN) {
				return new STRING_BOOLEAN(src);
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(srcType == ColumnType.BOOLEAN) {
			if(returnType == ColumnType.INT) {
				return new BOOLEAN_INT(src);
			}
			else if(returnType == ColumnType.LONG) {
				return new BOOLEAN_LONG(src);
			}
			else if(returnType == ColumnType.FLOAT) {
				return new BOOLEAN_FLOAT(src);
			}
			else if(returnType == ColumnType.DOUBLE) {
				return new BOOLEAN_DOUBLE(src);
			}
			else if(returnType == ColumnType.STRING) {
				return new BOOLEAN_STRING(src);
			}
			else if(returnType == ColumnType.BOOLEAN) {
				return new BOOLEAN_BOOLEAN(src);
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else {
			throw new Error("This should be impossible");
		}
	}

	
	protected int handle_int_int( int src )  { throw new Error("Programmer error: handle_int_int must be overridden by subclass"); }
	protected long handle_int_long( int src )  { throw new Error("Programmer error: handle_int_long must be overridden by subclass"); }
	protected float handle_int_float( int src )  { throw new Error("Programmer error: handle_int_float must be overridden by subclass"); }
	protected double handle_int_double( int src )  { throw new Error("Programmer error: handle_int_double must be overridden by subclass"); }
	protected String handle_int_String( int src )  { throw new Error("Programmer error: handle_int_String must be overridden by subclass"); }
	protected boolean handle_int_boolean( int src )  { throw new Error("Programmer error: handle_int_boolean must be overridden by subclass"); }
	protected int handle_long_int( long src )  { throw new Error("Programmer error: handle_long_int must be overridden by subclass"); }
	protected long handle_long_long( long src )  { throw new Error("Programmer error: handle_long_long must be overridden by subclass"); }
	protected float handle_long_float( long src )  { throw new Error("Programmer error: handle_long_float must be overridden by subclass"); }
	protected double handle_long_double( long src )  { throw new Error("Programmer error: handle_long_double must be overridden by subclass"); }
	protected String handle_long_String( long src )  { throw new Error("Programmer error: handle_long_String must be overridden by subclass"); }
	protected boolean handle_long_boolean( long src )  { throw new Error("Programmer error: handle_long_boolean must be overridden by subclass"); }
	protected int handle_float_int( float src )  { throw new Error("Programmer error: handle_float_int must be overridden by subclass"); }
	protected long handle_float_long( float src )  { throw new Error("Programmer error: handle_float_long must be overridden by subclass"); }
	protected float handle_float_float( float src )  { throw new Error("Programmer error: handle_float_float must be overridden by subclass"); }
	protected double handle_float_double( float src )  { throw new Error("Programmer error: handle_float_double must be overridden by subclass"); }
	protected String handle_float_String( float src )  { throw new Error("Programmer error: handle_float_String must be overridden by subclass"); }
	protected boolean handle_float_boolean( float src )  { throw new Error("Programmer error: handle_float_boolean must be overridden by subclass"); }
	protected int handle_double_int( double src )  { throw new Error("Programmer error: handle_double_int must be overridden by subclass"); }
	protected long handle_double_long( double src )  { throw new Error("Programmer error: handle_double_long must be overridden by subclass"); }
	protected float handle_double_float( double src )  { throw new Error("Programmer error: handle_double_float must be overridden by subclass"); }
	protected double handle_double_double( double src )  { throw new Error("Programmer error: handle_double_double must be overridden by subclass"); }
	protected String handle_double_String( double src )  { throw new Error("Programmer error: handle_double_String must be overridden by subclass"); }
	protected boolean handle_double_boolean( double src )  { throw new Error("Programmer error: handle_double_boolean must be overridden by subclass"); }
	protected int handle_String_int( String src )  { throw new Error("Programmer error: handle_String_int must be overridden by subclass"); }
	protected long handle_String_long( String src )  { throw new Error("Programmer error: handle_String_long must be overridden by subclass"); }
	protected float handle_String_float( String src )  { throw new Error("Programmer error: handle_String_float must be overridden by subclass"); }
	protected double handle_String_double( String src )  { throw new Error("Programmer error: handle_String_double must be overridden by subclass"); }
	protected String handle_String_String( String src )  { throw new Error("Programmer error: handle_String_String must be overridden by subclass"); }
	protected boolean handle_String_boolean( String src )  { throw new Error("Programmer error: handle_String_boolean must be overridden by subclass"); }
	protected int handle_boolean_int( boolean src )  { throw new Error("Programmer error: handle_boolean_int must be overridden by subclass"); }
	protected long handle_boolean_long( boolean src )  { throw new Error("Programmer error: handle_boolean_long must be overridden by subclass"); }
	protected float handle_boolean_float( boolean src )  { throw new Error("Programmer error: handle_boolean_float must be overridden by subclass"); }
	protected double handle_boolean_double( boolean src )  { throw new Error("Programmer error: handle_boolean_double must be overridden by subclass"); }
	protected String handle_boolean_String( boolean src )  { throw new Error("Programmer error: handle_boolean_String must be overridden by subclass"); }
	protected boolean handle_boolean_boolean( boolean src )  { throw new Error("Programmer error: handle_boolean_boolean must be overridden by subclass"); }


	private class INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT src;

		private INT_INT(TypedRowAccessor src) {
			this.src = src.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_int(src.getIntFromRow(row));
		}
	}

	private class INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT src;

		private INT_LONG(TypedRowAccessor src) {
			this.src = src.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_long(src.getIntFromRow(row));
		}
	}

	private class INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT src;

		private INT_FLOAT(TypedRowAccessor src) {
			this.src = src.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_float(src.getIntFromRow(row));
		}
	}

	private class INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT src;

		private INT_DOUBLE(TypedRowAccessor src) {
			this.src = src.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_double(src.getIntFromRow(row));
		}
	}

	private class INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT src;

		private INT_STRING(TypedRowAccessor src) {
			this.src = src.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_String(src.getIntFromRow(row));
		}
	}

	private class INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT src;

		private INT_BOOLEAN(TypedRowAccessor src) {
			this.src = src.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_boolean(src.getIntFromRow(row));
		}
	}

	private class LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG src;

		private LONG_INT(TypedRowAccessor src) {
			this.src = src.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_int(src.getLongFromRow(row));
		}
	}

	private class LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG src;

		private LONG_LONG(TypedRowAccessor src) {
			this.src = src.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_long(src.getLongFromRow(row));
		}
	}

	private class LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG src;

		private LONG_FLOAT(TypedRowAccessor src) {
			this.src = src.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_float(src.getLongFromRow(row));
		}
	}

	private class LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG src;

		private LONG_DOUBLE(TypedRowAccessor src) {
			this.src = src.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_double(src.getLongFromRow(row));
		}
	}

	private class LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG src;

		private LONG_STRING(TypedRowAccessor src) {
			this.src = src.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_String(src.getLongFromRow(row));
		}
	}

	private class LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG src;

		private LONG_BOOLEAN(TypedRowAccessor src) {
			this.src = src.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_boolean(src.getLongFromRow(row));
		}
	}

	private class FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT src;

		private FLOAT_INT(TypedRowAccessor src) {
			this.src = src.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_int(src.getFloatFromRow(row));
		}
	}

	private class FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT src;

		private FLOAT_LONG(TypedRowAccessor src) {
			this.src = src.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_long(src.getFloatFromRow(row));
		}
	}

	private class FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT src;

		private FLOAT_FLOAT(TypedRowAccessor src) {
			this.src = src.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_float(src.getFloatFromRow(row));
		}
	}

	private class FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT src;

		private FLOAT_DOUBLE(TypedRowAccessor src) {
			this.src = src.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_double(src.getFloatFromRow(row));
		}
	}

	private class FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT src;

		private FLOAT_STRING(TypedRowAccessor src) {
			this.src = src.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_String(src.getFloatFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT src;

		private FLOAT_BOOLEAN(TypedRowAccessor src) {
			this.src = src.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_boolean(src.getFloatFromRow(row));
		}
	}

	private class DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE src;

		private DOUBLE_INT(TypedRowAccessor src) {
			this.src = src.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_int(src.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE src;

		private DOUBLE_LONG(TypedRowAccessor src) {
			this.src = src.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_long(src.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE src;

		private DOUBLE_FLOAT(TypedRowAccessor src) {
			this.src = src.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_float(src.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE src;

		private DOUBLE_DOUBLE(TypedRowAccessor src) {
			this.src = src.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_double(src.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE src;

		private DOUBLE_STRING(TypedRowAccessor src) {
			this.src = src.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_String(src.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE src;

		private DOUBLE_BOOLEAN(TypedRowAccessor src) {
			this.src = src.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_boolean(src.getDoubleFromRow(row));
		}
	}

	private class STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING src;

		private STRING_INT(TypedRowAccessor src) {
			this.src = src.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_int(src.getStringFromRow(row));
		}
	}

	private class STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING src;

		private STRING_LONG(TypedRowAccessor src) {
			this.src = src.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_long(src.getStringFromRow(row));
		}
	}

	private class STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING src;

		private STRING_FLOAT(TypedRowAccessor src) {
			this.src = src.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_float(src.getStringFromRow(row));
		}
	}

	private class STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING src;

		private STRING_DOUBLE(TypedRowAccessor src) {
			this.src = src.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_double(src.getStringFromRow(row));
		}
	}

	private class STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING src;

		private STRING_STRING(TypedRowAccessor src) {
			this.src = src.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_String(src.getStringFromRow(row));
		}
	}

	private class STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING src;

		private STRING_BOOLEAN(TypedRowAccessor src) {
			this.src = src.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_boolean(src.getStringFromRow(row));
		}
	}

	private class BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN src;

		private BOOLEAN_INT(TypedRowAccessor src) {
			this.src = src.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_int(src.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN src;

		private BOOLEAN_LONG(TypedRowAccessor src) {
			this.src = src.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_long(src.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN src;

		private BOOLEAN_FLOAT(TypedRowAccessor src) {
			this.src = src.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_float(src.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN src;

		private BOOLEAN_DOUBLE(TypedRowAccessor src) {
			this.src = src.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_double(src.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN src;

		private BOOLEAN_STRING(TypedRowAccessor src) {
			this.src = src.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_String(src.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN src;

		private BOOLEAN_BOOLEAN(TypedRowAccessor src) {
			this.src = src.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_boolean(src.getBoolFromRow(row));
		}
	}

}