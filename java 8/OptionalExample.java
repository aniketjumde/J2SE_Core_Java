import java.io.*;
import java.util.*;

public class OptionalExample
{
	public static void main(String args[])
	{
		String str="Hello Pradeep";
		
		if(str==null)
		{
			System.out.println("String is Null");
		}
		else
		{
			System.out.println("String length is :"+str.length());
		}
	}
}
