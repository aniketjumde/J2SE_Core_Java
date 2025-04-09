import java.io.*;
import java.util.*;


public class AcceptNumber 
{

	public static void main(String[] args) throws IOException
	{
		System.out.println("Start Exection");
		System.out.println();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			System.out.print("Enter the number :");
			int num=Integer.parseInt(br.readLine());
			System.out.println("Your number is : "+num);
		}
		
		catch(NumberFormatException ea)
		{
			System.out.println("Given Input is Invalid :"+ea);
		}
		
		catch(IOException ie)
		{
			System.out.println("Input Exception "+ie);
		}
		
		catch(Exception ee)
		{
			System.out.println("Invalid Exception"+ee);
		}
		
		System.out.println();
		System.out.println("End Exection");	
	}
}
