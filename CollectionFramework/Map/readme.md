# Hashing in Java (`hashCode()`)

## Java Collection Hierarchy

```text
                    Iterable
                        ^
                        |
                  Collection
                        ^
                        |
        (List, Set, Queue, etc.)

             (Separate Hierarchy)

                     Map (Interface)
                         |
        ---------------------------------
        |               |               |
    HashMap         SortedMap      ConcurrentMap
        |               |               |
 LinkedHashMap      NavigableMap  ConcurrentHashMap
        |               |
        |            TreeMap
        |
 WeakHashMap
 IdentityHashMap
 EnumMap
 Hashtable (Legacy)
      |
 Properties
```

---

# What is `hashCode()`?

Every Java object inherits the `hashCode()` method from the `Object` class.

```java
public native int hashCode();
```

It returns a **32-bit integer** that represents the object.

Example:

```java
Object obj = new Object();
System.out.println(obj.hashCode());
```

Example Output:

```text
356573597
```

Another run:

```text
123456789
```

The value can change between program executions.

---

# Why do we need `hashCode()`?

Imagine storing **1,000,000 students**.

Without hashing:

```text
Student1
Student2
Student3
...
Student1000000
```

Searching for **Rahul** means checking every student one by one.

**Time Complexity:** `O(n)`

---

# Hash Buckets

Instead of one long list, Java stores objects in **buckets**.

```text
Bucket 0
Bucket 1
Bucket 2
...
Bucket 15
```

Each object is placed into a bucket using its hash code.

Searching becomes approximately:

**Time Complexity:** `O(1)`

---

# How Bucket Selection Works

Suppose:

```java
String name = "Rahul";
```

Java calculates:

```text
name.hashCode() → 787654321
```

To find the bucket:

```text
787654321 % 16 = 1
```

So the object is stored in:

```text
Bucket 1
└── Rahul
```

---

# Collision

Sometimes two objects produce the same bucket.

Example:

```text
Bucket 1
├── Rahul
└── Neha
```

This is called a **Collision**.

Java then searches only inside that bucket instead of the entire collection.

---

# Advantages of Hashing

- Fast lookup
- Fast insertion
- Efficient storage
- Used by `HashMap`, `HashSet`, and `Hashtable`

---

# Time Complexity

| Operation | Average | Worst Case |
|-----------|---------|------------|
| Search | O(1) | O(n) |
| Insert | O(1) | O(n) |
| Delete | O(1) | O(n) |

Worst case happens when many objects end up in the same bucket.

---

# Key Points

- `hashCode()` returns an integer.
- Hash code determines the bucket.
- Buckets make searching much faster.
- Multiple objects can share the same bucket (**collision**).
- `HashMap` uses `hashCode()` along with `equals()` to locate keys efficiently.


# HashMap Collision Resolution in Java

As we know what a collision is, let's focus only on how Java resolves it internally.

## Create a HashMap

```java
HashMap<String, Integer> map = new HashMap<>();
```

Internally, imagine it has **8 buckets**.

| Index (Bucket) |
|---------------:|
| 0 |
| 1 |
| 2 |
| 3 |
| 4 |
| 5 |
| 6 |
| 7 |

Initially, every bucket is empty.

```text
0 -> null
1 -> null
2 -> null
3 -> null
4 -> null
5 -> null
6 -> null
7 -> null
```

---

## Step 1: Insert Rahul

```java
map.put("Rahul", 100);
```

Suppose:

```text
"Rahul".hashCode() = 101
```

Bucket index:

```text
101 % 8 = 5
```

Java checks bucket **5**.

```text
Bucket 5 -> null
```

Since it's empty,

Java creates a `Node`.

Internally (simplified):

```java
class Node {
    int hash;
    String key;
    Integer value;
    Node next;
}
```

Java creates:

```text
Node

hash = 101
key = "Rahul"
value = 100
next = null
```

Bucket becomes:

```text
5

↓

Rahul
```

---

## Step 2: Insert Amit

```java
map.put("Amit", 200);
```

Suppose:

```text
"Amit".hashCode() = 53
```

Bucket index:

```text
53 % 8 = 5
```

Oops.

Bucket **5** already contains Rahul.

**Collision!**

Now Java does **NOT** overwrite Rahul.

Instead, it traverses the linked list (or tree, if applicable) in that bucket.

Currently:

```text
Bucket 5

Rahul
```

Java checks:

```text
Rahul.equals("Amit")
```

```text
False.
```

So Java creates another node.

```text
Bucket 5

Rahul
   |
   v
Amit
```

Notice the `next` pointer:

```text
Rahul.next

↓

Amit
```

**Collision resolved!**

---

# Java 8 Improvement

Before Java 8:

Every collision was stored as a linked list.

Problem:

If 1000 objects collided,

```text
Rahul
  ↓
Amit
  ↓
John
  ↓
...
  ↓
1000th node
```

Searching became:

```text
O(n)
```

Very slow.

# Java 8 HashMap Collision Handling

## Java 8 Solution

If too many nodes end up in the same bucket (by default, **more than 8 nodes**, and the table is sufficiently large), Java converts that linked list into a **Red-Black Tree**.

### Before

```text
Rahul
  ↓
Amit
  ↓
John
  ↓
Neha
  ↓
Raj
```

### After Treeification

