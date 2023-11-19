//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N+1][sum+1];
        
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return backtrack(arr, sum, 0, N, dp) == 1 ? true : false;
    }
    
    public static int backtrack(int[] arr, int sum, int start, int N, int[][] dp) {
        if(sum == 0) {
            return dp[start][sum] = 1;
        }
        
        if(dp[start][sum] != -1)
            return dp[start][sum];
        
        for(int i=start;i<arr.length;i++) {
            if(sum - arr[i] < 0)
                continue;
            sum = sum - arr[i];
            if(backtrack(arr, sum, i+1, N, dp) == 1)
                return dp[start][sum] = 1;
            sum = sum + arr[i];
        }
        
        return dp[start][sum] = 0;
    }
}