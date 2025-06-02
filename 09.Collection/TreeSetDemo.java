import java.io.*;
import java.util.*;

public class TreeSetDemo
{
	public static void main(String args[])
	{
		TreeSet<String> ts=new TreeSet<String>();
		ts.add("Pune");
		ts.add("Delhi");
		ts.add("Nashik");
		ts.add("Beed");
		
		System.out.println(ts);
		
		System.out.println("Display using Loop :");
		Iterator ir=ts.iterator();
		while(ir.hasNext())
		{
			System.out.println(ir.next());
		}
		
		ts=(TreeSet)ts.descendingSet();
		System.out.println("Element in Desceding Order :"+ts	);
		while(ir.hasNext())
		{
			System.out.println(ir.next());
		}
	}

}