```text
        John
       /    \
    Amit    Raj
    /          \
 Rahul         Neha
```

Searching now becomes approximately

```text
O(log n)
```

instead of

```text
O(n)
```

This is much faster for buckets with many collisions.

---

## How Nodes Are Connected

The current `Node`'s `next` reference points to the newly created `Node` in the same bucket.

The `hashCode` itself is just an integer stored inside each node. It never points to anything.

This is exactly how Java stores colliding entries (before treeification):

```text
Bucket 5
   │
   ▼
┌──────────┐
│ Rahul    │
│ hash=101 │
│ next ────┼──────────┐
└──────────┘          │
                      ▼
                 ┌──────────┐
                 │ Amit     │
                 │ hash=53  │
                 │ next ────┼──────────┐
                 └──────────┘          │
                                       ▼
                                  ┌──────────┐
                                  │ John     │
                                  │ hash=89  │
                                  │ next=null│
                                  └──────────┘
```

---

# BST

Imagine people entering a room one by one and standing wherever they arrive.

If everyone enters in sorted order, they end up in a long line.

```text
A
 \
  B
   \
    C
     \
      D
```

Searching takes a long time.

---

# Red-Black Tree

## Rule 1: Every new node is inserted as RED

This is the first rule.

Suppose we insert

```text
10
```

Tree

```text
10(B)
```

The first node (root) is always Black.

---

## Insert 20

Java inserts it as Red.

```text
10(B)
   \
   20(R)
```

Java didn't think

> "20 is even, make it red."

No.

Every new node starts as **RED**.

---

## Insert 30

Java first inserts it as RED.

```text
10(B)
   \
   20(R)
      \
      30(R)
```

Now there is a problem.

## Rule 2: A Red node cannot have a Red child

Current tree

```text
10(B)
   \
   20(R)
      \
      30(R)
```

Look carefully.

```text
20(R)
   ↓
30(R)
```

❌ Invalid.

Two consecutive red nodes.

Java says

> "I need to fix this."

Rotate around **10**.

After

```text
    20
   /  \
 10    30
```

Then recolor.

```text
    20(B)
   /    \
10(R)  30(R)
```

Notice something?

We inserted

```text
10
20
30
```

But Java rearranged the pointers automatically.

---

## Step 4: Insert 40

40 > 20

Go right.

40 > 30

Go right.

Temporary tree

```text
      20(B)
     /     \
 10(R)    30(R)
              \
              40(R)
```

Again,

```text
30(R)
   ↓
40(R)
```

Two consecutive red nodes.

Now Java checks the uncle.

The uncle of **40** is **10**, and **10** is Red.

Instead of rotating, Java recolors.

Result

```text
      20(B)
     /     \
10(B)     30(B)
             \
            40(R)
```

Balanced again.

---

## Step 5: Insert 50

Insert normally.

```text
      20(B)
     /     \
10(B)     30(B)
             \
            40(R)
               \
               50(R)
```

Again,

```text
Red parent
    ↓
Red child
```

Violation.

Now Java rotates.

After balancing

```text
       20(B)
      /     \
   10(B)   40(B)
           /    \
       30(R)   50(R)
```

See?

Instead of becoming a long chain,

Java reorganized it.

---

# When does HashMap use a Red-Black Tree?

In **Java 8 and later**, a bucket is converted from a **Linked List** to a **Red-Black Tree** only if **both conditions are true**.

---

## Condition 1: More than 8 nodes in the same bucket

This value is called

```text
TREEIFY_THRESHOLD = 8
```

Example

```text
Bucket 5

Rahul
 ↓
Amit
 ↓
John
 ↓
Neha
 ↓
Raj
 ↓
Ankit
 ↓
Pooja
 ↓
Karan
```

This is **8 nodes**.

If another node is added to that same bucket (making it exceed the threshold), HashMap considers treeification.

---

## Condition 2: HashMap capacity must be at least 64

This value is called

```text
MIN_TREEIFY_CAPACITY = 64
```

Suppose your HashMap currently has only **16 buckets**.

Even if one bucket has **9 colliding nodes**

```text
Bucket 5

Rahul
 ↓
Amit
 ↓
John
 ↓
...
```

Java does **NOT** convert it into a Red-Black Tree yet.

Instead, it resizes the HashMap.

For example

```text
16 buckets
      ↓
32 buckets
      ↓
64 buckets
```

Why?

Because after resizing, the colliding nodes may spread across different buckets, so a tree might no longer be necessary.

---

# Ordering Inside HashMap Tree

When a bucket is converted into a Red-Black Tree, the entries are compared **key-wise**.

Example

```text
      superking
      /       \
   Akash     zebra
```




== compares primitive values or object references. For objects, it checks whether two references point to the same memory location. equals() compares the logical content of objects. For example, two String objects created with new String("Java") have different references, so == returns false, but their contents are the same, so equals() returns true."


<<<<<<< HEAD
equals() compares objects according to its implementation. By default, the implementation inherited from Object compares references (like ==). Classes such as String, Integer, and many others override equals() to compare their contents instead."
=======
equals() compares objects according to its implementation. By default, the implementation inherited from Object compares references (like ==). Classes such as String, Integer, and many others override equals() to compare their contents instead."
>>>>>>> 5958ecc (Add : LinkedHashedMap with readme)
