//How to copy one file into another

import java.io.*;
import java.util.*;

public class CopyOneFileToAnother
{
	public static void main(String args[])
	{
		File f=new File(args[0]);
		
		if(! f.exists() )
        	{
            System.out.println(args[0] +  " : does not Exist !!");
            System.exit(0);
      	} 
        
        	if(! f.isFile())
        	{
            System.out.println(args[0] +  " : is not a File !!");
            System.exit(0);
        	}
        	
        	FileReader fr=null;
        	FileWriter fw=null;
        	BufferedReader br=null;
        	
        	try
        	{
        		fr=new FileReader(args[0]);
        		fw=new FileWriter(args[1]);
        		br=new BufferedReader(fr);
        		
        		while(true)
        		{
        			String line=br.readLine();
        			
        			if(line==null)
        			{
        				break;
        			}
        			
        			 fw.write(line+"\n");
        		
        		}
        		
        		System.out.println(args[0] + " is copied into " + args[1] + "Succesfully !!");
        	}
        	
        	catch(Exception ce)
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
                System.out.println("Problem while closing file !!");
            }
        	}
	}
}	
