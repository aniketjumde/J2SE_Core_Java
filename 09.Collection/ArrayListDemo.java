import java.io.*;
import java.util.*;

public class ArrayListDemo 
{
    public static void main(String args[]) 
    {
        List<Integer> al = new ArrayList<Integer>();
	   System.out.println("No.of.Element : " + al.size());
        al.add(11);
        al.add(22);
        al.add(33);
        al.add(44);
	   System.out.println("No.of.Element : " + al.size());
        System.out.println("Data : "+al);
        
        al.remove(3);
        al.remove(2);
	   System.out.println("No.of.Element : " + al.size());
        System.out.println("Data : "+al);
        
        System.out.println("Display data using for each loop :");
        for(int data : al)
        {
        	System.out.println(data);
        }
        
        Iterator ir=al.iterator();
        System.out.println("Display Data using Iterator :");
        while(ir.hasNext())
        {
        	System.out.println(ir.next());
        }
        
        al.clear();  //It deletes all Elements
        System.out.println("No.of.Element : " + al.size());
        System.out.println("Data : "+al);
        
    }	
}

