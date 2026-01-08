package com.access;

class A
{
	int a=10;
	private int b=20;
	protected int c=40;
	public int d=50;
}


class B extends A
{
	public void display()
	{
		System.out.println("Protected c :"+ c);
	}
}



public class Demo 
{
	public static void main(String args[])
	{
		
		A ob=new A();
		
		System.out.println("Default a :"+ob.a);
		System.out.println("Public d  :"+ob.d);
		
		B ob1=new B();
		
		ob1.display();
	}
}
