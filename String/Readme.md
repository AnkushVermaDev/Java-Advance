# ☕ Java String & StringBuilder Methods

This document covers the most commonly used **String** and **StringBuilder** methods in Java with simple explanations.

---

# 📚 String Methods

## `charAt(int index)`

Returns the character at the specified index.

```java
String str = "Hello";

System.out.println(str.charAt(1));
```

**Output**

```text
e
```

---

## `codePointAt(int index)`

Returns the Unicode (ASCII) value of the character at the specified index.

```java
String str = "A";

System.out.println(str.codePointAt(0));
```

**Output**

```text
65
```

---

## `substring(int beginIndex, int endIndex)`

Extracts a portion of the string.

```java
String str = "Programming";

System.out.println(str.substring(0, 7));
```

**Output**

```text
Program
```

> **Note**
>
> * `beginIndex` is **inclusive**.
> * `endIndex` is **exclusive**.
> * `beginIndex` **must be less than or equal to** `endIndex`.
> * If `beginIndex > endIndex`, Java throws a `StringIndexOutOfBoundsException`.

Example:

```java
str.substring(7, 0); // ❌ Error
```

---

## `compareTo(String anotherString)`

Compares two strings lexicographically (dictionary order based on Unicode values).
Lexicographically means dictionary order (alphabetical order) based on the Unicode/ASCII value of characters.
if first unicode small than other :> -1
if bigger : substracted value of it
if same : go for next charater


Returns:

* Negative value → Current string is smaller.
* Positive value → Current string is greater.
* `0` → Both strings are equal.

```java
String s1 = "Apple";
String s2 = "Banana";

System.out.println(s1.compareTo(s2));
```

---

## `endsWith(String suffix)`

Checks whether a string ends with the specified suffix.

```java
String str = "Hello.java";

System.out.println(str.endsWith(".java"));
```

**Output**

```text
true
```

---

## `contains(CharSequence sequence)`

Checks whether the string contains the specified sequence of characters.

```java
String str = "Java Programming";

System.out.println(str.contains("Programming"));
```

**Output**

```text
true
```

---

## `replace(CharSequence target, CharSequence replacement)`

Replaces all occurrences of the target string with another string.

```java
String str = "Java Programming";

System.out.println(str.replace("Java", "Python"));
```

**Output**

```text
Python Programming
```

---

## `replaceAll(String regex, String replacement)`

Replaces all matches using a **Regular Expression (Regex)**.

```java
String str = "abc123";

System.out.println(str.replaceAll("[0-9]", ""));
```

**Output**

```text
abc
```

> **Note:** `replaceAll()` treats the first argument as a **regular expression**, while `replace()` performs a literal text replacement.

---

## `toUpperCase()`

Converts all letters to uppercase.

```java
System.out.println("java".toUpperCase());
```

**Output**

```text
JAVA
```

---

## `toLowerCase()`

Converts all letters to lowercase.

```java
System.out.println("JAVA".toLowerCase());
```

**Output**

```text
java
```

---

## `trim()`

Removes leading and trailing whitespace.

```java
String str = "   Hello World   ";

System.out.println(str.trim());
```

**Output**

```text
Hello World
```

---

## `isEmpty()`

Checks whether the string is empty.

Returns `true` if its length is `0`.

```java
String str = "";

System.out.println(str.isEmpty());
```

**Output**

```text
true
```

---

## `length()`

Returns the total number of characters in the string.

```java
String str = "Hello";

System.out.println(str.length());
```

**Output**

```text
5
```

---

## `split(String delimiter)`

Splits the string into an array using the specified delimiter.

```java
String str = "Java is awesome";

String[] words = str.split(" ");
```

**Output**

```text
Java
is
awesome
```

---

# 🚀 StringBuilder Methods

`StringBuilder` is a **mutable** sequence of characters. Unlike `String`, it can be modified without creating a new object.

---

## `append(String text)`

Adds the specified text to the end of the `StringBuilder`.

