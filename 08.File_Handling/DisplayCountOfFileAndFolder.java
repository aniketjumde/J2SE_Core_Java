//Display count of files & folders present in given directory
import java.io.*;
import java.util.*;

public class DisplayCountOfFileAndFolder
{
	public static void main(String[] args)
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+" :does not exits.!!!");
			System.exit(0);
		}
		
		if(!f.isDirectory())
		{
			System.out.println(args[0]+" :is Not a Directory.!!!");
			System.exit(0);
		}
		
		File fob[]=f.listFiles();
		
		int dcnt=0;
		int fcnt=0;
		
		for(File ob : fob)
		{
			if(ob.isFile())
			{
				++fcnt;
			}
			
			if(ob.isDirectory())
			{
				++dcnt;
			}
		
		}
		
        System.out.println("No. of Files  : " + fcnt);
        System.out.println("No. of Folder : " + dcnt);
	}


}
