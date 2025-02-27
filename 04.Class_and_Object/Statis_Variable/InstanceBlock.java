import java.io.*;

class A
{
	static
	{
		System.out.println("I am in static Block");
	}


	{
		System.out.println("I am in InstanceBlock");   //Instance Block is Called Before Constructor
	}

	public A()
	{
		System.out.println("I am in Constructor   " );
	}

}

public class InstanceBlock
{
	public static void main(String[] args) {
		A ob=new A();
	}
}

/*

I am in static Block
I am in InstanceBlock
I am in Constructor
*/