# Arrays vs ArrayList in Java

---

# 📦 Array

## What is an Array?

An **array** is a fixed-size container that stores multiple elements of the **same data type**. Before storing elements, you must specify the size of the array.

### Example

```java
int[] numbers = new int[5];
```

The above array can store exactly **5 integers**.

---

## Key Features

* **Fixed Size:** Once an array is created, its size cannot be increased or decreased.
* **Fast Access:** Elements can be accessed using their index in constant time (`O(1)`).
* **Same Data Type:** All elements must belong to the same type (e.g., all `int`, all `String`).
* **Stores Primitive and Object Types:** Arrays can store both primitive values (`int`, `char`, `double`, etc.) and objects.

---

## Drawbacks

* **Fixed Capacity:** You cannot add more elements than the declared size.
* **No Built-in Methods:** Arrays don't provide methods like `add()`, `remove()`, or `contains()`. You must write the logic yourself.
* **Manual Resizing:** If you need a larger array, you must create a new one and copy all existing elements.
* **Insertion and Deletion are Costly:** Adding or removing elements in the middle requires shifting other elements manually.

---

## When Should You Use an Array?

Use an array when:

* The number of elements is known beforehand.
* The size will not change during program execution.
* Fast index-based access is important.
* Memory usage should be minimal.

### Examples

* Days of the week
* Months of the year
* Student marks for a fixed number of subjects
* RGB color values

---

# 📦 ArrayList

**Package**

```java
java.util.ArrayList
```

---

## What is an ArrayList?

An **ArrayList** is a resizable array provided by the Java Collections Framework. Unlike an array, its size can grow or shrink automatically as elements are added or removed.

### Example

```java
ArrayList<String> names = new ArrayList<>();
```

---

### Can an ArrayList Store Different Data Types?

Normally, an `ArrayList` stores only one type of object.

```java
ArrayList<String> list = new ArrayList<>();
```

However, if you declare it as:

```java
ArrayList<Object> mixedList = new ArrayList<>();

mixedList.add("Ankush");
mixedList.add(21);
mixedList.add(true);
mixedList.add(99.5);
```

It can store different object types because every Java object ultimately inherits from the `Object` class.

> **Note:** Using `ArrayList<Object>` is generally discouraged because it reduces type safety and requires type casting when retrieving elements.

---

## Key Features

* **Dynamic Size:** Automatically grows or shrinks as elements are added or removed.
* **Rich Built-in Methods:** Provides methods like `add()`, `remove()`, `contains()`, `clear()`, `size()`, and many more.
* **Generic Support:** Stores objects of any specified type using Generics.

Examples:

```java
ArrayList<Integer>
ArrayList<String>
ArrayList<Student>
```

* **Maintains Insertion Order:** Elements remain in the order they were inserted.
* **Allows Duplicate Elements:** The same value can appear multiple times.

---

## Drawbacks

### Performance Overhead

When the internal array becomes full, the `ArrayList` creates a larger array and copies all existing elements into it. This resizing operation takes extra time.

---

### Higher Memory Usage

An `ArrayList` usually allocates extra capacity to reduce the number of resizing operations. Because of this, it may use more memory than a normal array.

---

### Slow Insertion and Deletion

Adding or removing elements in the middle of an `ArrayList` requires shifting the remaining elements.

Example:

```
Before:
[10, 20, 30, 40]

Remove 20

After:
[10, 30, 40]
```

Here, `30` and `40` must shift one position to the left.

---

## When Should You Use an ArrayList?

Use an `ArrayList` when:

* The number of elements is unknown.
* Elements need to be added or removed frequently (especially at the end).
* You want convenient built-in methods.
* Dynamic resizing is required.

### Examples

* Shopping cart
* Student list
* Contact list
* Todo list
* Chat messages
* Product catalog

---

# 📚 Commonly Used ArrayList Methods

| Method                        | Purpose                                                      |
| ----------------------------- | ------------------------------------------------------------ |
| `add(element)`                | Adds an element to the end of the list.                      |
| `add(index, element)`         | Inserts an element at a specific index.                      |
| `remove(index)`               | Removes the element at the specified index.                  |
| `remove(Object obj)`          | Removes the first occurrence of the specified object.        |
| `removeIf(predicate)`         | Removes elements that satisfy a given condition.             |
| `set(index, element)`         | Replaces the element at the specified index.                 |
| `get(index)`                  | Returns the element at the specified index.                  |
| `contains(element)`           | Checks whether an element exists in the list.                |
| `isEmpty()`                   | Returns `true` if the list contains no elements.             |
| `size()`                      | Returns the total number of elements in the list.            |
| `clear()`                     | Removes all elements from the list.                          |
| `indexOf(element)`            | Returns the index of the first occurrence of an element.     |
| `lastIndexOf(element)`        | Returns the index of the last occurrence of an element.      |
| `subList(fromIndex, toIndex)` | Returns a view of a portion of the list.                     |
| `addAll(collection)`          | Adds all elements from another collection.                   |
| `toArray()`                   | Converts the `ArrayList` into an array.                      |
| `iterator()`                  | Returns an iterator to traverse the list.                    |
| `forEach()`                   | Executes an action for each element in the list.             |
| `sort(comparator)`            | Sorts the elements of the list.                              |
| `replaceAll(operator)`        | Replaces every element using the given function.             |
| `retainAll(collection)`       | Keeps only the elements present in another collection.       |
| `removeAll(collection)`       | Removes all elements that are present in another collection. |

---

# Quick Comparison

| Feature              | Array                        | ArrayList                                                    |
| -------------------- | ---------------------------- | ------------------------------------------------------------ |
| Size                 | Fixed                        | Dynamic                                                      |
| Package              | Built into Java              | `java.util`                                                  |
| Stores               | Primitive values and Objects | Objects only (primitives use wrapper classes like `Integer`) |
| Built-in Methods     | No                           | Yes                                                          |
| Performance          | Faster                       | Slightly slower due to resizing overhead                     |
| Memory Usage         | Lower                        | Slightly higher                                              |
| Allows Duplicates    | Yes                          | Yes                                                          |
| Access by Index      | Yes                          | Yes                                                          |
| Resize Automatically | ❌ No                         | ✅ Yes                                                        |
| Generic Support      | ❌ No                         | ✅ Yes                                                        |
| Best Use Case        | Fixed-size data              | Dynamic-size data                                            |
