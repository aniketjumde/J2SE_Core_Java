import java.io.*;


class A
{
	private int i;

	public A()
	{
		i=0;
		System.out.println("A's Default Constructor ");
	}

	public A(int i)
	{
		this.i=i;
		System.out.println("A's Parametrised Constructor ");

	}	

	void display()
	{
		System.out.println(" Value of i :"+i);
	}
}

class B extends A
{
	private int j;

	public B()
	{
		super();
		j=0;
		System.out.println("B's Default Constructor ");

	}

	public B(int i,int j)
	{
		super(i);
		this.j=j;
		System.out.println("B's Parametrised Constructor ");

	}

	void display()
	{
		super.display();
		System.out.println(" Value of j :"+j);
	}
}


public class ConstructorInSingleInheritance
{
	public static void main(String[] args) {
		

		B ob=new B();
		ob.display();

		System.out.println("-----------------------------------------------");

		B ob1=new B(11,22);
		ob1.display();
	}
}