# Java Stream API — Complete Notes

---

## 1. What is Stream API?

The **Stream API** was introduced in **Java 8** to process collections of data in a **declarative and functional style**.

A **Stream** is a sequence of elements that supports operations for processing data.

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

numbers.stream()
       .filter(n -> n > 20)
       .forEach(System.out::println);
```

**Output:**
```
30
40
50
```

### Simple Definition
> Stream API is used to process data from collections in a pipeline using operations such as filtering, mapping, sorting, and collecting.

---

## 2. Why Do We Need Stream API?

Before Java 8, collection processing was commonly done with loops.

**Without Stream API:**
```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

for (Integer n : numbers) {
    if (n > 20) {
        System.out.println(n);
    }
}
```

**With Stream API:**
```java
numbers.stream()
       .filter(n -> n > 20)
       .forEach(System.out::println);
```

The Stream API provides a cleaner way to describe **what** you want to do, rather than writing all the control-flow details yourself.

---

## 3. Stream API vs Collection

| | Collection | Stream |
|---|---|---|
| Purpose | **Stores** data | **Processes** data |
| Example | `List<Integer> numbers = Arrays.asList(10, 20, 30, 40);` | `numbers.stream()` |

```
Collection
    ↓
 STORES DATA

Stream
    ↓
 PROCESSES DATA
```

> A Stream does not normally store elements itself.

---

## 4. Real-Life Example — Conveyor Belt

Imagine a factory conveyor belt:

```
                    STREAM PIPELINE

10 ──┐
20 ──┤
30 ──┤──→ FILTER ──→ MAP ──→ SORT ──→ OUTPUT
40 ──┤
50 ──┘
```

Each operation processes the data and passes it to the next operation.

```java
numbers.stream()
       .filter(n -> n > 20)
       .map(n -> n * 2)
       .sorted()
       .forEach(System.out::println);
```

**Pipeline trace:**
```
[10,20,30,40,50]
       ↓
filter > 20
       ↓
[30,40,50]
       ↓
map × 2
       ↓
[60,80,100]
       ↓
sorted
       ↓
[60,80,100]
       ↓
forEach
       ↓
PRINT
```

---

## 5. Stream Pipeline

A Stream pipeline generally has **three parts**:

```
SOURCE
  ↓
INTERMEDIATE OPERATIONS
  ↓
TERMINAL OPERATION
```

```java
numbers.stream()                       // Source
       .filter(n -> n > 20)            // Intermediate
       .map(n -> n * 2)                // Intermediate
       .forEach(System.out::println);  // Terminal
```

---

## 6. Source

The source is where the data comes from.

**Common sources:**
```java
List<Integer> list = Arrays.asList(1, 2, 3);
list.stream();
```

**Array:**
```java
Arrays.stream(array);
```

**Direct values:**
```java
Stream.of(10, 20, 30);
```

**Primitive streams:**
```java
IntStream.range(1, 10);
```

---

## 7. Creating a Stream

**From List:**
```java
List<String> names = Arrays.asList("Rahul", "Amit", "Priya");
Stream<String> stream = names.stream();
```

**From Set:**
```java
Set<Integer> numbers = Set.of(10, 20, 30);
numbers.stream();
```

**From Array:**
```java
int[] numbers = {10, 20, 30};
Arrays.stream(numbers);
```

**Using `Stream.of()`:**
```java
Stream<String> names = Stream.of("Rahul", "Amit", "Priya");
```

---

## 8. Intermediate Operations

Intermediate operations **transform or filter** a Stream. They **return another Stream**.

Examples: `filter()`, `map()`, `flatMap()`, `distinct()`, `sorted()`, `limit()`, `skip()`, `peek()`, `takeWhile()`, `dropWhile()`

> **Important:** Intermediate operations are generally **lazy**. They don't cause the pipeline to produce a final result until a terminal operation is invoked.

---

## 9. `filter()` ⭐⭐⭐

**Purpose:** Select elements that satisfy a condition.

**Syntax:** `filter(Predicate)`

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

numbers.stream()
       .filter(n -> n > 30)
       .forEach(System.out::println);
```

