package dsiter.writer;

import dsiter.iterator.IDatasetIterator;
import dsiter.row.*;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.Instant;

/**
 * An implementation of {@link IWriter} that writes an
 * iterator as CSV.
 */
public class CsvWriter implements IWriter {

	private String columnSeparator;
	private String lineSeparator;
	private boolean writeHeader;

	/**
	 * Construct a CsvWriter with default
	 * parameters; equivalent to
	 * {@code new CsvWriter(",", "\n", true)}
	 */
	public CsvWriter() {
		this(",", "\n", true);
	}

	/**
	 * Construct a CsvWriter with the given {@code columnSeparator} and
	 * {@code lineSeparator}; if {@code writeHeader} is {@code true}, then
	 * output a header as the first line.
	 *
	 * @param columnSeparator The column separtor to use
	 * @param lineSeparator   The line separator to use
	 * @param writeHeader     If {@code true}, write a header as the first line, else
	 *                        only write data lines.
	 */
	public CsvWriter(String columnSeparator, String lineSeparator, boolean writeHeader) {
		this.columnSeparator = columnSeparator;
		this.lineSeparator = lineSeparator;
		this.writeHeader = writeHeader;
	}

	@Override
	public MimeType getMimeType() {
		try {
			return new MimeType("text/plain");
//			return new MimeType("text/csv");
		}
		catch (MimeTypeParseException e) {
			// This should never happen
			throw new Error("Programmer Error: failed to parse hardcoded mime type");
		}
	}

	/**
	 * Write the passed iterator to {@code outStream} as CSV
	 *
	 * @param it        The iterator to be written
	 * @param outStream The OutputStream to be written to
	 */
	@Override
	public void writeTo(IDatasetIterator it, OutputStream outStream) throws Exception {

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

		IRowAccessor[] cas = new IRowAccessor[cds.length];
		for(int i=0; i<cds.length; i++) {
			cas[i] = cds[i].getAccessor();
		}

		while(it.tryMoveNext()) {
			Row row = it.getCurrentRow();

			for(int i=0; i<cas.length; i++) {
				IRowAccessor ca = cas[i];
				ColumnType type = ca.getType();

				if(type == ColumnType.STRING) {
					out.print("\"");
					out.print(ca.getValueFromRow(row));
					out.print("\"");
				}
				else if(type == ColumnType.JSDATE) {
					Instant inst = Instant.ofEpochMilli((long)ca.getValueFromRow(row));
					out.print(inst.toString());
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
