// Java implementation of iterative Binary Search 

/*
Approach for binary search:
 -Compare x with the middle element.
 -If x matches with middle element, we return the mid index.
 -Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element. So we recur for right half.
 -Else (x is smaller) recur for the left half.
*/

class BinarySearch { 
	// Returns index of x if it is present in arr[], else return -1 
	
	int binarySearch(int arr[], int x) 
	{ 
		int l = 0, r = arr.length - 1; 
		while (l <= r) { 
			int m = l + (r - l) / 2; 

			// Check if x is present at mid 
			if (arr[m] == x) 
				return m; 

			// If x greater, ignore left half 
			if (arr[m] < x) 
				l = m + 1; 

			// If x is smaller, ignore right half 
			else
				r = m - 1; 
		} 

		// if we reach here, then element was 
		// not present 
		return -1; 
	} 

	// Driver method to test above 
	public static void main(String args[]) 
	{ 
		BinarySearch ob = new BinarySearch(); 
		int arr[] = { 2, 3, 4, 10, 40 }; 
		int n = arr.length; 
		int x = 10; 
		int result = ob.binarySearch(arr, x); 
		if (result == -1) 
			System.out.println("Element not present"); 
		else
			System.out.println("Element found at "+ "index " + result); 
	} 
} 
