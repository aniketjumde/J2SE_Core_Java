import java.io.*;
import java.util.Arrays;
import java.util.Collections;

class Array
{
	public void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public int getSum(int arr[])
	{
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}

		return sum;
	}


	public int getMax(int arr[])
	{
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}

	public int getMin(int arr[])
	{
		int min=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<min)
			{
				min=arr[i];
			}
		}
		return min;
	}

	public void reverse(int arr[])
	{
		System.out.print("Reverse of Array : " );
		for(int i=arr.length-1;i>=0;i--)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public int binarySearch(int arr[],int key)
	{
		return Arrays.binarySearch(arr,key);
	}

	public void SecondLargest(int arr[])
	{
		int largest=arr[0];
		int secondL=arr[1];

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>largest)
			{
				secondL=largest;
				largest=arr[i];
			}
			else if(arr[i]>secondL&& arr[i]!=largest)
			{
				secondL=arr[i];
			}
		}
		System.out.println("SecondLargest Elememt is :"+secondL);

	}
	public void sort(int arr[])
	{
		Arrays.sort(arr);
		System.out.println("Sort Array :"+Arrays.toString(arr));
	}
}


public class ArraysOperation
{
	public static void main(String[] args) throws Exception
	{
	
		Array ob=new Array();

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.print("How many number you want to Stored in Array :");
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[n];

		System.out.print("Enter the Arrays Elememt :");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}

		System.out.print("Array : ");
		ob.printArray(arr);
		System.out.println("Sum of Elememt : "+ob.getSum(arr));
		System.out.println("Max of Elememt : "+ob.getMax(arr));
		System.out.println("Min of Elememt : "+ob.getMin(arr));
		ob.SecondLargest(arr);
		System.out.print("Enter a number to search: ");
        int key = Integer.parseInt(br.readLine());
        int index = ob.binarySearch(arr, key);
        System.out.println((index >= 0) ? "Element found at index: " + index : "Element not found");

        ob.sort(arr);
        ob.reverse(arr);
	}
}