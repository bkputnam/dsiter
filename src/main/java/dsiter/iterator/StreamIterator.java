package dsiter.iterator;


import dsiter.pipe.IPipe;
import dsiter.row.Row;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Abstract IDatasetIterator that provides a framework for creating an IDatasetIterator from a java Stream.
 * @param <T>
 */
public abstract class StreamIterator<T> implements IDatasetIterator {
	private Stream<T> stream;
	private Iterator<T> streamIterator;
	private T currentItem;
	private Row row;

	public StreamIterator(Stream<T> stream) {
		this.stream = stream;
		this.streamIterator = stream.iterator();

		row = new Row(getColumnDescriptors());
	}

	protected abstract void copyItemToRow(T currentItem, Row destRow);

	@Override
	public boolean tryMoveNext() {
		if (streamIterator.hasNext()) {
			currentItem = streamIterator.next();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Row getCurrentRow() {
		copyItemToRow(currentItem, row);
		return row;
	}

	@Override
	public long tryGetLength() {
		return -1;
	}

	@Override
	public boolean tryAbsorb(IPipe pipe) throws Exception {
		return false;
	}

	@Override
	public void close() throws Exception {
		stream.close();
	}
}
