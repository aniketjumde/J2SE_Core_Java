package com.access.outside;

class parent
{
	void display()
	{
		System.out.println("Default Method");
	}
	
	public void show()
	{
		System.out.println("Public Method");
	}
	
	protected void pshow()
	{
		System.out.println("Protected Method");
	}
	
}

class Child extends parent
{
	
	void display()
	{
		super.display();
		System.out.println("Default Method accessiable in Child class (Same Package)");
	}
	
	public void show()
	{
		super.show();
		System.out.println("Public Method accessiable in Child");
	}
	
	protected void pshow()
	{
		System.out.println("Protected Method accessiable in Child");
	}
}

public class Demo 
{

	public static void main(String args[])
	{
		Child ob=new Child();
		ob.display();
		ob.show();
		ob.pshow();
	}
}
