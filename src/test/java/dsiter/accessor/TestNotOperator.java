package dsiter.accessor;

import dsiter.row.ConstantAccessor;
import dsiter.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestNotOperator {

    @Test
    public void testNotTrue() {
        NotOperator no = new NotOperator(
            ConstantAccessor.getBoolInstance(true)
        );

        assertEquals(false, no.getValueFromRow(new Row()));
    }

    @Test
    public void testNotFalse() {
        NotOperator no = new NotOperator(
                ConstantAccessor.getBoolInstance(false)
        );

        assertEquals(true, no.getValueFromRow(new Row()));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNullFails() {
        NotOperator no = new NotOperator(null);
    }
}
