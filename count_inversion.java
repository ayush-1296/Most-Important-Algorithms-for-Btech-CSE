// Java program to count inversions in an array

/*
Count Inversion:
Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Time complexity= O(n^2).
*/
 
class CountInversion { 
	static int arr[] = new int[] { 1, 20, 6, 4, 5 }; 

	static int getInvCount(int n) 
	{ 
		int inv_count = 0; 
		for (int i = 0; i < n - 1; i++) 
			for (int j = i + 1; j < n; j++) 
				if (arr[i] > arr[j]) 
					inv_count++; 

		return inv_count; 
	} 

	// Driver method to test the above function 
	public static void main(String[] args) 
	{ 
		System.out.println("Number of inversions are "+ getInvCount(arr.length)); 
	} 
} 
