import java.io.*;
import java.util.*;

public class ArrayListDemo 
{
    public static void main(String args[]) 
    {
        List<Integer> al = new ArrayList<Integer>();

        al.add(11);
        al.add(22);
        al.add(33);
        al.add(44);
        
        System.out.println("Size : " + al.size());
        System.out.println(al);
    }
}

