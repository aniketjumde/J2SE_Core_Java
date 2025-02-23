import java.io.*;
import java.util.*;

public class InputUsingScanner
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		System.out.print("Enter the First Number :");
		int num1=sc.nextInt();

		System.out.print("Enter the Second Number :");
		int num2=sc.nextInt();

		int ans=num1+num2;

		System.out.println("Addition is : "+ ans);
	}
}