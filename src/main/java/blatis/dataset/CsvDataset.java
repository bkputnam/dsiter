package blatis.dataset;

import blatis.iterator.AbstractDatasetIterator;
import blatis.row.*;

import java.io.*;

public class CsvDataset extends AbstractDataset {

	protected String filename;
	protected ColumnDescriptor[] cds;
	protected String columnSeparatorRegex;
	protected RowShape shape;
	protected IParserMutator[] parserMutators;

	private static String DEFAULT_COLUMN_SEPARATOR_REGEX = "\\s+";

	public CsvDataset(String filename, String columnSeparatorRegex, ColumnDescriptor[] cds) {
		this.filename = filename;
		this.columnSeparatorRegex = columnSeparatorRegex;
		this.cds = cds;

		shape = new RowShape();
		parserMutators = new IParserMutator[cds.length];
		for(int i=0; i<cds.length; i++) {
			ColumnDescriptor cd = cds[i];
			ColumnType type = cd.getType();
			shape.incrNum(type);
			parserMutators[i] = ParserMutator.getInstance(type, shape.getNum(type) - 1);
		}
	}

	public CsvDataset(String filename, ColumnDescriptor[] cds) {
		this(filename, DEFAULT_COLUMN_SEPARATOR_REGEX, cds);
	}

	public CsvDataset(String filename, String columnSeparatorRegex) throws FileNotFoundException, IOException {
		this(filename, columnSeparatorRegex, guessColumns(filename, columnSeparatorRegex));
	}

	public CsvDataset(String filename) throws FileNotFoundException, IOException {
		this(filename, DEFAULT_COLUMN_SEPARATOR_REGEX);
	}

	protected static ColumnDescriptor[] guessColumns(String filename, String columnSeparatorRegex)
		throws FileNotFoundException, IOException
	{
		BufferedReader r = new BufferedReader(new FileReader(filename));
		String firstLine = r.readLine();
		if (firstLine == null) {
			throw new IllegalArgumentException("Unable to parse CSV file (no lines)");
		}

		String secondLine = "";
		while (secondLine != null && secondLine.trim().equals("")) {
			secondLine = r.readLine();
		}
		if (secondLine == null) {
			throw new IllegalArgumentException("Unable to parse CSV file (no data)");
		}

		String[] headerNames = splitLine(firstLine, columnSeparatorRegex);
		String[] dataChunks = splitLine(secondLine, columnSeparatorRegex);
		if(headerNames.length != dataChunks.length) {
			throw new IllegalArgumentException(
				"Different number of columns in header/data (" +
					headerNames.length + "/" + dataChunks.length + ")"
			);
		}

		RowShape shape = new RowShape();
		ColumnDescriptor[] result = new ColumnDescriptor[headerNames.length];
		for(int i=0; i<headerNames.length; i++) {
			String dataChunk = dataChunks[i];
			ColumnType type = guessType(dataChunk);
			shape.incrNum(type);

			result[i] = new ColumnDescriptor(
				headerNames[i],
				type,
				shape.getNum(type) - 1
			);
		}
		return result;
	}

	protected static String[] splitLine(String line, String columnSeparatorRegex) {
		// TODO - add support for quoted strings, e.g. "Hello world" so that we don't accidentally split it into "\"Hello" and "world\""
		return line.split(columnSeparatorRegex);
	}

	protected String[] splitLine(String line) {
		return splitLine(line, columnSeparatorRegex);
	}

	protected static ColumnType guessType(String cell) {
		if(
			cell.toLowerCase().equals("true") ||
			cell.toLowerCase().equals("false")
		)
		{
			return ColumnType.BOOLEAN;
		}

		try {
			Long.parseLong(cell);
			return ColumnType.LONG;
		}
		catch (NumberFormatException e2) {
			try {
				Double.parseDouble(cell);
				return ColumnType.DOUBLE;
			}
			catch (NumberFormatException e3) {
				return ColumnType.STRING;
			}
		}
	}

	protected void parseLineToRow(String line, Row row) {
		String[] chunks = splitLine(line);
		if (chunks.length != parserMutators.length) {
			throw new IllegalArgumentException(
				"Row did not have enough columns (" + chunks.length + ", expected " + parserMutators.length + ")"
			);
		}

		for(int i=0; i<parserMutators.length; i++) {
			parserMutators[i].parseAndMutate(chunks[i], row);
		}
	}

	@Override
	public AbstractDatasetIterator getIterator() {
		return new CsvIterator();
	}

	private class CsvIterator extends AbstractDatasetIterator {

		private BufferedReader r;
		private boolean done;
		private String line;
		private Row row;

		public CsvIterator() {
			done = false;

			try {
				r = new BufferedReader(new FileReader(filename));
				String header = r.readLine();
			}
			catch (FileNotFoundException e) {
				done = true;
			}
			catch (IOException e) {
				done = true;
			}

			row = new Row(shape);
		}

		@Override
		public boolean tryMoveNext() {
			if(done) {
				return false;
			}
			else {
				try {
					line = r.readLine();
				}
				catch (IOException e) {
					done = true;
				}

				if (line==null) {
					done = true;
				}

				return !done;
			}
		}

		@Override
		public Row getCurrentRow() {
			parseLineToRow(line, row);
			return row;
		}

		@Override
		public ColumnDescriptor[] getColumnDescriptors() {
			return cds;
		}
	}
}
