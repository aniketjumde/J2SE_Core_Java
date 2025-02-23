import java.io.*;

public class AreaOfCircle
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the radius of Circle :");
		double radius=Double.parseDouble(br.readLine());

		double area=3.14*radius*radius;

		System.out.println("Area of Circle is : "+area);
	}
}