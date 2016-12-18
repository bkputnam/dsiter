package dsiter.row;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRowCopier {

	@Test
	public void test1() {
		ColumnDescriptor[] allSrcCds = new ColumnDescriptor[] {
			new ColumnDescriptor("i1", ColumnType.INT, 0),
			new ColumnDescriptor("i2", ColumnType.INT, 1),
			new ColumnDescriptor("i3", ColumnType.INT, 2),

			new ColumnDescriptor("d1", ColumnType.DOUBLE, 0),
			new ColumnDescriptor("d2", ColumnType.DOUBLE, 1),
			new ColumnDescriptor("d3", ColumnType.DOUBLE, 2),

			new ColumnDescriptor("s1", ColumnType.STRING, 0),
			new ColumnDescriptor("s2", ColumnType.STRING, 1),
			new ColumnDescriptor("s3", ColumnType.STRING, 2)
		};

		ColumnDescriptor[] someSrcCds = new ColumnDescriptor[] {
			allSrcCds[2], // i3
			allSrcCds[5], // d3
			allSrcCds[8]  // s3
		};

		Row src = new Row();
		src.ints = new int[] { 1, 2, 3 };
		src.doubles = new double[] { 1.0, 2.0, 3.0 };
		src.strings = new String[] { "foo", "bar", "baz" };

		RowCopier copier = new RowCopier(someSrcCds);

		ColumnDescriptor[] destCds = copier.getDestColumnDescriptors();

		assertEquals("i3", destCds[0].getName());
		assertEquals(ColumnType.INT, destCds[0].getType());
		assertEquals(0, destCds[0].getRowArrayIndex());

		assertEquals("d3", destCds[1].getName());
		assertEquals(ColumnType.DOUBLE, destCds[1].getType());
		assertEquals(0, destCds[1].getRowArrayIndex());

		assertEquals("s3", destCds[2].getName());
		assertEquals(ColumnType.STRING, destCds[2].getType());
		assertEquals(0, destCds[2].getRowArrayIndex());

		RowShape destShape = copier.getDestShape();

		assertEquals(1, destShape.getNumInts());
		assertEquals(0, destShape.getNumLongs());
		assertEquals(0, destShape.getNumFloats());
		assertEquals(1, destShape.getNumDoubles());
		assertEquals(1, destShape.getNumStrings());
		assertEquals(0, destShape.getNumBools());

		Row dest = new Row(destShape);
		copier.copyTo(src, dest);

		assertEquals(3, copier.getDestColumnDescriptors()[0].getAccessor().getValueFromRow(dest));
		assertEquals(3.0, copier.getDestColumnDescriptors()[1].getAccessor().getValueFromRow(dest));
		assertEquals("baz", copier.getDestColumnDescriptors()[2].getAccessor().getValueFromRow(dest));
	}
}
