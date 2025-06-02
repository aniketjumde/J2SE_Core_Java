import java.io.*;
import java.util.*;


public class QueueDemo
{
	public static void main(String args[])
	{
		Queue<String> ob=new LinkedList<>();
		ob.add("AAA");
		ob.add("BBB");
		ob.add("CCC");
		ob.add("DDD");
		
		System.out.println("Size :"+ob.size());
		System.out.println("Queue :"+ob);
		System.out.println("Top/First Element :"+ob.peek());
		System.out.println("remove Element :"+ob.remove());
		while(!ob.isEmpty())
		{
			System.out.println(ob.remove());
		}
		
	
	}
}
