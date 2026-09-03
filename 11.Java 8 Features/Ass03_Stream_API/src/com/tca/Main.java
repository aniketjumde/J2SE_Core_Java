package com.tca;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

		// ### Filter() : SELECTED Data
//		ex: Give List number greater than 20
		
		numbers.stream()
			   .filter(n->n>20)
			   .forEach(n->System.out.println(n));
		
		
		//### Map()- Transform Data (change Data)
//		ex :Take each number and multiply it by 2.
		
		numbers.stream()
			   .map(n->n*2)
			   .forEach(n->System.out.println(n));
		
		//### sorted() — sort data
		
		System.out.println("Sorted :");
		numbers.stream()
			   .sorted()
			   .forEach(n->System.out.println(n));

		// Method Refference
		List<String> names =
			    Arrays.asList("Rahul", "Amit", "Priya");

			names.forEach(
			    System.out::println
			);

		
		
	}

}
