package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;
import dsiter.pipe.IPipe;
import dsiter.pipe.SkipPipe;
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
 * type {@code ColumnType.STRING}, named {@code "line"}.
 *
 * <p>
 *     Since a new Reader must be instantiated for each create
 *     iterator, the constructor takes in an IReaderFactory
 * </p>
 *
 * <p>
 *     Instances can also be created via the static methods
 *     {@code LineReaderDataset.fromString(String src)} and
 *     {@code LineReaderDataset.fromFilename(String filename)}
 *     without requiring an IReaderFactory instance.
 * </p>
 */
public class LineReaderDataset implements IDataset {

	private IReaderFactory IReaderFactory;

	/**
	 * Construct a LineReaderDataset from an IReaderFactory
	 *
	 * @param IReaderFactory this factory will be used to construct a
	 *                       new reader whenever getIterator() is
	 *                       called
	 */
	public LineReaderDataset(IReaderFactory IReaderFactory) {
		this.IReaderFactory = IReaderFactory;
	}

	/**
	 * Shorthand to construct a LineReaderDataset that reads
	 * lines from a string
	 *
	 * @param src the string to be iterated over as lines
	 * @return a new LineReaderDataset instance
	 */
	public static LineReaderDataset fromString(String src) {
		return new LineReaderDataset(new StringReaderFactory(src));
	}

	/**
	 * Shorthand to construct a LineReaderDataset that reads
	 * lines from a file.
	 *
	 * @param filename the filename, including the full path
	 * @return a new LineReaderDataset instance
	 */
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
		public long tryGetLength() {
			return -1;
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

		@Override
		public void close() throws Exception {
			reader.close();
		}

		@Override
		public boolean tryAbsorb(IPipe pipe) {
			if (pipe instanceof SkipPipe) {
				skipLines(((SkipPipe)pipe).getHowMany());
				return true;
			}
			else {
				return false;
			}
		}

		private void skipLines(long howMany) {
			try {
				for (long i=0; i<howMany; i++) {
					reader.readLine();
				}
			}
			catch (IOException e) {
				done = true;
			}
		}
	}
}
