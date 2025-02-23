import java.io.*;

public class JaggedArrayInitialization 
{
	public static void main(String[] args) {
		
		int[][] a={{11,22,33},{33},{55,66}};

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