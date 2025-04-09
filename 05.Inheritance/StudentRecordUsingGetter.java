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


}

public class StudentRecordUsingGetter
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
		System.out.println("ROll NO\tName\tPercentage\tMobile No\tEmail\t");
		for(int i=0;i<n;i++)
		{
			System.out.println(S[i].getRno()+"\t"+S[i].getName()+"\t"+S[i].getPer()+"\t"+S[i].getMobileNo()+"\t"+S[i].getEmail());
			System.out.println("=================================================================");
		}
	}

}
