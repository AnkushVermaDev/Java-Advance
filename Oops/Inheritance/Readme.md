# Inheritance in Java

## Introduction

Inheritance is one of the core concepts of **Object-Oriented Programming (OOP)** in Java. It allows a class (child/subclass) to inherit the properties (fields) and behaviors (methods) of another class (parent/superclass).

Inheritance helps in:
- Reusing existing code.
- Reducing code duplication.
- Improving maintainability.
- Achieving method overriding and runtime polymorphism.

**Syntax:**
```java
class Parent {
    // Parent class members
}

class Child extends Parent {
    // Child class members
}
```

---

# Types of Inheritance in Java

## 1. Single Inheritance

In **Single Inheritance**, one child class inherits from one parent class.

```
Parent
   |
   |
 Child
```

### Example

```java
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}
```

---

## 2. Multilevel Inheritance

In **Multilevel Inheritance**, one class inherits another class, and then another class inherits from it.

```
Grandparent
      |
      |
   Parent
      |
      |
    Child
```

### Example

```java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy weeps");
    }
}
```

---

## 3. Multiple Inheritance

In **Multiple Inheritance**, one child class inherits from two or more parent classes.

```
 Parent A      Parent B
      \         /
       \       /
        \     /
         Child
```

### Note

❌ Java **does not support multiple inheritance using classes** because it can lead to ambiguity (Diamond Problem).

✅ It can be achieved using **interfaces**.

### Example

```java
interface A {
    void display();
}

interface B {
    void show();
}

class Child implements A, B {

    public void display() {
        System.out.println("Interface A");
    }

    public void show() {
        System.out.println("Interface B");
    }
}
```

---

## 4. Hierarchical Inheritance

In **Hierarchical Inheritance**, multiple child classes inherit from the same parent class.

```
        Parent
       /   |   \
      /    |    \
 Child1 Child2 Child3
```

### Example

```java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows");
    }
}
```

---

# Advantages of Inheritance

- ✅ Code Reusability
- ✅ Reduces Code Duplication
- ✅ Easy Maintenance
- ✅ Supports Method Overriding
- ✅ Helps Achieve Runtime Polymorphism
- ✅ Improves Code Organization

---

# Disadvantages of Inheritance

- ❌ Tight coupling between classes
- ❌ Changes in parent class may affect child classes
- ❌ Deep inheritance hierarchy becomes difficult to maintain

---

# Summary

| Type | Description | Supported in Java |
|------|-------------|-------------------|
| Single | One child inherits one parent | ✅ Yes |
| Multilevel | Child inherits from parent, which inherits another parent | ✅ Yes |
| Multiple | One child inherits multiple parent classes | ❌ No (Classes), ✅ Yes (Interfaces) |
| Hierarchical | Multiple child classes inherit one parent | ✅ Yes |

---

## Key Points

- Use the `extends` keyword for class inheritance.
- Java supports **Single**, **Multilevel**, and **Hierarchical** inheritance using classes.
- Java **does not support Multiple Inheritance with classes** to avoid ambiguity.
- Multiple inheritance is achieved using **interfaces** with the `implements` keyword.

---