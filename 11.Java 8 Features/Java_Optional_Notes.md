# Java `Optional` — Complete Notes

---

## 1. What is `Optional` in Java?

`Optional` is a **container object** introduced in **Java 8** that may contain a value or may be **empty**.

The main purpose of `Optional` is to handle situations where a value **might be missing** and reduce accidental `NullPointerException`s.

Think of it as:

```
Optional
   │
   ├── Has a value  → Optional contains something
   │
   └── No value     → Optional.empty()
```

---

## 2. Why Do We Need `Optional`?

Consider this normal Java code:

```java
String name = null;
System.out.println(name.length());
```

This causes:
```
NullPointerException
```

Because:
```
name
 ↓
null
 ↓
length()
 ↓
💥 NullPointerException
```

`Optional` gives us a way to explicitly represent:
> "There might be a value here, or there might not be."

---

## 3. Creating an `Optional`

There are three important ways.

### 3.1 `Optional.of()`

Use when you **know** the value is not null:

```java
Optional<String> name = Optional.of("Rahul");
```

Visualization:
```
Optional<String>
       ↓
   ┌─────────┐
   │ "Rahul" │
   └─────────┘
```

⚠️ If you do:
```java
Optional.of(null);
```
you will get a `NullPointerException`.

### 3.2 `Optional.ofNullable()`

Use when the value **may be null**.

```java
String name = null;
Optional<String> result = Optional.ofNullable(name);
```

Now:
```
Optional<String>
       ↓
   ┌──────────┐
   │  EMPTY   │
   └──────────┘
```

No `NullPointerException` is thrown merely because the value is null.

> This is the **most commonly used** way to create an `Optional` when the value may be absent.

### 3.3 `Optional.empty()`

You can explicitly create an empty `Optional`:

```java
Optional<String> result = Optional.empty();
```

Meaning: *"There is no String value."*

---

## 4. The Three Basic Creation Methods — Summary

```java
Optional.of("Rahul");      // I guarantee this value isn't null.
Optional.ofNullable(name); // This value may or may not be null.
Optional.empty();          // There is definitely no value.
```

---

## 5. Checking Whether a Value Exists

### 5.1 `isPresent()`

```java
Optional<String> name = Optional.of("Rahul");
System.out.println(name.isPresent());   // true
```

```java
Optional<String> name = Optional.empty();
System.out.println(name.isPresent());   // false
```

### 5.2 `isEmpty()` (Java 11+)

```java
Optional<String> name = Optional.empty();
System.out.println(name.isEmpty());     // true
```

```
isPresent() → "Do I have a value?"
isEmpty()   → "Do I NOT have a value?"
```

---

## 6. Getting the Value — `get()`

```java
Optional<String> name = Optional.of("Rahul");
String result = name.get();
System.out.println(result);   // Rahul
```

**But there's a problem.** If:
```java
Optional<String> name = Optional.empty();
name.get();
```
This throws:
```
NoSuchElementException
```

> ⚠️ Don't blindly use `get()`. It defeats the entire purpose of `Optional` — you're back to a null-check-style crash, just with a different exception name.

---

## 7. `orElse()` ⭐

One of the most useful methods.

```java
Optional<String> name = Optional.empty();
String result = name.orElse("Unknown");
System.out.println(result);   // Unknown
```

Visualization:
```
Optional
   ↓
Is value present?
   ↓
  NO
   ↓
Use "Unknown"
```

If the value exists:
```java
Optional<String> name = Optional.of("Rahul");
String result = name.orElse("Unknown");
// Result: Rahul
```

> `orElse("Unknown")` means: **"Give me the value; if it's absent, give me 'Unknown'."**

---

## 8. `orElseGet()`

Similar to `orElse()`, but it takes a `Supplier`.

```java
String result = name.orElseGet(() -> "Unknown");
```

```
Value exists?
   │
   ├── YES → return value
   │
   └── NO  → execute Supplier
```

```java
Optional<String> name = Optional.empty();
String result = name.orElseGet(() -> "Unknown");
// Result: Unknown
```

---

## 9. `orElse()` vs `orElseGet()` ⭐ (Common Interview Question)

