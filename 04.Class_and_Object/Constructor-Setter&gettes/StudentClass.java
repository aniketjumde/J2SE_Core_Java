import java.io.*;
import java.util.*;

class Student
{
	private int rno;
	private String name;
	private Double per;

	public Student() {}

	public Student(int rno,String name,Double per)
	{
		this.rno=rno;
		this.name=name;
		this.per=per;
	}

	public void display()
	{
		System.out.println(rno+" | "+name+" | "+per);
	}

}

public class StudentClass
{
	public static void main(String[] args) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("How many Student :");
		int n=Integer.parseInt(br.readLine());

		Student S[]=new Student[n];

		for(int i=0;i<S.length;i++)
		{
			System.out.print("Enter the Roll No:");
			int rno=Integer.parseInt(br.readLine());

			System.out.print("Enter the name :");
			String name=br.readLine();

			System.out.print("Enter the Persentage :");
			Double per=Double.parseDouble(br.readLine());

			S[i]=new Student(rno,name,per);
		}

		System.out.println("\nStudent Details:");
		System.out.println("Roll No | Name | Percentage");
		for(int i=0;i<S.length;i++)
		{
			S[i].display();
		}
	}
}