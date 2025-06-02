import java.io.*;
import java.util.*;

public class AcceptIntegerUsngSet
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		TreeSet<Integer> ts = new TreeSet<>();

		
		System.out.println("How many number you want to store :");
		int n=Integer.parseInt(br.readLine());
		
		int i=0;
		while(i<n)
		{
			System.out.println("Enter the num :");
			int num=Integer.parseInt(br.readLine());
		
            boolean status = ts.add(num); 

			
			if(status==true)
			{
				i++;
			}
			else
			{
				System.out.println(num+" is already Present.!");
			}	
		}
		
		System.out.println("Element After Sort : "+ts);
	}

}
