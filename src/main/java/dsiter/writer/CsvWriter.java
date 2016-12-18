package dsiter.writer;

import dsiter.iterator.IDatasetIterator;
import dsiter.row.ColumnAccessor;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by bkputnam on 12/3/16.
 */
public class CsvWriter implements IWriter {

    private String columnSeparator;
    private String lineSeparator;
    private boolean writeHeader;

    public CsvWriter() {
        this(",", "\n", true);
    }

    public CsvWriter(String columnSeparator, String lineSeparator, boolean writeHeader) {
        this.columnSeparator = columnSeparator;
        this.lineSeparator = lineSeparator;
        this.writeHeader = writeHeader;
    }

    @Override
    public void writeTo(IDatasetIterator it, OutputStream outStream) {

        PrintWriter out = new PrintWriter(outStream);

        ColumnDescriptor[] cds = it.getColumnDescriptors();

        if( writeHeader ) {
            for(int i=0; i<cds.length; i++) {
                out.print(cds[i].getName());
                if(i<cds.length-1) {
                    out.print(columnSeparator);
                }
            }
            out.print(lineSeparator);
        }

        ColumnAccessor[] cas = new ColumnAccessor[cds.length];
        for(int i=0; i<cds.length; i++) {
            cas[i] = cds[i].getAccessor();
        }

        while(it.tryMoveNext()) {
            Row row = it.getCurrentRow();

            for(int i=0; i<cas.length; i++) {
                ColumnAccessor ca = cas[i];
                ColumnType type = ca.getType();

                if(type == ColumnType.STRING) {
                    out.print("\"");
                    out.print(ca.getValueFromRow(row));
                    out.print("\"");
                }
                else {
                    out.print(ca.getValueFromRow(row));
                }

                if(i<cas.length-1) {
                    out.print(columnSeparator);
                }
            }

            out.print(lineSeparator);
            out.flush();
        }

        out.close();
    }
}
