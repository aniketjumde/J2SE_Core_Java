import java.io.*;
import java.util.*;

public class NormalMethodExceptionThrow
{

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException
	{
		int a[]={1,2,3,4,5};
		System.out.println(a[55]);  // This Exception is Handele By JVM(Throw To the JVM)
		
		System.out.println("End-of-main");
	}
}

