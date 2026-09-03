package com.tca;

import java.util.Arrays;
import java.util.List;

public class Main 
{

	public static void main(String args[])
	{
		//Using Anonymus Class
		Calculator c=new Calculator() {
			
			public int add(int a,int b)
			{
				return a+b;
			}
		};
		
		int result=c.add(10, 20);
		System.out.println("Addition Using Anonymus Class : "+result);
		
		//Using Lambad Expression
		
		Calculator sum=(num1, num2)-> num1+num2;
		System.out.println("Addition using Lambda Expression is : "+sum.add(16, 4));
		
		Calculator diff=(num1,num2)->num1-num2;
		System.out.println("Minuse is : "+diff.add(50,23));
		
		Calculator mul=(num1,num2)->{
			System.out.println("Multiplication of two numbers");
			return num1 * num2;
		};
		
		System.out.println(mul.add(2, 8));
		
		
		Calculator div=(num1,num2)->{
			System.out.println("Divistion of two numbers");
			return num1 / num2;
		};
		
		System.out.println(div.add(20,5));
		
		
		
		System.out.println("Greater than 50 ");
		List<Integer> numbers = Arrays.asList(10, 60, 30, 80, 90, 20);

		numbers.forEach(num -> {
		    if (num > 50) {
		        System.out.println(num);
		    }
		});

	}
}
