# `==` vs `equals()` in Java

## Interview Definition

> `==` compares primitive values or object references. For objects, it checks whether two references point to the same memory location. `equals()` compares the logical content of objects. For example, two `String` objects created with `new String("Java")` have different references, so `==` returns `false`, but their contents are the same, so `equals()` returns `true`.

---

## Important Point

`equals()` compares objects **according to its implementation**.

By default, the implementation inherited from `Object` compares references, just like `==`.

Classes such as `String`, `Integer`, and many others override `equals()` to compare their contents instead.

---

# 1. Primitive Example

```java
int a = 10;
int b = 10;

System.out.println(a == b);      // true
```

Here `==` compares the actual values.

`equals()` cannot be used with primitive data types.

---

# 2. Object Example

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);        // false
System.out.println(s1.equals(s2));   // true
```

### Memory Representation

```text
s1 ─────► "Java"

s2 ─────► "Java"
```

`==` checks

> Are both references pointing to the same object?

Answer:

```text
false
```

`equals()` checks

> Do both objects contain the same value?

Answer:

```text
true
```

---

# 3. String Pool Example

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);      // true
System.out.println(s1.equals(s2)); // true
```

Both variables point to the same object in the String Pool.

```text
        "Java"
        ▲    ▲
        │    │
       s1   s2
```

---

# 4. Custom Class Without Overriding `equals()`

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

Student obj1 = new Student("Rahul");
Student obj2 = new Student("Rahul");

System.out.println(obj1.equals(obj2)); // false
```

Why?

Because `Student` inherits `equals()` from `Object`.

Internally, it behaves like:

```java
public boolean equals(Object obj) {
    return this == obj;
}
```

So `obj1` and `obj2` are different objects in memory.

```text
obj1 ─────► Student("Rahul")

obj2 ─────► Student("Rahul")
```

Result:

```text
false
```

---

# 5. Custom Class After Overriding `equals()`

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return this.name.equals(s.name);
    }
}

Student obj1 = new Student("Rahul");
Student obj2 = new Student("Rahul");

System.out.println(obj1.equals(obj2)); // true
```

Now `equals()` compares the `name` field instead of the object reference.

---

# Real-Life Analogy

Imagine two students each own a copy of the same book.

`==` asks

> Are they holding the exact same physical book?

`equals()` asks

> Do both books have the same content?

Different copies:

```text
==        → false
equals()  → true
```

---

# Quick Revision

| `==` | `equals()` |
|------|------------|
| Compares primitive values or object references | Compares objects according to its implementation |
| For objects, checks if references point to the same memory location | By default (`Object`), compares references |
| Cannot be overridden | Can be overridden |
| Used with primitives and objects | Used only with objects |
| `new String("Java") == new String("Java")` → `false` | `new String("Java").equals(new String("Java"))` → `true` |

---

# One-Line Interview Answer

> `==` compares primitive values or object references. For objects, it checks whether two references point to the same memory location. `equals()` compares objects according to its implementation. By default, `Object.equals()` compares references, but classes like `String`, `Integer`, and many others override it to compare their logical contents.