**Output:**
```
40
50
```

> `filter()` = **SELECT**

---

## 10. `map()` ⭐⭐⭐

**Purpose:** Transform each element.

```java
numbers.stream()
       .map(n -> n * 2)
       .forEach(System.out::println);
```

Input: `10 20 30` → Output: `20 40 60`

> `map()` = **TRANSFORM**

---

## 11. `flatMap()` ⭐⭐⭐

`flatMap()` is used when each element can produce **multiple** elements and you want **one flattened Stream**.

```java
List<List<Integer>> numbers = Arrays.asList(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4),
    Arrays.asList(5, 6)
);
```

**Without flattening:**
```
[1,2]
[3,4]
[5,6]
```

**Using `flatMap()`:**
```java
numbers.stream()
       .flatMap(list -> list.stream())
       .forEach(System.out::println);
```

**Output:**
```
1
2
3
4
5
6
```

> `map()` → one-to-one transformation
> `flatMap()` → one-to-many + flatten

---

## 12. `distinct()`

Removes duplicates.

```java
List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 30);

numbers.stream()
       .distinct()
       .forEach(System.out::println);
```

**Output:**
```
10
20
30
```

---

## 13. `sorted()`

**Natural order:**
```java
numbers.stream()
       .sorted()
       .forEach(System.out::println);
```

**Reverse order:**
```java
numbers.stream()
       .sorted(Comparator.reverseOrder())
       .forEach(System.out::println);
```

**Custom sorting (for objects):**
```java
employees.stream()
         .sorted(Comparator.comparing(Employee::getSalary))
         .forEach(System.out::println);
```

---

## 14. `limit()`

Limits the number of elements.

```java
numbers.stream()
       .limit(3)
       .forEach(System.out::println);
```

Input: `10 20 30 40 50` → Output:
```
10
20
30
```

---

## 15. `skip()`

Skips the first N elements.

```java
numbers.stream()
       .skip(2)
       .forEach(System.out::println);
```

Input: `10 20 30 40 50` → Output:
```
30
40
50
```

---

## 16. `peek()`

Used mainly for observing elements during pipeline processing, especially while debugging.

```java
numbers.stream()
       .filter(n -> n > 20)
       .peek(n -> System.out.println("Filtered: " + n))
       .map(n -> n * 2)
       .forEach(System.out::println);
```

> Avoid using `peek()` for important business logic.

---

## 17. `takeWhile()` (Java 9+)

Processes elements **while a condition remains true**.

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 20, 50);

numbers.stream()
       .takeWhile(n -> n < 40)
       .forEach(System.out::println);
```

**Output:**
```
10
20
30
```

When `40` is encountered, processing stops for this operation.

---

## 18. `dropWhile()` (Java 9+)

Drops elements while the condition is true, then keeps the remaining elements.

```java
numbers.stream()
       .dropWhile(n -> n < 40)
       .forEach(System.out::println);
```

For `10 20 30 40 20 50` → Result:
```
40
20
50
```

---

## 19. Terminal Operations

Terminal operations **produce a final result or side effect**.

Examples: `forEach()`, `forEachOrdered()`, `collect()`, `toList()`, `count()`, `reduce()`, `min()`, `max()`, `findFirst()`, `findAny()`, `anyMatch()`, `allMatch()`, `noneMatch()`, `toArray()`

> After a terminal operation, the Stream is considered **consumed**.

---

## 20. `forEach()` ⭐⭐⭐

Performs an action on every element.

```java
numbers.stream()
       .forEach(n -> System.out.println(n));
```

**Method reference:**
```java
numbers.stream()
       .forEach(System.out::println);
```

> `forEach()` = **PERFORM ACTION**

---

## 21. `forEachOrdered()`

Processes elements in encounter order.

```java
numbers.stream()
       .forEachOrdered(System.out::println);
```

Particularly relevant when working with **parallel streams**.

---

## 22. `collect()` ⭐⭐⭐

Collects Stream results into a container or another result.

```java
List<Integer> result =
    numbers.stream()
           .filter(n -> n > 20)
           .collect(Collectors.toList());
