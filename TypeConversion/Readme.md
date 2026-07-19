# ☕ Java Wrapper Classes

Wrapper classes in Java allow primitive data types to be treated as **objects**. They provide useful utility methods, support Java Collections and Generics, and simplify type conversions.

---

# 📚 Table of Contents

* What is a Wrapper Class?
* Primitive Types vs Wrapper Classes
* Why Use Wrapper Classes?
* Wrapper Class Mapping
* Common Conversions
* Autoboxing & Unboxing
* Important Methods
* Advantages & Disadvantages
* Primitive vs Wrapper Comparison
* Conversion Flow
* Example

---

# 📖 What is a Wrapper Class?

A **Wrapper Class** is a class that wraps (stores) a primitive data type inside an object.

### Example

Primitive:

```java
int age = 20;
```

Wrapper Object:

```java
Integer ageObject = Integer.valueOf(age);
```

> All wrapper classes belong to the `java.lang` package, so no import statement is required.

---

# 🔢 Primitive Types vs Wrapper Classes

| Primitive | Wrapper Class |
| --------- | ------------- |
| `byte`    | `Byte`        |
| `short`   | `Short`       |
| `int`     | `Integer`     |
| `long`    | `Long`        |
| `float`   | `Float`       |
| `double`  | `Double`      |
| `char`    | `Character`   |
| `boolean` | `Boolean`     |

---

# ❓ Why Do We Need Wrapper Classes?

Primitive data types are **not objects**, but many Java features work only with objects.

Wrapper classes are required for:

* ✅ Collection Framework (`ArrayList`, `HashMap`, etc.)
* ✅ Generics
* ✅ Utility methods
* ✅ String-to-number conversions
* ✅ Ability to store `null`
* ✅ Object-Oriented Programming

---

# 🔄 Common Conversions

| Conversion          | Method                     | Returns   |
| ------------------- | -------------------------- | --------- |
| Primitive → Wrapper | `Integer.valueOf(int)`     | `Integer` |
| String → Primitive  | `Integer.parseInt(String)` | `int`     |
| String → Wrapper    | `Integer.valueOf(String)`  | `Integer` |
| Wrapper → Primitive | `intValue()`               | `int`     |

---

# ⚡ Autoboxing

**Autoboxing** is the automatic conversion of a primitive value into its wrapper object.

```java
Integer number = 100;
```

The compiler converts it to:

```java
Integer number = Integer.valueOf(100);
```

---

# ⚡ Unboxing

**Unboxing** is the automatic conversion of a wrapper object into its primitive value.

```java
Integer number = 100;

int value = number;
```

The compiler converts it to:

```java
int value = number.intValue();
```

---

# 🛠 Important Wrapper Methods

## `Integer.valueOf(int)`

Converts a primitive `int` into an `Integer` object.

```java
int number = 50;

Integer obj = Integer.valueOf(number);
```

---

## `Integer.valueOf(String)`

Converts a numeric `String` into an `Integer` object.

```java
Integer obj = Integer.valueOf("200");
```

---

## `Integer.parseInt(String)`

Converts a numeric `String` into a primitive `int`.

```java
int value = Integer.parseInt("200");
```

---

## `intValue()`

Converts an `Integer` object back into a primitive `int`.

```java
Integer obj = Integer.valueOf(50);

int value = obj.intValue();
```

---

# 🚀 Quick Comparison

| Feature   | Autoboxing          | Unboxing            | `valueOf()`           | `parseInt()`       | `intValue()`        |
| --------- | ------------------- | ------------------- | --------------------- | ------------------ | ------------------- |
| Purpose   | Primitive → Wrapper | Wrapper → Primitive | Create Wrapper Object | String → Primitive | Wrapper → Primitive |
| Input     | Primitive           | Wrapper             | Primitive / String    | String             | Wrapper             |
| Output    | `Integer`           | `int`               | `Integer`             | `int`              | `int`               |
| Automatic | ✅ Yes               | ✅ Yes               | ❌ No                  | ❌ No               | ❌ No                |

---

# ✅ Advantages

* Supports Java Collections
* Supports Generics
* Provides many utility methods
* Can store `null`
* Makes type conversion easier

---

# ❌ Disadvantages

* Uses more memory than primitive types
* Slightly slower due to object creation
* Unnecessary for simple arithmetic operations

---

# 📊 Primitive vs Wrapper

| Primitive           | Wrapper              |
| ------------------- | -------------------- |
| Stores value        | Stores object        |
| Faster              | Slightly slower      |
| Cannot store `null` | Can store `null`     |
| No methods          | Many utility methods |
| Less memory         | More memory          |

---

# 🔧 Common Integer Methods

```java
Integer.valueOf()
Integer.parseInt()
Integer.toString()
Integer.max()
Integer.min()
Integer.compare()
Integer.sum()
Integer.intValue()
```

---

# 🔁 Conversion Flow

### Primitive → Wrapper → Primitive

```text
Primitive int
      │
      │ valueOf()
      ▼
Integer Object
      │
      │ intValue()
      ▼
Primitive int
```

---

### String → Primitive

```text
String
   │
   │ parseInt()
   ▼
Primitive int
```

---

### String → Wrapper

```text
String
   │
   │ valueOf()
   ▼
Integer Object
```

---

# 💻 Example

```java
public class WrapperDemo {

    public static void main(String[] args) {

        // Primitive
        int primitive = 10;

        // valueOf()
        Integer wrapper = Integer.valueOf(primitive);

        // Autoboxing
        Integer autoBox = primitive;

        // parseInt()
        int number = Integer.parseInt("100");

        // intValue()
        int primitiveAgain = wrapper.intValue();

        // Unboxing
        int autoUnbox = autoBox;

        System.out.println("Primitive: " + primitive);
        System.out.println("Wrapper: " + wrapper);
        System.out.println("Autoboxing: " + autoBox);
        System.out.println("parseInt(): " + number);
        System.out.println("intValue(): " + primitiveAgain);
        System.out.println("Unboxing: " + autoUnbox);
    }
}
```

---

# 📝 Summary

| Method         | Description                                                        |
| -------------- | ------------------------------------------------------------------ |
| `valueOf()`    | Creates an `Integer` object from a primitive or numeric `String`.  |
| `parseInt()`   | Converts a numeric `String` to a primitive `int`.                  |
| `intValue()`   | Extracts a primitive `int` from an `Integer` object.               |
| **Autoboxing** | Automatic conversion from a primitive to its wrapper object.       |
| **Unboxing**   | Automatic conversion from a wrapper object to its primitive value. |

---

⭐ If you found this guide helpful, consider giving the repository a **Star** on GitHub!
