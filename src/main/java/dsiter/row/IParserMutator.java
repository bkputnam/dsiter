/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * Interface for classes that parse strings and insert them directly into
                     * Rows.
                     *
                     * <p>
                     *     You probably won't have to implement this interface yourself: it
                     *     comes with default implementations for all the standard types
                     *     (e.g. uses {@code Integer.parseInt} for ints, {@code Boolean.parseBoolean}
                     *     for booleans, etc. The only reason to make a custom implementation
                     *     is if you want to parse values in some other format.
                     * </p>
                     */
/* GENERATED CODE */public interface IParserMutator {
/* GENERATED CODE */
                        /**
                         * Parse a string value and insert it into the passed Row
                         *
                         * @param value The string value to be parsed
                         * @param row   The Row to be modified
                         */
/* GENERATED CODE */    void parseAndMutate(String value, Row row);
/* GENERATED CODE */
                        /**
                         * Given a ColumnType and an index, return an {@code IParserMutator}
                         * instance that parses that type and inserts it into Rows at the
                         * specified index.
                         *
                         * @param type  The type to be parsed
                         * @param index The location at which the parsed values should be
                         *              inserted
                         * @return An {@code IParserMutator} instance that parses
                         * {@code type} values and inserts them at {@code index}
                         */
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
