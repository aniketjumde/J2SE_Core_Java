import java.io.*;
import java.util.Arrays;

public class CopyOfArray
{
	public static void main(String[] args) 
	{
		
		int a[]={11,22,33};
		int b[]=Arrays.copyOf(a,a.length);

		System.out.println(Arrays.toString(b));

		System.out.println();

		System.out.println(a);
		System.out.println(b);
	}
}