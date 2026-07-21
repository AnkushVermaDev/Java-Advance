# Java Generics

## What are Generics?

Generics in Java allow you to write **classes, interfaces, and methods** that work with different data types while maintaining **type safety**.

Instead of writing separate code for `Integer`, `String`, `Double`, etc., you can write a single implementation that works with all of them.

Generics help by:

- Improving code reusability
- Providing compile-time type checking
- Reducing runtime errors
- Eliminating unnecessary type casting

A generic type is represented using angle brackets (`<>`).

```java
class Box<T> {
    T value;
}
```

Here, `T` is called a **type parameter** and acts as a placeholder for an actual type.

---

# Why Use Generics?

Before Java 5, collections stored every object as an `Object`.

Because of this, Java didn't remember the actual type of the stored object.

Whenever an element was retrieved, it had to be manually type cast.

If the cast was incorrect, the program would fail at runtime.

## Without Generics

```java
ArrayList list = new ArrayList();

list.add("Java");
list.add(100);

String language = (String) list.get(1);
```

Output

```
ClassCastException
```

The compiler cannot detect the mistake because everything is treated as an `Object`.

---

## With Generics

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");

// list.add(100); ❌ Compile-time Error

String language = list.get(0);
```

Now Java checks the type while compiling the program.

This means type errors are detected **before the program runs**.

---

# Advantages of Generics

- Type safety
- Compile-time error checking
- Eliminates explicit type casting
- Improves code reusability
- Makes code cleaner and easier to read

---

# Generic Type Parameters

A generic type parameter is written inside angle brackets.

```java
class Box<T> {

    T value;
}
```

`T` is just a convention.

Common type parameter names are:

| Type Parameter | Meaning |
|---------------|---------|
| `T` | Type |
| `E` | Element |
| `K` | Key |
| `V` | Value |
| `N` | Number (custom convention) |

---

# Generic Class

A generic class allows the same class to work with multiple data types.

```java
class Box<T> {

