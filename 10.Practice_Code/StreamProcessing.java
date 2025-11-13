import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class StreamProcessing {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 70),
            new Student("Charlie", 90),
            new Student("David", 65),
            new Student("Eve", 95)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks >= 80)
            .map(s -> s.name)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Top Students: " + topStudents);
    }
}

