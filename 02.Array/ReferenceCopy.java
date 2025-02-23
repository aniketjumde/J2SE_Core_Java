import java.io.*;
import java.util.Arrays;

public class ReferenceCopy
{
	public static void main(String[] args) {
		
		int a[]={11,22,33};
		int b[]=new int[3];

		b=a;

		System.out.println(Arrays.toString(b));

		System.out.println(a);
		System.out.println(b);
	}
}