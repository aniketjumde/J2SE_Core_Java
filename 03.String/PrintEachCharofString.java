import java.io.*;

class PrintEachCharofString
{
	public static void main(String[] args) {
		
		String s="Aniket";

		System.out.println("length of String :"+s.length());

		for(int i=0;i<s.length();i++)
		{
			System.out.print(s.charAt(i));
		}
		System.out.println();
	}
}