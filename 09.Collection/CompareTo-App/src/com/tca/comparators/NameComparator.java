package com.tca.comparators;

import java.util.Comparator;

import com.tca.entities.Student;

public class NameComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) 
	{
	/*	
		String name1 = o1.getName();
		String name2 = o2.getName();
		return name1.compareTo(name2);
	*/
		
		return -o1.getName().compareTo(o2.getName());
	}
	
}
