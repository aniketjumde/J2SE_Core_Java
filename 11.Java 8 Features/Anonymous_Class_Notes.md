# Anonymous Class in Java — Complete Notes

## 1. What is an Anonymous Class?

An **anonymous class** is a class without a name that is **declared and instantiated in a single expression**. It has no separate `.java` class definition — it is defined inline, usually to implement an interface or extend a class for **one-time use**.

- It is a special form of a **local inner class**.
- It doesn't have a constructor of its own (it uses the constructor of the parent class/interface implicitly).
- It can be instantiated only once, at the point of declaration.

---

## 2. Why Use an Anonymous Class?

- Avoids creating a separate named class just for one-time use.
- Keeps code shorter and closer to where it is actually used.
- Commonly used for:
  - Event handling (e.g., GUI button clicks)
  - Callbacks / listeners
  - Thread creation (`Runnable`)
  - Comparator implementations for sorting
  - Simple, throwaway custom behavior

---

## 3. Syntax

```java
ClassOrInterfaceName obj = new ClassOrInterfaceName() {
    // field declarations
    // method overrides
};
```

---

## 4. Example — Implementing an Interface

Interface:
```java
interface Greeting {
    void sayHello();
}
```

**Without anonymous class** (named class approach):
```java
class EnglishGreeting implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeting g = new EnglishGreeting();
        g.sayHello();
    }
}
```

**With anonymous class:**
```java
public class Main {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello!");
            }
        };
        g.sayHello();
    }
}
```

Here, `new Greeting() { ... }` creates an **unnamed class implementing `Greeting`** and instantiates it immediately.

---

## 5. Example — Extending a Class

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            @Override
            void sound() {
                System.out.println("Bark");
            }
        };
        dog.sound();   // Output: Bark
    }
}
```

An anonymous class can **override methods** of the parent class it extends, similar to overriding interface methods.

---

## 6. Example — Anonymous Class with Runnable (Threading)

```java
public class Main {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running via anonymous class");
            }
        };
        new Thread(task).start();
    }
}
```

## 7. Example — Anonymous Class with Comparator

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println(names); // [Apple, Banana, Cherry]
    }
}
```

---

## 8. When to Use Anonymous Classes

**Use them when:**
- You need an object only once.
- The implementation is small and simple.
- Creating a separate named class would be unnecessary overhead.

**Avoid them when:**
- The implementation is large or complex (hurts readability).
- You need to reuse the same behavior elsewhere.
- The interface has a single abstract method and a **lambda** would be clearer (Java 8+).

---

## 9. Anonymous Class vs Lambda Expression (Java 8+)

