import java.io.*;

public class MetaDataOfFolder
{
    public static void main(String[] args) 
    {
        File f = new File( args[0] );  // "study"
	   
        if(!f.exists() )
        {
            System.out.println(args[0] +  " : does not Exist !!");
            System.exit(0);
        }
         
        if(! f.isDirectory())
        {
            System.out.println(args[0] +  " : is not a Directory !!");
            System.exit(0);
        }
                
        System.out.println(f.getName());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.length());
        System.out.println("Read  : " + f.canRead());
        System.out.println("Write : " + f.canWrite());        
    }
}
