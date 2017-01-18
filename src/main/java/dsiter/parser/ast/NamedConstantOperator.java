package dsiter.parser.ast;

import dsiter.accessor.ConstantAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.IRowAccessor;
import dsiter.row.Row;

import java.util.Map;

public class NamedConstantOperator implements AstNode {

	private String name;

	public NamedConstantOperator(String name) {
		this.name = name;
	}

	@Override
	public IRowAccessor link(ColumnDescriptor[] cds) throws LinkException {
		throw new Error("NamedConstantOperator can only be used for checking isomorphism");
	}

	@Override
	public boolean matches(AstNode compareTo, Map<String, String> columnMap, Map<String, ConstantOperator> constantMap) {
		if (!(compareTo instanceof ConstantOperator)) {
			return false;
		}
		else {
			constantMap.put(name, (ConstantOperator)compareTo);
			return true;
		}
	}
}
