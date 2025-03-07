import java.io.*;

class A
{
	private int i=11;

	public void display()
	{
		System.out.println("I am display in A !!");
		System.out.println(i);	}
}

class B extends A
{
	private int j=22;

	public void display()
	{
		super.display();
		System.out.println("I am display in B !!");
		System.out.println(j);
	}
}

public class MethodOverriding
{
	public static void main(String[] args) {
		
		A ob1=new A();
		ob1.display();

		System.out.println("-----------------------------------------------------");

		B ob=new B();
		ob.display();

		System.out.println("-----------------------------------------------------");

		A ob2=new B();
		ob2.display();

	}
}