import java.io.*;
import java.util.*;

public class Vector2Demo
{
	public static void main(String args[])
	{
		Vector<String> v=new Vector<>(2,3);
		//Capacity is 2 and Capacity Increment is 3
		
		System.out.println("Initial Capacity :"+v.capacity());
		System.out.println("Size :"+v.size());
		
		v.add("Pune");
		v.add("Mumbai");
		v.add("Delhi");
		
		
		System.out.println("Initial Capacity :"+v.capacity());
		System.out.println("Size :"+v.size());
		
		System.out.println("Elemnts in Vector :"+v);
		
		Iterator ir=v.iterator();
		
		while(ir.hasNext())
		{
			System.out.println(ir.next());
		}
	
	}

}
