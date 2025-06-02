import java.io.*;
import java.util.*;

public class HashSetvsLinkedHashSet
{
	public static void main(String args[])
	{
		LinkedHashSet<String> ob=new LinkedHashSet<>();
		
		ob.add("Pune");
		ob.add("Delhi");
		ob.add("Nashik");
		ob.add("Beed");
		ob.add("Banglore");
		
		System.out.println(ob);
		
		HashSet<String> b=new HashSet<>();
		
		b.add("Pune");
		b.add("Delhi");
		b.add("Nashik");
		b.add("Beed");
		b.add("Banglore");
		
		System.out.println(b);
		
	}

}
