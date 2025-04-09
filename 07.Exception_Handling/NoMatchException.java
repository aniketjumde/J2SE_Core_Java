/*
Write a Java Program That define NoMatchException and throw it when accepted String is not equal to "India".
*/

import java.io.*;
import java.util.*;

class NoStringMatchException extends Exception
{
	public NoStringMatchException(String msg)
	{
		super(msg);
	}	
}

public class NoMatchException
{
	public static void main(String[] args)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			System.out.print("Enter the String :");
			String name=br.readLine();
			
			name=name.toUpperCase();
			
			if(name.contains("INDIA"))
			{
				System.out.println("Given String has INDIA.");
			}
			else
			{
				throw new NoStringMatchException("Given String has NOT  INDIA.");
			}
		}
		
		catch(IOException ie)
		{
			System.out.println("Problem : I/O Error.!!!");
		}
		
		catch(NoStringMatchException nse)
		{
			nse.printStackTrace();
		}
	}

}
