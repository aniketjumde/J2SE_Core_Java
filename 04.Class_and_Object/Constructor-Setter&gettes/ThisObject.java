import java.io.*;

class A
{
	int i;
	int j;

	A()
	{
		i=0;
		j=0;
		System.out.println("default Constructor.!!");
	}

	A(int i,int j)
	{
		this.i=i;
		this.j=j;
		System.out.println("Parametrazied Constructor-1..!!");
	}

	void display()
	{
		System.out.println("Value of i : "+i);
		System.out.println("Value of j : "+j);
	}
}

public class ThisObject
{
	public static void main(String[] args) {
		
		A ob1=new A();
		A ob2=new A(11,44);
		ob1.display();
		ob2.display();
	}
}