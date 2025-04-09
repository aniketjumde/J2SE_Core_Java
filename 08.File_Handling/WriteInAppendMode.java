//Q. How Achive Append mode in Java

import java.io.*;
import java.util.*;

public class WriteInAppendMode
{
	public static void main(String args[])
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+":does not exits.!!!");
			System.exit(0);
		}
		
		if(!f.isFile)
		{
			System.out.println(args[0]+":is not File.!!!");
			System.exit(0);
		}
		
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		
		try
		{
			fr=new FileReader(args[0]);
			br=new BufferedReader(fr);
			fw=new FileWriter(args[1],true);  // true measn append the data
									   // false means over-write the old data
			
			while(true)
			{
				String line=br.readLine();
				
				if(line==null)
				{
					break;
				}
				
				fw.write(line+"\n");
			
			}
		
		}
		
		catch(Exception ec)
		{
			System.out.println("Problem While Reading a File.!!!");
		}
		
		finally
		{
			try
			{
				fr.close();
				br.close();
				fw.close();
			}
			
			catch(Exception e)
			{
				System.out.println("Problem While Closing a File.!!!");
			}
		}
	
	}
}
