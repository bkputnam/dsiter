package blatis.operator;

import blatis.row.ConstantAccessor;
import blatis.row.Row;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestNotOperator {

    @Test
    public void testNotTrue() {
        NotOperator no = new NotOperator(
            new ConstantAccessor(true)
        );

        assertEquals(false, no.getValueFromRow(new Row()));
    }

    @Test
    public void testNotFalse() {
        NotOperator no = new NotOperator(
                new ConstantAccessor(false)
        );

        assertEquals(true, no.getValueFromRow(new Row()));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNullFails() {
        NotOperator no = new NotOperator(null);
    }
}
