import java.io.*;
import java.util.*;

class Employee
{
	private int id;
	private String ename;
	private Double salary;
	private String city;

	public Employee() {}
	
	public Employee(int id,String ename,Double salary,String city)
	{
		this.id=id;
		this.ename=ename;
		this.salary=salary;
		this.city=city;
	}

	public void display()
	{
		
		System.out.println(id+"\t"+ename+"\t"+salary+"\t"+city);
		
	}
	
}

public class SimpleEmployeeClass
{
	public static void main(String[] args) throws Exception
	{
 		Employee E1=new Employee(101,"AAAA",20000.0,"Pune");

 		Employee E2=new Employee(102,"BBBB",40000.0,"Mumbai");

 		E1.display();
 		E2.display();

 	}
}