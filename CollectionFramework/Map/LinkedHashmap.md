# LinkedHashMap in Java

`LinkedHashMap` is a class in the Java Collections Framework that combines the **fast lookup of a HashMap** with the **predictable iteration order of a Linked List**.

> **LinkedHashMap = HashMap + Doubly Linked List**

---

# Hierarchy

```
Object
   ↓
AbstractMap<K,V>
   ↓
HashMap<K,V>
   ↓
LinkedHashMap<K,V>
```

- Extends `HashMap`
- Implements the `Map` interface
- Maintains insertion order by default
- Can also maintain access order

---

# Why LinkedHashMap?

A normal `HashMap` does **not** guarantee iteration order.

```text
Inserted:
A
B
C
```

### HashMap

```text
C
A
B
```

(Order is unpredictable)

### LinkedHashMap

```text
A
B
C
```

(Order is preserved)

---

# Internal Working

LinkedHashMap internally uses:

- **Hash Table** → Fast lookup (`O(1)`)
- **Doubly Linked List** → Maintains order

```
Hash Table

101 → Rahul
102 → Aman
103 → Priya

        │
        ▼

101 ⇄ 102 ⇄ 103
```

The linked list determines the iteration order.

---

# Declaration

```java
LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
```

Where

- `Integer` → Key
- `String` → Value

---

# Features

- Maintains insertion order
- Fast lookup (`O(1)` average)
- One `null` key allowed
- Multiple `null` values allowed
- Duplicate keys are replaced
- Duplicate values are allowed
- Not synchronized (Not Thread Safe)

---

# Constructors

### Default

```java
new LinkedHashMap<>();
```

Capacity = **16**

Load Factor = **0.75**

---

### Capacity

```java
new LinkedHashMap<>(50);
```

---

### Capacity + Load Factor

```java
new LinkedHashMap<>(50, 0.75f);
```

---

### Access Order

```java
new LinkedHashMap<>(16, 0.75f, true);
```

Third parameter:

```java
true
```

means

> Maintain **Access Order** instead of **Insertion Order**

---

# Insertion Order

Default behavior

```
put(1,A)
put(2,B)
put(3,C)
```

Iteration

```
1
2
3
```

Calling

```java
get(2);
```

does **not** change the order.

---

# Access Order

```
put(1,A)
put(2,B)
put(3,C)
```

Current order

```
1
2
3
```

Now

```java
get(2);
```

becomes

```
1
3
2
```

Recently accessed entries move to the end.

Useful for:

- LRU Cache
- Recently Viewed Items
- Browser History

---

# Time Complexity

| Operation | Complexity |
|------------|------------|
| put() | O(1) |
| get() | O(1) |
| remove() | O(1) |
| containsKey() | O(1) |
| containsValue() | O(n) |
| Iteration | O(n) |

---

# Common Methods

## Adding

```java
put(key, value)
putIfAbsent(key, value)
```

---

## Retrieving

```java
get(key)
getOrDefault(key, defaultValue)
```

---

## Updating

```java
replace(key, value)
replace(key, oldValue, newValue)
```

---

## Removing

```java
remove(key)
remove(key, value)
clear()
```

---

## Checking

```java
containsKey(key)
containsValue(value)
isEmpty()
size()
```

---

## Views

```java
keySet()
values()
entrySet()
```

---

## Iteration

```java
for(Map.Entry<K,V> entry : map.entrySet())
```

```java
for(K key : map.keySet())
```

```java
for(V value : map.values())
```

```java
map.forEach(...)
```

---

# HashMap vs LinkedHashMap

| Feature | HashMap | LinkedHashMap |
|----------|----------|---------------|
| Order | ❌ Not Guaranteed | ✅ Insertion Order |
| Lookup | O(1) | O(1) |
| Duplicate Keys | ❌ No | ❌ No |
| Duplicate Values | ✅ Yes | ✅ Yes |
| Null Key | One | One |
| Null Values | Multiple | Multiple |
| Memory Usage | Less | More |
| Performance | Slightly Faster | Slightly Slower |

---

# Real-Life Applications

- LRU Cache
- Browser History
- Recently Opened Files
- Shopping Cart
- Student Registration
- Ordered API Responses
- Configuration Files
- Maintaining insertion sequence

---

# Interview Questions

### Why use LinkedHashMap?

When you need:

- Fast searching
- Predictable iteration order

---

### Difference between HashMap and LinkedHashMap?

`HashMap` provides no ordering guarantee, while `LinkedHashMap` preserves insertion order (or access order if configured).

---

