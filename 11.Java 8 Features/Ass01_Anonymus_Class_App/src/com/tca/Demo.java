package com.tca;

class Animal
{
	public void sound()
	{
		System.out.println("Animal Sound");
	}
}


public class Demo {

	public static void main(String[] args) 
	{
		
		Animal a=new Animal() {
			
			public void sound()
			{
				System.out.println("Dog's is Bark.!!!");
			}
		};
		
		a.sound();
	}

}
