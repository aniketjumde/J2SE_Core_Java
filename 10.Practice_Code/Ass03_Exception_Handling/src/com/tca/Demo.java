package com.tca;

public class Demo {

	public static void main(String[] args) 
	{
		try
		{
			int x = 10;
			int y = 0;
			
			int ans = x / y;   // This will throw ArithmeticException
			System.out.println(ans);
			
		}
		catch(ArithmeticException ae)
		{
			ae.printStackTrace();
		}
		
		try
		{
			int[] arr = {11,22,33,44};
			System.out.println(arr[5]);  // This will throw ArrayIndexOutOfBoundsException
		}
		catch(ArrayIndexOutOfBoundsException e )
		{
			e.printStackTrace();
		}

	}

}
