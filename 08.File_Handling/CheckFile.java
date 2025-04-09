import java.io.*;
import java.util.*;

public class CheckFile
{
	public static void main(String args[])
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+": does not exits.!!");
			System.exit(0);
		}
		
		if(!f.isFile())
		{
			System.out.println(args[0]+" : is not a Directory.!!");
			System.exit(0);
		}
		
		System.out.println("Okk");
	
	}
}
