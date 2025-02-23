import java.io.*;


public class MinNumber
{
	public static void main(String[] args) 
	{
		
		int min=Integer.parseInt(args[0]);

		for(int i=1;i<args.length;i++)
		{
			if(Integer.parseInt(args[i])<min)
			{
				min=Integer.parseInt(args[i]);
			}
		}

		System.out.println("Minimum number is : "+min);

	}
}