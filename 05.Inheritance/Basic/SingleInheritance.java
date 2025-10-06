import java.io.*;

class A
{
	private int i=10;
	
	public void display()
	{
		System.out.println("A's display : "+i);
	}

}

class B extends A
{
	private int j=20;

	public void display()
	{
		System.out.println("B's Show  : "+j);
	}
}


public class  SingleInheritance
{
	public static void main(String[] args) {
		
		A ob1=new A();
		ob1.display();

		System.out.println("--------------------------------------------------------------");

		B ob2=new B();
		ob2.show();

		System.out.println("--------------------------------------------------------------");

		A ob3 =new B();

		// ob3.show()  Compile shiw the error because Show is Not declared in A'S Classs

		ob3.display();
	}
}
