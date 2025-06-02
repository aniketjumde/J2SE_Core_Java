import java.io.*;
import java.util.*;

public class HashMapDemo
{
	public static void main(String args[])
	{
		HashMap<Integer,String> ob=new HashMap<Integer,String>();
		ob.put(101,"AAA");
		ob.put(102,"BBB");
		ob.put(103,"CCC");
		ob.put(104,"DDD");
		
		System.out.println("Hash Map : "+ob);
		
		Set<Integer> S=ob.keySet();
		
		for(Integer k: S)
		{
			System.out.println("Key :"+k+" value: "+ob.get(k));
		}
		
		
	}

}
