import java.io.*;
/*
  WHAT IS MEAN BY JAGGED ARRAY?.
-->It is an array of array in which different rows have different length.
*/
public class JaggedArray
{
	public static void main(String[] args) {
		
		int a[][]=new int[3][];

		a[0]=new int[3];
		a[1]=new int[1];
		a[2]=new int[2];

		System.out.println("Length of array a :"+a.length);
		System.out.println("Length of array a[0] : "+a[0].length);
		System.out.println("Length of array a[1] : "+a[1].length);
		System.out.println("Length of array a[2] : "+a[2].length);

		a[0][0]=11;
		a[0][1]=22;
		a[0][2]=33;
		a[1][0]=55;
		a[2][0]=88;
		a[2][1]=99;
		System.out.println();
		System.out.println("Jagged Array : ");

		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}