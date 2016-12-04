package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public abstract class ColumnMutator implements IRowMutator {
    protected int index;

    protected ColumnMutator(int index) { this.index = index; }

    public abstract void setValueInRow(Row row, Object value);
    public abstract ColumnType getType();

    public static ColumnMutator create(ColumnType type, int rowArrayIndex) {
        if( type == ColumnType.INT ) {
            return new ColumnMutator.IntMutator( rowArrayIndex );
        }
        else if( type == ColumnType.LONG ) {
            return new ColumnMutator.LongMutator( rowArrayIndex );
        }
        else if( type == ColumnType.FLOAT ) {
            return new ColumnMutator.FloatMutator( rowArrayIndex );
        }
        else if( type == ColumnType.DOUBLE ) {
            return new ColumnMutator.DoubleMutator( rowArrayIndex );
        }
        else if( type == ColumnType.STRING ) {
            return new ColumnMutator.StringMutator( rowArrayIndex );
        }
        else if( type == ColumnType.BOOLEAN ) {
            return new ColumnMutator.BoolMutator( rowArrayIndex );
        }
        else {
            throw new Error("Programmer Error: unrecognized Type: " + type);
        }
    }

    public static class IntMutator extends ColumnMutator {
        public IntMutator(int index) { super(index); }

        public ColumnType getType() { return ColumnType.INT; }

        public void setValueInRow(Row row, Object value) { row.ints[this.index] = (int)value; }
    }

    public static class LongMutator extends ColumnMutator {
        public LongMutator(int index) { super(index); }

        public ColumnType getType() { return ColumnType.LONG; }

        public void setValueInRow(Row row, Object value) { row.longs[this.index] = (long)value; }
    }

    public static class FloatMutator extends ColumnMutator {
        public FloatMutator(int index) { super(index); }

        public ColumnType getType() { return ColumnType.FLOAT; }

        public void setValueInRow(Row row, Object value) { row.floats[this.index] = (float)value; }
    }

    public static class DoubleMutator extends ColumnMutator {
        public DoubleMutator(int index) { super(index); }

        public ColumnType getType() { return ColumnType.DOUBLE; }

        public void setValueInRow(Row row, Object value) { row.doubles[this.index] = (double)value; }
    }

    public static class StringMutator extends ColumnMutator {
        public StringMutator(int index) { super(index); }

        public ColumnType getType() { return ColumnType.STRING; }

        public void setValueInRow(Row row, Object value) { row.strings[this.index] = (String)value; }
    }

    public static class BoolMutator extends ColumnMutator {
        public BoolMutator(int index) { super(index); }

        public ColumnType getType() { return ColumnType.BOOLEAN; }

        public void setValueInRow(Row row, Object value) { row.bools[this.index] = (boolean)value; }
    }
}
