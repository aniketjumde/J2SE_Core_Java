import java.io.*;


public class InputUsingBufferReader
{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the First number : ");
		int num1=Integer.parseInt(br.readLine());

		System.out.print("Enter the Second number : ");
		int num2=Integer.parseInt(br.readLine());

		int ans=num1+num2;
		System.out.println("Addition is : "+ ans);

	}
}