```

Result: `[30, 40, 50]`

**Collect into a Set:**
```java
Set<Integer> result =
    numbers.stream()
           .collect(Collectors.toSet());
```

---

## 23. `toList()`

Modern Java provides:
```java
List<Integer> result =
    numbers.stream()
           .filter(n -> n > 20)
           .toList();
```

This is often simpler than `.collect(Collectors.toList())`.

> **Important distinction:** `Stream.toList()` returns an **unmodifiable** List.

---

## 24. `count()`

Counts elements.

```java
long count =
    numbers.stream()
           .filter(n -> n > 20)
           .count();
```

For `10 20 30 40 50` → Result: `3`

---

## 25. `min()`

Finds minimum.

```java
Optional<Integer> min =
    numbers.stream()
           .min(Integer::compareTo);
```

Because there may be no elements, the result is an `Optional`.

---

## 26. `max()`

Finds maximum.

```java
Optional<Integer> max =
    numbers.stream()
           .max(Integer::compareTo);
```

---

## 27. `findFirst()`

Returns the first element.

```java
Optional<Integer> result =
    numbers.stream()
           .findFirst();
```

```
[10,20,30]
   ↓
findFirst()
   ↓
Optional[10]
```

---

## 28. `findAny()`

Returns some element.

```java
Optional<Integer> result =
    numbers.stream()
           .findAny();
```

Especially useful with **parallel streams**, where you shouldn't assume which element will be returned.

---

## 29. `anyMatch()` ⭐

Checks whether **at least one** element satisfies a condition.

```java
boolean result =
    numbers.stream()
           .anyMatch(n -> n > 40);
```

Result: `true`

> `anyMatch()` = **IS THERE AT LEAST ONE?**

---

## 30. `allMatch()`

Checks whether **all** elements satisfy a condition.

```java
boolean result =
    numbers.stream()
           .allMatch(n -> n > 0);
```

Result: `true`

> `allMatch()` = **DO ALL SATISFY IT?**

---

## 31. `noneMatch()`

Checks whether **no** elements satisfy a condition.

```java
boolean result =
    numbers.stream()
           .noneMatch(n -> n < 0);
```

Result: `true`

> `noneMatch()` = **DOES NONE SATISFY IT?**

---

## 32. `reduce()` ⭐⭐⭐

Combines multiple elements into one result.

**Example — sum:**
```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

int sum =
    numbers.stream()
           .reduce(0, (a, b) -> a + b);

System.out.println(sum);
```

**Output:** `100`

**Visualization:**
```
10 + 20 = 30
30 + 30 = 60
60 + 40 = 100
```

> `reduce()` = **MANY → ONE**

---

## 33. `toArray()`

Converts the Stream into an array.

```java
Object[] arr = numbers.stream().toArray();
```

**For a typed array:**
```java
Integer[] arr = numbers.stream().toArray(Integer[]::new);
```

---

## 34. Primitive Streams

Java provides specialized primitive streams: `IntStream`, `LongStream`, `DoubleStream`.

Useful for numeric operations.

```java
IntStream.range(1, 5)
         .forEach(System.out::println);
```

**Output:**
```
1
2
3
4
```

---

## 35. `range()`

`range()` **excludes** the ending value.

```java
IntStream.range(1, 5)   // Produces: 1 2 3 4
```

---

## 36. `rangeClosed()`

**Includes** the ending value.

```java
IntStream.rangeClosed(1, 5)   // Produces: 1 2 3 4 5
```

> `range()` → end excluded
> `rangeClosed()` → end included

---

## 37. `sum()`

Works with primitive streams.

```java
int sum =
    numbers.stream()
           .mapToInt(Integer::intValue)
           .sum();
```

---

## 38. `average()`

```java
OptionalDouble average =
    numbers.stream()
           .mapToInt(Integer::intValue)
           .average();
