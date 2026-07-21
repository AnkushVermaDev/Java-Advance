# Iterable in Java

## What is Iterable?

`Iterable` is an interface in Java that represents a collection of objects that can be traversed (iterated) one element at a time.

It allows an object to be used in a **for-each loop**.

```java
public interface Iterable<T> {
    Iterator<T> iterator();
}
```

The only abstract method is:

```java
Iterator<T> iterator();
```

This method returns an `Iterator` that can move through the elements.

---

## Relationship between Iterable and Iterator

```
Iterable
    |
    | iterator()
    v
Iterator
```

- **Iterable** → Can provide an iterator.
- **Iterator** → Actually moves through the elements.

---

## Why do we use Iterable?

Without `Iterable`, Java wouldn't know how to loop through an object's elements.

If a class implements `Iterable`, it promises:

> "I know how to provide an iterator."

---

## For-each Loop

The enhanced for loop works because the object implements `Iterable`.

```java
for (String car : cars) {
    System.out.println(car);
}
```

Internally, Java converts it into something similar to:

```java
Iterator<String> it = cars.iterator();

while (it.hasNext()) {
    String car = it.next();
    System.out.println(car);
}
```

---

## Common Classes that Implement Iterable

- ArrayList
- LinkedList
- HashSet
- TreeSet
- PriorityQueue
- ArrayDeque

All of these provide an `iterator()` method.

---

## Iterable vs Iterator

| Iterable | Iterator |
|----------|----------|
| Interface | Interface |
| Provides an iterator | Traverses elements |
| Has `iterator()` | Has `hasNext()`, `next()`, `remove()` |
| Used once to get an iterator | Used repeatedly to access elements |

---

## Creating Your Own Iterable

```java
import java.util.Iterator;
import java.util.List;

class Names implements Iterable<String> {

    private List<String> names = List.of("Alice", "Bob", "Charlie");

    @Override
    public Iterator<String> iterator() {
        return names.iterator();
    }
}
```

Using it:

```java
Names names = new Names();

for (String name : names) {
    System.out.println(name);
}
```

Output

```
Alice
Bob
Charlie
```

---

## Key Points

- `Iterable` is an interface.
- It contains one abstract method: `iterator()`.
- `iterator()` returns an `Iterator`.
- `Iterator` is responsible for traversing elements.
- Any class implementing `Iterable` can be used in a for-each loop.
- Collections like `ArrayList` implement `Iterable`.

---

## Memory Trick

Think of it like a **library**:

- **Iterable** = The library.
- **iterator()** = Asking the librarian for a guide.
- **Iterator** = The guide who walks you through every shelf.
- **next()** = "Show me the next book."
- **hasNext()** = "Are there more books?"



so finally An Iterable produces an Iterator, and the Iterator traverses the elements.