import java.io.*;
import java.util.*;

public class SetDemo
{
	public static void main(String args[])
	{
		
		TreeSet<String> ts=new TreeSet<String>();
		ts.add("Pune");
		ts.add("Delhi");
		ts.add("Nashik");
		ts.add("Beed");
		
		System.out.println("TreeSet in Ascending  : "+ts);
		System.out.println("TreeSet in Descending : "+ts.descendingSet());
		
		HashSet<String> b=new HashSet<>();
		
		b.add("Pune");
		b.add("Delhi");
		b.add("Nashik");
		b.add("Beed");
		b.add("Banglore");
		
		System.out.println("HashSet               : "+b);
		
		LinkedHashSet<String> ob=new LinkedHashSet<>();
		
		ob.add("Pune");
		ob.add("Delhi");
		ob.add("Nashik");
		ob.add("Beed");
		ob.add("Banglore");
		
		System.out.println("LinkedHashSet         : "+ob);
	}

}
