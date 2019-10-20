//Java program to find x raised to power y using divide and conquer

/*
This code for extended version of power function that can work for float x and negative y.
Given two integers x and n, write a function to compute x^n. We may assume that x and n are small and overflow doesn’t happen.
This problem has been optimized to O(logn) from O(n) by calculating power(x, y/2) only once and storing it.
*/

class Powerxn { 
	
	static float power(float x, int y) 
	{ 
		float temp; 
		if( y == 0) 
			return 1; 
		temp = power(x, y/2); 
		
		if (y%2 == 0) 
			return temp*temp; 
		else
		{ 
			if(y > 0) 
				return x * temp * temp; 
			else
				return (temp * temp) / x; 
		} 
	} 
	
	/* Program to test function power */
	public static void main(String[] args) 
	{ 
		float x = 2; 
		int y = -3; 
		System.out.printf("%f", power(x, y)); 
	} 
}