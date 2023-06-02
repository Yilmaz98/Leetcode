class Solution {
      public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        helper(0, n, dp);
        return dp[1][n];
    }
    
    int helper(int start, int end, int[][] dp) {
        if (start >= end)
            return 0;
        
        if (dp[start][end] != 0)
            return dp[start][end];
        
        int amount = Integer.MAX_VALUE;
        
        for (int k = start; k <= end; k++) {
            int maxAmountNeededOnEitherSideOfPivot = Math.max(helper(start, k - 1, dp), helper(k + 1, end, dp));
            amount = Math.min(amount, maxAmountNeededOnEitherSideOfPivot + k);
        }
        
        return dp[start][end] = amount;
    }
}