```

For `10 20 30 40 50` → Average: `30.0`

---

## 39. `mapToInt()`

Converts a Stream into an `IntStream`.

```java
int sum =
    employees.stream()
             .mapToInt(Employee::getSalary)
             .sum();
```

Very useful when working with numeric object properties.

Similarly: `mapToLong()`, `mapToDouble()`

---

## 40. `boxed()`

Converts a primitive Stream into an object Stream.

```java
List<Integer> numbers =
    IntStream.rangeClosed(1, 5)
             .boxed()
             .toList();
```

Result: `[1, 2, 3, 4, 5]`

---

## 41. `concat()`

Combines two Streams.

```java
Stream<Integer> s1 = Stream.of(1, 2, 3);
Stream<Integer> s2 = Stream.of(4, 5, 6);

Stream.concat(s1, s2)
      .forEach(System.out::println);
```

**Output:**
```
1
2
3
4
5
6
```

---

## 42. `generate()`

Creates an effectively unbounded Stream using a `Supplier`.

```java
Stream.generate(() -> "Hello")
      .limit(3)
      .forEach(System.out::println);
```

**Output:**
```
Hello
Hello
Hello
```

`limit()` is important here because `generate()` can otherwise continue indefinitely.

---

## 43. `iterate()`

Generates values sequentially.

```java
Stream.iterate(1, n -> n + 1)
      .limit(5)
      .forEach(System.out::println);
```

**Output:**
```
1
2
3
4
5
```

---

## 44. Parallel Stream

Streams can also be processed in parallel.

```java
numbers.parallelStream()
       .forEach(System.out::println);
```

This allows multiple threads to process portions of the data.

> **Important:** Parallel streams are **not automatically faster**. For small collections or simple operations, the overhead can make them slower. Use them when parallel processing is actually appropriate.

---

## 45. Sequential vs Parallel

**Sequential:**
```java
numbers.stream()
```
```
Thread
  ↓
10 → 20 → 30 → 40 → 50
```

**Parallel:**
```java
numbers.parallelStream()
```
```
       ┌→ 10
Thread ├→ 20
       ├→ 30
       ├→ 40
       └→ 50
```

The actual execution and ordering depend on the stream and operation.

---

## 46. Stream Laziness ⭐⭐⭐

This is an important interview concept.

```java
numbers.stream()
       .filter(n -> {
           System.out.println("Checking " + n);
           return n > 20;
       });
```

Nothing useful is produced yet because there is **no terminal operation**.

Add:
```java
.forEach(System.out::println);
```

Now the pipeline executes:
```
stream()
   ↓
filter()
   ↓
forEach()
   ↓
EXECUTION
```

---

## 47. Intermediate vs Terminal Operations

| Intermediate | Terminal |
|---|---|
| `filter()` | `forEach()` |
| `map()` | `collect()` |
| `flatMap()` | `toList()` |
| `distinct()` | `count()` |
| `sorted()` | `reduce()` |
| `limit()` | `min()` |
| `skip()` | `max()` |
| `peek()` | `findFirst()` |
| `takeWhile()` | `findAny()` |
| `dropWhile()` | `anyMatch()` |
| | `allMatch()` |
| | `noneMatch()` |
| | `toArray()` |

> Intermediate → returns Stream
> Terminal → produces final result / completes processing

---

## 48. Short-Circuit Operations

Some operations don't necessarily need to process every element.

Examples: `limit()`, `findFirst()`, `findAny()`, `anyMatch()`, `allMatch()`, `noneMatch()`, `takeWhile()`

```java
numbers.stream()
       .anyMatch(n -> n > 40);
```

Once the Stream finds `50`, it can stop because the answer is already known:
```
10 → false
20 → false
30 → false
40 → false
50 → TRUE → STOP
```

This can improve efficiency.

---

## 49. Stateful Operations

Some operations need to consider multiple elements or maintain state.

Examples: `sorted()`, `distinct()`

```java
numbers.stream()
       .sorted()
