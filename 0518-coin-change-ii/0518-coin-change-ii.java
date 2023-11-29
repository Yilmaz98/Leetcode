class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 1) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(amount, coins, 0, dp);
    }
    
    public int recurse(int amount, int[] coins, int start, int[][] dp) {
        if(start == coins.length - 1) {
            return amount % coins[start] == 0 ? 1 : 0;
        }
        
        if(dp[start][amount] != -1) {
            return dp[start][amount];
        }
        
        if(amount == 0) {
            return 1;
        }
        
        int pick = 0;
        int notPick = 0;
        
        if(coins[start] <= amount)
            pick = recurse(amount - coins[start], coins, start, dp);
        notPick = recurse(amount, coins, start + 1, dp);
        
        return dp[start][amount] = pick + notPick;
    }
}