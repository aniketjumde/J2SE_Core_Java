import java.io.*;
import java.util.*;

class A
{
	void display() throws ArrayIndexOutOfBoundsException
	{
		try
		{
			//File open,Data Base open logic 
			int a[]={1,2,3,4,5};
			System.out.println(a[1]);
		
			System.out.println("End-of-Display");
		}
		
		catch(ArrayIndexOutOfBoundsException ae)
		{
			System.out.println("Invalid Index You have Used..!");
		}
		
		finally
		{
			System.out.println("I am in Finally");
			//Close the File and Data Base Connection
		}
	}
	
	
}

public class FinallyBlock
{

	public static void main(String[] args)
	{
		A ob=new A();
		ob.display();
		System.out.println("End-of-Main");
	}


}
