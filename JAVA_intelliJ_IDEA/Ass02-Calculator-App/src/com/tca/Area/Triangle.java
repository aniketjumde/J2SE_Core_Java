package com.tca.Area;

public class Triangle
{
    public double a;
    public double b;

    public Triangle(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public Double getTriangleArea(double base, double height)
    {
        double area = (a * b) / 2;
        return area;
    }



}
