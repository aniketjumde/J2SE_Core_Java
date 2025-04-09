public class Assertion
{
	public static void main(String[] args)
	{
		int n=Integer.parseInt(args[0]);
		
		assert(n>=0):"Negative number is not allowed ";
		
		int fact=1;
		for(int i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		
		System.out.println("Factorial : "+fact);
	}



}
