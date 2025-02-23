import java.io.*;
// Accept command line Arguments and Display
public class AcceptCommandLineInput
{
	 public static void main(String[] args) 
	 {
		System.out.println("No.of.Arguments : " +args.length);

		if(args.length>0)
		{

			for(String s : args)   //this for is Traverse all the element in command line
			{
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}
}