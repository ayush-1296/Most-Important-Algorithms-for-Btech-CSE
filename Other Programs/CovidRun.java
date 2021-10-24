/*
This was the solution of a problem(Covid Run)  in the October long challenge 2020. 
Problem link : https://www.codechef.com/OCT20B/problems/CVDRUN/
The problem is about, we are having N cities numbered from 0 to (N-1) and at start, virus is at City X. We need to find whether the virus attacks our City(City Y) or not.
The virus always jumps from city X to city (X+K)%N. 

Logic: First let's add all the affected cities to a data structure becuase we can assure that at somewhere the cities will repeat same cycle.So if any city affected twice we can 
       break our loop. Then traverse through that data structure and find whether City Y is present or not.
*/

// Code //

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
 
	public static void main (String[] args) throws java.lang.Exception
	{
	
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();      //Scanning the number of testcases
		
	    
          while(t-->0)
	       	{
          		int n=s.nextInt()      // Scanning the number of cities
	            int k=s.nextInt();     // Scanning the number jumps virus does    
	            int x=s.nextInt();     // Scanning Covid's current city
	            int y=s.nextInt();     // Scanning the city we live in.
              
              // Declaring an ArrayList
	            ArrayList<Integer>a=new ArrayList<>();
              
              // Adding the covid's current city to ArrayList 'a'.
	            a.add(x);
	            int z=x;
	            while(true)
	              {              
	                 z=(z+k)%n;
                   // If the city is already present in our ArrayList then we can break our loop.
	                 if(a.contains(z))
	                     break;
	                 else
	                    a.add(z);
	               }
	            int i;
              // Search whether City Y is present in ArrayList or not.
	            for(i=0;i<a.size();i++)
	              {
	                  if(a.get(i)==y)
	                {
                       // If City Y is present then print "YES".
	                     System.out.println("YES");
	                     break;
	                }
	               }
                 // This condition tells us that City Y is not present in the ArrayList. So print "NO"
	       if(i==a.size())
	         System.out.println("NO");
	      	}
		s.close();
	   }
}




