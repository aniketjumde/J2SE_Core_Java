//Accept Cities using ArrayList

import java.io.*;
import java.util.*;

public class AcceptCities
{

	public static void main(String args[]) throws Exception
	{
	
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
		
		List<String> city=new ArrayList<String>();
		
		System.out.print("How many City you want to Enter :");
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the City :");
			String data=br.readLine();
			
			city.add(data);
		
		}
		
		System.out.println("List of Cities : "+city );
		
		city.clear();
		System.out.println("List of Cities After Remove  : "+city );
	}



}
