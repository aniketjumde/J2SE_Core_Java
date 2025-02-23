import java.io.*;

public class SumOfCommandLine
{
	public static void main(String[] args) {
		
		int sum=0;

		if(args.length==0)
		{
			sum=0;
		}
		else 
		{
			for(String s : args)
			{
				sum +=Integer.parseInt(s);
			}
		}

		System.out.println("Sum of Command Line Number is : "+sum);
	}
}