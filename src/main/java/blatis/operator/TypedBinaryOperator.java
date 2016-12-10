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

public abstract class TypedBinaryOperator extends TypedRowAccessor {

	TypedRowAccessor lhs;
	TypedRowAccessor rhs;

	public TypedBinaryOperator(TypedRowAccessor lhs, TypedRowAccessor rhs) {
		this.lhs = lhs;
		this.rhs = rhs;

		if(lhs == null) { throw new IllegalArgumentException("lhs cannot be null"); }
		if(rhs == null) { throw new IllegalArgumentException("rhs cannot be null"); }

		ColumnType lhsType = lhs.getType();
		ColumnType rhsType = rhs.getType();

        if(!testTypeCompatibility(lhsType, rhsType)) {
            throw new IllegalArgumentException("Incompatible types: " + lhsType + ", " + rhsType);
        }

		ColumnType returnType = super.type = this.getReturnType(lhsType, rhsType);
		super.innerAccessor = getInnerAccessor(lhs, rhs, returnType);
	}

	protected abstract ColumnType getReturnType(ColumnType lhsType, ColumnType rhsType);
	protected abstract boolean testTypeCompatibility(ColumnType lhsType, ColumnType rhsType);

    protected boolean eitherTypeIs(ColumnType type) { return lhs.getType() == type || rhs.getType() == type; }
    protected boolean bothTypesAre(ColumnType type) { return lhs.getType() == type && rhs.getType() == type; }



