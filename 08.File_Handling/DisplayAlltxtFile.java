//Delete all .txt files from given folder

import java.io.*;
import java.util.*;

public class DisplayAlltxtFile
{
	public static void main(String[] args)
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+":doesn not exits.!!!");
			System.exit(0);
		}
		
		if(!f.isDirectory())
		{
			System.out.println(args[0]+": is not a Directory.!!!");
			System.exit(0);
		}
		
		File fob[]=f.listFiles();
		
		for(File ob: fob)
		{
			if(ob.isFile())
			{
				String fname=ob.getName();
				
				if(fname.endsWith(".txt"))
				{
					ob.delete(); 
                   		System.out.println(fname + ":  deleted Succesfully");
				}			
			
			}
		}
	}

}

