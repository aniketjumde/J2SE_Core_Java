import java.io.*;

class Circle
{
	private static final Double PI=3.14;
	private Double radius;

	public Circle() { }

	public Circle(Double radius)
	{
		this.radius=radius;
	}

	public Double getArea()
	{
		return PI*radius*radius;
	}
}

public class FinalKeyword
{
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the radius of Circle :");
		Double radius=Double.parseDouble(bf.readLine());

		Circle C=new Circle(radius);
		Double ans=C.getArea();

		System.out.println("Area of the Circle is : "+ans);
	}
}