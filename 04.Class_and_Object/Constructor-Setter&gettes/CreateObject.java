import java.io.*;

class A
{
	int i=10;
	int j=20;

	void display()
	{
		System.out.println("value of i : "+i);
		System.out.println("Value of j : "+j);
	}
}

public class CreateObject
{
	public static void main(String[] args) {
		
		A ob=new A();
		ob.display();
	}
}