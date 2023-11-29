//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> result = new ArrayList<>();
        
        List<Integer> denominations = Arrays.asList(2000, 500, 200 ,100, 50, 20, 10, 5 , 2 ,1);
        return recurse(N, result, denominations);
    } 
    
    public static List<Integer> recurse(int N, List<Integer> result, List<Integer> denominations) {
        if(N == 0) {
            return result;
        }
        
        int coins = 0;
        for(int i=0;i<denominations.size();i++) {
            if(denominations.get(i) <= N) {
                result.add(denominations.get(i));
                if(recurse(N- denominations.get(i), result, denominations).size() > 0) {
                    return result;   
                }
                result.remove(result.size() - 1);
            } else {
                continue;
            }
        }
        
        return new ArrayList<>();
    }
}