# dsiter

Dataset Iterator library.

Inspiration from:

* [LaTiS](https://github.com/latis-data/latis/)
* [LINQ's Enumerable Methods](https://msdn.microsoft.com/en-us/library/system.linq.enumerable_methods(v=vs.110).aspx)
* The `.pipe()` syntax in
	[Gulp](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
	and
	[NodeJS](https://nodejs.org/api/stream.html#stream_readable_pipe_destination_options)

## Example

```java
import static dsiter.StdPipes.*;

AbstractDatasetIterator it = new RangeIterator(10)
	.pipe(filter("value%2=0"));

ColumnAccessor a = it.getColumnDescriptor("value").getAccessor();

while(it.tryMoveNext()) {
	Row row = it.getCurrentRow();
	int value = (int)a.getValueFromRow(row);
	System.out.println(value); // prints 0, 2, 4, 6, 8
}
```