**`orElse()`:**
```java
name.orElse("Unknown");
```
The fallback expression is **evaluated even if the Optional contains a value** (it's a plain method argument — Java evaluates arguments eagerly).

**`orElseGet()`:**
```java
name.orElseGet(() -> "Unknown");
```
The supplier is invoked **only when the Optional is empty**.

This matters especially when the fallback operation is **expensive or has side effects**:

```java
Optional<String> name = Optional.of("Rahul");

// BAD: getDefaultName() runs EVEN THOUGH name is present!
name.orElse(getDefaultName());

// GOOD: getDefaultName() runs ONLY if name is empty
name.orElseGet(() -> getDefaultName());
```

---

## 10. `orElseThrow()` ⭐⭐

Throws a custom exception if the value is absent, instead of returning a fallback.

**No-arg version (Java 10+)** — throws `NoSuchElementException`:
```java
String result = name.orElseThrow();
```

**With a custom exception supplier:**
```java
String result =
    name.orElseThrow(() -> new IllegalArgumentException("Name not found"));
```

```
Value exists?
   │
   ├── YES → return value
   │
   └── NO  → throw the given exception
```

This is the **preferred alternative to `get()`** whenever the absence of a value should be treated as an application error.

---

## 11. `ifPresent()`

```java
Optional<String> name = Optional.of("Rahul");

name.ifPresent(n -> System.out.println(n));   // Rahul
```

Using method reference:
```java
name.ifPresent(System.out::println);
```

This is a nice connection between **Optional + Lambda + Method Reference**.

### Visualization

If present:
```
Optional
   ↓
Has value?
   ↓
 YES
   ↓
"Rahul"
   ↓
ifPresent()
   ↓
println("Rahul")
```

If empty:
```
Optional
   ↓
Has value?
   ↓
 NO
   ↓
Do nothing
```

---

## 12. `ifPresentOrElse()` (Java 9+)

```java
Optional<String> name = Optional.empty();

name.ifPresentOrElse(
    n -> System.out.println(n),
    () -> System.out.println("Name not found")
);
```

**Output:**
```
Name not found
```

```
             Optional
                ↓
        ┌───────┴───────┐
        ↓               ↓
     Present           Empty
        ↓               ↓
   first action    second action
```

---

## 13. `map()` — Very Important ⭐⭐⭐

```java
Optional<String> name = Optional.of("Rahul");

Optional<Integer> length = name.map(String::length);
```

Visualization:
```
Optional<String>
      ↓
   "Rahul"
      ↓
     map()
      ↓
 String::length
      ↓
      5
      ↓
Optional<Integer>
```

**Without Optional:**
```java
int length = name.length();
```

**With Optional:**
```java
Optional<Integer> length = name.map(String::length);
```

> If the `Optional` is empty, `map()` **doesn't invoke** the mapping function and the result remains empty — no `NullPointerException` risk.

---

## 14. `flatMap()` ⭐⭐⭐

Used when the mapping function **itself returns an `Optional`**, to avoid ending up with a nested `Optional<Optional<T>>`.

```java
class Person {
    private Optional<Address> address;
    public Optional<Address> getAddress() { return address; }
}

class Address {
    private String city;
    public String getCity() { return city; }
}
```

**Using `map()` — produces a nested Optional (wrong tool here):**
```java
Optional<Person> person = Optional.of(new Person());

Optional<Optional<Address>> result =
    person.map(Person::getAddress);   // Optional<Optional<Address>> ❌
```

**Using `flatMap()` — flattens it into a single Optional:**
```java
Optional<Address> address =
    person.flatMap(Person::getAddress);   // Optional<Address> ✅
```

**Chaining safely to get the city:**
```java
String city =
    person.flatMap(Person::getAddress)
          .map(Address::getCity)
          .orElse("Unknown City");
```

```
map()     → wraps the function's result in Optional (may cause nesting)
flatMap() → merges/flattens an Optional-returning function's result
```

> Rule of thumb: use `map()` when the mapper returns a **plain value**; use `flatMap()` when the mapper **already returns an `Optional`**.

---

## 15. `filter()`

Used to conditionally keep or discard the value inside an `Optional`.

```java
Optional<String> name = Optional.of("Rahul");

Optional<String> result =
    name.filter(n -> n.length() > 10);

System.out.println(result.isPresent());   // false ("Rahul" has 5 chars)
```

```
Optional<String>
      ↓
   "Rahul"
      ↓
   filter(condition)
      ↓
Condition false → Optional becomes EMPTY
Condition true  → Optional keeps the value
```

If the original `Optional` is already empty, `filter()` simply returns empty — the predicate is never evaluated.

---

## 16. `or()` (Java 9+)

Returns the current `Optional` if it has a value; otherwise returns another `Optional` supplied lazily.

```java
Optional<String> name = Optional.empty();

Optional<String> result =
    name.or(() -> Optional.of("Default Name"));

System.out.println(result.get());   // Default Name
```

> Difference from `orElse()`/`orElseGet()`: `or()` returns **another `Optional`**, not a raw value — useful for chaining multiple fallback `Optional` sources.

---

## 17. `equals()` and `hashCode()`

Two `Optional` instances are equal if:
- Both are empty, **or**
- Both contain values that are `.equals()` to each other.

```java
Optional.of("Rahul").equals(Optional.of("Rahul"));   // true
Optional.empty().equals(Optional.empty());            // true
Optional.of("Rahul").equals(Optional.of("Amit"));     // false
```

---

## 18. `stream()` (Java 9+)

Converts an `Optional` into a `Stream` of 0 or 1 element — useful for combining with the Stream API.

```java
Optional<String> name = Optional.of("Rahul");

name.stream()
    .forEach(System.out::println);   // Rahul
```

Common real-world use — flattening a list of `Optional`s into present values only:

```java
List<Optional<String>> list =
    List.of(Optional.of("Rahul"), Optional.empty(), Optional.of("Amit"));

List<String> presentValues =
    list.stream()
        .flatMap(Optional::stream)
        .toList();

System.out.println(presentValues);   // [Rahul, Amit]
```

---

## 19. `Optional` Method Cheat Sheet

| Method | Purpose | Returns |
|---|---|---|
| `Optional.of(v)` | Wrap a **non-null** value | `Optional<T>` |
| `Optional.ofNullable(v)` | Wrap a value that may be null | `Optional<T>` |
| `Optional.empty()` | Explicitly empty Optional | `Optional<T>` |
| `isPresent()` | Is a value present? | `boolean` |
| `isEmpty()` | Is the Optional empty? | `boolean` |
| `get()` | Get value (throws if empty) | `T` |
| `orElse(v)` | Value or a fixed fallback (always evaluated) | `T` |
| `orElseGet(supplier)` | Value or a lazily-computed fallback | `T` |
| `orElseThrow()` / `orElseThrow(supplier)` | Value or throw exception | `T` |
| `ifPresent(consumer)` | Run action if present | `void` |
| `ifPresentOrElse(consumer, runnable)` | Run one of two actions | `void` |
| `map(function)` | Transform value if present | `Optional<R>` |
| `flatMap(function)` | Transform + flatten nested Optional | `Optional<R>` |
| `filter(predicate)` | Keep value only if condition true | `Optional<T>` |
| `or(supplier)` | Fallback to another Optional | `Optional<T>` |
| `stream()` | Convert to a 0/1-element Stream | `Stream<T>` |

---

## 20. Best Practices — How `Optional` Should (and Shouldn't) Be Used

✅ **Do:**
- Use `Optional` as a **return type** for methods where "no result" is a legitimate outcome (e.g., `findById()` in a repository).
- Chain `map()`/`filter()`/`orElse()` to avoid explicit null checks.
- Prefer `orElseGet()` over `orElse()` when the fallback is expensive.
- Use `orElseThrow()` instead of `get()` when absence should be an error.

❌ **Avoid:**
- Using `Optional` as a **field type** in classes (it's not `Serializable` and adds overhead) — use plain nullable fields with proper null checks instead.
- Using `Optional` as a **method parameter type** — it complicates the API; use method overloading instead.
- Calling `get()` without first checking `isPresent()` — this reintroduces the same crash risk `Optional` was meant to avoid.
- Wrapping collections in `Optional` — e.g., `Optional<List<T>>`. Return an **empty list** instead of an empty/absent `Optional` for collections.

```java
// ❌ Avoid
class Person {
    private Optional<String> middleName;  // don't do this
}

// ✅ Better
class Person {
    private String middleName;  // nullable, handled where needed
}
```

---

# Interview Questions with Solutions

**Q1. What is `Optional` and why was it introduced in Java 8?**
**A:** `Optional<T>` is a container object that may or may not hold a non-null value. It was introduced to make the possibility of a "missing value" **explicit in the type system**, reducing accidental `NullPointerException`s and forcing callers to consciously handle the absent case rather than assuming a value is always there.

**Q2. What is the difference between `Optional.of()` and `Optional.ofNullable()`?**
**A:** `Optional.of(value)` requires the value to be **non-null** — passing `null` throws `NullPointerException` immediately. `Optional.ofNullable(value)` safely handles both null and non-null inputs, returning `Optional.empty()` if the value is null.

**Q3. What exception does `get()` throw when the Optional is empty, and why is `get()` discouraged?**
**A:** It throws `NoSuchElementException`. It's discouraged because calling it without checking presence just replaces one type of crash (`NullPointerException`) with another (`NoSuchElementException`) — defeating the purpose of using `Optional` in the first place. Prefer `orElse()`, `orElseGet()`, `orElseThrow()`, or `ifPresent()`.

**Q4. What is the key difference between `orElse()` and `orElseGet()`?**
**A:** `orElse(value)` **always evaluates** its argument, even if the Optional already has a value present, because Java evaluates method arguments eagerly. `orElseGet(supplier)` only invokes the supplier **lazily**, when the Optional is actually empty. This matters when the fallback computation is expensive or has side effects (e.g., a database call or logging).

**Q5. When would you use `map()` vs `flatMap()` on an `Optional`?**
**A:** Use `map()` when the mapping function returns a **plain value** (`T -> R`). Use `flatMap()` when the mapping function **itself returns an `Optional`** (`T -> Optional<R>`), to avoid ending up with a nested `Optional<Optional<R>>`.

**Q6. Why shouldn't `Optional` be used as a class field or method parameter?**
**A:** `Optional` was primarily designed as a **return type** to communicate "this method might not produce a result." As a field, it adds serialization issues (it's not `Serializable`) and memory/performance overhead. As a parameter type, it complicates the calling API — method overloading or simply accepting a nullable/default value is preferred instead.

**Q7. What is the difference between `isPresent()` and `ifPresent()`?**
**A:** `isPresent()` returns a `boolean` indicating whether a value exists, typically used inside an `if` condition. `ifPresent(consumer)` directly executes a given action **only if** the value is present, avoiding the need for an explicit `if` block and manual `get()` call.

**Q8. How would you safely get a nested object's property using `Optional`, avoiding `NullPointerException`, given `Person -> Optional<Address> -> String city`?**
```java
String city =
    person.flatMap(Person::getAddress)
          .map(Address::getCity)
          .orElse("Unknown City");
```

**Q9. What does `filter()` do on an `Optional`, and what happens if the Optional is already empty?**
**A:** `filter(predicate)` keeps the value only if it satisfies the given predicate; otherwise it returns `Optional.empty()`. If the `Optional` was already empty, `filter()` simply returns empty **without evaluating the predicate at all**.

**Q10. What's the difference between `orElseGet()` and `or()`?**
**A:** `orElseGet(supplier)` returns a **raw value `T`** as the fallback. `or(supplier)` returns **another `Optional<T>`** as the fallback, which is useful when you want to keep chaining Optional-returning fallback sources instead of immediately unwrapping to a plain value.

**Q11. How can `Optional` be converted into a `Stream`? Give a practical use case.**
**A:** Via the `stream()` method (Java 9+), which converts the Optional into a Stream of 0 or 1 elements. A common use case is flattening a `List<Optional<T>>` into a `List<T>` of only the present values:
```java
List<String> present =
    listOfOptionals.stream()
                   .flatMap(Optional::stream)
                   .toList();
```

**Q12. Two `Optional<String>` instances both wrap the value `"Rahul"`. Are they `equal`? What about two empty Optionals?**
**A:** Yes to both. `Optional.equals()` returns true if both are empty, or if both hold values that are `.equals()` to each other — `Optional.of("Rahul").equals(Optional.of("Rahul"))` is `true`, and `Optional.empty().equals(Optional.empty())` is also `true`.

**Q13. Why is `Optional<List<T>>` generally considered bad practice?**
**A:** Collections already have a natural "empty" representation (an empty `List`/`Set`/`Map`). Wrapping them in `Optional` adds an unnecessary extra layer of "empty vs. absent" ambiguity — callers would need to check both `isPresent()` **and** whether the list itself is empty. It's cleaner and idiomatic to simply return an empty collection when there's nothing to return.

**Q14. What will this code print, and why?**
```java
Optional<String> name = Optional.of("Rahul");

String result = name.orElse(getExpensiveDefault());
```
**A:** It prints whatever `name` holds (`"Rahul"`), **but** `getExpensiveDefault()` still runs and its return value is computed and discarded — because `orElse()`'s argument is evaluated eagerly regardless of whether the Optional is present. This is exactly the trap `orElseGet()` avoids.

**Q15. How do you throw a custom exception if an `Optional` is empty?**
```java
User user =
    userOptional.orElseThrow(() -> new UserNotFoundException("User not found"));
```
This is the recommended alternative to `get()` whenever an absent value represents an application-level error condition that should be surfaced explicitly.

---

## Quick Revision Summary

```
Optional.of(v)        → wrap non-null value (throws if null)
Optional.ofNullable(v)→ wrap value that may be null
Optional.empty()      → explicitly empty

isPresent() / isEmpty()   → check presence
get()                     → risky, avoid
orElse(v)                 → fallback, ALWAYS evaluated
orElseGet(supplier)       → fallback, LAZILY evaluated
orElseThrow(...)          → fallback = throw exception

ifPresent(consumer)          → act if present
ifPresentOrElse(c1, c2)      → act on present or empty

map(fn)      → transform value (T -> R)
flatMap(fn)  → transform + flatten (T -> Optional<R>)
filter(pred) → keep value conditionally
or(supplier) → fallback to another Optional
stream()     → convert to 0/1-element Stream
```
