/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE */public interface IParserMutator {
/* GENERATED CODE */
/* GENERATED CODE */    void parseAndMutate(String value, Row row);
/* GENERATED CODE */
/* GENERATED CODE */    static IParserMutator getInstance(ColumnType type, int index) {
/* GENERATED CODE */        switch (type) {
/* GENERATED CODE */            
/* GENERATED CODE */            case INT: return new IParserMutator() {
/* GENERATED CODE */                @Override
/* GENERATED CODE */                public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */                    row.ints[index] = Integer.parseInt(value);
/* GENERATED CODE */                }
/* GENERATED CODE */            };
/* GENERATED CODE */            
/* GENERATED CODE */            case LONG: return new IParserMutator() {
/* GENERATED CODE */                @Override
/* GENERATED CODE */                public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */                    row.longs[index] = Long.parseLong(value);
/* GENERATED CODE */                }
/* GENERATED CODE */            };
/* GENERATED CODE */            
/* GENERATED CODE */            case FLOAT: return new IParserMutator() {
/* GENERATED CODE */                @Override
/* GENERATED CODE */                public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */                    row.floats[index] = Float.parseFloat(value);
/* GENERATED CODE */                }
/* GENERATED CODE */            };
/* GENERATED CODE */            
/* GENERATED CODE */            case DOUBLE: return new IParserMutator() {
/* GENERATED CODE */                @Override
/* GENERATED CODE */                public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */                    row.doubles[index] = Double.parseDouble(value);
/* GENERATED CODE */                }
/* GENERATED CODE */            };
/* GENERATED CODE */            
/* GENERATED CODE */            case STRING: return new IParserMutator() {
/* GENERATED CODE */                @Override
/* GENERATED CODE */                public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */                    row.strings[index] = (value);
/* GENERATED CODE */                }
/* GENERATED CODE */            };
/* GENERATED CODE */            
/* GENERATED CODE */            case BOOLEAN: return new IParserMutator() {
/* GENERATED CODE */                @Override
/* GENERATED CODE */                public void parseAndMutate(String value, Row row) {
/* GENERATED CODE */                    row.bools[index] = Boolean.parseBoolean(value);
/* GENERATED CODE */                }
/* GENERATED CODE */            };
/* GENERATED CODE */            
/* GENERATED CODE */            default:
/* GENERATED CODE */                throw new Error("Programmer Error: this should be impossible");
/* GENERATED CODE */        }
/* GENERATED CODE */    }
/* GENERATED CODE */}
