import java.io.*;

public class StringCaseI
{
	public static void main(String[] args) {
		
		String s="ABC";  //Memory is alocated on "String Constant Pool"
		String t="ABC"; //Memory is alocated on "String Constant Pool"

		System.out.print("Reference is Equal :");
		if(s==t)
		{
			System.out.println("YES");
		}
		else 
		{
			System.out.println("NO");
		}

		System.out.print("String Content  is Equal :");

		if(s.equals(t))
		{
			System.out.println("YES");
		}
		else 
		{
			System.out.println("NO");
		}
	}
}