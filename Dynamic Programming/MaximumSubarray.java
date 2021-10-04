// Java program to print largest contiguous
// array sum
import java.io.*;

class Main {


  // Takes as input an array and prints out maximum contiguous sum
  //Uses kadane's algorithm
	static int maxSubArraySum(int a[], int size)
	{
	int max_so_far = a[0];
	int curr_max = a[0];

	for (int i = 1; i < size; i++)
	{
		curr_max = Math.max(a[i], curr_max+a[i]);
		max_so_far = Math.max(max_so_far, curr_max);
	}
	return max_so_far;
	}

	/* Driver program to test maxSubArraySum */
	public static void main(String[] args)
	{
   Scanner scn = new Scanner(System.in);
   int n = scn.nextInt();
   int[] arr = new int[n];
   for(int i=0;i<n;i++){
     arr[i] = scn.nextInt();
   }
	int max_sum = maxSubArraySum(a, n);
	System.out.println("Maximum contiguous sum is "	+ max_sum);
	}
}
