//Display the Meta Data of a File 
import java.io.*;
import java.util.*;


public class MetaDataOfFile
{
	public static void main(String[] args)
	{
		File f=new File(args[0]);
		
		if(!f.exists())
		{
			System.out.println(args[0]+" : does not exits.!!");
			System.exit(0);
		}
		
		if(!f.isFile())
		{
			System.out.println(args[0]+" : does not a Directory.!!");
			System.exit(0);
		}
		
		System.out.println("Name of File :"+f.getName());
		System.out.println("Path :"+f.getAbsolutePath());
		System.out.println("Size :"+f.length());
		System.out.println("Can You read  :"+f.canRead());
		System.out.println("Can You write :"+f.canWrite());
	}	




}

