class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;  
        int[][] memo = new int[n][amount + 1];

        int ans = helper(0, amount, coins, memo);
            
        return ans == Integer.MAX_VALUE -1? -1 : ans;
    }
    
    public int helper(int i, int sum,int[] coins, int[][] memo) {
        if(sum <0 || i == coins.length) {
            return Integer.MAX_VALUE -1 ;
        }
        
      
        if(sum == 0) {
            return 0;
        }
    
        if(memo[i][sum] != 0)
            return memo[i][sum];
        
        return memo[i][sum] = Math.min(helper(i, sum - coins[i] ,coins, memo) + 1,  helper(i+1, sum, coins, memo));
    }
}