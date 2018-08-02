package dsiter.dataset;

import dsiter.iterator.IDatasetIterator;
import dsiter.iterator.StreamIterator;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * IDataset that lists all files living inside a folder recursively.
 */
public class DirectoryListDataset implements IDataset {
	private Path basePath;

	/**
	 * Create a Dataset that lists all of the files living at {@code basePath}
	 * @param basePath
	 */
	public DirectoryListDataset(Path basePath) {
		this.basePath = basePath;
	}

	/**
	 * Create a Dataset that lists all of the files living at {@code basePath}
	 * @param basePath
	 */
	public DirectoryListDataset(String basePath) {
		this(Paths.get(basePath));
	}

	@Override
	public IDatasetIterator getIterator() throws Exception {
		Stream<Path> pathStream = Files.walk(basePath)
			.filter(path -> path.toFile().isFile());
		return new PathStreamIterator(pathStream);
	}

	private class PathStreamIterator extends StreamIterator<Path> {

		public PathStreamIterator(Stream<Path> pathStream) {
			super(pathStream);
		}

		@Override
		protected void copyItemToRow(Path currentPath, Row destRow) {
			destRow.strings[0] = currentPath.toString();
			destRow.longs[0] = currentPath.toFile().length();
		}

		@Override
		public ColumnDescriptor[] getColumnDescriptors() {
			return new ColumnDescriptor[] {
				new ColumnDescriptor("filename", ColumnType.STRING, 0),
				new ColumnDescriptor("size", ColumnType.LONG, 0)
			};
		}
	}
}
