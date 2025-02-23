import java.io.*;

class DisplayReverseCommandLineArgument
{
	public static void main(String[] args) {
		
		System.out.println("Reverse List of Command Line Arguments ");
		for(int i=(args.length-1);i>=0;i--)
		{
			System.out.print(args[i]+" ");
		}
		System.out.println();
	}
}