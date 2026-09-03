package com.tca;
// Anonymus Class Witha an INterface Implementation

/*
  
 class EnglishGreeting implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class Main {
    public static void main(String[] args) {
        Greeting g = new EnglishGreeting();
        g.sayHello();
    }
}

 */



public class Main {

	public static void main(String[] args) 
	{
		
		Greeting g=new Greeting() {
			
			public void sayHello()
			{
				System.out.println("Hello Welcome to Anonymus Class");
			}
		};
		g.sayHello();

	}

}
