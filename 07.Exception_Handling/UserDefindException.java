import java.io.*;
import java.util.*;

class TemperatureException extends Exception 
{
	public TemperatureException(String msg)
	{
		super(msg);
	}
}

public class UserDefindException
{
	public static void main(String[] args)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			System.out.print("Enter the Temperature :");
			double temp=Double.parseDouble(br.readLine());
			
			if(temp<90)
			{
				throw new TemperatureException("Temperature is below Normal.!!!");
			}
			else if(temp>100)
			{
				throw new TemperatureException("Temperature is High.!!!");
			}
			
			System.out.println("Normal Temperature : "+temp);
		}	
		
		catch(IOException ie)
		{
			System.out.println("Problem :I/O Error.!!!");
		}
		
		catch(NumberFormatException ne)
		{
			System.out.println("Problem : Given Input is Invalid.!!!");
		}
		
		catch(TemperatureException te)
		{
			te.printStackTrace();
		}	
	
	}
}
