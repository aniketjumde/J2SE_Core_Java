import java.io.*;
import java.util.*;

class StudentRecord
{
	private int rno;
	private String name;
	private double per;
	
	public StudentRecord(int rno,String name,double per)
	{
		this.rno=rno;
		this.name=name;
		this.per=per;
	}
	
	public void display()
	{
		System.out.println("Roll No : "+rno);
		System.out.println("Name    : "+name);
		System.out.println("Percentage : "+per);
	}
	
}


class NewStudentRecord extends StudentRecord
{
	private String mobileNo;
	private String email;
	
	public NewStudentRecord(int rno,String name,double per,String mobileNo,String email)
	{
		super(rno,name,per);
		this.mobileNo=mobileNo;
		this.email=email;
		
	}
	
	public void display()
	{
		super.display();
		System.out.println("Mobile No : "+mobileNo);
		System.out.println("Email : "+email);
	}

}

public class Student
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("How many Student Record you want to store :");
		int n=Integer.parseInt(br.readLine());
		
		NewStudentRecord S[]=new NewStudentRecord[n];
		
		
		for(int i=0;i<n;i++)
		{
		  System.out.print("Enter the Roll No    :");
		  int rno=Integer.parseInt(br.readLine());
		  
		  System.out.print("Enter the Name       :");
		  String name=br.readLine();
		  
		  System.out.print("Enter the Percentage :");
		  double per=Double.parseDouble(br.readLine());
		  
		  System.out.print("Enter the Mobile No  :");
		  String mob=br.readLine();
		  
		  System.out.print("Enter the email Id   :");
		  String emai=br.readLine();
		
		  S[i]=new NewStudentRecord(rno,name,per,mob,emai);
		  
		  System.out.println();=
		}
		
		System.out.println("=========================STUDENT RECORDS==========================");
		
		for(int i=0;i<n;i++)
		{
			S[i].display();
			System.out.println("=================================================================");
		}
	}

}