### Can LinkedHashMap store null?

✅ One `null` key

✅ Multiple `null` values

---

### Are duplicate keys allowed?

❌ No

Existing value gets replaced.

---

### Are duplicate values allowed?

✅ Yes

---

### Which is faster?

`HashMap` is slightly faster because it doesn't maintain a linked list.

---

### When should I use LinkedHashMap?

Use it whenever you need:

- Fast lookup
- Ordered iteration
- Cache implementations
- Predictable output

---

# Quick Revision

- `LinkedHashMap` extends `HashMap`
- Maintains **Insertion Order**
- Can maintain **Access Order**
- Uses **Hash Table + Doubly Linked List**
- Lookup: **O(1)**
- One `null` key
- Multiple `null` values
- Duplicate keys overwrite previous values
- Duplicate values allowed
- Slightly slower and uses more memory than `HashMap`
- Commonly used in **LRU Cache**, **History**, and **Ordered Data**



# LRU Cache Explained (Using a Bag of Books)

## What is an LRU Cache?

Imagine you have a bag that can only hold a limited number of books.

**Bag Capacity = 3 books**

The rule is simple:

- If the bag is full and a new book arrives,
- Remove the book that hasn't been used for the longest time.

This is called **Least Recently Used (LRU)**.

---

## Step 1: Put Book A

```
A
```

---

## Step 2: Put Book B

```
A
B
```

---

## Step 3: Put Book C

Now the bag is full.

```
A
B
C
```

Capacity = **3**

---

## Step 4: Read Book B

Suppose you read **Book B**.

Did you remove it?

❌ No.

Did you add it again?

❌ No.

You simply **used** it.

Your brain now thinks:

> "I just used B. I might need it again soon."

So **B becomes the most recently used book**.

The order of recent usage now becomes:

```
Least Recent          Most Recent

A  →  C  →  B
```

Notice that nothing was added or removed.
Only the **usage order** changed.

---

## Step 5: Someone Gives You Book D

Your bag is already full.

Current books:

```
A
B
C
```

You need to insert **D**.

But first, you must remove one book.

Which one should go?

### Option 1: Remove B

❌ Bad idea.

You just used it.

---

### Option 2: Remove C

🤔 Maybe...

It hasn't been used recently.

---

### Option 3: Remove A

✅ Best choice.

Why?

Because **A has not been used for the longest time.**

It is the **Least Recently Used** book.

So remove **A** and insert **D**.

Final bag:

```
C
B
D
```

Recent usage order:

```
Least Recent          Most Recent

C  →  B  →  D
```

---

# The Rule of LRU

Whenever the cache is full:

1. Find the item that has not been used for the longest time.
2. Remove it.
3. Insert the new item.

That's it.

---

# Example Timeline

| Operation | Cache | Explanation |
|-----------|-------|-------------|
| Put A | A | Add A |
| Put B | A B | Add B |
| Put C | A B C | Cache becomes full |
| Read B | A C B | B becomes most recently used |
| Put D | C B D | Remove A (least recently used) |

---

# Why is it Called "Least Recently Used"?

LRU asks only one question:

> **"Which item has not been used for the longest time?"**

That item is removed.

No other rule matters.

---

# Real-World Examples

## Web Browser

Your browser stores recently visited pages.

If memory becomes full, it removes the page you haven't visited for the longest time.

---

## CPU Cache

Processors keep frequently used data in cache.

Old, unused data is evicted first using LRU-like policies.

---

## Database Cache

Databases like Redis or Memcached may evict old keys that haven't been accessed recently.

---

## Mobile Apps

Recently opened screens or images stay in memory.

Unused ones are removed when memory is needed.

---

# Key Takeaways

- Cache has a fixed capacity.
- Every access (read or write) makes an item **most recently used**.
- If the cache is full:
  - Remove the **Least Recently Used (LRU)** item.
  - Insert the new item.
- LRU improves performance by keeping recently accessed data readily available.

---

# One-Line Definition

> **An LRU (Least Recently Used) Cache removes the item that has not been accessed for the longest time whenever the cache reaches its maximum capacity.**


# LinkedHashMap LRU Cache Using `removeEldestEntry()`

One of the most common interview questions about `LinkedHashMap` is:

> **"I never called `removeEldestEntry()`. Who called it?"**

The answer is simple:

**Java calls it internally.**

You never invoke it yourself.

---

# Example

```java
// Capacity = 3
LinkedHashMap<String, Integer> cache =
    new LinkedHashMap<String, Integer>(16, 0.75f, true) {

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return size() > 3;
        }
    };

cache.put("A", 1);
cache.put("B", 2);
cache.put("C", 3);
cache.put("D", 4);
```

