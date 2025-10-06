package com.tca;


class DefaulterStudentException extends Exception 
{
    public DefaulterStudentException(String message) 
    {
        super(message);
    }
}


public class DefaulterStudentDemo 
{
  
    public static void checkAttendance(String studentName, int attendance) throws DefaulterStudentException 
    {
        if (attendance < 75) {
            throw new DefaulterStudentException("Student " + studentName + " is a defaulter! Attendance: " + attendance + "%");
        } else {
            System.out.println("Student " + studentName + " is allowed. Attendance: " + attendance + "%");
        }
    }

    public static void main(String[] args) {
        try 
        {
            checkAttendance("Pradeep", 72); 
            checkAttendance("Rohan", 80);
            checkAttendance("Kaushal",66);
        } catch (DefaulterStudentException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
}
