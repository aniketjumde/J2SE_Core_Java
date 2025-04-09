import java.io.*;
import java.util.*;

class A
{
	void display() throws ArrayIndexOutOfBoundsException
	{
		int a[]={1,2,3,4,5};
		System.out.println(a[55]);
		
		System.out.println("End-of-Display");
	}
}

public class CallerMethodHandling
{
	public static void main(String[] args)
	{
		try
		{
			
			A ob=new A();
			ob.display();
		}
		
		catch(ArrayIndexOutOfBoundsException ae)  //This Exception Handle by the User
		{
			System.out.println("Invalid Index You have Used..!");
		}
		
		System.out.println("End-of-Main");
	}
}
