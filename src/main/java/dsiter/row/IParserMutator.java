/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE */import java.text.NumberFormat;
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
/* GENERATED CODE */    void parseAndMutate(String value, Row row) throws Exception;
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
/* GENERATED CODE */
/* GENERATED CODE */        NumberFormat parser; // shared variable, used by some of the parsers
/* GENERATED CODE */
/* GENERATED CODE */        switch (type) {
/* GENERATED CODE */            
/* GENERATED CODE */            case INT:
/* GENERATED CODE */                parser = NumberFormat.getIntegerInstance(java.util.Locale.US);
/* GENERATED CODE */                return new IParserMutator() {
/* GENERATED CODE */                    @Override
/* GENERATED CODE */                    public void parseAndMutate(String value, Row row) throws Exception {
/* GENERATED CODE */                        row.ints[index] = parser.parse(value).intValue();
/* GENERATED CODE */                    }
/* GENERATED CODE */                };
/* GENERATED CODE */            
/* GENERATED CODE */            case LONG:
/* GENERATED CODE */                parser = NumberFormat.getIntegerInstance(java.util.Locale.US);
/* GENERATED CODE */                return new IParserMutator() {
/* GENERATED CODE */                    @Override
/* GENERATED CODE */                    public void parseAndMutate(String value, Row row) throws Exception {
/* GENERATED CODE */                        row.longs[index] = parser.parse(value).longValue();
/* GENERATED CODE */                    }
/* GENERATED CODE */                };
/* GENERATED CODE */            
/* GENERATED CODE */            case FLOAT:
/* GENERATED CODE */                parser = NumberFormat.getNumberInstance(java.util.Locale.US);
/* GENERATED CODE */                return new IParserMutator() {
/* GENERATED CODE */                    @Override
/* GENERATED CODE */                    public void parseAndMutate(String value, Row row) throws Exception {
/* GENERATED CODE */                        row.floats[index] = parser.parse(value).floatValue();
/* GENERATED CODE */                    }
/* GENERATED CODE */                };
/* GENERATED CODE */            
/* GENERATED CODE */            case DOUBLE:
/* GENERATED CODE */                parser = NumberFormat.getNumberInstance(java.util.Locale.US);
/* GENERATED CODE */                return new IParserMutator() {
/* GENERATED CODE */                    @Override
/* GENERATED CODE */                    public void parseAndMutate(String value, Row row) throws Exception {
/* GENERATED CODE */                        row.doubles[index] = parser.parse(value).doubleValue();
/* GENERATED CODE */                    }
/* GENERATED CODE */                };
/* GENERATED CODE */            
/* GENERATED CODE */            case STRING:
/* GENERATED CODE */                
/* GENERATED CODE */                return new IParserMutator() {
/* GENERATED CODE */                    @Override
/* GENERATED CODE */                    public void parseAndMutate(String value, Row row) throws Exception {
/* GENERATED CODE */                        row.strings[index] = value;
/* GENERATED CODE */                    }
/* GENERATED CODE */                };
/* GENERATED CODE */            
/* GENERATED CODE */            case BOOLEAN:
/* GENERATED CODE */                
/* GENERATED CODE */                return new IParserMutator() {
/* GENERATED CODE */                    @Override
/* GENERATED CODE */                    public void parseAndMutate(String value, Row row) throws Exception {
/* GENERATED CODE */                        row.bools[index] = Boolean.parseBoolean(value);
/* GENERATED CODE */                    }
/* GENERATED CODE */                };
/* GENERATED CODE */            
/* GENERATED CODE */            default:
/* GENERATED CODE */                throw new Error("Programmer Error: this should be impossible");
/* GENERATED CODE */        }
/* GENERATED CODE */    }
/* GENERATED CODE */}
