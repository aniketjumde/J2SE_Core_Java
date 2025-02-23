import java.io.*;
// Accept ‘n’ ages(integers) of person from command line & display count of how many eligible for voting.

public class EligibleForVoting
{
	public static void main(String[] args) {
		

		int cnt=0;

		for(String s :args)
		{
			if(Integer.parseInt(s)>=18)
			{
				cnt++;
			}
		}

		System.out.println("How many Eligible For Voting : "+cnt +" people");	
	}
}