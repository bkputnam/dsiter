package blatis.row;

/**
 * Created by bkputnam on 12/3/16.
 */
public class LessThanPredicate implements IPredicate {

    IPredicate innerPredicate;

    public LessThanPredicate(IRowAccessor lhs, IRowAccessor rhs) {
        if( lhs == null ) { throw new IllegalArgumentException("lhs cannot be null"); }
        if( rhs == null ) { throw new IllegalArgumentException("rhs cannot be null"); }

        if( lhs.getType() != rhs.getType() ) {
            throw new IllegalArgumentException(
                "lhs and rhs must have same type (found " +
                lhs.getType() + ", " + rhs.getType() +
                ", respectively)"
            );
        }

        ColumnDescriptor.Type type = lhs.getType();
        innerPredicate =
            type == ColumnDescriptor.Type.INT ? new Int(lhs, rhs) :
            type == ColumnDescriptor.Type.LONG ? new Long(lhs, rhs) :
            type == ColumnDescriptor.Type.FLOAT ? new Float(lhs, rhs) :
            type == ColumnDescriptor.Type.DOUBLE ? new Double(lhs, rhs) :
            null;
        if( innerPredicate == null ) {
            throw new IllegalArgumentException("Unsupported column type: " + type);
        }
    }

    @Override
    public boolean testRow(Row row) {
        return innerPredicate.testRow(row);
    }

    private static abstract class BaseLtPredicate implements IPredicate {
        protected IRowAccessor lhs;
        protected IRowAccessor rhs;

        public BaseLtPredicate(IRowAccessor lhs, IRowAccessor rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        public abstract boolean testRow(Row row);
    }

    private static class Int extends BaseLtPredicate {
        public Int(IRowAccessor lhs, IRowAccessor rhs) {
            super(lhs, rhs);
        }

        @Override
        public boolean testRow(Row row) {
            return (int)lhs.getValueFromRow(row) < (int)rhs.getValueFromRow(row);
        }
    }

    private static class Long extends BaseLtPredicate {
        public Long(IRowAccessor lhs, IRowAccessor rhs) {
            super(lhs, rhs);
        }

        @Override
        public boolean testRow(Row row) {
            return (long)lhs.getValueFromRow(row) < (long)rhs.getValueFromRow(row);
        }
    }

    private static class Float extends BaseLtPredicate {
        public Float(IRowAccessor lhs, IRowAccessor rhs) {
            super(lhs, rhs);
        }

        @Override
        public boolean testRow(Row row) {
            return (float)lhs.getValueFromRow(row) < (float)rhs.getValueFromRow(row);
        }
    }

    private static class Double extends BaseLtPredicate {
        public Double(IRowAccessor lhs, IRowAccessor rhs) {
            super(lhs, rhs);
        }

        @Override
        public boolean testRow(Row row) {
            return (double)lhs.getValueFromRow(row) < (double)rhs.getValueFromRow(row);
        }
    }
}
