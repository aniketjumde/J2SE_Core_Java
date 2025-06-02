package com.tca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tca.comparators.NameComparator;
import com.tca.comparators.PercentageComparator;
import com.tca.comparators.RnoComparator;
import com.tca.entities.Student;

public class Demo 
{

	public static void main(String[] args) 
	{
		Student s1 = new Student(101,"AAA", 60.78);
		Student s2 = new Student(102,"BBB", 55.34);
		Student s3 = new Student(103,"CCC", 30.58);
		
		List<Student> L = new ArrayList<>();
		L.add(s1);
		L.add(s2);
		L.add(s3);
		
		System.out.println("****Descending Roll Number Wise***");
		System.out.println("-------------------------------------");
		
		Collections.sort(L , new RnoComparator());
		
		for(Student ob : L)
		{
			System.out.println("Roll Number : " + ob.getRno() );
			System.out.println("Name        : " + ob.getName() );
			System.out.println("Percentage  : " + ob.getPer() );
			System.out.println("-------------------------------------");
		}
		
		
		
		System.out.println("****Descending Name Wise***");
		System.out.println("-------------------------------------");
		
		Collections.sort(L , new NameComparator());
		
		for(Student ob : L)
		{
			System.out.println("Roll Number : " + ob.getRno() );
			System.out.println("Name        : " + ob.getName() );
			System.out.println("Percentage  : " + ob.getPer() );
			System.out.println("-------------------------------------");
		}

		System.out.println("****Descending Percentage Wise***");
		System.out.println("-------------------------------------");
		
		Collections.sort(L , new PercentageComparator());
		
		for(Student ob : L)
		{
			System.out.println("Roll Number : " + ob.getRno() );
			System.out.println("Name        : " + ob.getName() );
			System.out.println("Percentage  : " + ob.getPer() );
			System.out.println("-------------------------------------");
		}
	}

}
