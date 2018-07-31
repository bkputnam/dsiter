# dsiter (DataSet ITERator)

A lazy interator library for datasets.

## Summary

This library implements a standard set of operations on a dataset such as `filter(condition)`, `first(n)`, `last(n)`,
`skip(n)`, `take(n)`, etc. These operations are implemented as chained iterators, so to take the first `n` rows from
your usual you would iterate over `new TakeIterator(yourDataset().getIterator(), n)` or, equivalently,
`yourDataset().getIterator().pipe(take(n))`. Here is a basic example:

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

These iterators are implemented to be lazy whenever possible; that is, they will not compute anything until they are
actually iterated over.

A Dataset instance can pull data from any source that can be broken up into rows and columns. Datasets produce Iterators
over themselves, and Iterators produce Row instances when iterated over. Row instances have a structure that describes
their columns; each column has a position within the Row, a name, and a type. All Rows returned from an Iterator will
have the same structure. Row structure is defined at runtime, not at compile time.

When an Iterator is used by another Iterator it is essentially used up - it cannot be iterated over by any other means
even if you keep a reference to it. For example, this could produce unpredictable behavior:

```java
// Create a base iterator
IDatasetIterator base = myDataset.getIterator();

// Chain another iterator on top of base. `chained` now owns `base` and `base` should no longer be used directly.
IDatasetIterator chained = new TakeIterator(base, 5);

// Use the chained iterator as usual
chained.tryMoveNext();
Row row1 = chained.getCurrentRow();

// It is not well-defined what state base will now be in
base.tryMoveNext();
Row row2 = base.getCurrentRow();
```

## Is this library thread-safe?

It is not safe to access an IDatasetIterator from multiple threads at once without some sort of blocking mechanism.

It is often possible for multiple threads to iterate over the same IDataset using separate IDatasetIterators. The
classes in this library support this capability so long as the underlying IDataset can also support it. When in doubt,
consult the manual for your IDataset.

## Documentation

TODO(bkputnam)