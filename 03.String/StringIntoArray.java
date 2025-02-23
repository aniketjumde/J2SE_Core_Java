import java.io.*;

public class StringIntoArray
{
	public static void main(String[] args) {
		
		String s="INDIA";
		char a[]=s.toCharArray();

		for(int i=0;i<s.length();i++)
		{
			System.out.print (a[i]);
		}
		System.out.println(); 	
	}
}
