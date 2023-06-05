//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
          int start = 0, end = 0, len = -1, minStart = 0;
          
          if(k > s.length())
            return -1;
          
          int[] map = new int[256];
          
          int unique = 0;
        
        while(end < s.length()) {
            char c1 = s.charAt(end);
            if(map[c1] == 0)
                unique++;
            map[c1]++;
            end++;
            while(unique > k) {
                char c2 = s.charAt(start);
                map[c2]--;
                if(map[c2] == 0)
                    unique--;
                start++;
            }
            
            if(len < end - start) {
                    len = end - start;
                     minStart = start;
            }
        }
    
        
        return len >= k ? -1 : len ;
    }
}