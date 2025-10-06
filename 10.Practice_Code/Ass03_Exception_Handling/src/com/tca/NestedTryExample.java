package com.tca;

public class NestedTryExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30};
            System.out.println("Outer try block started");

            try {
                int result = numbers[2] / 0;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Cannot divide by zero!");
                e.printStackTrace();
            }

            System.out.println("Accessing element: " + numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Array index out of range!");
            e.printStackTrace();
        }

        System.out.println("Program continues normally...");
    }
}
