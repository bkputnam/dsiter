/* GENERATED CODE */package dsiter.row;
/* GENERATED CODE */
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE *///	DO NOT EDIT!!!
/* GENERATED CODE *///
/* GENERATED CODE *///	This is generated code. Edit the template instead.
/* GENERATED CODE *////////////////////////////////////////////
/* GENERATED CODE */
/* GENERATED CODE */public interface ConstantAccessor {
/* GENERATED CODE */
/* GENERATED CODE */	
/* GENERATED CODE */	static IRowAccessor getInstance(int value) {
/* GENERATED CODE */		return new IRowAccessor.INT() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public int getIntFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	static IRowAccessor getInstance(long value) {
/* GENERATED CODE */		return new IRowAccessor.LONG() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public long getLongFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	static IRowAccessor getInstance(float value) {
/* GENERATED CODE */		return new IRowAccessor.FLOAT() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public float getFloatFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	static IRowAccessor getInstance(double value) {
/* GENERATED CODE */		return new IRowAccessor.DOUBLE() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public double getDoubleFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	static IRowAccessor getInstance(String value) {
/* GENERATED CODE */		return new IRowAccessor.STRING() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public String getStringFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */	static IRowAccessor getInstance(boolean value) {
/* GENERATED CODE */		return new IRowAccessor.BOOLEAN() {
/* GENERATED CODE */			@Override
/* GENERATED CODE */			public boolean getBoolFromRow(Row row) {
/* GENERATED CODE */				return value;
/* GENERATED CODE */			}
/* GENERATED CODE */		};
/* GENERATED CODE */	}
/* GENERATED CODE */	
/* GENERATED CODE */}
