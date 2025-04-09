//Reading a File Line by Line

import java.io.*;
import java.util.*;

public class ReadFileByLine
{
	public static void main(String args[])
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+":does not exits.!!!");
			System.exit(0);
		}
		
		if(!f.isFile())
		{
			System.out.println(args[0] +": is not File.!!!");
			System.exit(0);
		}
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try
		{
			fr=new FileReader(args[0]);
			br=new BufferedReader(fr);
			while(true)
			{
				String line=br.readLine();
				
				if(line==null)
				{
					break;
				}
				
				System.out.println(line);
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
			}
			catch(Exception e)
            	{
                	System.out.println("Problem while closing file !!");
            	}
		
		}
	}

}
