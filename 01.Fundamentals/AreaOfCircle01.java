import java.io.*;
import java.util.*;

public class AreaOfCircle01
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		System.out.print("Enter the radius of Circle :");
		double radius=sc.nextDouble();

		double area=3.14*radius*radius;
		System.out.println("Area of Circle is : "+area);
	}
}