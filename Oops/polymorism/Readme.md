# Polymorphism in Java

## What is Polymorphism?

**Polymorphism** is one of the four fundamental concepts of Object-Oriented Programming (OOP). It allows **the same object or method to behave in different ways depending on the situation**.

- **Poly** = Many
- **Morphism** = Forms

> **Definition:** Polymorphism means **"one interface, many forms."**

---

# Types of Polymorphism

## 1. Compile-Time Polymorphism (Static Polymorphism)

Compile-time polymorphism is achieved through **Method Overloading**.

### Features

- Decision is made by the **compiler**.
- Same method name with different parameter lists.
- Faster because binding happens during compilation.

### Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

---

## 2. Run-Time Polymorphism (Dynamic Polymorphism)

Run-time polymorphism is achieved through **Method Overriding**.

### Features

- Decision is made at **runtime**.
- Parent reference points to a child object.
- The overridden method of the child class is executed.

### Example

```java
class A {
    void show() {
        System.out.println("Class A");
    }
}

class B extends A {

    @Override
    void show() {
        System.out.println("Class B");
    }
}

public class Demo {

    public static void main(String[] args) {

        A obj = new B();

        obj.show();    // Output: Class B
    }
}
```

---

# Dynamic Method Dispatch (Dynamic Method Overriding)

## Meaning

Dynamic Method Dispatch is the mechanism by which Java decides **at runtime** which overridden method should be executed.

The decision is based on **the actual object**, not the reference type.

Example:

```java
A obj = new B();
obj.show();
```

Although the reference type is `A`, the object created is `B`, so Java executes:

```java
B.show();
```

---

## Purpose

Dynamic method dispatch provides:

- Runtime Polymorphism
- Flexibility
- Code Reusability
- Extensibility
- Loose Coupling

---

## Requirements

Dynamic method overriding is possible **only if**:

- There is an **inheritance relationship** (`extends` or `implements`).
- The child class overrides the parent's method.
- A parent reference refers to a child object.

Example:

```java
A obj = new B();
```

Without inheritance, dynamic method overriding is **not possible**.

---

# instanceof Operator

The `instanceof` operator checks whether an object belongs to a particular class or interface.

It always returns a boolean value.

- `true` → Object is an instance of the specified class (or its subclass/implemented interface).
- `false` → Otherwise.

---

## Syntax

```java
objectName instanceof ClassName
```

---

## Important Points

- Works **only with objects**.
- Does **not** work with primitive data types like:
  - `int`
  - `char`
  - `double`
  - `float`
  - `boolean`
- Commonly used before type casting to avoid `ClassCastException`.

---

## Example

```java
class A {}

class B extends A {}

public class Demo {

    public static void main(String[] args) {

        A obj = new B();

        System.out.println(obj instanceof A); // true
        System.out.println(obj instanceof B); // true

        String str = "Hello";

        System.out.println(str instanceof String); // true

        int x = 10;

        // x instanceof Integer   // Compilation Error

        Integer num = x; // Autoboxing

        System.out.println(num instanceof Integer); // true
    }
}
```

---