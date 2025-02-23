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

	public void display()
	{
		
		System.out.println(id+"\t"+ename+"\t"+salary+"\t"+city);
		
	}
}

public class EmployeClass
{
	public static void main(String[] args) throws Exception
	{
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

 		int n=0;
 		System.out.print("Enter How many Employee Information :");
 		n=Integer.parseInt(br.readLine());

 		System.out.println();

 		Employee E[]=new Employee[n];

 		for(int i=0;i<E.length;i++)
 		{
 			E[i]=new Employee();

 			System.out.print("Enter the Id of Employee     : ");
 			E[i].setId(Integer.parseInt(br.readLine()));

 			System.out.print("Enter the Name of Employee   : ");
 			E[i].setEname(br.readLine());

 			System.out.print("Enter the Salary of Employee : ");
 			E[i].setSalary(Double.parseDouble(br.readLine()));

 			System.out.print("Enter the City of Employee   : ");
 			E[i].setCity(br.readLine());

 			System.out.println();

 		}

 		System.out.println("ID\tENAME\tSALARY\tCITY");
 		for(int i=0;i<E.length;i++)
 		{
 			
 			E[i].display();
 		}


 	}
}