| Aspect | Anonymous Class | Lambda Expression |
|---|---|---|
| Applicable to | Any interface (single or multiple methods), abstract classes, concrete classes | Only **functional interfaces** (single abstract method) |
| `this` keyword | Refers to the anonymous class instance | Refers to the enclosing class instance |
| Bytecode | Generates a separate `.class` file (e.g., `Main$1.class`) | Uses `invokedynamic`; no separate class file generated at compile time |
| Verbosity | More verbose | Concise |
| Fields/State | Can declare instance variables/state | Cannot declare instance fields (it's just a function body) |
| Constructors | Can technically have instance initializer blocks | Not applicable — no constructors |

**Example comparison:**
```java
// Anonymous class
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running...");
    }
};

// Lambda (preferred for functional interfaces)
Runnable r2 = () -> System.out.println("Running...");
```

---

## 10. Key Characteristics / Rules

- Cannot have an explicit constructor (no name to give it).
- Cannot be `static` (unless declared inside a static context implicitly through enclosing scope) and cannot declare static members except constants (`static final`).
- Can access **effectively final** local variables of the enclosing method.
- Can access instance members of the enclosing class.
- Compiles into a separate class file named like `Outer$1.class`, `Outer$2.class`, etc.
- Can extend a class **or** implement an interface — **not both simultaneously**, and only **one** interface at a time.
- If the superclass/interface has multiple abstract methods, all must be implemented.

---

## 11. Anonymous Class Capturing Local Variables

```java
public class Main {
    public static void main(String[] args) {
        int count = 10; // must be effectively final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Count is: " + count);
            }
        };
        r.run();
    }
}
```

If `count` is modified after being captured (e.g., `count = 20;`), the code **won't compile**, because local variables used inside an anonymous class must be **effectively final**.

---

# Interview Questions on Anonymous Classes

### Basic / Conceptual

1. **What is an anonymous class in Java?**
   A class without a name, declared and instantiated in a single expression, typically used for one-time implementations of an interface or subclassing.

2. **Why do we need anonymous classes when named classes already exist?**
   To avoid boilerplate of creating a separate class file for a one-time-use implementation, keeping code concise and localized.

3. **Can an anonymous class implement more than one interface?**
   No. An anonymous class can implement only **one** interface or extend only **one** class — not both, and not multiple interfaces.

4. **Can an anonymous class have a constructor?**
   No, because it has no name. However, it can have **instance initializer blocks** that act like a constructor.

5. **Can an anonymous class extend a class and implement an interface simultaneously?**
   No, it can do only one of the two — either extend a class, or implement an interface.

6. **Is an anonymous class a type of inner class?**
   Yes, it is a special case of a local inner class without a name.

### Intermediate

7. **How does the compiler treat an anonymous class internally?**
   The compiler generates a separate `.class` file for it, typically named `EnclosingClass$1.class`, `EnclosingClass$2.class`, and so on (numbered in order of appearance).

8. **Can an anonymous class access variables from its enclosing scope?**
   Yes — it can access instance variables of the enclosing class freely, and **local variables** of the enclosing method only if they are **final or effectively final**.

9. **Why must local variables accessed by an anonymous class be effectively final?**
   Because the anonymous class instance may outlive the method call (e.g., if passed to a thread or stored elsewhere), and the JVM captures a **copy** of the variable at the time of creation — allowing mutation would cause inconsistent state between the copy and the original.

10. **Can an anonymous class have static members?**
    It can only have `static final` (constant) fields, not other static methods or variables, because anonymous classes are tied to an instance context.

11. **What is the difference between a local inner class and an anonymous class?**
    A local inner class has a name and is defined within a method body; it can be instantiated multiple times and can have its own constructors. An anonymous class has no name, is defined and instantiated in one step, and can be instantiated only once.

12. **Can you create multiple objects of the same anonymous class?**
    No. Since it's declared and instantiated inline in a single expression, you get only one object from that declaration site — though the underlying generated class *could* be reused across separate `new X(){}` expressions with identical bodies (rare/compiler-dependent, generally treated as distinct).

### Advanced

13. **When would you prefer an anonymous class over a lambda expression?**
    - When implementing an interface with more than one abstract method.
    - When extending an abstract or concrete class (lambdas only work with functional interfaces).
    - When you need to declare instance fields or additional helper methods within the implementation.

14. **What is the value of `this` inside an anonymous class?**
    `this` refers to the anonymous class's own instance, not the enclosing class. To refer to the enclosing instance, use `EnclosingClassName.this`.

15. **Can an anonymous class throw checked exceptions?**
    Yes, but only if the overridden method's signature (in the interface/superclass) permits or declares that exception via `throws`.

16. **How is memory managed for anonymous classes — do they cause memory leaks?**
    Since a non-static anonymous class implicitly holds a reference to its enclosing instance, it can prevent that enclosing object from being garbage collected if the anonymous class instance outlives it (a common issue in Android/GUI event listeners).

17. **Can an anonymous class be generic?**
    An anonymous class cannot declare its own generic type parameters, but it can implement/extend a generic interface/class with a specific type argument, e.g. `new Comparator<String>() { ... }`.

18. **What happens if the interface being implemented anonymously has a default method?**
    The anonymous class inherits the default method automatically; you only need to override the abstract method(s), unless you explicitly want to override the default method too.

19. **Can an anonymous class be used as a return type from a method?**
    Yes, commonly by returning it as the interface or superclass type, e.g. `return new Comparator<String>() { ... };`.

20. **How would you refactor an anonymous class into a lambda? Give an example.**
    ```java
    // Anonymous class
    Comparator<String> c1 = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    };

    // Lambda equivalent
    Comparator<String> c2 = (a, b) -> a.length() - b.length();
    ```

### Scenario-Based

21. **You need to sort a list using custom logic only once. Would you write a named class, an anonymous class, or a lambda? Justify.**
    A **lambda** is best if `Comparator` is used (functional interface, single method, no extra state needed) — it's the most concise. An anonymous class would be the choice if the interface had multiple methods or you needed extra fields/state.

22. **In event-driven GUI programming (e.g., Swing), why are anonymous classes commonly used for listeners?**
    Because each button/component typically needs a unique, small piece of one-time behavior, and defining a named class for every listener would clutter the codebase unnecessarily.

23. **What issue can arise if an anonymous class (implementing `Runnable`) is passed to a long-running thread while holding a reference to a large enclosing object?**
    It can cause a **memory leak**, since the anonymous class retains an implicit reference to the enclosing instance, preventing it from being garbage collected as long as the thread is alive.

---

## Quick Summary Table

| Feature | Supported in Anonymous Class? |
|---|---|
| Named constructor | ❌ No |
| Instance initializer block | ✅ Yes |
| Implement multiple interfaces | ❌ No (only one) |
| Extend class + implement interface together | ❌ No |
| Static methods/variables | ❌ (except `static final` constants) |
| Access enclosing instance members | ✅ Yes |
| Access local variables (effectively final only) | ✅ Yes |
| Reusable / instantiated multiple times | ❌ No (single use at declaration) |
| Generic type parameters of its own | ❌ No (can use parent's generics) |
