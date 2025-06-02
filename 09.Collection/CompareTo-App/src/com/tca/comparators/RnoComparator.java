package com.tca.comparators;

import java.util.Comparator;

import com.tca.entities.Student;

public class RnoComparator implements Comparator<Student> 
{

	@Override
	public int compare(Student o1, Student o2) 
	{
		Integer rno1 = o1.getRno();
		Integer rno2 = o2.getRno();
		
		return -rno1.compareTo(rno2);
	}

}
