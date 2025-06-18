package com.tca.dao;

import com.tca.config.Configuration;
import com.tca.entities.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentDao
{
    public boolean save(Student ob) //(101,"AAA",89.23)
    {
        FileWriter fw = null;
        try
        {
            int rno=ob.getRno();
            String name=ob.getName();
            Double per=ob.getPercentage();
            fw = new FileWriter(Configuration.FILE_NAME,true);
            fw.write(rno+","+name+","+per+"\n");
            System.out.println("Record is Saved for Roll Number : "+rno );

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                fw.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void saveAll(List<Student> L) // L-->[[111,"AAA",87.0],[112,"BBB",26.9],[113,"CCC",87.3]]
    {
        for(Student ob : L)
        {
            save(ob);
        }
    }

    public List<Student> getAllStudents() {
        List<Student> L = new ArrayList<Student>();
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(Configuration.FILE_NAME);
            br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                String tok[] = line.split(",");  // tokenzing string comma wise

                int trno = Integer.parseInt(tok[0]);
                String tname = tok[1];
                Double tper = Double.parseDouble(tok[2]);

                L.add(new Student(trno, tname, tper));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        return L;
    }

    public Student SearchStudent(int trno)
    {
        List<Student> L = getAllStudents(); // L---> [101,..] [102,..],[103,..]

        if(L.isEmpty())
        {
            return null;
        }
        else
        {
            for(Student ob : L)
            {
                if(ob.getRno() == trno)
                {
                    return ob;
                }
            }
        }
        return null;

    }

    public  boolean deleteStudent(int trno)
    {
        List<Student> L = getAllStudents();

        for(Student ob : L)
        {
            if(ob.getRno() == trno)
            {
                L.remove(ob);

                File f=new File(Configuration.FILE_NAME);
                f.delete();
                try
                {
                    f.createNewFile();
                    saveAll(L);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return false;
                }
                return true;
            }

        }
        return false; // returning false bcz 107 wala student didnt able to find
    }

    public boolean updateStudent(int trno,String tname,Double tper)
    {
        List<Student> L = getAllStudents();
        for (Student ob : L) {
            if(ob.getRno() == trno)
            {
                ob.setName(tname);
                ob.setPercentage(tper);

                File f = new File(Configuration.FILE_NAME);
                f.delete();
                try
                {
                    f.createNewFile();
                    saveAll(L);

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
