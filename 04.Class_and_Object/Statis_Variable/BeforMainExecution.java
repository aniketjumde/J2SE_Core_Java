import java.io.*;

public class BeforMainExecution
{
	static
	{
		System.out.println("Hello World");
		System.out.println("Befor Main");
	}

	public static void main(String[] args) 
	{
		System.out.println("Main Started..!");
	}
}