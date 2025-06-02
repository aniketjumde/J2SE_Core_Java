import java.io.*;
import java.util.*;


public class StackDemo
{
	public static void main(String args[])
	{
	
		Stack<String> ob=new Stack<String>();
		ob.push("Pune");
		ob.push("Delhi");
		ob.push("Nashik");
		ob.push("Beed");
		
		System.out.println("Size :"+ob.size());
		System.out.println("Stack Element :"+ob);
		System.out.println("Topmost Element :"+ob.peek());
		System.out.println("Pop Element   :"+ob.pop());	
		System.out.println("Pop Element   :"+ob.pop());	
		System.out.println("Pop Element   :"+ob.pop());	
		System.out.println("Pop Element   :"+ob.pop());
		
		
		ob.push("AAA");
		ob.push("BBB");
		ob.push("CCC");
		ob.push("DDD");
		
		System.out.println("Size :"+ob.size());
		System.out.println("Stack Element :"+ob);
		
		System.out.println("---Pop Element--- ");
		
		while(!ob.empty())
		{
			System.out.println(ob.pop());
		}
				
	
	}
}
