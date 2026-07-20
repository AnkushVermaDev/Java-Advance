# Interface in Java

## What is an Interface?

An **Interface** is a blueprint (contract) for a class. It defines **what a class should do**, but not **how it should do it**.

Interfaces are mainly used to achieve:

- Abstraction
- Runtime Polymorphism
- Multiple Inheritance
- Loose Coupling

> **Definition:** An interface specifies a set of methods that implementing classes must provide.

---

# Interface Basics

### In Java, an interface is a blueprint for a class that contains:

- Abstract methods (methods without a body)
- Constants
- Default methods (Java 8+)
- Static methods (Java 8+)
- Private methods (Java 9+)

Basic Syntax:

```java
interface Animal {
    void sound();
}
```

Implementation:

```java
class Dog implements Animal {

    public void sound() {
        System.out.println("Dog Barks");
    }
}
```

---

# Implicit Access Modifiers

## Methods

Methods in an interface are **implicitly**:

```java
public abstract
```

Example:

```java
interface Animal {

    void sound();
}
```

Actually becomes:

```java
public abstract void sound();
```

---

## Variables

Variables in an interface are **implicitly**:

```java
public static final
```

Example:

```java
interface Student {

    int AGE = 20;
}
```

Actually becomes:

```java
public static final int AGE = 20;
```

> Interface variables are constants and cannot be modified.

---

# Members of an Interface

| Member | Default Modifier |
|----------|------------------|
| Abstract Method | `public abstract` |
| Variable | `public static final` |
| Default Method | `public` |
| Static Method | `public static` |
| Private Method | `private` (Java 9+) |

---

# Access Modifiers of Interfaces

## Top-Level Interface

Only two access modifiers are allowed:

### Public

```java
public interface Animal {

}
```

Accessible from any package.

### Default (Package-Private)

```java
interface Animal {

}
```

Accessible only within the same package.

### Not Allowed

```java
private interface Animal { }     // ❌

protected interface Animal { }   // ❌
```

**Reason:** A top-level interface has no enclosing class, so `private` and `protected` have no meaning.

---

## Nested Interface

A nested interface is declared inside another class.

```java
class Outer {

    public interface A {}

    protected interface B {}

    interface C {}

    private interface D {}
}
```

All four access modifiers are valid because the interface belongs to the enclosing class.

---

# Multiple Inheritance

Java does not support multiple inheritance with classes, but it **does** support it using interfaces.

```java
interface Camera {
    void click();
}

interface MusicPlayer {
    void play();
}

class Mobile implements Camera, MusicPlayer {

    public void click() {}

    public void play() {}
}
```

---

# Runtime Polymorphism

Interfaces support runtime polymorphism.

```java
Animal obj = new Dog();

obj.sound();
```

The interface reference can point to different implementing objects.

---

# Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|----------|-----------|----------------|
| Keyword | `implements` | `extends` |
| Multiple Inheritance | ✅ Yes | ❌ No |
| Variables | `public static final` | Any type |
| Constructor | ❌ No | ✅ Yes |
| Methods | Abstract, Default, Static, Private | Abstract + Concrete |

---

# Important Interview Points

- Interface = Contract (Blueprint)
- Uses `implements`
- Supports multiple inheritance
- Supports runtime polymorphism
- Abstract methods are `public abstract`
- Variables are `public static final`
- Default methods → Java 8
- Static methods → Java 8
- Private methods → Java 9
- Top-level interface → `public` or default only
- Nested interface → `public`, `protected`, default, `private`

---

# Summary

| Concept | Description |
|----------|-------------|
| Interface | Blueprint / Contract |
| Keyword | `implements` |
| Abstract Method | `public abstract` |
| Variable | `public static final` |
| Default Method | Java 8+ |
| Static Method | Java 8+ |
| Private Method | Java 9+ |
| Top-Level Interface | `public`, default |
| Nested Interface | `public`, `protected`, default, `private` |
| Supports | Abstraction, Multiple Inheritance, Runtime Polymorphism |