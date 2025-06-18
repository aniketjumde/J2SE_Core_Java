package com.tca;

import com.tca.config.Configuration;
import com.tca.dao.StudentDao;
import com.tca.entities.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App
{
     public static void main(String[] args) throws FileNotFoundException {

         //Test Code Of Update

         StudentDao dao = new StudentDao();
         int er=102;
         String name="PPP";
         Double per= 99.0;

         if(dao.updateStudent(er,name,per))
         {
             System.out.println("Record Updated for Roll Number : " + er);
         }
         else
         {
             System.out.println("Record Not Updated for Roll Number : " + er);
         }





        /*

        Test-Code Delete


         StudentDao dao = new StudentDao();
         int r=102;

         if(  dao.deleteStudent(r)  )
         {
             System.out.println("Record Deleted for Roll Number : " + r);
         }
         else
         {
             System.out.println("Unable to delete Record for Roll Number : " + r );
         }

        */







         /*
    // Test-Code Search
    StudentDao dao = new StudentDao();
    int trno=107;

    if(dao.SearchStudent(trno)==null)
    {
        System.out.println("No Record Found !!!");
    }
    else
    {
        System.out.println("Record Found !!!");
        System.out.println("Roll No: "+dao.SearchStudent(trno).getRno());
        System.out.println("Name: "+dao.SearchStudent(trno).getName());
        System.out.println("Percentage : "+dao.SearchStudent(trno).getPercentage());
    }


*/





         /*
         // Test Code  - getAllStudent()

         StudentDao dao = new StudentDao();

         List<Student> L = dao.getAllStudents();

         if(L.isEmpty())
         {
             System.out.println("No Records Found !!");
         }
         else
         {

             for(Student S : L)
             {
                 S.display();
             }
         }

          */


    }

}