```

The sorting operation generally needs to consider the elements together before producing the sorted result. These are sometimes described as **stateful intermediate operations**.

---

## 50. Stateless Operations

Operations such as `filter()` and `map()` can generally process an element based only on that element and the operation's logic.

```java
.filter(n -> n > 20)
```

Each number can be tested independently.

---

## 51. Stream Cannot Normally Be Reused

Once a terminal operation consumes a Stream, you shouldn't try to use that same Stream again.

**Wrong:**
```java
Stream<Integer> stream = numbers.stream();

stream.forEach(System.out::println);
stream.count();  // ❌ IllegalStateException
```

**Correct — create a new Stream each time:**
```java
numbers.stream().forEach(System.out::println);
numbers.stream().count();
```

---

## 52. Stream Does Not Modify the Original Collection

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

List<Integer> result =
    numbers.stream()
           .filter(n -> n > 20)
           .toList();
```

Original: `[10, 20, 30, 40]`
Result: `[30, 40]`

The filtering operation didn't remove elements from the original List.

---

## 53. Stream + Lambda Expression

Streams and lambdas are commonly used together.

```java
numbers.stream()
       .filter(n -> n > 20)
       .map(n -> n * 2)
       .forEach(n -> System.out.println(n));
```

Here `n -> n > 20`, `n -> n * 2`, and `n -> System.out.println(n)` are all lambdas.

```
Lambda Expression
       +
Stream API
       ↓
Functional-style data processing
```

---

## 54. Stream + Predicate

`filter()` uses a `Predicate`.

```java
Predicate<Integer> condition = n -> n > 20;

numbers.stream()
       .filter(condition)
       .forEach(System.out::println);
```

`Predicate` means: **Input → boolean**
```
30 → true
10 → false
```

---

## 55. Stream + Function

`map()` commonly uses a `Function`.

```java
Function<Integer, Integer> doubleValue = n -> n * 2;

numbers.stream()
       .map(doubleValue)
       .forEach(System.out::println);
```

`Function` means: **Input → Output**
```
10 → 20
20 → 40
```

---

## 56. Stream + Consumer

`forEach()` accepts a `Consumer`.

```java
Consumer<Integer> print = n -> System.out.println(n);

numbers.stream()
       .forEach(print);
```

`Consumer` means: **Input → Nothing**

---

## 57. Stream + Comparator

Used for sorting.

```java
employees.stream()
         .sorted(Comparator.comparing(Employee::getSalary))
         .forEach(System.out::println);
```

---

## 58. `Collectors.groupingBy()` ⭐⭐⭐

This is very important for real-world Java development.

```java
class Employee {
    String name;
    String department;
    // constructor/getters...
}
```

**Group employees by department:**
```java
Map<String, List<Employee>> result =
    employees.stream()
             .collect(Collectors.groupingBy(Employee::getDepartment));
```

```
Employees
    ↓
groupingBy(department)
    ↓
┌───────────────┐
│ IT            │ → employees
│ HR            │ → employees
│ Finance       │ → employees
└───────────────┘
```

---

## 59. `Collectors.partitioningBy()`

Divides elements into two groups based on a boolean condition.

```java
Map<Boolean, List<Integer>> result =
    numbers.stream()
           .collect(Collectors.partitioningBy(n -> n > 30));
```

```
              numbers
                 ↓
             n > 30 ?
             /      \
          true      false
           ↓          ↓
        40,50      10,20,30
```

---

## 60. `Collectors.joining()`

Combines Strings.

```java
List<String> names = Arrays.asList("Rahul", "Amit", "Priya");

String result =
    names.stream()
         .collect(Collectors.joining(", "));
```

Result: `Rahul, Amit, Priya`

---

## 61. `Collectors.toSet()`

```java
Set<Integer> result =
    numbers.stream()
           .collect(Collectors.toSet());
```

Useful when you want unique values.

---

## 62. `Collectors.counting()`

Count elements inside a collector operation.

```java
long count =
    employees.stream()
             .collect(Collectors.counting());
```

More commonly, simply:
```java
long count = employees.stream().count();
```

---

## 63. `Collectors.summingInt()`

```java
int totalSalary =
    employees.stream()
             .collect(Collectors.summingInt(Employee::getSalary));
```

