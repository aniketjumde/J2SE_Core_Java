import java.io.*;
import java.util.*;


public class Array1DAcceptThrowUser
{
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);

		System.out.print("Enter the Size of Array : ");
		int size=scanner.nextInt();

		int[] arr=new int[size];

		for(int i=0;i<size;i++)
		{
			System.out.print("Enter the "+(i+1)+" element :");
			arr[i]=scanner.nextInt();
		}

		
		System.out.print("Array :");
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		

	}
}