```java
StringBuilder sb = new StringBuilder();

sb.append("Java");
sb.append(" Programming");
```

**Result**

```text
Java Programming
```

---

## `delete(int start, int end)`

Removes characters from the start index (inclusive) to the end index (exclusive).

```java
StringBuilder sb = new StringBuilder("Hello");

sb.delete(0, 1);
```

**Result**

```text
ello
```

---

## `deleteCharAt(int index)`

Removes the character at the specified index.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.deleteCharAt(1);
```

**Result**

```text
Hllo
```

---

## `insert(int index, String text)`

Inserts text at the specified index.

```java
StringBuilder sb = new StringBuilder("Java");

sb.insert(4, " Programming");
```

**Result**

```text
Java Programming
```

---

## `charAt(int index)`

Returns the character at the specified index.

```java
StringBuilder sb = new StringBuilder("Hello");

System.out.println(sb.charAt(1));
```

**Output**

```text
e
```

---

## `codePointAt(int index)`

Returns the Unicode value of the character at the specified index.

```java
StringBuilder sb = new StringBuilder("A");

System.out.println(sb.codePointAt(0));
```

**Output**

```text
65
```

---

## `length()`

Returns the number of characters currently stored.

```java
StringBuilder sb = new StringBuilder("Java");

System.out.println(sb.length());
```

**Output**

```text
4
```

---

## `reverse()`

Reverses the sequence of characters.

```java
StringBuilder sb = new StringBuilder("Java");

sb.reverse();
```

**Result**

```text
avaJ
```

---

## `setLength(int newLength)`

Changes the length of the `StringBuilder`.

Setting it to `0` clears all content.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.setLength(0);
```

**Result**

```text
""
```

---

## `setCharAt(int index, char ch)`

Replaces the character at the specified index.

```java
StringBuilder sb = new StringBuilder("Java");

sb.setCharAt(0, 'K');
```

**Result**

```text
Kava
```

---

# 📊 String vs StringBuilder

| Feature         | String                              | StringBuilder                     |
| --------------- | ----------------------------------- | --------------------------------- |
| Mutable         | ❌ No                                | ✅ Yes                             |
| Object Creation | New object after every modification | Same object is modified           |
| Performance     | Slower for repeated modifications   | Faster for repeated modifications |
| Thread Safe     | ✅ Yes                               | ❌ No                              |
| Best Use Case   | Read-only text                      | Frequently changing text          |

---

# 📝 Quick Summary

| Method           | Purpose                                           |
| ---------------- | ------------------------------------------------- |
| `charAt()`       | Returns a character at the specified index.       |
| `codePointAt()`  | Returns the Unicode value of a character.         |
| `substring()`    | Extracts a portion of a string.                   |
| `compareTo()`    | Compares two strings lexicographically.           |
| `endsWith()`     | Checks whether a string ends with a suffix.       |
| `contains()`     | Checks whether a string contains a sequence.      |
| `replace()`      | Replaces literal text.                            |
| `replaceAll()`   | Replaces text using a regular expression.         |
| `toUpperCase()`  | Converts all letters to uppercase.                |
| `toLowerCase()`  | Converts all letters to lowercase.                |
| `trim()`         | Removes leading and trailing whitespace.          |
| `isEmpty()`      | Checks whether a string is empty.                 |
| `length()`       | Returns the number of characters.                 |
| `split()`        | Splits a string into an array.                    |
| `append()`       | Adds text to the end of a `StringBuilder`.        |
| `delete()`       | Removes a range of characters.                    |
| `deleteCharAt()` | Removes one character at a specified index.       |
| `insert()`       | Inserts text at a specified index.                |
| `reverse()`      | Reverses the character sequence.                  |
| `setLength()`    | Changes the length or clears the `StringBuilder`. |
| `setCharAt()`    | Replaces the character at a specified index.      |

---

⭐ **If you found this guide helpful, consider giving this repository a Star on GitHub!**
