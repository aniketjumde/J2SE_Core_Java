import java.io.*;
import java.util.*;

public class LinkedListDemo
{

	public static void main(String args[])
	{
		LinkedList<String> ob = new LinkedList<>();

		ob.add("Pune");
		ob.add("Delhi");
		ob.add("Nashik");
		ob.add("beed");
		
		System.out.println("Size :"+ob.size());
		System.out.println("LinkedList :"+ob);
		
		System.out.println("--------------Forward :------------");
		
		ListIterator ir=ob.listIterator();
		
		while(ir.hasNext())
		{
			System.out.println(ir.next());
		}	
		
		System.out.println("--------------Backward--------------");
		
		while(ir.hasPrevious())
		{
			System.out.println(ir.previous());
		}
	}

}