After inserting `"D"`:

```
A → removed
B
C
D
```

The cache size stays **3**, making this a simple **LRU (Least Recently Used) Cache**.

---

# "Who Called `removeEldestEntry()`?"

You only wrote:

```java
cache.put("D", 4);
```

You never wrote:

```java
removeEldestEntry(...);
```

Yet it executes.

That's because **`LinkedHashMap` calls it internally** after every insertion.

Think of it exactly like method overriding in `Thread`.

---

## Example

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running...");
    }
}
```

Do you call

```java
run();
```

No.

You call

```java
thread.start();
```

Internally Java does something similar to:

```java
start()
    ↓
Java creates a new thread
    ↓
Java calls run()
```

The same idea applies here.

```
cache.put(...)
        ↓
LinkedHashMap.put(...)
        ↓
afterNodeInsertion(...)
        ↓
removeEldestEntry(...)
```

You override the method.

Java decides **when** to call it.

---

# What Happens Internally During `put()`?

When you execute

```java
cache.put("D", 4);
```

`LinkedHashMap` performs several steps.

---

## Step 1 — Calculate the Hash

Java computes

```java
"D".hashCode()
```

---

## Step 2 — Find the Bucket

Using the hash value, Java determines the bucket index.

```
bucket = hash & (table.length - 1)
```

---

## Step 3 — Insert into the Hash Table

If the bucket is empty:

```
Bucket 5

D
```

A new node is created.

If the bucket already contains entries:

- Java searches for the same key.
- If found, it updates the value.
- Otherwise, it handles the collision by linking the new node into the bucket chain (or a tree for large buckets in modern JDKs).

---

## Step 4 — Link into the Doubly Linked List

Unlike `HashMap`, every node is also connected in a doubly linked list.

For insertion order:

```
A ⇄ B ⇄ C ⇄ D
```

For access order (`true`):

Recently accessed entries move to the tail.

Example:

```
Access B

Before

A ⇄ B ⇄ C

After

A ⇄ C ⇄ B
```

---

## Step 5 — Call `removeEldestEntry()`

After the new node has been inserted, `LinkedHashMap` checks whether the eldest entry should be removed.

Internally, it performs logic equivalent to:

```java
if (removeEldestEntry(firstEntry)) {
    remove(firstEntry);
}
```

Your override:

```java
@Override
protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
    return size() > 3;
}
```

After inserting `"D"`:

```
Size = 4
```

Returns:

```java
true
```

So Java removes:

```
A
```

Final cache:

```
B
C
D
```

---

# Internal Node Structure

A `LinkedHashMap.Entry` extends the `HashMap.Node` by adding links for maintaining insertion/access order.

Each node has three important links:

```
next
before
after
```

```
                Hash Table

Bucket 3
   │
   ▼
+-------+     next      +-------+
|  A    | ----------->  |  X    |
+-------+               +-------+

Linked List

null
  ▲
  │
before
+-------+   after   +-------+   after   +-------+
|   A   | <-------> |   B   | <-------> |   C   |
+-------+           +-------+           +-------+
```

### Link Purpose

| Link | Purpose |
|------|---------|
| `next` | Connects nodes in the same hash bucket (collision handling). |
| `before` | Points to the previous node in the doubly linked list. |
| `after` | Points to the next node in the doubly linked list. |

---

# Why `LinkedHashMap` Is Perfect for an LRU Cache

An LRU cache needs two operations to be efficient:

- Fast lookup by key
- Fast removal of the least recently used entry

`LinkedHashMap` provides both:

- **Hash table** → O(1) key lookup
- **Doubly linked list** → O(1) insertion, removal, and reordering
- **`removeEldestEntry()` hook** → automatic eviction when the cache exceeds its capacity

With `accessOrder = true`, the least recently used entry is always at the head of the linked list, making eviction straightforward.

---

# Key Takeaways

- `removeEldestEntry()` is **never called directly by your code**.
- It is **automatically invoked by `LinkedHashMap` after each `put()` operation**.
- Overriding it allows you to define a custom eviction policy.
- `LinkedHashMap` combines a **hash table** for O(1) lookups with a **doubly linked list** for maintaining insertion or access order.
- Every entry contains three links:
  - `next` → bucket chain (collision handling)
  - `before` → previous entry in the linked list
  - `after` → next entry in the linked list
- This design makes `LinkedHashMap` an ideal foundation for implementing an **LRU Cache** with minimal code.