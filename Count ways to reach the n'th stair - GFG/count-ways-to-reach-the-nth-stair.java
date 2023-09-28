//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        if(n <= 2)
            return n;
        
        int prev = 2;
        int prevprev = 1;
        int curr = 0;
        
        for(int i=3;i<=n;i++) {
            curr = (prev + prevprev) % (int) (Math.pow(10,9) + 7);
            prevprev = prev;
            prev = curr;
        }
        
        return prev;
    }
}

