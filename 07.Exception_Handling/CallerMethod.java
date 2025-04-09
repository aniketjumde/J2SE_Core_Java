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

public class CallerMethod 
{
	public static void main(String[] args)	throws ArrayIndexOutOfBoundsException
	{
		
			
		A ob=new A();
		ob.display(); //this object is Exception is Also throws the JVM(JVM ) will be handle this
		System.out.println("End-of-Main");
	}
}
