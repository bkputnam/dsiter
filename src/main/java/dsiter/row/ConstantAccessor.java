/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
                    /**
                     * Non-instantiable class whose static methods can be used to get
                     * instances of {@link IRowAccessor} that only return a single
                     * constant value.
                     *
                     * <p>
                     *     For example, one might use a constant accessor when computing
                     *     the cube root of a column:
                     * </p>
                     * <pre>{@code
                     * IRowAccessor cubeRootAccessor = new NthRootOperator(
                     * 	someColumnAccessor,
                     * 	ConstantAccessor.getInstance(3)
                     * );
                     * }</pre>
                     */
/* GENERATED CODE */public final class ConstantAccessor {
/* GENERATED CODE */
/* GENERATED CODE */   private ConstantAccessor() {
/* GENERATED CODE */       throw new AssertionError("Programmer Error: this should be impossible");
/* GENERATED CODE */   }
/* GENERATED CODE */
/* GENERATED CODE */	
                    	/**
                    	 * Construct and return a new {@link IRowAccessor.INT} which
                    	 * always returns {@code value}
                    	 *
                    	 * @param value The constant value to be returned by the IRowAccessor
                    	 * @return An {@link IRowAccessor.INT} that always returns
                    	 * 		{@code value}
                    	 */
/* GENERATED CODE */	public static IRowAccessor.INT getInstance(int value) {
/* GENERATED CODE */		return new IRowAccessor.INT() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public int getIntFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct and return a new {@link IRowAccessor.LONG} which
                    	 * always returns {@code value}
                    	 *
                    	 * @param value The constant value to be returned by the IRowAccessor
                    	 * @return An {@link IRowAccessor.LONG} that always returns
                    	 * 		{@code value}
                    	 */
/* GENERATED CODE */	public static IRowAccessor.LONG getInstance(long value) {
/* GENERATED CODE */		return new IRowAccessor.LONG() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public long getLongFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct and return a new {@link IRowAccessor.FLOAT} which
                    	 * always returns {@code value}
                    	 *
                    	 * @param value The constant value to be returned by the IRowAccessor
                    	 * @return An {@link IRowAccessor.FLOAT} that always returns
                    	 * 		{@code value}
                    	 */
/* GENERATED CODE */	public static IRowAccessor.FLOAT getInstance(float value) {
/* GENERATED CODE */		return new IRowAccessor.FLOAT() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public float getFloatFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct and return a new {@link IRowAccessor.DOUBLE} which
                    	 * always returns {@code value}
                    	 *
                    	 * @param value The constant value to be returned by the IRowAccessor
                    	 * @return An {@link IRowAccessor.DOUBLE} that always returns
                    	 * 		{@code value}
                    	 */
/* GENERATED CODE */	public static IRowAccessor.DOUBLE getInstance(double value) {
/* GENERATED CODE */		return new IRowAccessor.DOUBLE() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public double getDoubleFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct and return a new {@link IRowAccessor.STRING} which
                    	 * always returns {@code value}
                    	 *
                    	 * @param value The constant value to be returned by the IRowAccessor
                    	 * @return An {@link IRowAccessor.STRING} that always returns
                    	 * 		{@code value}
                    	 */
/* GENERATED CODE */	public static IRowAccessor.STRING getInstance(String value) {
/* GENERATED CODE */		return new IRowAccessor.STRING() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public String getStringFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
                    	/**
                    	 * Construct and return a new {@link IRowAccessor.BOOLEAN} which
                    	 * always returns {@code value}
                    	 *
                    	 * @param value The constant value to be returned by the IRowAccessor
                    	 * @return An {@link IRowAccessor.BOOLEAN} that always returns
                    	 * 		{@code value}
                    	 */
/* GENERATED CODE */	public static IRowAccessor.BOOLEAN getInstance(boolean value) {
/* GENERATED CODE */		return new IRowAccessor.BOOLEAN() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