    private T value;

    Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

Usage

```java
Box<Integer> numberBox = new Box<>(10);

Box<String> stringBox = new Box<>("Hello");

System.out.println(numberBox.getValue());

System.out.println(stringBox.getValue());
```

Output

```
10
Hello
```

---

# Generic Methods

Methods can also be generic.

```java
class Demo {

    public static <T> void print(T value) {
        System.out.println(value);
    }
}
```

Usage

```java
Demo.print(10);

Demo.print("Java");

Demo.print(5.5);
```

Output

```
10
Java
5.5
```

---

# Bounded Type Parameters

Sometimes we don't want every data type.

We may want to allow only a particular class and its subclasses.

For this, Java provides **bounded type parameters**.

Syntax

```java
<T extends ParentClass>
```

Example

```java
class Calculator<T extends Number> {

    T value;

    Calculator(T value) {
        this.value = value;
    }

    double square() {
        return value.doubleValue() * value.doubleValue();
    }
}
```

Usage

```java
Calculator<Integer> c1 = new Calculator<>(10);

Calculator<Double> c2 = new Calculator<>(5.5);

// Calculator<String> c3 = new Calculator<>("Java"); ❌ Error
```

Only subclasses of `Number` are allowed.

---

# Generics and Inheritance

One important thing to understand is that **inheritance works differently with generics.**

Consider these classes:

```java
class Animal { }

class Dog extends Animal { }
```

---

## Normal Inheritance

A child object can always be stored in a parent reference.

```java
Animal animal = new Dog();
```

This is called **upcasting**.

It works because every `Dog` **is an** `Animal`.

---

## Does the Same Rule Apply to Generics?

Suppose we have

```java
ArrayList<Dog> dogs = new ArrayList<>();
```

Can we do this?

```java
ArrayList<Animal> animals = dogs;
```

❌ **No.**

Even though `Dog` extends `Animal`, **`ArrayList<Dog>` is NOT a subclass of `ArrayList<Animal>`**.

Similarly,

```java
Box<Dog> dogBox = new Box<>();

Box<Animal> animalBox = dogBox;
```

This is also invalid.

---

## Why?

Imagine Java allowed this.

```java
ArrayList<Dog> dogs = new ArrayList<>();

ArrayList<Animal> animals = dogs;

animals.add(new Animal());

Dog dog = dogs.get(0);
```

Now the `dogs` list contains an `Animal` that is **not** a `Dog`.

This breaks type safety.

Therefore Java prevents it.

Generic types are **invariant**.

That means

- `Dog` is a subclass of `Animal`
- `Box<Dog>` is **not** a subclass of `Box<Animal>`
- `ArrayList<Dog>` is **not** a subclass of `ArrayList<Animal>`

---

## Comparison

| Normal Classes | Generic Classes |
|----------------|-----------------|
| `Animal a = new Dog();` ✅ | `Box<Animal> b = new Box<Dog>();` ❌ |

---

## Key Point

Objects follow inheritance.

Generic types **do not**.

---

# Why Do We Need Wildcards?

We just learned that

```java
List<Dog>
```

cannot be assigned to

```java
List<Animal>
```

But what if we only want to **read** data from the list?

We don't really care whether the list stores

- Dogs
- Cats
- Animals

We simply want to process its elements.

This is where **Wildcards** become useful.

---

# Java Generic Wildcards (`?`)

A wildcard is represented using a question mark (`?`).

It represents **an unknown type**.

Syntax

```java
List<?>
```

It means

> "A list containing some unknown type."

---

# Unbounded Wildcard (`?`)

Example

```java
List<String> names = List.of("A", "B");

List<Integer> numbers = List.of(1, 2, 3);

printList(names);

printList(numbers);
```

Method

```java
public static void printList(List<?> list) {

    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

Output

```
A
B
1
2
3
```

The method works for every kind of list.

---

## Reading

```java
Object obj = list.get(0);
```

Since Java doesn't know the actual type, elements are returned as `Object`.

---

## Adding

```java
List<?> list = new ArrayList<String>();

list.add("Hello"); // ❌

list.add(10); // ❌

list.add(null); // ✅
```

Why?

The compiler only knows that the list contains **some unknown type**.

Adding objects would not be type safe.

Only `null` is allowed.

---

# Upper Bounded Wildcards (`? extends T`)

Sometimes we want a list containing only a particular class or its subclasses.

Syntax

```java
? extends Animal
```

Meaning

> Animal or any subclass of Animal.

Example

```java
class Animal { }

class Dog extends Animal { }

class Cat extends Animal { }
```

Method

```java
public static void printAnimals(List<? extends Animal> animals) {

    for (Animal animal : animals) {
        System.out.println(animal);
    }
}
```

Usage

```java
List<Dog> dogs = new ArrayList<>();

List<Cat> cats = new ArrayList<>();

printAnimals(dogs);

printAnimals(cats);
```

Both are valid.

---

## Reading

```java
Animal animal = animals.get(0);
```

Every element is guaranteed to be an `Animal`.

---

## Adding

```java
animals.add(new Dog());     // ❌

animals.add(new Cat());     // ❌

animals.add(new Animal());  // ❌
```

Why?

Suppose

```java
List<? extends Animal> animals = new ArrayList<Dog>();
```

If Java allowed

```java
animals.add(new Cat());
```

The Dog list would now contain a Cat.

Therefore adding objects is not allowed.

Only

```java
animals.add(null);
```

is permitted.

---

## Use Case

Use `? extends T` when you **only need to read** data.

Think of it as a **read-only view**.

---

# Lower Bounded Wildcards (`? super T`)

Sometimes our main goal is **adding** objects.

For that Java provides

```java
? super Dog
```

Meaning

> Dog or any superclass of Dog.

Possible types

```java
List<Dog>

List<Animal>

List<Object>
```

---

## Adding

```java
List<? super Dog> list = new ArrayList<Animal>();

list.add(new Dog());
```

Safe because every possible list can store a Dog.

---

## Reading

```java
Object obj = list.get(0);
```

You cannot do

```java
Dog dog = list.get(0);
```

because the list might actually be

```java
List<Object>
```

The compiler only guarantees that the returned value is an `Object`.

---

## Use Case

Use `? super T` when you mainly need to **add** objects.

Think of it as a **write-friendly collection**.

---

# PECS Rule

A simple rule for remembering wildcards is **PECS**.

**Producer → Extends**

If a collection **produces** values for you to read, use

```java
? extends T
```

**Consumer → Super**

If a collection **consumes** values that you add, use

```java
? super T
```

---

# Comparison

| Type | Accepts | Read As | Can Add |
|------|----------|---------|----------|
| `List<T>` | Only `T` | `T` | ✅ |
| `List<?>` | Any type | `Object` | ❌ (`null` only) |
| `List<? extends Animal>` | Animal and subclasses | `Animal` | ❌ (`null` only) |
| `List<? super Dog>` | Dog and superclasses | `Object` | ✅ `Dog` |

---

# Summary

- Generics make code reusable and type-safe.
- Generic classes and methods work with multiple data types.
- `T` is a type parameter.
- `extends` restricts generic types to a class and its subclasses.
- Generic types are **invariant**, so `List<Dog>` is **not** a `List<Animal>`.
- Wildcards (`?`) solve many inheritance-related problems with generics.
- `<?>` accepts any type but doesn't allow adding objects.
- `? extends T` is best for **reading**.
- `? super T` is best for **adding**.
- Remember the **PECS** rule:
  - **Producer → Extends**
  - **Consumer → Super**