package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;
import dsiter.reader.FileReaderFactory;
import dsiter.reader.IReaderFactory;
import dsiter.reader.StringReaderFactory;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Dataset that uses a BufferedReader to read lines from
 * a Reader. Returned rows will have a single column of
 * type `ColumnType.STRING`, named `"line"`.
 *
 * Since a new Reader must be instantiated for each created
 * iterator, the constructor takes in an IReaderFactory
 *
 * Instances can also be created via the static methods
 * `LineReaderDataset.fromString(String src)` and
 * `LineReaderDataset.fromFilename(String filename)`
 * without requiring an IReaderFactory instance.
 */
public class LineReaderDataset implements IDataset {

	IReaderFactory IReaderFactory;

	public LineReaderDataset(IReaderFactory IReaderFactory) {
		this.IReaderFactory = IReaderFactory;
	}

	public static LineReaderDataset fromString(String src) {
		return new LineReaderDataset(new StringReaderFactory(src));
	}

	public static LineReaderDataset fromFilename(String filename) {
		return new LineReaderDataset(new FileReaderFactory(filename));
	}

	@Override
	public IDatasetIterator getIterator() throws Exception {
		return new LineReaderIterator(IReaderFactory.getReader());
	}

	private class LineReaderIterator implements IDatasetIterator {

		Row row;
		BufferedReader reader;
		String line = null;
		boolean done = false;

		public LineReaderIterator(Reader r){
			reader = new BufferedReader(r);
			row = new Row();
			row.strings = new String[1];
		}

		@Override
		public boolean tryMoveNext() {
			if (done) {
				return false;
			}

			try {
				line = reader.readLine();
			}
			catch (IOException e) {
				done = true;
				return false;
			}

			return line != null;
		}

		@Override
		public Row getCurrentRow() {
			row.strings[0] = line;
			return row;
		}

		@Override
		public ColumnDescriptor[] getColumnDescriptors() {
			return new ColumnDescriptor[] {
				new ColumnDescriptor("line", ColumnType.STRING, 0)
			};
		}
	}
}
