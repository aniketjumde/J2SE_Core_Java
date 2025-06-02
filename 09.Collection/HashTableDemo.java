import java.io.*;
import java.util.*;

public class HashTableDemo
{
	public static void main(String args[])
	{
		Hashtable<Integer,String> ob=new Hashtable<Integer,String>();
		ob.put(101,"AAA");
		ob.put(102,"BBB");
		ob.put(103,"CCC");
		ob.put(104,"DDD");
		
		System.out.println("HashTable : "+ob);
		
		Enumeration keys=ob.keys();
		while(keys.hasMoreElements())
		{
			Integer id=(Integer)keys.nextElement();
			String name=ob.get(id);
			System.out.println(id+"--->"+name);
		}
		
		System.out.println("Hash Table :");
		Set<Integer> S=ob.keySet();
		
		for(Integer k :S)
		{
			System.out.println("Key :"+k+" value: "+ob.get(k));
		}
	}

}
