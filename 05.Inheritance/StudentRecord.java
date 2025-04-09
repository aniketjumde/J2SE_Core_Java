import java.io.*;
import java.util.*;

class Student
{
	private int rno;
	private String name;
	private double per;
	
	public Student() { }	//Default Condstructor 
	
	//Setter Method
	public void setRno(int rno)
	{
		this.rno=rno;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setPer(double per)
	{
		this.per=per;
		
	}
	
	//Gettor Method
	
	public int getRno()
	{
		return rno;
	}
	
	public String getName()
	{
	
		return name;
	}
	
	public double getPer()
	{
		return per;
	}
	
	public void display()
	{
		System.out.println("Roll No : "+getRno());
		System.out.println("Name    : "+getName());
		System.out.println("Percentage : "+getPer());
	}
}

class NewStudentRecord extends Student
{
	private String mobileNo;
	private String email;
	
	public NewStudentRecord() { }	//Default Condstructor 
	
	//Setter Method
	
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo=mobileNo;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	//Getter Method
	
	public String getMobileNo()
	{
		return mobileNo;
	}
	
	public String getEmail()
	{
		return email;
	}

	public void display()
	{
		super.display();
		System.out.println("Mobile No : "+mobileNo);
		System.out.println("Email : "+email);
	}

}

public class StudentRecord
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("How many student Information you want to store :");
		int n=Integer.parseInt(br.readLine());
		
		NewStudentRecord S[]=new NewStudentRecord[n];

		for(int i=0;i<n;i++)
		{
			S[i]=new NewStudentRecord();
				
			System.out.print("Enter the Roll No    :");
		  	S[i].setRno(Integer.parseInt(br.readLine()));
		  
		  	System.out.print("Enter the Name       :");
		  	S[i].setName(br.readLine());
		  	
		  	System.out.print("Enter the Percentage :");
		  	S[i].setPer(Double.parseDouble(br.readLine()));
		  
		  	System.out.print("Enter the Mobile No  :");
		  	S[i].setMobileNo(br.readLine());
		  
		  	System.out.print("Enter the email Id   :");
		  	S[i].setEmail(br.readLine());
		
		  
		  	System.out.println();
		}
		
		System.out.println("=========================STUDENT RECORDS==========================");
		
		for(int i=0;i<n;i++)
		{
			S[i].display();
			System.out.println("=================================================================");
		}
	}

}
