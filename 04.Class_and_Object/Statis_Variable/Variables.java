import java.io.*;

class A
{
	private int i;  // Non-Static or Instance Variable
	static private int  j=89; //Static or Class variable

	public A() { }  //Default Constructor

	public A(int i)  //Parametrized Constructor
	{
		this.i=i;
	}

	public void display()  // Inastance or Non-Static Method
	{
		System.out.println("Value of i : " +i);
		System.out.println("Value of j : "+j);
	}

	public static void show()  //Class or Static Method
	{
		//System.out.println("Value of i : " +i);  error: non-static variable i cannot be referenced from a static context
		System.out.println("Value of j : "+j);
	}


}

public class Variables
{
	public static void main(String[] args) 
	{
		A ob1=new A(11);
		ob1.display();
		A.show();

	}
}