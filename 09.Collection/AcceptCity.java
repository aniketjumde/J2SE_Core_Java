import java.io.*;
import java.util.*;

public class AcceptCity
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> city=new ArrayList<String>();
		
		while(true)
		{
			System.out.print("Enter the City name :");
			String data=br.readLine();
			city.add(data);
			
			System.out.print("Do you want to Continue (Yes/No) :");
			String option=br.readLine();
			
			option=option.toLowerCase();
			
			if(option.equals("no"))
			{
			
				break;
			}
			
		}
		
		System.out.println("List of Cities : "+city );
		
		city.clear();
		System.out.println("List of Cities After Remove  : "+city );
	
	}

}
