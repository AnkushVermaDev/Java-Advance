# Java Access Specifiers & Class Modifiers

## 1. Top-Level Class (Outer Class)

### Allowed
- `public`
- `default` (no modifier)

### Not Allowed
- `private`
- `protected`
- `static`

**Example**
```java
public class Bank { }   // ✅
class Bank { }          // ✅
private class Bank { }  // ❌
protected class Bank { }// ❌
static class Bank { }   // ❌
```

---

## 2. Methods (Inside a Class)

### Access Modifiers
- `public`
- `private`
- `protected`
- `default` (no modifier)

### Other Modifiers
- `static`
- `final`
- `abstract` *(only in abstract classes/interfaces)*
- `synchronized`
- `native`
- `strictfp` *(rarely used)*

---

## 3. Inner (Nested) Classes

### Allowed
- `public`
- `private`
- `protected`
- `default`
- `static` *(only for nested classes)*

**Example**
```java
class Outer {

    private class A { }

    protected class B { }

    public class C { }

    static class D { }
}
```

---

# Access Specifiers (One-Line Purpose)

| Specifier | Purpose |
|-----------|---------|
| **public** | Accessible from everywhere. |
| **private** | Accessible only within the same class. |
| **protected** | Accessible within the same package and by subclasses in other packages. |
| **default** | Accessible only within the same package. |
| **static** | Belongs to the class, not to an object. |

---

# Access Matrix

| Modifier | Same Class | Same Package | Subclass (Other Package) | Other Package |
|----------|:----------:|:------------:|:------------------------:|:-------------:|
| `private` | ✅ | ❌ | ❌ | ❌ |
| `default` | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

---

# Quick Interview Notes

- Top-level classes can only be `public` or `default`.
- `protected` is mainly used for inheritance.
- `private` members cannot be inherited directly.
- `static` members belong to the class, not objects.
- A `protected` method can be accessed:
  - ✅ From the same package.
  - ✅ From subclasses in different packages.
  - ❌ From non-subclasses in different packages.

---

## Example

```java
Bank user = new Bank();

user.display();      // ✅ public
user.printer();      // ✅ same package (protected)
user.privatemsg();   // ❌ private
Bank.usercontrol();  // ✅ static
```