	private IRowAccessor getInnerAccessor(TypedRowAccessor lhs, TypedRowAccessor rhs, ColumnType returnType) {
		ColumnType lhsType = lhs.getType();
		ColumnType rhsType = rhs.getType();

		if(lhsType == ColumnType.INT) {
			if(rhsType == ColumnType.INT) {
				if(returnType == ColumnType.INT) {
					return new INT_INT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new INT_INT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new INT_INT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new INT_INT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new INT_INT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new INT_INT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.LONG) {
				if(returnType == ColumnType.INT) {
					return new INT_LONG_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new INT_LONG_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new INT_LONG_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new INT_LONG_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new INT_LONG_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new INT_LONG_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.FLOAT) {
				if(returnType == ColumnType.INT) {
					return new INT_FLOAT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new INT_FLOAT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new INT_FLOAT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new INT_FLOAT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new INT_FLOAT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new INT_FLOAT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.DOUBLE) {
				if(returnType == ColumnType.INT) {
					return new INT_DOUBLE_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new INT_DOUBLE_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new INT_DOUBLE_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new INT_DOUBLE_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new INT_DOUBLE_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new INT_DOUBLE_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.STRING) {
				if(returnType == ColumnType.INT) {
					return new INT_STRING_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new INT_STRING_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new INT_STRING_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new INT_STRING_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new INT_STRING_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new INT_STRING_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.BOOLEAN) {
				if(returnType == ColumnType.INT) {
					return new INT_BOOLEAN_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new INT_BOOLEAN_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new INT_BOOLEAN_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new INT_BOOLEAN_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new INT_BOOLEAN_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new INT_BOOLEAN_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(lhsType == ColumnType.LONG) {
			if(rhsType == ColumnType.INT) {
				if(returnType == ColumnType.INT) {
					return new LONG_INT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new LONG_INT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new LONG_INT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new LONG_INT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new LONG_INT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new LONG_INT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.LONG) {
				if(returnType == ColumnType.INT) {
					return new LONG_LONG_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new LONG_LONG_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new LONG_LONG_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new LONG_LONG_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new LONG_LONG_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new LONG_LONG_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.FLOAT) {
				if(returnType == ColumnType.INT) {
					return new LONG_FLOAT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new LONG_FLOAT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new LONG_FLOAT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new LONG_FLOAT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new LONG_FLOAT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new LONG_FLOAT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.DOUBLE) {
				if(returnType == ColumnType.INT) {
					return new LONG_DOUBLE_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new LONG_DOUBLE_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new LONG_DOUBLE_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new LONG_DOUBLE_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new LONG_DOUBLE_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new LONG_DOUBLE_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.STRING) {
				if(returnType == ColumnType.INT) {
					return new LONG_STRING_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new LONG_STRING_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new LONG_STRING_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new LONG_STRING_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new LONG_STRING_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new LONG_STRING_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.BOOLEAN) {
				if(returnType == ColumnType.INT) {
					return new LONG_BOOLEAN_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new LONG_BOOLEAN_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new LONG_BOOLEAN_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new LONG_BOOLEAN_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new LONG_BOOLEAN_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new LONG_BOOLEAN_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(lhsType == ColumnType.FLOAT) {
			if(rhsType == ColumnType.INT) {
				if(returnType == ColumnType.INT) {
					return new FLOAT_INT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new FLOAT_INT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new FLOAT_INT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new FLOAT_INT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new FLOAT_INT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new FLOAT_INT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.LONG) {
				if(returnType == ColumnType.INT) {
					return new FLOAT_LONG_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new FLOAT_LONG_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new FLOAT_LONG_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new FLOAT_LONG_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new FLOAT_LONG_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new FLOAT_LONG_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.FLOAT) {
				if(returnType == ColumnType.INT) {
					return new FLOAT_FLOAT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new FLOAT_FLOAT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new FLOAT_FLOAT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new FLOAT_FLOAT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new FLOAT_FLOAT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new FLOAT_FLOAT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.DOUBLE) {
				if(returnType == ColumnType.INT) {
					return new FLOAT_DOUBLE_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new FLOAT_DOUBLE_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new FLOAT_DOUBLE_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new FLOAT_DOUBLE_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new FLOAT_DOUBLE_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new FLOAT_DOUBLE_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.STRING) {
				if(returnType == ColumnType.INT) {
					return new FLOAT_STRING_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new FLOAT_STRING_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new FLOAT_STRING_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new FLOAT_STRING_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new FLOAT_STRING_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new FLOAT_STRING_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.BOOLEAN) {
				if(returnType == ColumnType.INT) {
					return new FLOAT_BOOLEAN_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new FLOAT_BOOLEAN_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new FLOAT_BOOLEAN_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new FLOAT_BOOLEAN_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new FLOAT_BOOLEAN_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new FLOAT_BOOLEAN_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(lhsType == ColumnType.DOUBLE) {
			if(rhsType == ColumnType.INT) {
				if(returnType == ColumnType.INT) {
					return new DOUBLE_INT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new DOUBLE_INT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new DOUBLE_INT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new DOUBLE_INT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new DOUBLE_INT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new DOUBLE_INT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.LONG) {
				if(returnType == ColumnType.INT) {
					return new DOUBLE_LONG_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new DOUBLE_LONG_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new DOUBLE_LONG_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new DOUBLE_LONG_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new DOUBLE_LONG_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new DOUBLE_LONG_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.FLOAT) {
				if(returnType == ColumnType.INT) {
					return new DOUBLE_FLOAT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new DOUBLE_FLOAT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new DOUBLE_FLOAT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new DOUBLE_FLOAT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new DOUBLE_FLOAT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new DOUBLE_FLOAT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.DOUBLE) {
				if(returnType == ColumnType.INT) {
					return new DOUBLE_DOUBLE_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new DOUBLE_DOUBLE_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new DOUBLE_DOUBLE_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new DOUBLE_DOUBLE_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new DOUBLE_DOUBLE_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new DOUBLE_DOUBLE_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.STRING) {
				if(returnType == ColumnType.INT) {
					return new DOUBLE_STRING_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new DOUBLE_STRING_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new DOUBLE_STRING_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new DOUBLE_STRING_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new DOUBLE_STRING_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new DOUBLE_STRING_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.BOOLEAN) {
				if(returnType == ColumnType.INT) {
					return new DOUBLE_BOOLEAN_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new DOUBLE_BOOLEAN_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new DOUBLE_BOOLEAN_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new DOUBLE_BOOLEAN_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new DOUBLE_BOOLEAN_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new DOUBLE_BOOLEAN_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(lhsType == ColumnType.STRING) {
			if(rhsType == ColumnType.INT) {
				if(returnType == ColumnType.INT) {
					return new STRING_INT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new STRING_INT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new STRING_INT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new STRING_INT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new STRING_INT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new STRING_INT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.LONG) {
				if(returnType == ColumnType.INT) {
					return new STRING_LONG_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new STRING_LONG_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new STRING_LONG_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new STRING_LONG_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new STRING_LONG_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new STRING_LONG_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.FLOAT) {
				if(returnType == ColumnType.INT) {
					return new STRING_FLOAT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new STRING_FLOAT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new STRING_FLOAT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new STRING_FLOAT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new STRING_FLOAT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new STRING_FLOAT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.DOUBLE) {
				if(returnType == ColumnType.INT) {
					return new STRING_DOUBLE_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new STRING_DOUBLE_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new STRING_DOUBLE_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new STRING_DOUBLE_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new STRING_DOUBLE_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new STRING_DOUBLE_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.STRING) {
				if(returnType == ColumnType.INT) {
					return new STRING_STRING_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new STRING_STRING_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new STRING_STRING_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new STRING_STRING_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new STRING_STRING_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new STRING_STRING_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.BOOLEAN) {
				if(returnType == ColumnType.INT) {
					return new STRING_BOOLEAN_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new STRING_BOOLEAN_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new STRING_BOOLEAN_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new STRING_BOOLEAN_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new STRING_BOOLEAN_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new STRING_BOOLEAN_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else if(lhsType == ColumnType.BOOLEAN) {
			if(rhsType == ColumnType.INT) {
				if(returnType == ColumnType.INT) {
					return new BOOLEAN_INT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new BOOLEAN_INT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new BOOLEAN_INT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new BOOLEAN_INT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new BOOLEAN_INT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new BOOLEAN_INT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.LONG) {
				if(returnType == ColumnType.INT) {
					return new BOOLEAN_LONG_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new BOOLEAN_LONG_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new BOOLEAN_LONG_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new BOOLEAN_LONG_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new BOOLEAN_LONG_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new BOOLEAN_LONG_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.FLOAT) {
				if(returnType == ColumnType.INT) {
					return new BOOLEAN_FLOAT_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new BOOLEAN_FLOAT_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new BOOLEAN_FLOAT_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new BOOLEAN_FLOAT_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new BOOLEAN_FLOAT_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new BOOLEAN_FLOAT_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.DOUBLE) {
				if(returnType == ColumnType.INT) {
					return new BOOLEAN_DOUBLE_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new BOOLEAN_DOUBLE_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new BOOLEAN_DOUBLE_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new BOOLEAN_DOUBLE_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new BOOLEAN_DOUBLE_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new BOOLEAN_DOUBLE_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.STRING) {
				if(returnType == ColumnType.INT) {
					return new BOOLEAN_STRING_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new BOOLEAN_STRING_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new BOOLEAN_STRING_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new BOOLEAN_STRING_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new BOOLEAN_STRING_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new BOOLEAN_STRING_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else if(rhsType == ColumnType.BOOLEAN) {
				if(returnType == ColumnType.INT) {
					return new BOOLEAN_BOOLEAN_INT(lhs, rhs);
				}
				else if(returnType == ColumnType.LONG) {
					return new BOOLEAN_BOOLEAN_LONG(lhs, rhs);
				}
				else if(returnType == ColumnType.FLOAT) {
					return new BOOLEAN_BOOLEAN_FLOAT(lhs, rhs);
				}
				else if(returnType == ColumnType.DOUBLE) {
					return new BOOLEAN_BOOLEAN_DOUBLE(lhs, rhs);
				}
				else if(returnType == ColumnType.STRING) {
					return new BOOLEAN_BOOLEAN_STRING(lhs, rhs);
				}
				else if(returnType == ColumnType.BOOLEAN) {
					return new BOOLEAN_BOOLEAN_BOOLEAN(lhs, rhs);
				}
				else {
					throw new Error("This should be impossible");
				}
			}
			else {
				throw new Error("This should be impossible");
			}
		}
		else {
			throw new Error("This should be impossible");
		}
	}

	
	protected int handle_int_int_int( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_int must be overridden by subclass"); }
	protected long handle_int_int_long( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_long must be overridden by subclass"); }
	protected float handle_int_int_float( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_float must be overridden by subclass"); }
	protected double handle_int_int_double( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_double must be overridden by subclass"); }
	protected String handle_int_int_String( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_String must be overridden by subclass"); }
	protected boolean handle_int_int_boolean( int lhs, int rhs )  { throw new Error("Programmer error: handle_int_int_boolean must be overridden by subclass"); }
	protected int handle_int_long_int( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_int must be overridden by subclass"); }
	protected long handle_int_long_long( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_long must be overridden by subclass"); }
	protected float handle_int_long_float( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_float must be overridden by subclass"); }
	protected double handle_int_long_double( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_double must be overridden by subclass"); }
	protected String handle_int_long_String( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_String must be overridden by subclass"); }
	protected boolean handle_int_long_boolean( int lhs, long rhs )  { throw new Error("Programmer error: handle_int_long_boolean must be overridden by subclass"); }
	protected int handle_int_float_int( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_int must be overridden by subclass"); }
	protected long handle_int_float_long( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_long must be overridden by subclass"); }
	protected float handle_int_float_float( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_float must be overridden by subclass"); }
	protected double handle_int_float_double( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_double must be overridden by subclass"); }
	protected String handle_int_float_String( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_String must be overridden by subclass"); }
	protected boolean handle_int_float_boolean( int lhs, float rhs )  { throw new Error("Programmer error: handle_int_float_boolean must be overridden by subclass"); }
	protected int handle_int_double_int( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_int must be overridden by subclass"); }
	protected long handle_int_double_long( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_long must be overridden by subclass"); }
	protected float handle_int_double_float( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_float must be overridden by subclass"); }
	protected double handle_int_double_double( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_double must be overridden by subclass"); }
	protected String handle_int_double_String( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_String must be overridden by subclass"); }
	protected boolean handle_int_double_boolean( int lhs, double rhs )  { throw new Error("Programmer error: handle_int_double_boolean must be overridden by subclass"); }
	protected int handle_int_String_int( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_String_int must be overridden by subclass"); }
	protected long handle_int_String_long( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_String_long must be overridden by subclass"); }
	protected float handle_int_String_float( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_String_float must be overridden by subclass"); }
	protected double handle_int_String_double( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_String_double must be overridden by subclass"); }
	protected String handle_int_String_String( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_String_String must be overridden by subclass"); }
	protected boolean handle_int_String_boolean( int lhs, String rhs )  { throw new Error("Programmer error: handle_int_String_boolean must be overridden by subclass"); }
	protected int handle_int_boolean_int( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_boolean_int must be overridden by subclass"); }
	protected long handle_int_boolean_long( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_boolean_long must be overridden by subclass"); }
	protected float handle_int_boolean_float( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_boolean_float must be overridden by subclass"); }
	protected double handle_int_boolean_double( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_boolean_double must be overridden by subclass"); }
	protected String handle_int_boolean_String( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_boolean_String must be overridden by subclass"); }
	protected boolean handle_int_boolean_boolean( int lhs, boolean rhs )  { throw new Error("Programmer error: handle_int_boolean_boolean must be overridden by subclass"); }
	protected int handle_long_int_int( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_int must be overridden by subclass"); }
	protected long handle_long_int_long( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_long must be overridden by subclass"); }
	protected float handle_long_int_float( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_float must be overridden by subclass"); }
	protected double handle_long_int_double( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_double must be overridden by subclass"); }
	protected String handle_long_int_String( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_String must be overridden by subclass"); }
	protected boolean handle_long_int_boolean( long lhs, int rhs )  { throw new Error("Programmer error: handle_long_int_boolean must be overridden by subclass"); }
	protected int handle_long_long_int( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_int must be overridden by subclass"); }
	protected long handle_long_long_long( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_long must be overridden by subclass"); }
	protected float handle_long_long_float( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_float must be overridden by subclass"); }
	protected double handle_long_long_double( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_double must be overridden by subclass"); }
	protected String handle_long_long_String( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_String must be overridden by subclass"); }
	protected boolean handle_long_long_boolean( long lhs, long rhs )  { throw new Error("Programmer error: handle_long_long_boolean must be overridden by subclass"); }
	protected int handle_long_float_int( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_int must be overridden by subclass"); }
	protected long handle_long_float_long( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_long must be overridden by subclass"); }
	protected float handle_long_float_float( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_float must be overridden by subclass"); }
	protected double handle_long_float_double( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_double must be overridden by subclass"); }
	protected String handle_long_float_String( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_String must be overridden by subclass"); }
	protected boolean handle_long_float_boolean( long lhs, float rhs )  { throw new Error("Programmer error: handle_long_float_boolean must be overridden by subclass"); }
	protected int handle_long_double_int( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_int must be overridden by subclass"); }
	protected long handle_long_double_long( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_long must be overridden by subclass"); }
	protected float handle_long_double_float( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_float must be overridden by subclass"); }
	protected double handle_long_double_double( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_double must be overridden by subclass"); }
	protected String handle_long_double_String( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_String must be overridden by subclass"); }
	protected boolean handle_long_double_boolean( long lhs, double rhs )  { throw new Error("Programmer error: handle_long_double_boolean must be overridden by subclass"); }
	protected int handle_long_String_int( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_String_int must be overridden by subclass"); }
	protected long handle_long_String_long( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_String_long must be overridden by subclass"); }
	protected float handle_long_String_float( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_String_float must be overridden by subclass"); }
	protected double handle_long_String_double( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_String_double must be overridden by subclass"); }
	protected String handle_long_String_String( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_String_String must be overridden by subclass"); }
	protected boolean handle_long_String_boolean( long lhs, String rhs )  { throw new Error("Programmer error: handle_long_String_boolean must be overridden by subclass"); }
	protected int handle_long_boolean_int( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_boolean_int must be overridden by subclass"); }
	protected long handle_long_boolean_long( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_boolean_long must be overridden by subclass"); }
	protected float handle_long_boolean_float( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_boolean_float must be overridden by subclass"); }
	protected double handle_long_boolean_double( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_boolean_double must be overridden by subclass"); }
	protected String handle_long_boolean_String( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_boolean_String must be overridden by subclass"); }
	protected boolean handle_long_boolean_boolean( long lhs, boolean rhs )  { throw new Error("Programmer error: handle_long_boolean_boolean must be overridden by subclass"); }
	protected int handle_float_int_int( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_int must be overridden by subclass"); }
	protected long handle_float_int_long( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_long must be overridden by subclass"); }
	protected float handle_float_int_float( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_float must be overridden by subclass"); }
	protected double handle_float_int_double( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_double must be overridden by subclass"); }
	protected String handle_float_int_String( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_String must be overridden by subclass"); }
	protected boolean handle_float_int_boolean( float lhs, int rhs )  { throw new Error("Programmer error: handle_float_int_boolean must be overridden by subclass"); }
	protected int handle_float_long_int( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_int must be overridden by subclass"); }
	protected long handle_float_long_long( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_long must be overridden by subclass"); }
	protected float handle_float_long_float( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_float must be overridden by subclass"); }
	protected double handle_float_long_double( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_double must be overridden by subclass"); }
	protected String handle_float_long_String( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_String must be overridden by subclass"); }
	protected boolean handle_float_long_boolean( float lhs, long rhs )  { throw new Error("Programmer error: handle_float_long_boolean must be overridden by subclass"); }
	protected int handle_float_float_int( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_int must be overridden by subclass"); }
	protected long handle_float_float_long( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_long must be overridden by subclass"); }
	protected float handle_float_float_float( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_float must be overridden by subclass"); }
	protected double handle_float_float_double( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_double must be overridden by subclass"); }
	protected String handle_float_float_String( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_String must be overridden by subclass"); }
	protected boolean handle_float_float_boolean( float lhs, float rhs )  { throw new Error("Programmer error: handle_float_float_boolean must be overridden by subclass"); }
	protected int handle_float_double_int( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_int must be overridden by subclass"); }
	protected long handle_float_double_long( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_long must be overridden by subclass"); }
	protected float handle_float_double_float( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_float must be overridden by subclass"); }
	protected double handle_float_double_double( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_double must be overridden by subclass"); }
	protected String handle_float_double_String( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_String must be overridden by subclass"); }
	protected boolean handle_float_double_boolean( float lhs, double rhs )  { throw new Error("Programmer error: handle_float_double_boolean must be overridden by subclass"); }
	protected int handle_float_String_int( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_String_int must be overridden by subclass"); }
	protected long handle_float_String_long( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_String_long must be overridden by subclass"); }
	protected float handle_float_String_float( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_String_float must be overridden by subclass"); }
	protected double handle_float_String_double( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_String_double must be overridden by subclass"); }
	protected String handle_float_String_String( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_String_String must be overridden by subclass"); }
	protected boolean handle_float_String_boolean( float lhs, String rhs )  { throw new Error("Programmer error: handle_float_String_boolean must be overridden by subclass"); }
	protected int handle_float_boolean_int( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_boolean_int must be overridden by subclass"); }
	protected long handle_float_boolean_long( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_boolean_long must be overridden by subclass"); }
	protected float handle_float_boolean_float( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_boolean_float must be overridden by subclass"); }
	protected double handle_float_boolean_double( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_boolean_double must be overridden by subclass"); }
	protected String handle_float_boolean_String( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_boolean_String must be overridden by subclass"); }
	protected boolean handle_float_boolean_boolean( float lhs, boolean rhs )  { throw new Error("Programmer error: handle_float_boolean_boolean must be overridden by subclass"); }
	protected int handle_double_int_int( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_int must be overridden by subclass"); }
	protected long handle_double_int_long( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_long must be overridden by subclass"); }
	protected float handle_double_int_float( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_float must be overridden by subclass"); }
	protected double handle_double_int_double( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_double must be overridden by subclass"); }
	protected String handle_double_int_String( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_String must be overridden by subclass"); }
	protected boolean handle_double_int_boolean( double lhs, int rhs )  { throw new Error("Programmer error: handle_double_int_boolean must be overridden by subclass"); }
	protected int handle_double_long_int( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_int must be overridden by subclass"); }
	protected long handle_double_long_long( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_long must be overridden by subclass"); }
	protected float handle_double_long_float( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_float must be overridden by subclass"); }
	protected double handle_double_long_double( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_double must be overridden by subclass"); }
	protected String handle_double_long_String( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_String must be overridden by subclass"); }
	protected boolean handle_double_long_boolean( double lhs, long rhs )  { throw new Error("Programmer error: handle_double_long_boolean must be overridden by subclass"); }
	protected int handle_double_float_int( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_int must be overridden by subclass"); }
	protected long handle_double_float_long( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_long must be overridden by subclass"); }
	protected float handle_double_float_float( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_float must be overridden by subclass"); }
	protected double handle_double_float_double( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_double must be overridden by subclass"); }
	protected String handle_double_float_String( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_String must be overridden by subclass"); }
	protected boolean handle_double_float_boolean( double lhs, float rhs )  { throw new Error("Programmer error: handle_double_float_boolean must be overridden by subclass"); }
	protected int handle_double_double_int( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_int must be overridden by subclass"); }
	protected long handle_double_double_long( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_long must be overridden by subclass"); }
	protected float handle_double_double_float( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_float must be overridden by subclass"); }
	protected double handle_double_double_double( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_double must be overridden by subclass"); }
	protected String handle_double_double_String( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_String must be overridden by subclass"); }
	protected boolean handle_double_double_boolean( double lhs, double rhs )  { throw new Error("Programmer error: handle_double_double_boolean must be overridden by subclass"); }
	protected int handle_double_String_int( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_String_int must be overridden by subclass"); }
	protected long handle_double_String_long( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_String_long must be overridden by subclass"); }
	protected float handle_double_String_float( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_String_float must be overridden by subclass"); }
	protected double handle_double_String_double( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_String_double must be overridden by subclass"); }
	protected String handle_double_String_String( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_String_String must be overridden by subclass"); }
	protected boolean handle_double_String_boolean( double lhs, String rhs )  { throw new Error("Programmer error: handle_double_String_boolean must be overridden by subclass"); }
	protected int handle_double_boolean_int( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_boolean_int must be overridden by subclass"); }
	protected long handle_double_boolean_long( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_boolean_long must be overridden by subclass"); }
	protected float handle_double_boolean_float( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_boolean_float must be overridden by subclass"); }
	protected double handle_double_boolean_double( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_boolean_double must be overridden by subclass"); }
	protected String handle_double_boolean_String( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_boolean_String must be overridden by subclass"); }
	protected boolean handle_double_boolean_boolean( double lhs, boolean rhs )  { throw new Error("Programmer error: handle_double_boolean_boolean must be overridden by subclass"); }
	protected int handle_String_int_int( String lhs, int rhs )  { throw new Error("Programmer error: handle_String_int_int must be overridden by subclass"); }
	protected long handle_String_int_long( String lhs, int rhs )  { throw new Error("Programmer error: handle_String_int_long must be overridden by subclass"); }
	protected float handle_String_int_float( String lhs, int rhs )  { throw new Error("Programmer error: handle_String_int_float must be overridden by subclass"); }
	protected double handle_String_int_double( String lhs, int rhs )  { throw new Error("Programmer error: handle_String_int_double must be overridden by subclass"); }
	protected String handle_String_int_String( String lhs, int rhs )  { throw new Error("Programmer error: handle_String_int_String must be overridden by subclass"); }
	protected boolean handle_String_int_boolean( String lhs, int rhs )  { throw new Error("Programmer error: handle_String_int_boolean must be overridden by subclass"); }
	protected int handle_String_long_int( String lhs, long rhs )  { throw new Error("Programmer error: handle_String_long_int must be overridden by subclass"); }
	protected long handle_String_long_long( String lhs, long rhs )  { throw new Error("Programmer error: handle_String_long_long must be overridden by subclass"); }
	protected float handle_String_long_float( String lhs, long rhs )  { throw new Error("Programmer error: handle_String_long_float must be overridden by subclass"); }
	protected double handle_String_long_double( String lhs, long rhs )  { throw new Error("Programmer error: handle_String_long_double must be overridden by subclass"); }
	protected String handle_String_long_String( String lhs, long rhs )  { throw new Error("Programmer error: handle_String_long_String must be overridden by subclass"); }
	protected boolean handle_String_long_boolean( String lhs, long rhs )  { throw new Error("Programmer error: handle_String_long_boolean must be overridden by subclass"); }
	protected int handle_String_float_int( String lhs, float rhs )  { throw new Error("Programmer error: handle_String_float_int must be overridden by subclass"); }
	protected long handle_String_float_long( String lhs, float rhs )  { throw new Error("Programmer error: handle_String_float_long must be overridden by subclass"); }
	protected float handle_String_float_float( String lhs, float rhs )  { throw new Error("Programmer error: handle_String_float_float must be overridden by subclass"); }
	protected double handle_String_float_double( String lhs, float rhs )  { throw new Error("Programmer error: handle_String_float_double must be overridden by subclass"); }
	protected String handle_String_float_String( String lhs, float rhs )  { throw new Error("Programmer error: handle_String_float_String must be overridden by subclass"); }
	protected boolean handle_String_float_boolean( String lhs, float rhs )  { throw new Error("Programmer error: handle_String_float_boolean must be overridden by subclass"); }
	protected int handle_String_double_int( String lhs, double rhs )  { throw new Error("Programmer error: handle_String_double_int must be overridden by subclass"); }
	protected long handle_String_double_long( String lhs, double rhs )  { throw new Error("Programmer error: handle_String_double_long must be overridden by subclass"); }
	protected float handle_String_double_float( String lhs, double rhs )  { throw new Error("Programmer error: handle_String_double_float must be overridden by subclass"); }
	protected double handle_String_double_double( String lhs, double rhs )  { throw new Error("Programmer error: handle_String_double_double must be overridden by subclass"); }
	protected String handle_String_double_String( String lhs, double rhs )  { throw new Error("Programmer error: handle_String_double_String must be overridden by subclass"); }
	protected boolean handle_String_double_boolean( String lhs, double rhs )  { throw new Error("Programmer error: handle_String_double_boolean must be overridden by subclass"); }
	protected int handle_String_String_int( String lhs, String rhs )  { throw new Error("Programmer error: handle_String_String_int must be overridden by subclass"); }
	protected long handle_String_String_long( String lhs, String rhs )  { throw new Error("Programmer error: handle_String_String_long must be overridden by subclass"); }
	protected float handle_String_String_float( String lhs, String rhs )  { throw new Error("Programmer error: handle_String_String_float must be overridden by subclass"); }
	protected double handle_String_String_double( String lhs, String rhs )  { throw new Error("Programmer error: handle_String_String_double must be overridden by subclass"); }
	protected String handle_String_String_String( String lhs, String rhs )  { throw new Error("Programmer error: handle_String_String_String must be overridden by subclass"); }
	protected boolean handle_String_String_boolean( String lhs, String rhs )  { throw new Error("Programmer error: handle_String_String_boolean must be overridden by subclass"); }
	protected int handle_String_boolean_int( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_String_boolean_int must be overridden by subclass"); }
	protected long handle_String_boolean_long( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_String_boolean_long must be overridden by subclass"); }
	protected float handle_String_boolean_float( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_String_boolean_float must be overridden by subclass"); }
	protected double handle_String_boolean_double( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_String_boolean_double must be overridden by subclass"); }
	protected String handle_String_boolean_String( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_String_boolean_String must be overridden by subclass"); }
	protected boolean handle_String_boolean_boolean( String lhs, boolean rhs )  { throw new Error("Programmer error: handle_String_boolean_boolean must be overridden by subclass"); }
	protected int handle_boolean_int_int( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_boolean_int_int must be overridden by subclass"); }
	protected long handle_boolean_int_long( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_boolean_int_long must be overridden by subclass"); }
	protected float handle_boolean_int_float( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_boolean_int_float must be overridden by subclass"); }
	protected double handle_boolean_int_double( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_boolean_int_double must be overridden by subclass"); }
	protected String handle_boolean_int_String( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_boolean_int_String must be overridden by subclass"); }
	protected boolean handle_boolean_int_boolean( boolean lhs, int rhs )  { throw new Error("Programmer error: handle_boolean_int_boolean must be overridden by subclass"); }
	protected int handle_boolean_long_int( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_boolean_long_int must be overridden by subclass"); }
	protected long handle_boolean_long_long( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_boolean_long_long must be overridden by subclass"); }
	protected float handle_boolean_long_float( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_boolean_long_float must be overridden by subclass"); }
	protected double handle_boolean_long_double( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_boolean_long_double must be overridden by subclass"); }
	protected String handle_boolean_long_String( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_boolean_long_String must be overridden by subclass"); }
	protected boolean handle_boolean_long_boolean( boolean lhs, long rhs )  { throw new Error("Programmer error: handle_boolean_long_boolean must be overridden by subclass"); }
	protected int handle_boolean_float_int( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_boolean_float_int must be overridden by subclass"); }
	protected long handle_boolean_float_long( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_boolean_float_long must be overridden by subclass"); }
	protected float handle_boolean_float_float( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_boolean_float_float must be overridden by subclass"); }
	protected double handle_boolean_float_double( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_boolean_float_double must be overridden by subclass"); }
	protected String handle_boolean_float_String( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_boolean_float_String must be overridden by subclass"); }
	protected boolean handle_boolean_float_boolean( boolean lhs, float rhs )  { throw new Error("Programmer error: handle_boolean_float_boolean must be overridden by subclass"); }
	protected int handle_boolean_double_int( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_boolean_double_int must be overridden by subclass"); }
	protected long handle_boolean_double_long( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_boolean_double_long must be overridden by subclass"); }
	protected float handle_boolean_double_float( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_boolean_double_float must be overridden by subclass"); }
	protected double handle_boolean_double_double( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_boolean_double_double must be overridden by subclass"); }
	protected String handle_boolean_double_String( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_boolean_double_String must be overridden by subclass"); }
	protected boolean handle_boolean_double_boolean( boolean lhs, double rhs )  { throw new Error("Programmer error: handle_boolean_double_boolean must be overridden by subclass"); }
	protected int handle_boolean_String_int( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_boolean_String_int must be overridden by subclass"); }
	protected long handle_boolean_String_long( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_boolean_String_long must be overridden by subclass"); }
	protected float handle_boolean_String_float( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_boolean_String_float must be overridden by subclass"); }
	protected double handle_boolean_String_double( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_boolean_String_double must be overridden by subclass"); }
	protected String handle_boolean_String_String( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_boolean_String_String must be overridden by subclass"); }
	protected boolean handle_boolean_String_boolean( boolean lhs, String rhs )  { throw new Error("Programmer error: handle_boolean_String_boolean must be overridden by subclass"); }
	protected int handle_boolean_boolean_int( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_boolean_boolean_int must be overridden by subclass"); }
	protected long handle_boolean_boolean_long( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_boolean_boolean_long must be overridden by subclass"); }
	protected float handle_boolean_boolean_float( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_boolean_boolean_float must be overridden by subclass"); }
	protected double handle_boolean_boolean_double( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_boolean_boolean_double must be overridden by subclass"); }
	protected String handle_boolean_boolean_String( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_boolean_boolean_String must be overridden by subclass"); }
	protected boolean handle_boolean_boolean_boolean( boolean lhs, boolean rhs )  { throw new Error("Programmer error: handle_boolean_boolean_boolean must be overridden by subclass"); }


	private class INT_INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.INT rhs;

		private INT_INT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_int_int(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class INT_INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.INT rhs;

		private INT_INT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_int_long(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class INT_INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.INT rhs;

		private INT_INT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_int_float(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class INT_INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.INT rhs;

		private INT_INT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_int_double(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class INT_INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.INT rhs;

		private INT_INT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_int_String(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class INT_INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.INT rhs;

		private INT_INT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_int_boolean(lhs.getIntFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class INT_LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.LONG rhs;

		private INT_LONG_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_long_int(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class INT_LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.LONG rhs;

		private INT_LONG_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_long_long(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class INT_LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.LONG rhs;

		private INT_LONG_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_long_float(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class INT_LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.LONG rhs;

		private INT_LONG_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_long_double(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class INT_LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.LONG rhs;

		private INT_LONG_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_long_String(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class INT_LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.LONG rhs;

		private INT_LONG_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_long_boolean(lhs.getIntFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class INT_FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private INT_FLOAT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_float_int(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class INT_FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private INT_FLOAT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_float_long(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class INT_FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private INT_FLOAT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_float_float(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class INT_FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private INT_FLOAT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_float_double(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class INT_FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private INT_FLOAT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_float_String(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class INT_FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private INT_FLOAT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_float_boolean(lhs.getIntFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class INT_DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private INT_DOUBLE_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_double_int(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class INT_DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private INT_DOUBLE_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_double_long(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class INT_DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private INT_DOUBLE_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_double_float(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class INT_DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private INT_DOUBLE_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_double_double(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class INT_DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private INT_DOUBLE_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_double_String(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class INT_DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private INT_DOUBLE_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_double_boolean(lhs.getIntFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class INT_STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.STRING rhs;

		private INT_STRING_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_String_int(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class INT_STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.STRING rhs;

		private INT_STRING_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_String_long(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class INT_STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.STRING rhs;

		private INT_STRING_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_String_float(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class INT_STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.STRING rhs;

		private INT_STRING_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_String_double(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class INT_STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.STRING rhs;

		private INT_STRING_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_String_String(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class INT_STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.STRING rhs;

		private INT_STRING_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_String_boolean(lhs.getIntFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class INT_BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private INT_BOOLEAN_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_int_boolean_int(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class INT_BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private INT_BOOLEAN_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_int_boolean_long(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class INT_BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private INT_BOOLEAN_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_int_boolean_float(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class INT_BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private INT_BOOLEAN_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_int_boolean_double(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class INT_BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private INT_BOOLEAN_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_int_boolean_String(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class INT_BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.INT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private INT_BOOLEAN_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asIntAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_int_boolean_boolean(lhs.getIntFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class LONG_INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.INT rhs;

		private LONG_INT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_int_int(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class LONG_INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.INT rhs;

		private LONG_INT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_int_long(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class LONG_INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.INT rhs;

		private LONG_INT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_int_float(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class LONG_INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.INT rhs;

		private LONG_INT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_int_double(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class LONG_INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.INT rhs;

		private LONG_INT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_int_String(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class LONG_INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.INT rhs;

		private LONG_INT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_int_boolean(lhs.getLongFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class LONG_LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.LONG rhs;

		private LONG_LONG_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_long_int(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class LONG_LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.LONG rhs;

		private LONG_LONG_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_long_long(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class LONG_LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.LONG rhs;

		private LONG_LONG_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_long_float(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class LONG_LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.LONG rhs;

		private LONG_LONG_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_long_double(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class LONG_LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.LONG rhs;

		private LONG_LONG_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_long_String(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class LONG_LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.LONG rhs;

		private LONG_LONG_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_long_boolean(lhs.getLongFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class LONG_FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.FLOAT rhs;

		private LONG_FLOAT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_float_int(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class LONG_FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.FLOAT rhs;

		private LONG_FLOAT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_float_long(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class LONG_FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.FLOAT rhs;

		private LONG_FLOAT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_float_float(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class LONG_FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.FLOAT rhs;

		private LONG_FLOAT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_float_double(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class LONG_FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.FLOAT rhs;

		private LONG_FLOAT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_float_String(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class LONG_FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.FLOAT rhs;

		private LONG_FLOAT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_float_boolean(lhs.getLongFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class LONG_DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private LONG_DOUBLE_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_double_int(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class LONG_DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private LONG_DOUBLE_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_double_long(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class LONG_DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private LONG_DOUBLE_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_double_float(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class LONG_DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private LONG_DOUBLE_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_double_double(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class LONG_DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private LONG_DOUBLE_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_double_String(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class LONG_DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private LONG_DOUBLE_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_double_boolean(lhs.getLongFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class LONG_STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.STRING rhs;

		private LONG_STRING_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_String_int(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class LONG_STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.STRING rhs;

		private LONG_STRING_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_String_long(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class LONG_STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.STRING rhs;

		private LONG_STRING_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_String_float(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class LONG_STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.STRING rhs;

		private LONG_STRING_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_String_double(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class LONG_STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.STRING rhs;

		private LONG_STRING_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_String_String(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class LONG_STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.STRING rhs;

		private LONG_STRING_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_String_boolean(lhs.getLongFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class LONG_BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private LONG_BOOLEAN_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_long_boolean_int(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class LONG_BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private LONG_BOOLEAN_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_long_boolean_long(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class LONG_BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private LONG_BOOLEAN_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_long_boolean_float(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class LONG_BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private LONG_BOOLEAN_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_long_boolean_double(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class LONG_BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private LONG_BOOLEAN_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_long_boolean_String(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class LONG_BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.LONG lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private LONG_BOOLEAN_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asLongAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_long_boolean_boolean(lhs.getLongFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class FLOAT_INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.INT rhs;

		private FLOAT_INT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_int_int(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class FLOAT_INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.INT rhs;

		private FLOAT_INT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_int_long(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class FLOAT_INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.INT rhs;

		private FLOAT_INT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_int_float(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class FLOAT_INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.INT rhs;

		private FLOAT_INT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_int_double(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class FLOAT_INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.INT rhs;

		private FLOAT_INT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_int_String(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class FLOAT_INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.INT rhs;

		private FLOAT_INT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_int_boolean(lhs.getFloatFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class FLOAT_LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.LONG rhs;

		private FLOAT_LONG_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_long_int(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class FLOAT_LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.LONG rhs;

		private FLOAT_LONG_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_long_long(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class FLOAT_LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.LONG rhs;

		private FLOAT_LONG_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_long_float(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class FLOAT_LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.LONG rhs;

		private FLOAT_LONG_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_long_double(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class FLOAT_LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.LONG rhs;

		private FLOAT_LONG_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_long_String(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class FLOAT_LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.LONG rhs;

		private FLOAT_LONG_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_long_boolean(lhs.getFloatFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class FLOAT_FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private FLOAT_FLOAT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_float_int(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class FLOAT_FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private FLOAT_FLOAT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_float_long(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class FLOAT_FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private FLOAT_FLOAT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_float_float(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class FLOAT_FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private FLOAT_FLOAT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_float_double(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class FLOAT_FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private FLOAT_FLOAT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_float_String(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class FLOAT_FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.FLOAT rhs;

		private FLOAT_FLOAT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_float_boolean(lhs.getFloatFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class FLOAT_DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private FLOAT_DOUBLE_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_double_int(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class FLOAT_DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private FLOAT_DOUBLE_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_double_long(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class FLOAT_DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private FLOAT_DOUBLE_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_double_float(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class FLOAT_DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private FLOAT_DOUBLE_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_double_double(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class FLOAT_DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private FLOAT_DOUBLE_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_double_String(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class FLOAT_DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private FLOAT_DOUBLE_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_double_boolean(lhs.getFloatFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class FLOAT_STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.STRING rhs;

		private FLOAT_STRING_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_String_int(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class FLOAT_STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.STRING rhs;

		private FLOAT_STRING_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_String_long(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class FLOAT_STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.STRING rhs;

		private FLOAT_STRING_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_String_float(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class FLOAT_STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.STRING rhs;

		private FLOAT_STRING_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_String_double(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class FLOAT_STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.STRING rhs;

		private FLOAT_STRING_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_String_String(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class FLOAT_STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.STRING rhs;

		private FLOAT_STRING_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_String_boolean(lhs.getFloatFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private FLOAT_BOOLEAN_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_float_boolean_int(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private FLOAT_BOOLEAN_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_float_boolean_long(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private FLOAT_BOOLEAN_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_float_boolean_float(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private FLOAT_BOOLEAN_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_float_boolean_double(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private FLOAT_BOOLEAN_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_float_boolean_String(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class FLOAT_BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.FLOAT lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private FLOAT_BOOLEAN_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asFloatAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_float_boolean_boolean(lhs.getFloatFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class DOUBLE_INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.INT rhs;

		private DOUBLE_INT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_int_int(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class DOUBLE_INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.INT rhs;

		private DOUBLE_INT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_int_long(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class DOUBLE_INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.INT rhs;

		private DOUBLE_INT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_int_float(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class DOUBLE_INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.INT rhs;

		private DOUBLE_INT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_int_double(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class DOUBLE_INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.INT rhs;

		private DOUBLE_INT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_int_String(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class DOUBLE_INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.INT rhs;

		private DOUBLE_INT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_int_boolean(lhs.getDoubleFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class DOUBLE_LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.LONG rhs;

		private DOUBLE_LONG_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_long_int(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class DOUBLE_LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.LONG rhs;

		private DOUBLE_LONG_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_long_long(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class DOUBLE_LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.LONG rhs;

		private DOUBLE_LONG_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_long_float(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class DOUBLE_LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.LONG rhs;

		private DOUBLE_LONG_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_long_double(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class DOUBLE_LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.LONG rhs;

		private DOUBLE_LONG_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_long_String(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class DOUBLE_LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.LONG rhs;

		private DOUBLE_LONG_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_long_boolean(lhs.getDoubleFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class DOUBLE_FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.FLOAT rhs;

		private DOUBLE_FLOAT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_float_int(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class DOUBLE_FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.FLOAT rhs;

		private DOUBLE_FLOAT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_float_long(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class DOUBLE_FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.FLOAT rhs;

		private DOUBLE_FLOAT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_float_float(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class DOUBLE_FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.FLOAT rhs;

		private DOUBLE_FLOAT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_float_double(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class DOUBLE_FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.FLOAT rhs;

		private DOUBLE_FLOAT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_float_String(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class DOUBLE_FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.FLOAT rhs;

		private DOUBLE_FLOAT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_float_boolean(lhs.getDoubleFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private DOUBLE_DOUBLE_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_double_int(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private DOUBLE_DOUBLE_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_double_long(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private DOUBLE_DOUBLE_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_double_float(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private DOUBLE_DOUBLE_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_double_double(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private DOUBLE_DOUBLE_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_double_String(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private DOUBLE_DOUBLE_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_double_boolean(lhs.getDoubleFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class DOUBLE_STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.STRING rhs;

		private DOUBLE_STRING_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_String_int(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class DOUBLE_STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.STRING rhs;

		private DOUBLE_STRING_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_String_long(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class DOUBLE_STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.STRING rhs;

		private DOUBLE_STRING_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_String_float(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class DOUBLE_STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.STRING rhs;

		private DOUBLE_STRING_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_String_double(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class DOUBLE_STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.STRING rhs;

		private DOUBLE_STRING_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_String_String(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class DOUBLE_STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.STRING rhs;

		private DOUBLE_STRING_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_String_boolean(lhs.getDoubleFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private DOUBLE_BOOLEAN_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_double_boolean_int(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private DOUBLE_BOOLEAN_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_double_boolean_long(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private DOUBLE_BOOLEAN_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_double_boolean_float(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private DOUBLE_BOOLEAN_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_double_boolean_double(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private DOUBLE_BOOLEAN_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_double_boolean_String(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class DOUBLE_BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.DOUBLE lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private DOUBLE_BOOLEAN_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asDoubleAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_double_boolean_boolean(lhs.getDoubleFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class STRING_INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.INT rhs;

		private STRING_INT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_int_int(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class STRING_INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.INT rhs;

		private STRING_INT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_int_long(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class STRING_INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.INT rhs;

		private STRING_INT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_int_float(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class STRING_INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.INT rhs;

		private STRING_INT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_int_double(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class STRING_INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.INT rhs;

		private STRING_INT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_int_String(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class STRING_INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.INT rhs;

		private STRING_INT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_int_boolean(lhs.getStringFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class STRING_LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.LONG rhs;

		private STRING_LONG_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_long_int(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class STRING_LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.LONG rhs;

		private STRING_LONG_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_long_long(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class STRING_LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.LONG rhs;

		private STRING_LONG_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_long_float(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class STRING_LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.LONG rhs;

		private STRING_LONG_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_long_double(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class STRING_LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.LONG rhs;

		private STRING_LONG_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_long_String(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class STRING_LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.LONG rhs;

		private STRING_LONG_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_long_boolean(lhs.getStringFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class STRING_FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.FLOAT rhs;

		private STRING_FLOAT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_float_int(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class STRING_FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.FLOAT rhs;

		private STRING_FLOAT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_float_long(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class STRING_FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.FLOAT rhs;

		private STRING_FLOAT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_float_float(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class STRING_FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.FLOAT rhs;

		private STRING_FLOAT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_float_double(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class STRING_FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.FLOAT rhs;

		private STRING_FLOAT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_float_String(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class STRING_FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.FLOAT rhs;

		private STRING_FLOAT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_float_boolean(lhs.getStringFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class STRING_DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private STRING_DOUBLE_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_double_int(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class STRING_DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private STRING_DOUBLE_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_double_long(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class STRING_DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private STRING_DOUBLE_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_double_float(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class STRING_DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private STRING_DOUBLE_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_double_double(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class STRING_DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private STRING_DOUBLE_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_double_String(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class STRING_DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private STRING_DOUBLE_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_double_boolean(lhs.getStringFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class STRING_STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.STRING rhs;

		private STRING_STRING_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_String_int(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class STRING_STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.STRING rhs;

		private STRING_STRING_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_String_long(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class STRING_STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.STRING rhs;

		private STRING_STRING_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_String_float(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class STRING_STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.STRING rhs;

		private STRING_STRING_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_String_double(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class STRING_STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.STRING rhs;

		private STRING_STRING_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_String_String(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class STRING_STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.STRING rhs;

		private STRING_STRING_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_String_boolean(lhs.getStringFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class STRING_BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private STRING_BOOLEAN_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_String_boolean_int(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class STRING_BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private STRING_BOOLEAN_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_String_boolean_long(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class STRING_BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private STRING_BOOLEAN_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_String_boolean_float(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class STRING_BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private STRING_BOOLEAN_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_String_boolean_double(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class STRING_BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private STRING_BOOLEAN_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_String_boolean_String(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class STRING_BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.STRING lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private STRING_BOOLEAN_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asStringAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_String_boolean_boolean(lhs.getStringFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_INT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.INT rhs;

		private BOOLEAN_INT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_int_int(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class BOOLEAN_INT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.INT rhs;

		private BOOLEAN_INT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_int_long(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class BOOLEAN_INT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.INT rhs;

		private BOOLEAN_INT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_int_float(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class BOOLEAN_INT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.INT rhs;

		private BOOLEAN_INT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_int_double(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class BOOLEAN_INT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.INT rhs;

		private BOOLEAN_INT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_int_String(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class BOOLEAN_INT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.INT rhs;

		private BOOLEAN_INT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asIntAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_int_boolean(lhs.getBoolFromRow(row), rhs.getIntFromRow(row));
		}
	}

	private class BOOLEAN_LONG_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.LONG rhs;

		private BOOLEAN_LONG_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_long_int(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class BOOLEAN_LONG_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.LONG rhs;

		private BOOLEAN_LONG_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_long_long(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class BOOLEAN_LONG_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.LONG rhs;

		private BOOLEAN_LONG_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_long_float(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class BOOLEAN_LONG_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.LONG rhs;

		private BOOLEAN_LONG_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_long_double(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class BOOLEAN_LONG_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.LONG rhs;

		private BOOLEAN_LONG_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_long_String(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class BOOLEAN_LONG_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.LONG rhs;

		private BOOLEAN_LONG_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asLongAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_long_boolean(lhs.getBoolFromRow(row), rhs.getLongFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.FLOAT rhs;

		private BOOLEAN_FLOAT_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_float_int(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.FLOAT rhs;

		private BOOLEAN_FLOAT_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_float_long(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.FLOAT rhs;

		private BOOLEAN_FLOAT_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_float_float(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.FLOAT rhs;

		private BOOLEAN_FLOAT_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_float_double(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.FLOAT rhs;

		private BOOLEAN_FLOAT_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_float_String(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class BOOLEAN_FLOAT_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.FLOAT rhs;

		private BOOLEAN_FLOAT_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asFloatAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_float_boolean(lhs.getBoolFromRow(row), rhs.getFloatFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private BOOLEAN_DOUBLE_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_double_int(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private BOOLEAN_DOUBLE_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_double_long(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private BOOLEAN_DOUBLE_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_double_float(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private BOOLEAN_DOUBLE_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_double_double(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private BOOLEAN_DOUBLE_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_double_String(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class BOOLEAN_DOUBLE_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.DOUBLE rhs;

		private BOOLEAN_DOUBLE_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asDoubleAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_double_boolean(lhs.getBoolFromRow(row), rhs.getDoubleFromRow(row));
		}
	}

	private class BOOLEAN_STRING_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.STRING rhs;

		private BOOLEAN_STRING_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_String_int(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class BOOLEAN_STRING_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.STRING rhs;

		private BOOLEAN_STRING_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_String_long(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class BOOLEAN_STRING_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.STRING rhs;

		private BOOLEAN_STRING_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_String_float(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class BOOLEAN_STRING_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.STRING rhs;

		private BOOLEAN_STRING_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_String_double(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class BOOLEAN_STRING_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.STRING rhs;

		private BOOLEAN_STRING_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_String_String(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class BOOLEAN_STRING_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.STRING rhs;

		private BOOLEAN_STRING_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asStringAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_String_boolean(lhs.getBoolFromRow(row), rhs.getStringFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN_INT extends TypedRowAccessor.INT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private BOOLEAN_BOOLEAN_INT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public int getIntFromRow(Row row) {
			return handle_boolean_boolean_int(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN_LONG extends TypedRowAccessor.LONG {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private BOOLEAN_BOOLEAN_LONG(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public long getLongFromRow(Row row) {
			return handle_boolean_boolean_long(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN_FLOAT extends TypedRowAccessor.FLOAT {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private BOOLEAN_BOOLEAN_FLOAT(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public float getFloatFromRow(Row row) {
			return handle_boolean_boolean_float(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN_DOUBLE extends TypedRowAccessor.DOUBLE {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private BOOLEAN_BOOLEAN_DOUBLE(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public double getDoubleFromRow(Row row) {
			return handle_boolean_boolean_double(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN_STRING extends TypedRowAccessor.STRING {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private BOOLEAN_BOOLEAN_STRING(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public String getStringFromRow(Row row) {
			return handle_boolean_boolean_String(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
		}
	}

	private class BOOLEAN_BOOLEAN_BOOLEAN extends TypedRowAccessor.BOOLEAN {

		private TypedRowAccessor.BOOLEAN lhs;
		private TypedRowAccessor.BOOLEAN rhs;

		private BOOLEAN_BOOLEAN_BOOLEAN(TypedRowAccessor lhs, TypedRowAccessor rhs) {
			this.lhs = lhs.asBoolAccessor();
			this.rhs = rhs.asBoolAccessor();
		}

		public boolean getBoolFromRow(Row row) {
			return handle_boolean_boolean_boolean(lhs.getBoolFromRow(row), rhs.getBoolFromRow(row));
		}
	}

}