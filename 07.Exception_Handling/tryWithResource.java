import java.io.*;
import java.util.*;

class NoStringMatchException extends Exception
{
	public NoStringMatchException(String msg)
	{
		super(msg);
	}	
}

public class tryWithResource	
{
	public static void main(String[] args)
	{
		
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in)))
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
