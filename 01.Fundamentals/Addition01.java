import java.io.*;
import java.util.*;

public class Addition01
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);

		System.out.print("Enter the First Number :");
		float num1=sc.nextFloat();

		System.out.print("Enter the Second Number :");
		float num2=sc.nextFloat();

		float ans=num1+num2;

		System.out.println("Addition is : "+ans);

	}
}