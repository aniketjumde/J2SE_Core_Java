package com.tca;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import com.tca.entities.Student;
public class AppDeserialize
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis=null;
        ObjectInputStream ois =null;
        try
        {
            fis = new FileInputStream("resource/student.txt");
            ois = new ObjectInputStream(fis);
            Student s = (Student) ois.readObject();
            System.out.println("After Deserialization-");
            System.out.println("Roll Number : "+ s.getRno());
            System.out.println("Name: "+ s.getName());
            System.out.println("Percentage : "+ s.getPer() );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            ois.close();
            fis.close();
        }
    }
}