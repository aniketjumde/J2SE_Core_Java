package com.access.inside;

class C
{
    void display() 
    {   // default access
        System.out.println("Default access");
    }
}

public class Demo 
{
    public static void main(String[] args) {
        C obj = new C();
        obj.display(); //  Allowed (same package)
    }
}
