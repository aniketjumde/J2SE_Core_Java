import java.io.*;


public class MaxNumber
{
	public static void main(String[] args) 
	{
		
		int max=Integer.parseInt(args[0]);

		for(int i=1;i<args.length;i++)
		{
			if(Integer.parseInt(args[i])>max)
			{
				max=Integer.parseInt(args[i]);
			}
		}

		System.out.println("Max number is : "+max);

	}
}