/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * Enum that lists the various "primitive" types supported by {@link Row}
                     */
/* GENERATED CODE */public enum ColumnType {
/* GENERATED CODE */		INT,
/* GENERATED CODE */	LONG,
/* GENERATED CODE */	FLOAT,
/* GENERATED CODE */	DOUBLE,
/* GENERATED CODE */	STRING,
/* GENERATED CODE */	BOOLEAN,
/* GENERATED CODE */	JSDATE;
/* GENERATED CODE */
                    	/**
                    	 * Returns {@code true} if the current value represents a numeric type.
                    	 * Numeric types are defined to be {@code INT}, {@code LONG}, {@code FLOAT},
                    	 * and {@code DOUBLE}
                    	 *
                    	 * @return {@code true} if value is numeric
                    	 */
/* GENERATED CODE */	public boolean isNumeric() {
/* GENERATED CODE */		return this == INT || this == LONG || this == FLOAT || this == DOUBLE;
/* GENERATED CODE */	}
/* GENERATED CODE */}
