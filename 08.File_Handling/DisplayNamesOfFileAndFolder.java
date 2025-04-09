//Display names of files & folders present in given directory

import java.io.*;
import java.util.*;

public class DisplayNamesOfFileAndFolder
{
	public static void main(String[] args)
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+" : Does not exits..!");
			System.exit(0);
		}
		
		if(! f.isDirectory())
        	{
            System.out.println(args[0] +  " : is not a Directory !!");
            System.exit(0);
        	}
		
		String names[]=f.list();
		
		System.out.println("No. of Entries : " +  names.length);

        	System.out.println("Contes of Directory :");
		
		
		for(String fname : names)
		{
			System.out.println(fname);
		}
	}

}
