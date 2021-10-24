// Java implementation to find smallest
// subarray with all occurrences of
// a most frequent element
import java.io.*;
import java.util.*;
class GfG {
	
	static void smallestSubsegment(int a[], int n)
	{
		// To store left most occurrence of elements
		HashMap<Integer, Integer> left= new HashMap<Integer, Integer>();
	
		// To store counts of elements
		HashMap<Integer, Integer> count= new HashMap<Integer, Integer>();
	
		// To store maximum frequency
		int mx = 0;
	
		// To store length and starting index of
		// smallest result window
		int mn = -1, strindex = -1;
	
		for (int i = 0; i < n; i++)
		{
	
			int x = a[i];
	
			// First occurrence of an element,
			// store the index
			if (count.get(x) == null)
			{
				left.put(x, i) ;
				count.put(x, 1);
			}
	
			// increase the frequency of elements
			else
				count.put(x, count.get(x) + 1);
	
			// Find maximum repeated element and
			// store its last occurrence and first
			// occurrence
			if (count.get(x) > mx)
			{
				mx = count.get(x);
				
				// length of subsegment
				mn = i - left.get(x) + 1;
				strindex = left.get(x);
			}
	
			// select subsegment of smallest size
			else if ((count.get(x) == mx) &&
					(i - left.get(x) + 1 < mn))
			{
				mn = i - left.get(x) + 1;
				strindex = left.get(x);
			}
		}
	
		// Print the subsegment with all occurrences of
		// a most frequent element
		for (int i = strindex; i < strindex + mn; i++)
			System.out.print(a[i] + " ");
	}
	
	// Driver program
	public static void main (String[] args)
	{
		int A[] = { 1, 2, 2, 2, 1 };
		int n = A.length;
		smallestSubsegment(A, n);
	}
}

// This code is contributed by Gitanjali.
