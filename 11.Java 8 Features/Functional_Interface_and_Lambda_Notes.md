# Functional Interface & Lambda Expression — Complete Notes

---

# Part 1: Functional Interface

## 1. What is a Functional Interface?

A **functional interface** is an interface that contains **exactly one abstract method**.

It can have:
- ✅ **One** abstract method (mandatory)
- ✅ Any number of **default** methods
- ✅ Any number of **static** methods
- ✅ Methods inherited from `Object` (like `equals()`, `hashCode()`, `toString()`) **don't count** as abstract methods

```java
@FunctionalInterface
interface Greeting {
    void sayHello();          // the single abstract method

    default void greetLoudly() {   // allowed
        System.out.println("HELLO!!");
    }

    static void info() {           // allowed
        System.out.println("This is a greeting interface");
    }
}
```

> `@FunctionalInterface` is an **optional but recommended** annotation. It tells the compiler to enforce the single-abstract-method rule and throws a compile-time error if violated.

## 2. Purpose / Why Are They Needed?

- They form the **foundation for Lambda Expressions** and **Method References** in Java 8+.
- Without functional interfaces, a lambda would have nothing to "attach" to — a lambda expression is essentially a shorthand implementation of a functional interface's single method.
- They enable **functional-style programming** in Java — passing behavior (code) as data/arguments, similar to passing functions in languages like JavaScript or Python.
- They reduce boilerplate that anonymous classes required.
- They power the **Java Streams API**, event handling, and callback-driven code.

---

## 3. Four Important Built-in Functional Interfaces

Java (`java.util.function` package) provides several ready-made functional interfaces. The four most commonly used are:

| Interface | Purpose | Input | Output |
|---|---|---|---|
| `Predicate<T>` | Check something | Yes (1) | `boolean` |
| `Function<T,R>` | Convert something | Yes (1) | Result |
| `Consumer<T>` | Use something | Yes (1) | Nothing |
| `Supplier<T>` | Give something | No | Result |

### 3.1 Predicate — Check → boolean

Takes an input and returns `true` or `false`.

```java
Predicate<Integer> p = n -> n > 10;

System.out.println(p.test(15));  // true
System.out.println(p.test(5));   // false
```

**Think:** *Predicate = condition/check*

More examples:
```java
n -> n > 10
n -> n % 2 == 0
name -> name.isEmpty()
```

### 3.2 Function — Convert → Result

Takes an input and returns a **transformed** result.

```java
Function<Integer, Integer> f = n -> n * n;
System.out.println(f.apply(5));   // 25
```

**Think:** *Function = input → output*

```java
Function<String, Integer> length = s -> s.length();
System.out.println(length.apply("Hello"));   // 5
```

### 3.3 Consumer — Use → nothing

Takes an input but returns **nothing**.

```java
Consumer<String> c = name -> System.out.println(name);
c.accept("Rahul");   // Rahul
```

**Think:** *Consumer = consume/use input, no return*

```java
Consumer<Integer> c2 = n -> System.out.println(n * 2);
c2.accept(10);   // 20
```

### 3.4 Supplier — Nothing → Result

Takes **no input** but returns a result.

```java
Supplier<String> s = () -> "Hello";
System.out.println(s.get());   // Hello
```

**Think:** *Supplier = supply/give a value*

```java
Supplier<Integer> s2 = () -> 100;
System.out.println(s2.get());   // 100
```

---

## 4. Easy Way to Remember

| Interface | Input | Output | Method |
|---|---|---|---|
| `Predicate<T>` | 1 | `boolean` | `test()` |
| `Function<T,R>` | 1 | result | `apply()` |
| `Consumer<T>` | 1 | nothing | `accept()` |
| `Supplier<T>` | 0 | result | `get()` |

---

## 5. Real-Life Analogy — A Restaurant

```
Predicate  → "Is this customer above 18?"     → Yes/No
Function   → "Convert ₹100 to dollars"        → ₹1.2
Consumer   → "Print this customer's name"     → Nothing returned
Supplier   → "Give me a random number"        → Number
```

**The most important distinction:**

```
Predicate → input → true/false
Function  → input → output
Consumer  → input → nothing
Supplier  → nothing → output
```

---

# Part 2: Lambda Expression

## 1. What is a Lambda Expression?

A **lambda expression** is a short way to write the implementation of a method **without creating a separate class or anonymous class**. Introduced in **Java 8**.

It is essentially a compact way to provide the implementation of a **functional interface's single abstract method**.

