/* GENERATED CODE */package dsiter;
/* GENERATED CODE */
/* GENERATED CODE */import java.util.List;
/* GENERATED CODE */import java.util.ArrayList;
/* GENERATED CODE */
/* GENERATED CODE */import dsiter.iterator.IDatasetIterator;
/* GENERATED CODE */import dsiter.row.ColumnType;
/* GENERATED CODE */import dsiter.row.*;
/* GENERATED CODE */
/* GENERATED CODE */import static org.junit.Assert.*;
/* GENERATED CODE */
/* GENERATED CODE */public class IteratorExpectations {
/* GENERATED CODE */
/* GENERATED CODE */    List<ColumnExpectation> expectations;
/* GENERATED CODE */    int expectedLength = -1;
/* GENERATED CODE */
/* GENERATED CODE */    public IteratorExpectations() {
/* GENERATED CODE */        expectations = new ArrayList<ColumnExpectation>();
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    public void checkIterator(IDatasetIterator iter) throws Exception {
/* GENERATED CODE */
/* GENERATED CODE */        ColumnDescriptor[] cds = iter.getColumnDescriptors();
/* GENERATED CODE */
/* GENERATED CODE */        assertEquals(expectations.size(), cds.length);
/* GENERATED CODE */
/* GENERATED CODE */        IRowAccessor[] cas = new IRowAccessor[cds.length];
/* GENERATED CODE */
/* GENERATED CODE */        for(int i=0; i<cds.length; i++) {
/* GENERATED CODE */            ColumnDescriptor cd = cds[i];
/* GENERATED CODE */            ColumnExpectation e = expectations.get(i);
/* GENERATED CODE */            assertEquals(e.name, cd.getName());
/* GENERATED CODE */            assertEquals(e.type, cd.getType());
/* GENERATED CODE */
/* GENERATED CODE */            cas[i] = cd.getAccessor();
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        int count = 0;
/* GENERATED CODE */        while(iter.tryMoveNext()) {
/* GENERATED CODE */            Row row = iter.getCurrentRow();
/* GENERATED CODE */
/* GENERATED CODE */            for(int i=0; i<cas.length; i++) {
/* GENERATED CODE */                IRowAccessor ca = cas[i];
/* GENERATED CODE */                ColumnExpectation e = expectations.get(i);
/* GENERATED CODE */
/* GENERATED CODE */                assertEquals(e.values[count], ca.getValueFromRow(row));
/* GENERATED CODE */            }
/* GENERATED CODE */
/* GENERATED CODE */            count++;
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        assertEquals(count, expectedLength);
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    private void checkLength(Object[] values) {
/* GENERATED CODE */        if (expectedLength == -1) {
/* GENERATED CODE */            expectedLength = values.length;
/* GENERATED CODE */        }
/* GENERATED CODE */        else {
/* GENERATED CODE */            assertEquals(expectedLength, values.length);
/* GENERATED CODE */        }
/* GENERATED CODE */    }
/* GENERATED CODE */
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectInts(String name, int... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new Integer(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.INT;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectLongs(String name, long... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new Long(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.LONG;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectFloats(String name, float... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new Float(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.FLOAT;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectDoubles(String name, double... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new Double(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.DOUBLE;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectStrings(String name, String... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new String(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.STRING;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectBools(String name, boolean... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new Boolean(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.BOOLEAN;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */    public void expectJsDates(String name, long... values) {
/* GENERATED CODE */        Object[] boxedVals = new Object[values.length];
/* GENERATED CODE */        for(int i=0; i<values.length; i++) {
/* GENERATED CODE */            boxedVals[i] = new Long(values[i]);
/* GENERATED CODE */        }
/* GENERATED CODE */
/* GENERATED CODE */        checkLength(boxedVals);
/* GENERATED CODE */
/* GENERATED CODE */        ColumnExpectation e = new ColumnExpectation();
/* GENERATED CODE */        e.name = name;
/* GENERATED CODE */        e.type = ColumnType.JSDATE;
/* GENERATED CODE */        e.values = boxedVals;
/* GENERATED CODE */
/* GENERATED CODE */        expectations.add(e);
/* GENERATED CODE */    }
/* GENERATED CODE */    
/* GENERATED CODE */
/* GENERATED CODE */
/* GENERATED CODE */    private static class ColumnExpectation {
/* GENERATED CODE */        public String name;
/* GENERATED CODE */        public ColumnType type;
/* GENERATED CODE */        public Object[] values;
/* GENERATED CODE */    }
/* GENERATED CODE */}
