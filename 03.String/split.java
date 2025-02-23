import java.io.*;

public class split
{
	public static void main(String[] args) {
		
		String s="99999999,ANIKET,5000,1000";

		String token[]=s.split(",");

		System.out.println(token[0]);
		System.out.println(token[1]);
		System.out.println(token[2]);
		System.out.println(token[3]);

		int total=Integer.parseInt(token[2]);
		int paid=Integer.parseInt(token[3]);
		int rm=total-paid;

		if(total!=paid)
		{
			System.out.println("Hi "+token[1]+" Your remaining fess is " + rm);
		}

	}
}