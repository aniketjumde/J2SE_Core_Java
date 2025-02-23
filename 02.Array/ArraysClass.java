import java.io.*;
import java.util.Arrays;

public class ArraysClass 
{
	public static void main(String[] args) {
		
		int a[]={55,22,11,33,44};

		System.out.println("Array is   : "+Arrays.toString(a));

		Arrays.sort(a);

		System.out.println("After Sort : "+Arrays.toString(a));

		int pos=Arrays.binarySearch(a,33);

		if(pos>=0)
			System.out.println("11 is found at position "+pos);
		else 
			System.out.println("11 is not found in position ");

		int pos2=Arrays.binarySearch(a,88);

		if(pos2>=0)
			System.out.println("88 is found at position "+pos2);
		else 
			System.out.println("88 is not found in position ");


		int arr1[]={55,22,11,33,44};
		int arr2[]={55,22,11,33,44};

		if(Arrays.equals(arr1,arr2))
			System.out.println("Both arrays are equals !!");
		else 
			System.out.println("Voth arrays are not equals !!");

		int arr3[]=new int[5];
		Arrays.fill(arr3,55);

		System.out.println("Array is  : "+Arrays.toString(arr3));



	}
}