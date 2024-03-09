class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, -1);
        
        int cost1 = climbToTop(cost, n, 0, dp);
        int cost2 = climbToTop(cost, n, 1, dp);
        
        return Math.min(cost1, cost2);
    }
    
    public int climbToTop(int[] cost, int n, int start, int[] dp) {
        if(start >= n) {
            return 0;
        }
        
        if(dp[start] != -1)
            return dp[start];
        
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        
        one = cost[start] + climbToTop(cost, n, start + 1, dp);
        two = cost[start] + climbToTop(cost, n, start + 2, dp);
        
        return dp[start] = Math.min(one, two);
    }
}