---

## 64. `Collectors.averagingInt()`

```java
double averageSalary =
    employees.stream()
             .collect(Collectors.averagingInt(Employee::getSalary));
```

---

## 65. `Collectors.maxBy()` / `minBy()`

```java
Optional<Employee> highest =
    employees.stream()
             .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
```

---

## 66. `Collectors.toMap()`

Convert stream elements into a Map.

```java
Map<Integer, String> employeeMap =
    employees.stream()
             .collect(Collectors.toMap(Employee::getId, Employee::getName));
```

```
ID       NAME
101  →   Rahul
102  →   Amit
103  →   Priya
```

> **Be careful:** `toMap()` needs a merge strategy if multiple elements produce the same key.

---

## 67. Complete Real-World Example

**Requirement:** Find employees whose salary is greater than 50,000, sort them by salary, get their names, and collect the names into a List.

```java
List<String> result =
    employees.stream()
             .filter(e -> e.getSalary() > 50000)
             .sorted(Comparator.comparing(Employee::getSalary))
             .map(Employee::getName)
             .toList();
```

**Pipeline:**
```
Employees
    ↓
filter salary > 50000
    ↓
matching employees
    ↓
sort by salary
    ↓
Employee → name
    ↓
List<String>
```

This is the kind of Stream pipeline you'll commonly see in professional Java code.

---

## 68. Advantages of Stream API

**1. Less code**
```java
// Traditional
for (Integer n : numbers) {
    if (n > 20) {
        System.out.println(n);
    }
}

// Stream
numbers.stream().filter(n -> n > 20).forEach(System.out::println);
```

**2. Readable** — `.filter(n -> n > 20).map(n -> n * 2).sorted()` describes the processing steps clearly.

**3. Functional programming** — works naturally with `Lambda`, `Predicate`, `Function`, `Consumer`, `Supplier`, `Comparator`.

**4. Easy data transformation** — `.map(...)`

**5. Easy filtering** — `.filter(...)`

**6. Easy aggregation** — `count()`, `sum()`, `average()`, `reduce()`

**7. Parallel processing support** — `parallelStream()`

**8. Powerful collection processing** — you can combine multiple operations into one pipeline.

---

## 69. Disadvantages / Things to Remember

Streams aren't always the best choice.

**1. Can become difficult to read**
```java
// Overly chained — hard to follow
list.stream()
    .filter(...)
    .map(...)
    .filter(...)
    .sorted(...)
    .map(...)
    .flatMap(...)
    .filter(...)
    .collect(...);
```
If the pipeline becomes too complicated, ordinary code may be clearer.

**2. Debugging can be harder** — traditional loops are sometimes easier to debug step by step.

**3. Streams are not reusable** — once consumed, create another Stream.

**4. Parallel streams can add overhead** — don't assume `parallelStream()` always means faster.

**5. Side effects should generally be avoided**
```java
// Avoid
List<Integer> result = new ArrayList<>();
numbers.stream().forEach(n -> result.add(n));

// Prefer
List<Integer> result = numbers.stream().toList();
```

---

## 70. Most Important Stream Methods — Cheat Sheet

| Method | Type | Meaning |
|---|---|---|
| `stream()` | Creation | Create Stream |
| `filter()` | Intermediate | Select |
| `map()` | Intermediate | Transform |
| `flatMap()` | Intermediate | Flatten |
| `distinct()` | Intermediate | Remove duplicates |
| `sorted()` | Intermediate | Sort |
| `limit()` | Intermediate | Take first N |
| `skip()` | Intermediate | Skip first N |
| `peek()` | Intermediate | Observe/debug |
| `takeWhile()` | Intermediate | Take while condition true |
| `dropWhile()` | Intermediate | Drop while condition true |
| `forEach()` | Terminal | Perform action |
| `collect()` | Terminal | Collect result |
| `toList()` | Terminal | Create List |
| `count()` | Terminal | Count |
| `min()` | Terminal | Minimum |
| `max()` | Terminal | Maximum |
| `findFirst()` | Terminal | First element |
| `findAny()` | Terminal | Any element |
| `anyMatch()` | Terminal | At least one? |
| `allMatch()` | Terminal | All? |
| `noneMatch()` | Terminal | None? |
| `reduce()` | Terminal | Many → One |
| `toArray()` | Terminal | Convert to array |

