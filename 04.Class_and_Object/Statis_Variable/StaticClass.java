import java.io.*;

class A
{
	private int i;  //non-Static variable or Instance variable
	static private  int cnt; //Static or class variable

	public A()
	{
		i=0;
		cnt++;
	}

	public A(int i)
	{
		this.i=i;
		cnt++;
	}

	public void display()
	{
		System.out.println("Value of i :"+i);
	}

	public static void Show()
	{
		System.out.println("No.of.Object :"+cnt);
	}
}

public class StaticClass
{
	public static void main(String[] args) 
	{
		A ob1=new A();
		ob1.display();
		A ob2=new A(10);
		ob2.display();
		A ob3=new A(30);
		ob3.display();
		

		A.Show();
	}
}