# dsiter

Yet another lazy iterator library!

## What makes this lazy iterator library different from all the other lazy iterator libraries?

This library focuses on datasets which can be iterated over; an instance of `IDataset` will return iterators over
itself. A dataset can represent almost any source of data - a database view, a CSV file, or any other sort of tabular
data where every row has the same structure. This library does not handle well datasets where rows may each have a
different structure (e.g. arrays whose size changes from row to row). It is assumed that you will want to iterate over
the same datasets several times over the course of your application (e.g. if your application is a web server that
allows access to these datasets, you'll probably want to iterate over at least one of them per request).

Datasets are not assumed to be immutable, but this library does not provide a way to mutate them. How a dataset handles
mutation while the app is running is specific to the implementation of that particular dataset class.

A few other miscellaneous features/goals may set this library apart from others:

* A focus on reusing objects (e.g. Rows) to avoid allocation and garbage collection overhead. This should improve the
	speed of the library as a whole, but adds some extra complexity in places (e.g. if you save off a reference to a
	Row object, it may change unexpectedly from iteration to iteration)
* All lazy iterator libraries allow you to chain iterators; for example you might chain a "normal" iterator to a
	`FilterIterator` if you only want to see values that match a certain condition. Most libraries allow this via
	methods like `myIterator.filter(...)` which is very nice and concise, but not extensible - there isn't a simple
	way to add your own chainable iterator classes. This library introduces the concept of pipes (modelled after pipes
	in [shell](https://en.wikipedia.org/wiki/Pipeline_(Unix)) and
	[Gulp](https://github.com/gulpjs/gulp/blob/master/docs/API.md)/[NodeJS](https://nodejs.org/api/stream.html#stream_readable_pipe_destination_options))
	to allow users to create their own chainable iterator classes. The syntax in this library is
	`myIterator.pipe(filter(...))` for standard iterators, and `myIterator.pipe(new MyPipe(...))` for custom `IPipe`
	classes.
	* Some set of "standard" iterators may be added directly to the `IDatasetIterator` API in the future, but they'll
		just be shorthand for the `.pipe(...)` syntax.

### Planned features

* Allowing iterators to "absorb" pipes. This can result in massive efficiency improvements in some cases. E.g. a database
	table iterator by default must return all rows in table. If the resulting iterator is then piped through a
	`new LastPipe()` or `new StridePipe(1000)`, the result can be a lot of waste. However, if iterators have the
	ability to absorb pipes, then the iterator can look at the next pipe and incorporate it into the query. This means
	only the required rows are returned from the database, resulting in less waste and faster iterators.


## Example

```java
import static dsiter.StdPipes.*;

IDatasetIterator it = new RangeIterator(10)
	.pipe(filter("value%2=0"));

IRowAccessor a = it.getColumnDescriptor("value").getAccessor();

while(it.tryMoveNext()) {
	Row row = it.getCurrentRow();
	int value = (int)a.getValueFromRow(row);
	System.out.println(value); // prints 0, 2, 4, 6, 8
}
```

## Is this library thread-safe?

Most datasets are probably thread-safe in the sense that multiple threads can each get their own iterators at any point
in time. However, multiple threads cannot iterate over the same iterator without some form of outside synchronization.

## Inspiration

* [LaTiS](https://github.com/latis-data/latis/)
* [LINQ's Enumerable Methods](https://msdn.microsoft.com/en-us/library/system.linq.enumerable_methods(v=vs.110).aspx)
* The `.pipe()` syntax in
	[Gulp](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
	and
	[NodeJS](https://nodejs.org/api/stream.html#stream_readable_pipe_destination_options)
	
	