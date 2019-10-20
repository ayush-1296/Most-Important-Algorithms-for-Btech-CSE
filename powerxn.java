//Java program to find x raised to power y using divide and conquer

/*
Given two integers x and n, write a function to compute x^n. We may assume that x and n are small and overflow doesn’t happen.
*/

class powerxn { 
	/* Function to calculate x raised to the power y */
	static int power(int x, int y) 
	{ 
		if (y == 0) 
			return 1; 
		else if (y % 2 == 0) 
			return power(x, y / 2) * power(x, y / 2); 
		else
			return x * power(x, y / 2) * power(x, y / 2); 
	} 

	/* Program to test function power */
	public static void main(String[] args) 
	{ 
		int x = 2; 
		int y = 3; 

		System.out.printf("%d", power(x, y)); 
	} 
} 