import java.io.*;

public class Addition
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter the First Number :");
		float num1=Float.parseFloat(br.readLine());

		System.out.print("Enter the Second Number :");
		float num2=Float.parseFloat(br.readLine());

		float ans=num1+num2;

		System.out.println("Addition is : "+ans);
	}
}