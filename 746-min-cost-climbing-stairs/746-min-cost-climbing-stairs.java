class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+2];
        dp[0] = 0;
        dp[1] = cost[0];
        for(int i=2;i<dp.length;i++) {
            if(i-1 <= cost.length -1) {
               dp[i] = cost[i-1] + Math.min(dp[i-1],dp[i-2]);   
            } else {
                dp[i] = Math.min(dp[i-1],dp[i-2]);    
            }
        }
        return dp[dp.length-1];
    }
}