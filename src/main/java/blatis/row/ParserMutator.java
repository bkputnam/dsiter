/* GENERATED CODE */package blatis.row;
/* GENERATED CODE */
/* GENERATED CODE */public class ParserMutator {
/* GENERATED CODE */
/* GENERATED CODE */	protected int index;
/* GENERATED CODE */
/* GENERATED CODE */	public static IParserMutator getInstance(ColumnType type, int index) {
/* GENERATED CODE */		ParserMutator base = new ParserMutator(index);
/* GENERATED CODE */
/* GENERATED CODE */		switch (type) {
/* GENERATED CODE */			
/* GENERATED CODE */			case INT: return base.new INT();
/* GENERATED CODE */			case LONG: return base.new LONG();
/* GENERATED CODE */			case FLOAT: return base.new FLOAT();
/* GENERATED CODE */			case DOUBLE: return base.new DOUBLE();
/* GENERATED CODE */			case STRING: return base.new STRING();
/* GENERATED CODE */			case BOOLEAN: return base.new BOOLEAN();
/* GENERATED CODE */
/* GENERATED CODE */			default:
/* GENERATED CODE */				throw new IllegalArgumentException("Unsupported ColumnType: " + type);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	private ParserMutator(int index) {
/* GENERATED CODE */		this.index = index;
/* GENERATED CODE */	}
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	protected class INT implements IParserMutator {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */			row.ints[index] = Integer.parseInt(value);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	protected class LONG implements IParserMutator {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */			row.longs[index] = Long.parseLong(value);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	protected class FLOAT implements IParserMutator {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */			row.floats[index] = Float.parseFloat(value);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	protected class DOUBLE implements IParserMutator {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */			row.doubles[index] = Double.parseDouble(value);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	protected class STRING implements IParserMutator {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */			row.strings[index] = (value);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	protected class BOOLEAN implements IParserMutator {
/* GENERATED CODE */		@Override
/* GENERATED CODE */		public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */			row.bools[index] = Boolean.parseBoolean(value);
/* GENERATED CODE */		}
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
