//Reading a File Character by Character

import java.io.*;
import java.util.*;

public class ReadFileByChar
{
	public static void main(String[] args)
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+":does not exits.!!!");
			System.exit(0);
		}
		
		if(! f.isFile())
        	{
            System.out.println(args[0] +  " : is not a File !!");
            System.exit(0);
        	}
        
        	FileReader fr=null;
        	
        	try
        	{
        		fr=new FileReader(args[0]);
        		System.out.println("Content of File :");
        		
        		while(true)
        		{
        			int ch=fr.read();
        			
        			if(ch==-1)
        			{
        				break;
        			}
        			
        			System.out.print((char)ch);
        		}	
        	}
        	
        	catch(Exception ec)
        	{
        		System.out.println("Problem while reading a file !!!");
        	}
        	
        	finally
        	{
            try
            {
                fr.close(); 
            }
            catch(Exception e)
            {
                System.out.println("Problem while closing file !!");
            }
        	}

        
	}
	
}
