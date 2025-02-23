import java.io.*;

public class StringCaseII
{
	public static void main(String[] args) {
		
		String s="ABC";  //Memory is alocated on "String Constant Pool"
		String t=new String("ABC"); //Memory is alocated on "HEAP"

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