## 2. Basic Syntax

```java
(parameters) -> {
    // code
}
```

Example:
```java
(a, b) -> a + b
```

This means: *take `a` and `b`, and return `a + b`.*

## 3. Simple Example

Functional interface:
```java
interface Calculator {
    int add(int a, int b);
}
```

**Using an anonymous class:**
```java
Calculator c = new Calculator() {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
};
```

**Using a lambda expression:**
```java
Calculator c = (a, b) -> a + b;
```

Much shorter! 😊

```java
System.out.println(c.add(10, 20));   // 30
```

## 4. Why Can We Use a Lambda Here?

A lambda expression can be used **only when the interface is a functional interface** — i.e., it has exactly one abstract method.

```java
@FunctionalInterface
interface Greeting {
    void sayHello();
}
```

```java
Greeting g = () -> System.out.println("Hello");
g.sayHello();   // Hello
```

## 5. Lambda With Parameters

**No parameter:**
```java
() -> System.out.println("Hello");
```

**One parameter:**
```java
name -> System.out.println(name);
```

**Multiple parameters:**
```java
(a, b) -> a + b;
```

**Multiple statements (block body):**
```java
(a, b) -> {
    int result = a + b;
    return result;
};
```

## 6. Anonymous Class vs Lambda

**Anonymous class:**
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
};
```

**Lambda:**
```java
Runnable r = () -> System.out.println("Running");
```

## 7. Easy Formula to Remember

```
Lambda = Parameters + -> + Method Body
```

Example:
```java
(a, b) -> a + b
```

- `(a, b)` → parameters
- `->` → lambda operator
- `a + b` → method body / return expression

---

## 8. Applying Lambdas to the Four Functional Interfaces (Combined View)

```java
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(8));  // true

        // Function
        Function<Integer, Integer> square = n -> n * n;
        System.out.println(square.apply(6)); // 36

        // Consumer
        Consumer<String> printer = msg -> System.out.println("Msg: " + msg);
        printer.accept("Hi there");           // Msg: Hi there

        // Supplier
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());
    }
}
```

Each of these (`Predicate`, `Function`, `Consumer`, `Supplier`) is a **functional interface**, and the code on the right of `=` in each line is a **lambda expression** implementing its single abstract method.

---

## 9. Key Rules & Points to Remember

- A lambda expression can be assigned **only** to a variable of a **functional interface type**.
- Parameter types are usually **inferred** — you don't need to declare them explicitly (`(a, b) -> a + b` instead of `(int a, int b) -> a + b`), though you can if you want.
- A single-statement lambda body doesn't need `{}` or `return` — it's an implicit expression return.
- A multi-statement lambda body **must** use `{}` and an explicit `return` (if the method returns a value).
- Lambdas can access **effectively final** variables from the enclosing scope (same restriction as anonymous classes).
- Lambdas do **not** create a new scope for `this` — `this` inside a lambda refers to the enclosing class instance (unlike anonymous classes).
- Lambdas cannot be used with interfaces that have more than one abstract method (non-functional interfaces).

---

## 10. Quick Interview Questions

1. **What makes an interface a functional interface?** Having exactly one abstract method (default/static methods and `Object` methods don't count).
2. **What is the purpose of `@FunctionalInterface`?** It's an optional annotation that lets the compiler enforce the single-abstract-method rule at compile time.
3. **Why were functional interfaces introduced?** To enable lambda expressions and functional-style programming (passing behavior as data), reducing boilerplate from anonymous classes.
4. **Difference between `Predicate` and `Function`?** `Predicate` always returns a `boolean` (a check); `Function` returns a transformed result of any type.
5. **Difference between `Consumer` and `Supplier`?** `Consumer` takes input, returns nothing; `Supplier` takes no input, returns a value.
6. **What is a lambda expression?** A concise, anonymous way of implementing the single abstract method of a functional interface.
7. **Can a lambda be used with an interface having 2 abstract methods?** No — lambdas only work with functional interfaces (exactly one abstract method).
8. **What does `this` refer to inside a lambda vs. an anonymous class?** Inside a lambda, `this` refers to the enclosing class instance; inside an anonymous class, `this` refers to the anonymous class's own instance.
9. **Can lambda parameter types be omitted?** Yes, the compiler infers them from the functional interface's method signature (type inference).
10. **What variables can a lambda access from the enclosing method?** Only **effectively final** local variables (same rule as anonymous classes).
