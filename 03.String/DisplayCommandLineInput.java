import java.io.*;
import java.util.Arrays;

public class DisplayCommandLineInput
{
	public static void main(String[] args) 
	{
		
		System.out.print(" List of Command Line Input : ");
		for(int i=0;i<args.length;i++)
		{
			System.out.print(args[i]+ " ");
		}

		System.out.println();
	}
}