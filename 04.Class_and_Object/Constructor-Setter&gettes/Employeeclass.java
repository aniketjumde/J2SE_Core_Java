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

	public void setId(int id)
	{
		this.id=id;
	}

	public void setEname(String ename)
	{
		this.ename=ename;
	}

	public void setSalary(Double salary)
	{
		this.salary=salary;
	}

	public void setCity(String city)
	{
		this.city=city;
	}

	public int getId()
	{
		return this.id;
	}

	public String getEname()
	{
		return this.ename;
	}

	public Double getSalary()
	{
		return this.salary;
	}

	public String getCity()
	{
		return this.city;
	}
		
		
		
	
}

public class Employeeclass
{
	public static void main(String[] args) throws Exception
	{
 		Employee E1=new Employee();

 		E1.setId(101);
 		E1.setEname("AAAA");
 		E1.setSalary(20000.0);
 		E1.setCity("Pune");

 		Employee E2=new Employee();

 		E2.setId(102);
 		E2.setEname("BBBB");
 		E2.setSalary(40000.0);
 		E2.setCity("Mumbai");

 		System.out.println("Employee Id     : "+ E1.getId());
 		System.out.println("Employee Name   : "+ E1.getEname());
 		System.out.println("Employee Salary : "+ E1.getSalary());
 		System.out.println("Employee City   : "+ E1.getCity());
 		System.out.println();
 		System.out.println("Employee Id     : "+ E2.getId());
 		System.out.println("Employee Name   : "+ E2.getEname());
 		System.out.println("Employee Salary : "+ E2.getSalary());
 		System.out.println("Employee City   : "+ E2.getCity());
		
 	}
}