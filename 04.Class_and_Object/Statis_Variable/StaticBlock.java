import java.io.*;

class A
{
	private int i;
	private static int j;

	public A()
	{
		System.out.println("I am a default constructor");

	}

	static
	{
		System.out.println("I am Static Block");
	}

}

public class StaticBlock
{
	public static void main(String[] args) {
		
		A ob=new A();

		//Static Block gets a meomery at that time class is refered
		//Static Block is Executed Before Constructor Because class referd first and next call constructor
		//Static Block Executed only once 

	}
}

/* 
	I am Static Block 
	I am a default constructor
*/