import java.io.*;
import java.util.*;


public class Addition
{
	public static void main(String args[])
	{
		System.out.println("Start Exection");
		System.out.println();
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num1=0,num2=0,sum=0;
		
		while(true)
		{
			try
			{
				System.out.print("Enter the First Number :");
				num1=Integer.parseInt(br.readLine());
				break;
			}
			
			catch(Exception e)
			{
				System.out.println("-----Given Input is Invalid-----");
			}
		}
		
		while(true)
		{
			try
			{
				System.out.print("Enter the Second Number :");
				num2=Integer.parseInt(br.readLine());
				break;
			}
			
			catch(Exception e)
			{
				System.out.println("-----Given Input is Invalid-----");
			}
		}
		
		sum=num1+num2;
		System.out.println("Sum : "+sum);
	
		System.out.println();
		System.out.println("End Exection");
	}



}

