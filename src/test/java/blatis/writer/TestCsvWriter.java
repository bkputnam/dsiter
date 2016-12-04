package blatis.writer;

import blatis.iterator.AbstractDatasetIterator;
import blatis.iterator.ArrayIterator;
import blatis.iterator.RenameIterator;
import blatis.iterator.ZipIterator;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by bkputnam on 12/3/16.
 */
public class TestCsvWriter {

    @Test
    public void testCsv() {
        Integer[] vals1 = new Integer[] { 1, 2, 3, 4, 5, };
        Float[] vals2 = new Float[] { 3.142f, 2.718f, 0f, 1f, -1f };
        Boolean[] vals3 = new Boolean[] { true, true, false, false, false };
        String[] vals4 = new String[] { "hello", "world", "foo", "bar", "baz" };

        AbstractDatasetIterator it1 = new RenameIterator(new ArrayIterator<Integer>(vals1), "value", "a");
        AbstractDatasetIterator it2 = new RenameIterator(new ArrayIterator<Float>(vals2), "value", "b");
        AbstractDatasetIterator it3 = new RenameIterator(new ArrayIterator<Boolean>(vals3), "value", "c");
        AbstractDatasetIterator it4 = new RenameIterator(new ArrayIterator<String>(vals4), "value", "d");

        ZipIterator it = new ZipIterator(it1, it2, it3, it4);

        OutputStream os = new ByteArrayOutputStream();
        CsvWriter csvw = new CsvWriter();
        csvw.writeTo(it, os);

        String expected =
            "a,b,c,d\n"+
            "1,3.142,true,\"hello\"\n"+
            "2,2.718,true,\"world\"\n"+
            "3,0.0,false,\"foo\"\n"+
            "4,1.0,false,\"bar\"\n"+
            "5,-1.0,false,\"baz\"\n";

        assertEquals(expected, os.toString());
    }
}
