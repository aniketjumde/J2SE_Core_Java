import java.io.*;
import java.util.*;


public class VectorDemo
{
	public static void main(String args[])
	{
	   Vector<String> ob=new Vector<>();
        System.out.println("Initial Capacity: " + ob.capacity()); // Works now
	   System.out.println("Size :"+ ob.size());
	   
	   ob.add("Pune");
	   ob.add("Beed");
	   ob.add("Delhi");
	   ob.add("Mumbai");
	   
	   System.out.println("Capacity: " + ob.capacity()); // Works now
	   System.out.println("Size :"+ ob.size());
	   
	   System.out.println("Elements of vector :"+ob);
	   
	   Iterator ir=ob.iterator();
	   
	   while(ir.hasNext())
	   {
	   		System.out.println(ir.next());
	   }
	   
			
	
	
	}

}
