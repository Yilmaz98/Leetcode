class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        return recurse(n, dp);
    }
    
    public int recurse(int n, int[] dp) {
        if(n == 0)
            return 1;
        
        if(n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        int firstStep = 0;
        int secondStep = 0;
        
        firstStep = recurse(n - 1, dp);
        secondStep = recurse(n - 2, dp);
        
        return dp[n] = firstStep + secondStep;
    }
}