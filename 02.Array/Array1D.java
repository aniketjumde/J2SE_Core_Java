import java.io.*;

public class Array1D
{
	public static void main(String[] args) 
	{
		int a[]={11, 22, 33, 44, 55}; //int[] a=new int[5];

		System.out.println(a); // Array variable is store reference as well as array length 
		System.out.println(a.length);

		System.out.print("Array : ");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}