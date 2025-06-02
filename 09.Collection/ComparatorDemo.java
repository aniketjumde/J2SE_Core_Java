import java.io.*;
import java.util.*;

public class ComparatorDemo
{
	public static void main(String args[])
	{
		String s1="BCA";
		String s2="BCA";
		
		// BCA == BCA      it gives 0
		// BCA < BSC       it gives -1
		// BSC > BCA       it gives 1
		
		int status=s1.compareTo(s2);
		
		if(status==0)
		{
			System.out.println("Both String are Equal.");
		}
		else if(status < 0)
		{
			System.out.println("First string is less than the Second String");
		} 
		else
		{
			System.out.println("First string is Greter than the Second String");
		}
	}
}
