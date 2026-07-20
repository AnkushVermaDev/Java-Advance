# Abstraction in Java

## What is Abstraction?

**Abstraction** is one of the core principles of **Object-Oriented Programming (OOP)**. It means **hiding the implementation details** and showing only the essential functionality to the user.

### Real-Life Example

Think of **driving a car**:

- You know **how to start, stop, and accelerate** the car.
- You **don't need to know** how the engine works internally.

This is abstraction—you interact with the necessary features without worrying about the internal implementation.

Java provides abstraction using:
- **Abstract Classes**
- **Interfaces**

---

# Abstract Class

An **abstract class** is a class that contains **abstract methods (methods without a body)** and **can also contain concrete methods (methods with a body)**.

It cannot be instantiated directly and is meant to be extended by other classes.

### Definition

> An abstract class is a class that contains abstract methods (methods without a body) and can also have concrete methods (methods with a body).

> In Java, an abstract class cannot be instantiated directly. It is used as a blueprint for related classes by providing common properties and behaviors that subclasses can inherit.

> Abstract classes can also have constructors and member variables (fields), which are inherited by subclasses.

---

## Declaring an Abstract Class

Use the `abstract` keyword to declare an abstract class.

```java
abstract class Animal {

}
```

---

## Features of an Abstract Class

- ✅ Can contain **abstract methods**.
- ✅ Can contain **concrete (normal) methods**.
- ✅ Can have **constructors**.
- ✅ Can have **instance variables (fields)**.
- ✅ Can have **static methods**.
- ❌ Cannot be instantiated.

Example:

```java
Animal a = new Animal(); // Error
```

---

# Abstract Method

An **abstract method** is a method that **does not have a body**.

Only its declaration is provided, and the implementation is left for the child class.

### Syntax

```java
abstract returnType methodName();
```

### Example

```java
abstract class Animal {

    abstract void sound();

}
```

Notice:

- It has **no method body** (`{ }`).
- It ends with a semicolon (`;`).

---

## Implementing an Abstract Method

Any class extending an abstract class **must override** all its abstract methods.

```java
abstract class Animal {

    abstract void sound();

}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

}
```

---

# Concrete Method

A **concrete method** is a normal method that **contains a body (implementation)**.

### Example

```java
void eat() {
    System.out.println("Eating...");
}
```

Concrete methods are inherited normally and may be overridden unless declared `final`.

---

# Access Specifiers for Abstract Methods

An abstract method can use the following access modifiers:

| Access Specifier | Allowed |
|-----------------|----------|
| `public` | ✅ Yes |
| `protected` | ✅ Yes |
| Default (no modifier) | ✅ Yes |
| `private` | ❌ No |

---

## Why Can't an Abstract Method Be `private`?

A **private method** cannot be inherited by subclasses.

Since an abstract method **must be implemented (overridden)** by a child class, making it `private` would make overriding impossible.

Therefore, Java does **not** allow private abstract methods.

Example:

```java
abstract class Animal {

    private abstract void sound(); // Compilation Error

}
```

---

# Example of an Abstract Class

```java
abstract class Animal {

    abstract void sound();

    void eat() {
        System.out.println("Animal is eating");
    }

}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

}

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();
        d.eat();

    }

}
```

### Output

```text
Dog barks
Animal is eating
```

---

# Summary

| Feature | Abstract Class |
|---------|----------------|
| Can have abstract methods | ✅ Yes |
| Can have concrete methods | ✅ Yes |
| Can have constructors | ✅ Yes |
| Can have variables | ✅ Yes |
| Can be instantiated | ❌ No |
| Can be extended | ✅ Yes |

---

## Abstract Method vs Concrete Method

| Feature | Abstract Method | Concrete Method |
|---------|------------------|-----------------|
| Has a body | ❌ No | ✅ Yes |
| Ends with `;` | ✅ Yes | ❌ No |
| Must be overridden | ✅ Yes | ❌ No |
| Can be `public` | ✅ Yes | ✅ Yes |
| Can be `protected` | ✅ Yes | ✅ Yes |
| Can have default access | ✅ Yes | ✅ Yes |
| Can be `private` | ❌ No | ✅ Yes |

---

# Key Points

- **Abstraction** hides implementation details and exposes only essential functionality.
- Java achieves abstraction using **Abstract Classes** and **Interfaces**.
- An **abstract class** cannot be instantiated.
- An abstract class can contain both **abstract methods** and **concrete methods**.
- Every abstract method **must be implemented** by the child class.
- Abstract methods can be **public**, **protected**, or have **default access**, but **cannot be private** because private methods cannot be overridden.
- Concrete methods contain implementation and behave like normal methods.