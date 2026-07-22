# Java Set

A **Set** is a collection in Java that stores **unique elements**. It is part of the **Java Collections Framework (JCF)** and extends the `Collection` interface.

```java
Set<String> set = new HashSet<>();
```

---

# Table of Contents

- Introduction
- Features
- Set Hierarchy
- Types of Set
- Creating a Set
- Common Methods
- Traversing a Set
- Internal Working
- Time Complexity
- Set vs List
- Set Operations
- Best Practices
- Interview Questions
- Summary

---

# Introduction

A **Set** is used when duplicate elements are **not allowed**.

Examples:

- Student IDs
- Email Addresses
- Usernames
- Product IDs
- Tags
- Unique Words

---

# Features

- Stores only unique elements.
- Duplicate values are ignored.
- Part of Java Collections Framework.
- Does not support indexing.
- Order depends on implementation.
- Stores objects only.
- Can store one `null` value (`HashSet` and `LinkedHashSet`).

---

# Set Hierarchy

```
Iterable
    │
Collection
    │
   Set
    │
──────────────────────────────────
│               │                │
HashSet   LinkedHashSet      SortedSet
                                 │
                           NavigableSet
                                 │
                             TreeSet
```

---

# Types of Set

## 1. HashSet

- Most commonly used.
- Fastest implementation.
- No insertion order.
- Uses hashing.
- Allows one `null`.

```java
Set<Integer> set = new HashSet<>();
```

---

## 2. LinkedHashSet

- Maintains insertion order.
- Slightly slower than HashSet.
- Allows one `null`.

```java
Set<Integer> set = new LinkedHashSet<>();
```

---

## 3. TreeSet

- Stores elements in sorted order.
- Uses Red-Black Tree.
- Does not allow `null`.

```java
Set<Integer> set = new TreeSet<>();
```

---

# Comparison

| Feature | HashSet | LinkedHashSet | TreeSet |
|----------|----------|---------------|----------|
| Duplicate | ❌ | ❌ | ❌ |
| Order | No | Insertion | Sorted |
| Null | One | One | No |
| Speed | Fastest | Fast | Slower |
| Data Structure | Hash Table | Hash Table + Linked List | Red-Black Tree |

---

# Creating a Set

## HashSet

```java
Set<String> names = new HashSet<>();
```

## LinkedHashSet

```java
Set<String> names = new LinkedHashSet<>();
```

## TreeSet

```java
Set<String> names = new TreeSet<>();
```

---

# Common Methods

## add()

Adds an element to the Set.

```java
set.add("Apple");
```

Returns:

- `true` → Element added.
- `false` → Duplicate element.

---

## remove()

Removes an element.

```java
set.remove("Apple");
```

---

## contains()

Checks whether an element exists.

```java
set.contains("Apple");
```

---

## size()

Returns the number of elements.

```java
set.size();
```

---

## isEmpty()

Checks whether the Set is empty.

```java
set.isEmpty();
```

---

## clear()

Removes all elements.

```java
set.clear();
```

---

# Traversing a Set

## Enhanced For Loop

```java
for (String item : set)
    System.out.println(item);
```

---

## Iterator

```java
Iterator<String> it = set.iterator();
```

---

## forEach()

```java
set.forEach(System.out::println);
```

---

# Fetching Elements

A Set does **not** support indexing.

❌ Invalid

```java
set.get(0);
```

Get any element

```java
set.iterator().next();
```

Convert to List

```java
List<String> list = new ArrayList<>(set);
```

---

# Important Methods

| Method | Description |
|---------|-------------|
| add() | Adds an element |
| remove() | Removes an element |
| contains() | Checks element |
| size() | Returns size |
| clear() | Removes all elements |
| isEmpty() | Checks empty |
| iterator() | Returns iterator |
| addAll() | Adds another collection |
| removeAll() | Removes another collection |
| retainAll() | Keeps common elements |
| containsAll() | Checks collection |

---

# Internal Working

## HashSet

Internally uses a **HashMap**.

Each element is stored as a **key**.

```
HashSet
    │
    ▼
HashMap

Apple  → PRESENT
Banana → PRESENT
Orange → PRESENT
```

Duplicate keys are not allowed, so duplicate elements are ignored.

---

## LinkedHashSet

Internally uses a **LinkedHashMap**.

```
HashSet
      +
Linked List
```

Maintains insertion order.

---

## TreeSet

Internally uses a **TreeMap**.

```
TreeSet
    │
    ▼
TreeMap
    │
Red-Black Tree
```

Automatically stores elements in sorted order.

---

# Time Complexity

## HashSet

| Operation | Complexity |
|------------|------------|
| add() | O(1) Average |
| remove() | O(1) Average |
| contains() | O(1) Average |
| size() | O(1) |

---

## LinkedHashSet

| Operation | Complexity |
|------------|------------|
| add() | O(1) |
| remove() | O(1) |
| contains() | O(1) |

---

## TreeSet

| Operation | Complexity |
|------------|------------|
| add() | O(log n) |
| remove() | O(log n) |
| contains() | O(log n) |

---

# Set vs List

| Feature | Set | List |
|----------|------|------|
| Duplicate Elements | ❌ | ✅ |
| Indexing | ❌ | ✅ |
| Order | Depends | Maintained |
| get(index) | ❌ | ✅ |
| Null Values | Depends | Multiple Allowed |

---

# Set Operations

## Union

```java
set1.addAll(set2);
```

---

## Intersection

```java
set1.retainAll(set2);
```

---

## Difference

```java
set1.removeAll(set2);
```

---

# When to Use Set

Use a Set when:

- Duplicate values should not exist.
- Fast searching is required.
- Storing unique IDs.
- Removing duplicates from a collection.
- Working with mathematical set operations.
- Maintaining unique tags or categories.

---

# Best Practices

- Prefer the `Set` interface over implementation classes.

```java
Set<String> set = new HashSet<>();
```

- Use **HashSet** for best performance.
- Use **LinkedHashSet** when insertion order matters.
- Use **TreeSet** when sorted data is required.
- Override `equals()` and `hashCode()` for custom objects.
- Avoid modifying objects after adding them to a HashSet if those changes affect equality.

---

# Common Interview Questions

### What is a Set?

A collection that stores unique elements.

---

### Can a Set contain duplicates?

No.

---

### Can a Set contain null?

- HashSet → Yes (one)
- LinkedHashSet → Yes (one)
- TreeSet → No

---

### Why doesn't Set have `get(index)`?

Because Set has no indexing.

---

### Which Set maintains insertion order?

LinkedHashSet.

---

### Which Set stores sorted elements?

TreeSet.

---

### Which Set is fastest?

HashSet.

---

### What does HashSet use internally?

HashMap.

---

### Which methods are most commonly used?

- `add()`
- `remove()`
- `contains()`
- `size()`
- `clear()`
- `isEmpty()`
- `iterator()`

---

# Summary

- `Set` is an interface in the Java Collections Framework.
- It stores **unique elements**.
- Duplicate values are automatically ignored.
- `HashSet` provides the best average performance.
- `LinkedHashSet` preserves insertion order.
- `TreeSet` maintains sorted order.
- A Set does **not** support indexing.
- Common operations include `add()`, `remove()`, `contains()`, `size()`, and `clear()`.
- Sets are ideal for removing duplicates, fast lookups, and storing unique data.

---
