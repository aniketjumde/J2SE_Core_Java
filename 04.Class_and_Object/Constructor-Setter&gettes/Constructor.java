import java.io.*;


class Demo
{
	private int i;
	private int j;

	Demo()
	{
		i=0;
		j=0;
		System.out.println("default Constructor.!!");
	}

	Demo(int x,int y)
	{
		i=x;
		j=y;
		System.out.println("Parametrazied Constructor-1..!!");
	}

	Demo(Demo temp)
	{
		i=temp.i;
		j=temp.j;
		System.out.println("Parametrazied Constructor-2..!!");
	}

	public void display()
	{
		System.out.println("value of i : "+i);
		System.out.println("value of j : "+j);

	}

}

public class Constructor
{
	public static void main(String[] args) {
		Demo ob1=new Demo();
		Demo ob2=new Demo(11,22);
		Demo ob3=new Demo(ob2);
		ob1.display();
		ob2.display();
		ob3.display();
	}
}