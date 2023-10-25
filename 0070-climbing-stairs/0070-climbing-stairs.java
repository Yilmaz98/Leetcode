class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recurse(n, dp);
    }
    
    public int recurse(int n, int[] dp) {
        if(n == 0)
            return dp[n] = 0;
        if(n == 1)
            return dp[n] = 1;
        if(n == 2)
            return dp[n] = 2;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = recurse(n-1, dp) + recurse(n-2, dp);
    }
}