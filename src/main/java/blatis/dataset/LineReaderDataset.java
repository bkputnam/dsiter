package blatis.dataset;

import blatis.reader.FileReaderFactory;
import blatis.reader.IReaderFactory;
import blatis.iterator.AbstractDatasetIterator;
import blatis.reader.StringReaderFactory;
import blatis.row.ColumnDescriptor;
import blatis.row.ColumnType;
import blatis.row.Row;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LineReaderDataset extends AbstractDataset {

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
	public AbstractDatasetIterator getIterator() throws Exception {
		return new LineReaderIterator(IReaderFactory.getReader());
	}

	private class LineReaderIterator extends AbstractDatasetIterator {

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
