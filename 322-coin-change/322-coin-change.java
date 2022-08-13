class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int dp[] = new int[amount+1];    
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++) {
            for(int j = 0;j<coins.length;j++) {
                if(i>=coins[j])
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
            }
        }
        
        if(dp[amount] == amount+1)
            return -1;

        
        return dp[amount];
    }
}