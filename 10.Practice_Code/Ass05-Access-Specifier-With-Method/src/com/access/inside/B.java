package com.access.inside;

class A 
{
    protected void show() 
    {
        System.out.println("Protected method");
    }
}

public class B extends A {
    public static void main(String[] args) 
    {
        B obj = new B();
        obj.show(); //  Allowed
    }
}
