package com;

import com.tca.Area.CircleArea;
import com.tca.Area.Rectangle;
import com.tca.Area.Triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo
{
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose Shape:\n1. Circle\n2. Triangle\n3. Rectangle");
        System.out.print("Enter choice (1/2/3): ");
        int choice = Integer.parseInt(br.readLine());

        switch (choice) {
            case 1:
                System.out.print("Enter radius: ");
                double radius = Double.parseDouble(br.readLine());
                CircleArea circle = new CircleArea(radius);
                System.out.println("Area of Circle: " + circle.getCirclearea());
                break;

            case 2:
                System.out.print("Enter base: ");
                double base = Double.parseDouble(br.readLine());
                System.out.print("Enter height: ");
                double height = Double.parseDouble(br.readLine());
                Triangle triangle = new Triangle(base, height);
                System.out.println("Area of Triangle: " + triangle.getTriangleArea(base,height));
                break;

            case 3:
                System.out.print("Enter length: ");
                double length = Double.parseDouble(br.readLine());
                System.out.print("Enter width: ");
                double width = Double.parseDouble(br.readLine());
                Rectangle rectangle = new Rectangle(length, width);
                System.out.println("Area of Rectangle: " + rectangle.getRectangleArea());
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}