import java.io.*;
import java.util.*;

class Student 
{
	private int rno;
	private String name;
	private Double per;

	public Student() { }

	public Student(int rno,String name,Double per)
	{
		this.rno=rno;
		this.name=name;
		this.per=per;
	}

	public void setRno(int rno)
	{
		this.rno=rno;
	}	

	public void setName(String name)
	{
		this.name=name;
	}

	public void setPer(Double per)
	{
		this.per=per;
	}

	public int getRno()
	{
		return rno;
	}

	public String getName()
	{
		return name;
	}

	public Double getPer()
	{
		return per;
	}

	public void display()
	{
		System.out.println(rno+" | "+name+" | "+per);
	}
}

public class StudentClassUsingSetter
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

		System.out.print("How many Student :");
		int n=Integer.parseInt(bf.readLine());

		Student S[]=new Student[n];

		for(int i=0;i<S.length;i++)
		{
			S[i]=new Student();

			System.out.print("Enter the Roll No:");
			S[i].setRno(Integer.parseInt(bf.readLine()));

			System.out.print("Enter the name :");
			S[i].setName(bf.readLine());

			System.out.print("Enter the Persentage :");
			S[i].setPer(Double.parseDouble(bf.readLine()));
	
		}

		System.out.println("\nStudent Details:");
		System.out.println("Roll No | Name | Percentage");
		for(int i=0;i<S.length;i++)
		{
			S[i].display();
		}
	}
}