---

## 71. Numeric Stream Methods

For `IntStream`, `LongStream`, and `DoubleStream`:

`sum()`, `average()`, `min()`, `max()`, `count()`, `boxed()`, `mapToObj()`

**Creation helpers:**
```java
IntStream.range()
IntStream.rangeClosed()
LongStream.range()
LongStream.rangeClosed()
```

---

## 72. Stream API Methods by Category

The easiest way to remember everything:

```
                    STREAM API
                        │
       ┌────────────────┴────────────────┐
       │                                  │
   INTERMEDIATE                       TERMINAL
       │                                  │
       ├─ filter()                        ├─ forEach()
       ├─ map()                           ├─ collect()
       ├─ flatMap()                       ├─ toList()
       ├─ distinct()                      ├─ count()
       ├─ sorted()                        ├─ reduce()
       ├─ limit()                         ├─ min()
       ├─ skip()                          ├─ max()
       ├─ peek()                          ├─ findFirst()
       ├─ takeWhile()                     ├─ findAny()
       └─ dropWhile()                     ├─ anyMatch()
                                          ├─ allMatch()
                                          ├─ noneMatch()
                                          └─ toArray()
```

---

## 73. The Most Important Interview Concepts

If you're preparing for Java interviews, make sure you understand:

**Basic**
- What is Stream API?
- Why was Stream API introduced?
- Stream vs Collection
- How to create a Stream
- Stream pipeline
- Lambda expressions
- Functional interfaces

**Intermediate**
- Intermediate vs terminal operations
- `filter()`, `map()`, `flatMap()`, `sorted()`, `distinct()`, `limit()`, `skip()`
- Lazy evaluation
- Short-circuit operations
- Stateful vs stateless operations

**Advanced**
- `reduce()`, `collect()`
- `Collectors.groupingBy()`, `Collectors.partitioningBy()`, `Collectors.toMap()`, `Collectors.joining()`
- Primitive streams, `mapToInt()`, `boxed()`
- Parallel streams
- Side effects
- Stream performance

---

## 74. Golden Rules to Remember 🧠

```
stream()               → Creates the pipeline
filter()                → SELECT
map()                   → TRANSFORM
flatMap()                → FLATTEN
distinct()                → REMOVE DUPLICATES
sorted()                   → SORT
limit()                     → TAKE N
skip()                        → IGNORE N
forEach()                       → PERFORM ACTION
collect() / toList()              → GET RESULT
count()                             → HOW MANY?
anyMatch()                            → ANY?
allMatch()                              → ALL?
noneMatch()                               → NONE?
findFirst()                                 → FIRST?
reduce()                                      → MANY → ONE
```

---

## Final Mental Model

When you see a Stream problem, ask these questions **in order**:

```
1. Where is my data?
       ↓
   stream()

2. Which elements do I want?
       ↓
   filter()

3. Do I need to change the elements?
       ↓
   map()

4. Do I have nested data?
       ↓
   flatMap()

5. Do I need sorting/unique values?
       ↓
   sorted() / distinct()

6. Do I need only some elements?
       ↓
   limit() / skip()

7. What final result do I need?
       ↓
   collect() / toList() / count()
   reduce() / findFirst() / etc.
```

### One Complete Example

```java
List<Integer> numbers = Arrays.asList(10, 20, 20, 30, 40, 50);

List<Integer> result =
    numbers.stream()
           .filter(n -> n > 20)
           .distinct()
           .map(n -> n * 2)
           .sorted()
           .toList();

System.out.println(result);
```

**Result:** `[60, 80, 100]`

The pipeline reads almost like English:
> Take the numbers → keep numbers greater than 20 → remove duplicates → multiply by 2 → sort → give me a List.
