package com.tca;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.tca.entities.Student;
public class AppSerialize {
    public static void main(String[] args) throws Exception
    {
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try
        {
            fos = new FileOutputStream("resource/student.txt");
            oos = new ObjectOutputStream(fos);
            Student s = new Student();
            s.setRno(101);
            s.setName("AAA");
            s.setPer(60.0);
            oos.writeObject(s);
            System.out.println("Object has Been Serialized !!!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            oos.close();
            fos.close();
        }
    }
}