package dsiter.iterator;

import dsiter.pipe.IPipe;
import dsiter.pipe.SkipPipe;
import dsiter.row.ColumnDescriptor;
import dsiter.row.ColumnType;
import dsiter.row.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class DirectoryListIterator implements IDatasetIterator {

	private Stream<Path> pathStream;
	private Iterator<Path> paths;

	private Path basePath;
	private Path currentPath = null;

	private Row row;

	public DirectoryListIterator(String dirName) throws IOException {
		basePath = Paths.get(dirName);
		pathStream = Files.walk(basePath)
			.filter(path -> path.toFile().isFile());
		paths = pathStream.iterator();

		row = new Row();
		row.strings = new String[1]; // filename
		row.longs = new long[1]; // size
	}

	@Override
	public boolean tryMoveNext() {
		if (paths.hasNext()) {
			currentPath = paths.next();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Row getCurrentRow() throws Exception {
		row.strings[0] = currentPath.toString();
		row.longs[0] = currentPath.toFile().length();
		return row;
	}

	@Override
	public long tryGetLength() {
		return -1;
	}

	@Override
	public ColumnDescriptor[] getColumnDescriptors() {
		return new ColumnDescriptor[] {
			new ColumnDescriptor("filename", ColumnType.STRING, 0),
			new ColumnDescriptor("size", ColumnType.LONG, 0)
		};
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) {
		// Can't absorb a SkipPipe more efficiently than just repeatedly calling tryMoveNext
		return false;
	}

	@Override
	public void close() throws Exception {
		pathStream.close();
	}
}
