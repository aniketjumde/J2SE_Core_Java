import java.util.*;

class Area
{
	private int radius;
	final  double PI=3.14;
	
	public Area(int radius)
	{
		this.radius=radius;
	} 
	
	public double areaOfCircel()
	{
		return PI*radius*radius;
	}
	
	
	public double parameterOfCircel()
	{
		return 2*PI*radius;
	}
}


public class Circle
{
	public static void main (String[] args)
	{
		Area ob=new Area(4);
		
		System.out.println("Area of Circle :"+ob.areaOfCircel());
		System.out.println("Parameter of Circle :"+ob.parameterOfCircel());
		
	}
}
